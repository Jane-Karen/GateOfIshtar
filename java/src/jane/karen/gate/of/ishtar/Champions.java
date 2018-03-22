/**
 * The Gate Of Ishtar
 * 
 * Created by Jane Karen Kumar
 * 
 * Date: 16 March 2018
 * 
 */

package jane.karen.gate.of.ishtar;

public class Champions{
	int id;
	String champion;
	static int hp;
	
	// Constructor
	Champions(int ID, String Champion) {
		id = ID;
		champion = Champion;
	}

	int get_id() {
		return id;
	}
}
