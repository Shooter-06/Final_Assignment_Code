package com.example.finalassignment;

public class Colors {
    String albumId;
    String id;
    String title;
    String URL;
    String thumbnailURL;

    public Colors(String albumId, String id, String title, String URL, String thumbnailURL) {
        this.albumId = albumId;
        this.id = id;
        this.title = title;
        this.URL = URL;
        this.thumbnailURL = thumbnailURL;
    }

    public String getAlbumId() {return albumId;}

    public void setAlbumId(String albumId) {this.albumId = albumId; }

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getURL() {return URL;}

    public void setURL(String URL) {this.URL = URL; }

    public String getThumbnailURL() {return thumbnailURL;}

    public void setThumbnailURL(String thumbnailURL) {this.thumbnailURL = thumbnailURL;}

    @Override
    public String toString() {
        return "Colors{" +
                "albumId='" + albumId + '\'' +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", URL='" + URL + '\'' +
                ", thumbnailURL='" + thumbnailURL + '\'' +
                '}';
    }
}
