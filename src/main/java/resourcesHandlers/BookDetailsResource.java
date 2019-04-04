package resourcesHandlers;

import app.Deserializer;
import model.BookToDeserialize;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
            deserializer = Deserializer.getInstance();
        } catch (IOException e) {
            e.printStackTrace();
        }

        booksList = deserializer.getBooksList();
        //System.out.println("Dlugosc listy: " + booksList.getItems().length);

        return books;
    }
}
