package mitko.home4task1;

/**
 * Created by LUKARSKI on 23.9.2016 г..
 */

public class Song {
    private String title, artistName;

    public Song(String title, String artistName) {
        this.title = title;
        this.artistName = artistName;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String value) {
        this.title = value;
    }

    public String getArtistName() {
        return artistName;
    }
    public void setArtistName(String value) {
        this.artistName = value;
    }


}
