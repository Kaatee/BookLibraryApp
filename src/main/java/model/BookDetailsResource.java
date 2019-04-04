package model;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/book/{isbn}")
public class BookDetailsResource {

    @GET
    @Produces("application/json")
    public String getBookByISBN(@PathParam("isbn") String isbn){
        String books = "abc";


        return books;
    }
}
