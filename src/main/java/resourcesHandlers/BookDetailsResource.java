package resourcesHandlers;

import app.Constants;
import app.Deserializer;
import app.Main;
import model.BookToDeserialize;

import javax.ws.rs.*;
import java.io.IOException;

@Path("/book/{isbn}")
public class BookDetailsResource {
    private Deserializer deserializer;
    private BookToDeserialize booksList;


    /**
     * Handle "/book/{isbn}" request
     * @param isbn
     * @return
     */
    @GET
    @Produces("application/json")
    public String getBookByISBN(@PathParam("isbn") String isbn){
        String books = "abc";

        try {
            deserializer = Deserializer.getInstance(Main.PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        booksList = deserializer.getBooksList();
        //System.out.println("Dlugosc listy: " + booksList.getItems().length);
        //throw new WebApplicationException(400);
        return books;
    }
}
