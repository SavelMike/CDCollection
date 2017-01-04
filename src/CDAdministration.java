import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Administration class in which CDs are stored
 * @author Evert Duipmans
 */
public class CDAdministration {
	private ArrayList<CD> cds = new ArrayList<>();
	
	/**
	 * Method to read CDs from a filename and store them in a list
	 * Make sure that this method throws and CDException when there is an invalid line in the file
	 * @param filename Name of the file
	 * @throws CDException Exception that will be thrown when the line cannot be processed
	 */
	public void readCDsFromFile(String filename) throws CDException, FileNotFoundException {
		// TODO: Here comes your implementation
		// Open scanner by using Filename;
		File f = new File(filename);
		Scanner sc = new Scanner(f);
		// Read file by lines;
		while (sc.hasNextLine()) {
			String str = sc.nextLine();
			// if line is a comment, keep run while loop;
			if ((str.length() == 0) && (str.charAt(0) == '#')) {
				continue;
			}
			CD cd = readLine(str);

			// add cd to array list
			cds.add(cd);
		}
	}

	/**
	 * Processes a line that was read from a file
	 * @param line Line from a file
	 * @return CD The object that was created using the information on the line
	 * @throws CDException Exception that will be thrown when the line cannot be processed
	 */
	private CD readLine(String line) throws CDException {
		// TODO: Here comes your implementation

		// 1. open scanner associated with string
		Scanner sc = new Scanner(line);

		// 2. set delimiter to ;
		sc.useDelimiter(";");

		// 3. read title, if can not read title - throw exception
		String title;
		if (sc.hasNext()) {
			title = sc.next();
		} else {
			throw new CDException("Cannot get title");
		}

		// 4. read author, if can not read author ....
		String author;
		if (sc.hasNext()) {
			author = sc.next();
		} else {
			throw new CDException("Cannot get author");
		}

		// 5. read number of tracks
		int tracks;
		if (sc.hasNextInt()) {
			tracks = sc.nextInt();
		} else {
			throw new CDException("Cannot get tracks");
		}

		// 6. minutes and seconds
		String minSec;
		int min = 0;
		int sec = 0;
		if (sc.hasNext()) {
			minSec = sc.next();
			// parse num,num
			Scanner scMS = new Scanner(minSec);
			scMS.useDelimiter(",");
			if (scMS.hasNextInt()) {
				min = scMS.nextInt();
			} else {
				throw new CDException("Cannot get minutes");
			}
			if (scMS.hasNextInt()) {
				sec = scMS.nextInt();
			} else {
				throw new CDException("Cannot get seconds");
			}
			if (scMS.hasNext()) {
				throw new CDException("Wrong format");
			}
		}
		// 7. read publisher
		String publisher;
		if (sc.hasNext()) {
			publisher = sc.next();
		} else {
			throw new CDException("Cannot get publisher");
		}

		return new CD(title, author, tracks, min, sec, publisher);
	}

	
	/**
	 * Print een overzicht van alle CD's (maak een toString methode in de klasse CD)
	 */
	@Override
	public String toString() {
		String result = "";
		for (CD cd : cds) {
			result += cd.toString() + "\n";
		}
		return result;
	}
}