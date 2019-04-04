package model;

public class VolumeInfo {
    private String title;
    private String subtitle;
    private String publisher;
    private String publishedDate;
    private String description;
    private IndustryIdentifiers[] industryIdentifiers;
    private Integer pageCount;
    private ImageLinks imageLinks;
    private String language;
    private String previewLink;
    private Double averageRating;
    private String[] authors;
    private String[] categories;

    /**
     * Class constructor
     */
    public VolumeInfo(){}

    /**
     * Class constructor specifying:
     * @param title
     * @param subtitle
     * @param publisher
     * @param publishedDate
     * @param description
     * @param industryIdentifiers
     * @param pageCount
     * @param imageLinks
     * @param language
     * @param previewLink
     * @param averageRating
     * @param authors
     * @param categories
     */
    public VolumeInfo(String title, String subtitle, String publisher, String publishedDate, String description, IndustryIdentifiers[] industryIdentifiers, Integer pageCount, ImageLinks imageLinks, String language, String previewLink, Double averageRating, String[] authors, String[] categories){
        this.title = title;
        this.subtitle = subtitle;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.description = description;
        this.industryIdentifiers = industryIdentifiers;
        this.pageCount = pageCount;
        this.imageLinks = imageLinks;
        this.language = language;
        this.previewLink = previewLink;
        this.averageRating = averageRating;
        this.authors = authors;
        this.categories = categories;
    }


    /**
     * @return book's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * set book's title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return book's subtitle
     */
    public String getSubtitle() {
        return subtitle;
    }

    /**
     * set book's subtitle
     * @param subtitle
     */
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
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
     * @return published date
     */
    public String getPublishedDate() {
        return publishedDate;
    }

    /**
     * @param publishedDate
     */
    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
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
     * @return page count
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
     * @return imageLinks
     */
    public ImageLinks getImageLinks() {
        return imageLinks;
    }

    /**
     * @param imageLinks
     */
    public void setImageLinks(ImageLinks imageLinks) {
        this.imageLinks = imageLinks;
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
     * @return average rating
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
     * @return array[] of book's authors
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
     * @return array[] of book's categories
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

    /**
     * @return industryIdentifiers object
     */
    public IndustryIdentifiers[] getIndustryIdentifiers() {
        return industryIdentifiers;
    }

    /**
     * @param industryIdentifiers
     */
    public void setIndustryIdentifiers(IndustryIdentifiers[] industryIdentifiers) {
        this.industryIdentifiers = industryIdentifiers;
    }

}
