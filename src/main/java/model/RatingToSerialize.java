package model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RatingToSerialize {
    private String author;
    private double averageRating;

    /**
     * Class constructor specifying author and his/her average rating
     *
     * @param author
     * @param averageRating
     */
    public RatingToSerialize(String author, double averageRating) {
        this.author = author;
        this.averageRating = averageRating;
    }

    /**
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return averageRating
     */
    public double getAverageRating() {
        return averageRating;
    }

    /**
     * @param averageRating
     */
    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

}
