package app;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.BookToDeserialize;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class Deserializer {
    private static Deserializer instance;
    public static ObjectMapper mapper;
    private String path;
    private static BookToDeserialize booksList;

    private Deserializer(String path){
        this.path = path;
    }

    /**
     * @param path
     * @return Deserializer instance with deserialized JSON objects.
     * Check if given path is URL or file
     * @throws IOException
     */
    public static synchronized Deserializer getInstance(String path) throws IOException {
        if (instance == null) {
            instance = new Deserializer(path);

            instance.mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            instance.mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

            boolean isValid =false;
            try
            {
                URL url = new URL(path);
                url.toURI();
                isValid = true;
                System.out.println("Jest sciezka");
            } catch (Exception exception){
            }

            if(isValid)
                instance.booksList = mapper.readValue(new URL(path), BookToDeserialize.class);
            else
                instance.booksList = mapper.readValue(new File(instance.path), BookToDeserialize.class);
        }

        return instance;
    }


    /**
     * @return booksList
     */
    public static BookToDeserialize getBooksList() {
        return booksList;
    }

    /**
     * @param booksList
     */
    private static void setBooksList(BookToDeserialize booksList) {
        Deserializer.booksList = booksList;
    }

    /**
     *
     */
    public static void deleteInstance() {
        Deserializer.instance = null;
    }

    /**
     * @return getMapper
     */
    public static ObjectMapper getMapper() {
        return mapper;
    }
}
