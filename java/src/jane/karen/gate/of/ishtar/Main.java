/**
 * The Gate Of Ishtar
 * 
 * Created by Jane Karen Kumar
 * 
 * Date: 17 March 2018
 * 
 */

package jane.karen.gate.of.ishtar;

import java.util.Random;

public class Main {

	static int i = 0;
	static int running_index = 0;
	static int[] running_champs = new int[5];
	static boolean status = false;

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException {
		
		Champions[] champData = new Champions[5];

		champData[0] = new Champions(1, "HUMAN");
		champData[1] = new Champions(2, "WIZARD");
		champData[2] = new Champions(3, "SPIRIT");
		champData[3] = new Champions(4, "GIANT");
		champData[4] = new Champions(5, "VAMPIRE"); 
		
		do {
			//Random selection of Champions
			Random rand = new Random();
			int random_champ_select = rand.nextInt(5);

			for (int temp_index = 0; temp_index < 5; temp_index++) {

				if ((random_champ_select + 1) == running_champs[temp_index]) {
					status = true;
					break;
				} else {
					status = false;
				}
			}

			if (status == false) {
				running_champs[running_index] = champData[random_champ_select].get_id();
				running_index++;
				
				switch (champData[random_champ_select].get_id()) {
					case 1:
						Human humanThread = new Human();
						humanThread.set_hp(100);
						humanThread.start();
						break;
	
					case 2:
						Wizard wizardThread = new Wizard();
						wizardThread.set_hp(100);
						wizardThread.start();
						break;
	
					case 3:
						Spirit spiritThread = new Spirit();
						spiritThread.set_hp(100);
						spiritThread.start();
						break;
	
					case 4:
						Giant giantThread = new Giant();
						giantThread.set_hp(150);
						giantThread.start();
						break;
	
					case 5:
						Vampire vampireThread = new Vampire();
						vampireThread.set_hp(110);
						vampireThread.start();
						break;
	
					default:
						break;
					}
			}
			
			i++;

			Thread.sleep((long) (Math.random() * 100));

		} while (i < 50);

	}
}
