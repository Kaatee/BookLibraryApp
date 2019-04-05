package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookToDeserialize {
    private Book[] items;

    /**
     * Class constructor specifying list of books (named items in JSON file)
     * @param items
     */
    public BookToDeserialize(Book[] items){
        this.items = items;
    }

    /**
     * Class constructor
     */
    public BookToDeserialize(){}


    /**
     * @return items
     */
    public Book[] getItems() {
        return items;
    }

    /**
     * @param items
     */
    public void setItems(Book[] items) {
        this.items = items;
    }
}
