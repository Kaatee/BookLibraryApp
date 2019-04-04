package model;

public class Book {
    private VolumeInfo volumeInfo;

    /**
     * Class constructor
     */
    public Book(){}

    /**
     * Class constructor specifying book's volumeInfo
     * @param volumeInfo
     */
    public Book(VolumeInfo volumeInfo){
        this.volumeInfo = volumeInfo;
    }

    /**
     * @return volumeInfo
     */
    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    /**
     * @param volumeInfo
     */
    public void setVolumeInfo(VolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }
}
