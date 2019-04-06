package resourcesHandlers;

import app.Const;
import app.Deserializer;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class RatingResourceTest {
    Deserializer des;
    private HttpServer server;
    private WebTarget target;
    private String excepted;

    @Before
    public void setUp() throws Exception {
        String path = new File("").getAbsolutePath() + "\\src\\test\\java\\app\\booksTest.json";
        Deserializer.getInstance(path);

        URI baseUri = UriBuilder.fromUri("http://localhost/").port(8081).build();
        ResourceConfig rc = new ResourceConfig(RatingResource.class);
        server = GrizzlyHttpServerFactory.createHttpServer(baseUri, rc);
        server.start();

        Client c = ClientBuilder.newClient();
        target = c.target("http://localhost:8081").register(RatingResource.class).path("rating");
    }


    @Test
    public void getAuthorsRating() {
        excepted = "[{\"author\":\"Bruce Eckel\",\"averageRating\":3.75}," +
                "{\"author\":\"Gary Cornell\",\"averageRating\":3.0}," +
                "{\"author\":\"Cay S. Horstmann\",\"averageRating\":3.0}]";

        Invocation.Builder invocationBuilder = target.request("application/json");
        invocationBuilder.header("some-header", "true");
        Response response = invocationBuilder.get();

        assertEquals(excepted, response.readEntity(String.class));
        assertEquals(200, response.getStatus());

        server.stop();
    }

    @Test
    public void sum() {
        RatingResource authorsRatingHandler = new RatingResource();
        ArrayList<Double> array1 = new ArrayList();
        array1.add(1.5);
        array1.add(1.5);
        assertEquals(3.0, authorsRatingHandler.sum(array1), Const.DELTA);

        ArrayList<Double> array2 = new ArrayList();
        assertEquals(0.0, authorsRatingHandler.sum(array2), Const.DELTA);

        ArrayList<Double> array3 = new ArrayList();
        array3.add(8.8);
        array3.add(1.5);
        assertEquals(10.3, authorsRatingHandler.sum(array3), Const.DELTA);

        server.stop();
    }


    @After
    public void tearDown() throws Exception {
        des.deleteInstance();
    }
}