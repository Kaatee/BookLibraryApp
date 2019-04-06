package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BookToSerialize {
    private String isbn;
    private String title;
    private String subtitle;
    private String publisher;
    private Long publishedDate;
    private String description;
    private Integer pageCount;
    private String thumbnail;
    private String language;
    private String previewLink;
    private Double averageRating;
    private String[] authors;
    private String[] categories;

    /**
     * Class constructor
     */
    public BookToSerialize(){}

    /**
     * Class constructor specifying:
     * @param isbn
     * @param title
     * @param subtitle
     * @param publisher
     * @param publishedDate
     * @param description
     * @param pageCount
     * @param thumbnail
     * @param language
     * @param previewLink
     * @param averageRating
     * @param authors
     * @param categories
     */
    public BookToSerialize( String isbn, String title, String subtitle, String publisher, String publishedDate,
                            String description, Integer pageCount, String thumbnail, String language,
                            String previewLink, Double averageRating, String[] authors,String[] categories)
    {
        this.isbn = isbn;
        this.title = title;
        this.subtitle = subtitle;
        this.publisher = publisher;

        this.setPublishedDate(publishedDate);

        this.description = description;
        this.pageCount = pageCount;
        this.thumbnail = thumbnail;
        this.language = language;
        this.previewLink = previewLink;
        this.averageRating = averageRating;
        this.authors = authors;
        this.categories = categories;

    }

    /**
     * @return isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return subtitle
     */
    public String getSubtitle() {
        return subtitle;
    }

    /**
     * @param subtitle
     */
    public void setSubtitle(String subtitle) {
    }

    /**
     * @return publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * @param publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * @return publishedDate
     */
    public Long getPublishedDate() {
        return publishedDate;
    }

    /**
     * set published date (convert "yyyy-MM-dd" or "yyyy" to long)
     * @param publishedDate (as "yyyy-MM-dd" or "yyyy")
     */
    public void setPublishedDate(String publishedDate) {
        try {
            if(publishedDate!=null) {
                SimpleDateFormat dateFormat;
                String[] splited = publishedDate.split("-");
                if (splited.length==3){
                    if(splited[0].length()==4)
                        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    else
                        dateFormat = new SimpleDateFormat("MM-dd-yyyy");
                }
                else {
                    if (splited.length == 1)
                        dateFormat = new SimpleDateFormat("yyyy");
                    else
                        dateFormat = new SimpleDateFormat("yyyy-MM");
                }

                Date date = null;
                date = dateFormat.parse(publishedDate);
                this.publishedDate = (long) date.getTime() / 1000;
            }
        } catch (Exception e) {
            System.out.println("Jestem tu");
            e.printStackTrace();
        }


    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return pageCount
     */
    public Integer getPageCount() {
        return pageCount;
    }

    /**
     * @param pageCount
     */
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * @return thumbnail
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * @param thumbnail
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     * @return language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return previewLink
     */
    public String getPreviewLink() {
        return previewLink;
    }

    /**
     * @param previewLink
     */
    public void setPreviewLink(String previewLink) {
        this.previewLink = previewLink;
    }

    /**
     * @return averageRating
     */
    public Double getAverageRating() {
        return averageRating;
    }

    /**
     * @param averageRating
     */
    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    /**
     * @return authors array[]
     */
    public String[] getAuthors() {
        return authors;
    }

    /**
     * @param authors
     */
    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    /**
     * @return categories array[]
     */
    public String[] getCategories() {
        return categories;
    }

    /**
     * @param categories
     */
    public void setCategories(String[] categories) {
        this.categories = categories;
    }
}
