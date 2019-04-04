package app;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.BookToDeserialize;

import java.io.File;
import java.io.IOException;

public class Deserializer {
    private static Deserializer instance;
    public static ObjectMapper mapper;
    private static BookToDeserialize booksList;

    private Deserializer(){}

    public static synchronized Deserializer getInstance() throws IOException {
        if (instance == null) {
            instance = new Deserializer();

            instance.mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            instance.mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            instance.booksList = mapper.readValue(new File(Constants.PATH), BookToDeserialize.class);
        }

        return instance;
    }


    public static BookToDeserialize getBooksList() {
        return booksList;
    }

    private static void setBooksList(BookToDeserialize booksList) {
        Deserializer.booksList = booksList;
    }
}
