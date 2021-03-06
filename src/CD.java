
/**
 * Class that represents a CD
 * Please come up with your own fields and methods (hint: look in the text files)
 * Do not forget to implement the toString method in this class!
 * @author Evert Duipmans
 */
public class CD {
	// TODO: Here comes your implementation
    private String title;
    private String author;
    private int tracks;
    private int min;
    private int sec;
    private  String publisher;


    public CD(String t, String atr, int tr, int m, int s, String pub) {
        title = t;
        author = atr;
        tracks = tr;
        min = m;
        sec = s;
        publisher = pub;
    }

    @Override
    public String toString() {
        String str = "";
        str = "title: " + title + ", author: " + author + ", tracks: " + tracks + ", minutes: " + min +
                ", sec: " + sec + ", publisher: " + publisher;
        return str;
    }
}