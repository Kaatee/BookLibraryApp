package app;

import resourcesHandlers.BookDetailsResource;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import resourcesHandlers.CategoryResource;
import resourcesHandlers.RatingResource;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;

public class Main {
    public static String PATH;
    /**
     * Main class of program. Runs server
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //PATH = "C:\\Users\\Kasia\\Desktop\\BookLibraryApp\\BookLibraryApp\\src\\main\\java\\app\\books.json";
        PATH="https://www.googleapis.com/books/v1/volumes?q=java&maxResults=40";
        URI baseUri = UriBuilder.fromUri("http://localhost/").port(8000).build();
        ResourceConfig config = new ResourceConfig(BookDetailsResource.class, CategoryResource.class, RatingResource.class);
        HttpServer httpServer = GrizzlyHttpServerFactory.createHttpServer(baseUri, config);
        try {
            httpServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
