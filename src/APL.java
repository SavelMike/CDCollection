
/**
 * Application class
 * You do not have to make any adjustments to this file!!!
 * @author Evert Duipmans
 */
public class APL {
	public static void main(String[] args) {
		CDAdministration administration = new CDAdministration();
		
		try {
			// Read the correct file:
			administration.readCDsFromFile("goodfile.txt");
			
			// Read the incorrect file
			administration.readCDsFromFile("wrongfile.txt");
		} catch (CDException cdex) {
			System.err.println(cdex.getMessage());
		}
		
		// Show all the CDs in the system
		System.out.println(administration);
	}
}