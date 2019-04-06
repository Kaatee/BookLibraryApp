package resourcesHandlers;

import app.Const;
import app.Constants;
import app.Deserializer;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.io.File;
import java.net.URI;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BookDetailsResourceTest {
    Deserializer des;
    private HttpServer server;
    private WebTarget target;
    private String excepted;

    /**
     * prepare DookDetailsResource tests
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        String path = new File("").getAbsolutePath() + Const.RELATIVE_PATH;
        Deserializer.getInstance(path);

        URI baseUri = UriBuilder.fromUri(Const.URI_LOCALHOST).port(9998).build();
        ResourceConfig rc = new ResourceConfig(BookDetailsResource.class);
        server = GrizzlyHttpServerFactory.createHttpServer(baseUri, rc);
        server.start();

        Client c = ClientBuilder.newClient();
        target = c.target("http://localhost:9998").register(BookDetailsResource.class).path("book");

    }

    /**
     * Check working of http://localhost:9998/book/{isbn} request
     * Check request for existing book
     */
    @Test
    public void getExistingBookByISBN1() {
        excepted = "{\"isbn\":\"9788324677658\",\"title\":\"Java. Techniki zaawansowane. Wydanie IX\",\"publisher\":\"Helion\",\"publishedDate\":1386543600,\"description\":\"Dziewiąte ...\",\"pageCount\":992,\"thumbnail\":\"http://books.google.com/books/content?id=mVNjAgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\",\"language\":\"pl\",\"previewLink\":\"http://books.google.pl/books?id=mVNjAgAAQBAJ&printsec=frontcover&dq=java&hl=&cd=5&source=gbs_api\",\"averageRating\":3.0,\"authors\":[\"Cay S. Horstmann\",\"Gary Cornell\"],\"categories\":[\"Java\",\"Computers\",\"Test\"]}";

        WebTarget isbn1WebTarget = target.path("9788324677658");
        Invocation.Builder invocationBuilder = isbn1WebTarget.request(Const.APPLICATION_JSON);
        invocationBuilder.header("some-header", "true");
        Response response = invocationBuilder.get();

        assertEquals(excepted, response.readEntity(String.class));
        assertEquals(200, response.getStatus());

        server.stop();
    }

    /**
     *  Check working of http://localhost:9998/book/{isbn} request
     *  Check request for existing book
     */
    @Test
    public void getNONExistingBookByISBN() {
        excepted = Constants.NO_RESULT_FOUND;

        WebTarget isbn1WebTarget = target.path("abc");
        Invocation.Builder invocationBuilder = isbn1WebTarget.request(Const.APPLICATION_JSON);
        invocationBuilder.header("some-header", "true");
        Response response = invocationBuilder.get();

        assertEquals(excepted, response.readEntity(String.class));
        assertEquals(404, response.getStatus());

        server.stop();
    }

    /**
     * Clean up after tests
     */
    @After
    public void clean(){
        des.deleteInstance();
    }
}