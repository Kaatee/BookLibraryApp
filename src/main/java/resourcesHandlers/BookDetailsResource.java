package resourcesHandlers;

import app.Constants;
import app.Deserializer;
import app.Main;
import com.fasterxml.jackson.core.JsonProcessingException;
import model.Book;
import model.BookToDeserialize;
import model.BookToSerialize;
import model.VolumeInfo;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
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
    public Response getBookByISBN(@PathParam("isbn") String isbn) {
        String result="";
        try {
            deserializer = Deserializer.getInstance(Main.PATH);

            booksList = deserializer.getBooksList();
            Book[] books = booksList.getItems();

            for (int i = 0; i < books.length; i++){
                try{
                if (books[i].getVolumeInfo().getIndustryIdentifiers()[0].getIdentifier().equals(isbn) || books[i].getVolumeInfo().getIndustryIdentifiers()[1].getIdentifier().equals(isbn)) {
                    VolumeInfo book = books[i].getVolumeInfo();

                    BookToSerialize bookToSerialize = new BookToSerialize(isbn, book.getTitle(), book.getSubtitle(), book.getPublisher(),
                            book.getPublishedDate(), book.getDescription(), book.getPageCount(),book.getImageLinks().getThumbnail(),
                            book.getLanguage(), book.getPreviewLink(), book.getAverageRating(), book.getAuthors(), book.getCategories());

                    result = deserializer.getMapper().writeValueAsString(bookToSerialize);
                    break;
                }
                }catch (Exception e){
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(result.equals("")){
            Response response = Response.status(404).type(Constants.PLAIN_TEXT).entity(Constants.NO_RESULT_FOUND).
                    header("headerName", "headerValue").build();
            return response;
        }

        Response response = Response.status(200).entity(result).header("yourHeaderName", "yourHeaderValue").build();
        return response;
    }
}
