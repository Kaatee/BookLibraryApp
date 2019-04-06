package resourcesHandlers;

import app.Deserializer;
import app.Main;
import model.Book;
import model.BookToDeserialize;
import model.RatingToSerialize;
import model.VolumeInfo;
import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("/rating")
public class RatingResource {
    private Deserializer deserializer;
    private BookToDeserialize booksList;


    @GET
    @Produces("application/json")
    public Response getCategoryBooks() {
        String result = "";
        JSONArray booksToSerialize = new JSONArray();
        Map<String, ArrayList<Double>> authors = new HashMap();

        try {
            deserializer = Deserializer.getInstance(Main.PATH);

            booksList = deserializer.getBooksList();
            Book[] books = booksList.getItems();
            for (int i = 0; i < books.length; i++) {
                try {
                    VolumeInfo book = books[i].getVolumeInfo();

                    ArrayList<String> authTmp;
                    if (book.getAuthors() != null) {
                        authTmp = new ArrayList<>(Arrays.asList(book.getAuthors()));
                    } else {
                        authTmp = new ArrayList<>();
                    }

                    double avgRatio = book.getAverageRating();
                    if (avgRatio != 0.0) {
                        for (String author : authTmp) {
                            if (!authors.containsKey(author)) {
                                ArrayList<Double> newList = new ArrayList<>();
                                newList.add(avgRatio);
                                authors.put(author, newList);
                            } else {
                                ArrayList<Double> newArray = authors.get(author);
                                newArray.add(avgRatio);
                                authors.replace(author, newArray);
                            }
                        }
                    }
                } catch (Exception e) {
                }
            }

            for (Map.Entry<String, ArrayList<Double>> entry : authors.entrySet()) {
                double avg = sum(entry.getValue()) / entry.getValue().size();
                RatingToSerialize a = new RatingToSerialize(entry.getKey(), avg);
                booksToSerialize.add(a);
            }

            //sorting list descending
            Collections.sort(booksToSerialize, new Comparator<RatingToSerialize>() {
                @Override
                public int compare(RatingToSerialize a, RatingToSerialize b) {
                    Double valA = a.getAverageRating();
                    Double valB = b.getAverageRating();

                    return -valA.compareTo(valB);
                }
            });

            result = deserializer.getMapper().writeValueAsString(booksToSerialize);
        } catch (Exception e) {
        }

        Response response = Response.status(200).entity(result).header("rating", "authorRating").build();
        return response;
    }

    /**
     * sum up all values in array list of double
     * @param array
     * @return sum of values in array
     */
    public static double sum(ArrayList<Double> array) {
        double sum = 0.0;
        for (double d : array) {
            sum += d;
        }
        return sum;
    }

}
