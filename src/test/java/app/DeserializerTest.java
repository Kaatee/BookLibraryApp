package app;

import model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class DeserializerTest {
    private Book[] exceptedBooksList;


    /**
     * prepare DeserializerTest
     */
    @Before
    public void setup(){
        InstanceMaker insMaker = InstanceMaker.getInstance();
        exceptedBooksList = insMaker.getExceptedBooksList();
    }

    /**
     * tests deserialization
     * @throws IOException
     */
    @Test
    public void getInstance() throws IOException{
        String path = new File("").getAbsolutePath() + Const.RELATIVE_PATH;
        Deserializer des = Deserializer.getInstance(path);

        Book[] deserializedBooks = des.getBooksList().getItems();

        assertEquals(exceptedBooksList.length, deserializedBooks.length);
        for (int i=0; i<deserializedBooks.length; i++) {
            VolumeInfo exceptedVI = exceptedBooksList[i].getVolumeInfo();
            VolumeInfo actualVI = deserializedBooks[i].getVolumeInfo();

            assertArrayEquals(exceptedVI.getAuthors(), actualVI.getAuthors());
            assertArrayEquals(exceptedVI.getCategories(), actualVI.getCategories());
            assertEquals(exceptedVI.getAverageRating(), actualVI.getAverageRating());
            assertEquals(exceptedVI.getPageCount(), actualVI.getPageCount());
            assertEquals(exceptedVI.getPreviewLink(), actualVI.getPreviewLink());
            assertEquals(exceptedVI.getLanguage(), actualVI.getLanguage());
            assertEquals(exceptedVI.getDescription(), actualVI.getDescription());
            assertEquals(exceptedVI.getPublishedDate(), actualVI.getPublishedDate());
            assertEquals(exceptedVI.getPublisher(), actualVI.getPublisher());
            assertEquals(exceptedVI.getTitle(), actualVI.getTitle());
            assertEquals(exceptedVI.getSubtitle(), actualVI.getSubtitle());

            if(exceptedVI.getImageLinks()!= null && actualVI.getImageLinks()!=null ) {
                assertEquals(exceptedVI.getImageLinks().getThumbnail(), actualVI.getImageLinks().getThumbnail());
            }
            else{
                assertNull(exceptedVI.getImageLinks());
                assertNull(actualVI.getImageLinks());
            }

            assertEquals(exceptedVI.getIndustryIdentifiers().length, actualVI.getIndustryIdentifiers().length );
            for (int j=0; j<actualVI.getIndustryIdentifiers().length; j++){
                assertEquals(exceptedVI.getIndustryIdentifiers()[j].getIdentifier(), actualVI.getIndustryIdentifiers()[j].getIdentifier());
            }
        }
    }
}