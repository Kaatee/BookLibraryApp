package resourcesHandlers;

import app.Constants;
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

import static org.junit.Assert.*;

public class CategoryResourceTest {
    Deserializer des;
    private HttpServer server;
    private WebTarget target;
    private String excepted;

    @Before
    public void setUp() throws Exception {
        String path = new File("").getAbsolutePath() + "\\src\\test\\java\\app\\booksTest.json";
        Deserializer.getInstance(path);

        URI baseUri = UriBuilder.fromUri("http://localhost/").port(9998).build();
        ResourceConfig rc = new ResourceConfig(CategoryResource.class);
        server = GrizzlyHttpServerFactory.createHttpServer(baseUri, rc);
        server.start();

        Client c = ClientBuilder.newClient();
        target = c.target("http://localhost:9998").register(CategoryResource.class).path("category");
    }

    @Test
    public void getExistingCategoryBooks1() {
        excepted = "[{\"isbn\":\"9788324677658\",\"title\":\"Java. Techniki zaawansowane. Wydanie IX\",\"publisher\":\"Helion\",\"publishedDate\":1386543600,\"description\":\"Dziewiąte ...\",\"pageCount\":992,\"thumbnail\":\"http://books.google.com/books/content?id=mVNjAgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\",\"language\":\"pl\",\"previewLink\":\"http://books.google.pl/books?id=mVNjAgAAQBAJ&printsec=frontcover&dq=java&hl=&cd=5&source=gbs_api\",\"averageRating\":3.0,\"authors\":[\"Cay S. Horstmann\",\"Gary Cornell\"],\"categories\":[\"Java\",\"Computers\",\"Test\"]},{\"isbn\":\"0131002872\",\"title\":\"Thinking in Java\",\"publisher\":\"Prentice Hall Professional\",\"publishedDate\":1041375600,\"description\":\"An overview of the programming language's fundamentals covers syntax, initialization, implementation, classes, error handling, objects, applets, multiple threads, projects, and network programming.\",\"pageCount\":1119,\"thumbnail\":\"http://books.google.com/books/content?id=Ql6QgWf6i7cC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\",\"language\":\"en\",\"previewLink\":\"http://books.google.pl/books?id=Ql6QgWf6i7cC&printsec=frontcover&dq=java&hl=&cd=7&source=gbs_api\",\"averageRating\":4.0,\"authors\":[\"Bruce Eckel\"],\"categories\":[\"Computers\",\"Java\"]},{\"isbn\":\"9781592432172\",\"title\":\"A Hypervista of the Java Landscape\",\"publisher\":\"InfoStrategist.com\",\"thumbnail\":\"http://books.google.com/books/content?id=7tkN1CYzn2cC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\",\"language\":\"en\",\"previewLink\":\"http://books.google.pl/books?id=7tkN1CYzn2cC&pg=PP1&dq=java&hl=&cd=1&source=gbs_api\",\"averageRating\":3.5,\"authors\":[\"Bruce Eckel\"],\"categories\":[\"Computers\"]}]";

        WebTarget isbn1WebTarget = target.path("Computers");
        Invocation.Builder invocationBuilder = isbn1WebTarget.request("application/json");
        invocationBuilder.header("some-header", "true");
        Response response = invocationBuilder.get();

        assertEquals(excepted, response.readEntity(String.class));
        assertEquals(200, response.getStatus());

        server.stop();
    }

    @Test
    public void getExistingCategoryBooks2() {
        excepted = "[{\"isbn\":\"9788324677658\"," +
                "\"title\":\"Java. Techniki zaawansowane. Wydanie IX\",\"publisher\":\"Helion\",\"publishedDate\":1386543600,\"description\":\"Dziewiąte ...\",\"pageCount\":992,\"thumbnail\":\"http://books.google.com/books/content?id=mVNjAgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\",\"language\":\"pl\",\"previewLink\":\"http://books.google.pl/books?id=mVNjAgAAQBAJ&printsec=frontcover&dq=java&hl=&cd=5&source=gbs_api\",\"averageRating\":3.0,\"authors\":[\"Cay S. Horstmann\",\"Gary Cornell\"],\"categories\":[\"Java\",\"Computers\",\"Test\"]},{\"isbn\":\"0131002872\",\"title\":\"Thinking in Java\",\"publisher\":\"Prentice Hall Professional\",\"publishedDate\":1041375600,\"description\":\"An overview of the programming language's fundamentals covers syntax, initialization, implementation, classes, error handling, objects, applets, multiple threads, projects, and network programming.\",\"pageCount\":1119,\"thumbnail\":\"http://books.google.com/books/content?id=Ql6QgWf6i7cC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\",\"language\":\"en\",\"previewLink\":\"http://books.google.pl/books?id=Ql6QgWf6i7cC&printsec=frontcover&dq=java&hl=&cd=7&source=gbs_api\",\"averageRating\":4.0,\"authors\":[\"Bruce Eckel\"],\"categories\":[\"Computers\",\"Java\"]}]";
        WebTarget isbn1WebTarget = target.path("Java");
        Invocation.Builder invocationBuilder = isbn1WebTarget.request("application/json");
        invocationBuilder.header("some-header", "true");
        Response response = invocationBuilder.get();

        assertEquals(excepted, response.readEntity(String.class));
        assertEquals(200, response.getStatus());

        server.stop();
    }

    @Test
    public void getNONExistingCategoryBooks() {
        excepted = "[]";

        WebTarget isbn1WebTarget = target.path("Abc");
        Invocation.Builder invocationBuilder = isbn1WebTarget.request("application/json");
        invocationBuilder.header("some-header", "true");
        Response response = invocationBuilder.get();

        assertEquals(excepted, response.readEntity(String.class));
        assertEquals(200, response.getStatus());

        server.stop();
    }

    @After
    public void tearDown() throws Exception {
        des.deleteInstance();
    }
}