package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageLinks {
    private String thumbnail;


    /**
     * Class constructor specifying:
     * @param thumbnail
     */
    public ImageLinks(String thumbnail){
        this.thumbnail = thumbnail;
    }

    /**
     * Class constructor
     */
    public ImageLinks(){}

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
}
