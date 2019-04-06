package resourcesHandlers;

import app.Deserializer;
import app.Main;
import model.Book;
import model.BookToDeserialize;
import model.BookToSerialize;
import model.VolumeInfo;
import org.json.simple.JSONArray;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.Arrays;

@Path("/category/{categoryName}")
public class CategoryResource {
    private Deserializer deserializer;
    private BookToDeserialize booksList;

    @GET
    @Produces("application/json")
    public Response getCategoryBooks(@PathParam("categoryName") String categoryName) {
        String result = "";
        JSONArray booksToSerialize = new JSONArray();
        try {
            deserializer = Deserializer.getInstance(Main.PATH);

            booksList = deserializer.getBooksList();
            Book[] books = booksList.getItems();

            for (int i = 0; i < books.length; i++) {
                try {
                    if (Arrays.asList(books[i].getVolumeInfo().getCategories()).contains(categoryName)) {
                        VolumeInfo book = books[i].getVolumeInfo();
                        String isbn = book.getIndustryIdentifiers()[0].getIdentifier();
                        try {
                            isbn = book.getIndustryIdentifiers()[2].getIdentifier();
                        } catch (Exception e) {
                        }

                        BookToSerialize bookToSerialize = new BookToSerialize(isbn, book.getTitle(), book.getSubtitle(), book.getPublisher(),
                                book.getPublishedDate(), book.getDescription(), book.getPageCount(), book.getImageLinks().getThumbnail(),
                                book.getLanguage(), book.getPreviewLink(), book.getAverageRating(), book.getAuthors(), book.getCategories());
                        booksToSerialize.add(bookToSerialize);

                    }
                } catch (Exception e) {
                }
            }

            result = deserializer.getMapper().writeValueAsString(booksToSerialize);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Response response = Response.status(200).entity(result).header("category", "bookCategory").build();
        return response;
    }
}
