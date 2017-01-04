
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
    private String minSec;
    private  String publisher;


    public CD(String t, String atr, int tr, String msec, String pub) {
        title = t;
        author = atr;
        tracks = tr;
        minSec = msec;
        publisher = pub;
    }
}