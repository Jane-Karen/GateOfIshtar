/**
 * The Gate Of Ishtar
 * 
 * Created by Jane Karen Kumar
 * 
 * Date: 19 March 2018
 * 
 * Description: This Giant class is used to accommodate all the activities which are to be done by the Champion-Giant.
 * 
 */

package jane.karen.gate.of.ishtar;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Giant extends Thread {

	static String dayOfWeek;
	static boolean AttackStatus = false;
	Brand BrandThread ;
	Mithra MithraThread ;
	Khaleesi KhaleesiThread ;
	static int hp;

	//Sets the Giant HP
	static void set_hp(int HP) {
		hp = HP;
	}

	//Returns the Giant HP
	static int get_hp() {
		return hp;
	}
	
	//Set the attack status
	static void setAttackStatus(boolean attack) {
		AttackStatus = attack;
	}

	//Returns the attack status
	static boolean getAttackStatus() {
		return AttackStatus;
	}
	
	//Function to be called when Giant has to meet the Council
	static void meetCouncil() {
		
		SimpleDateFormat simpleDateformat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();

		System.out.println( "Giant Met Council " + "HH:MM:SS :: " + simpleDateformat.format(date) + " HP :: " + get_hp());
	}
	
	/* 
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		
		// the day of the week spelled out completely
        Date now = new Date();
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE");
        dayOfWeek = simpleDateformat.format(now);		
		
		System.out.println("Giant Running : " + "HH:MM:SS :: " + " HP :: " + get_hp());

		try {
			Thread.sleep((long) (Math.random() * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		switch (dayOfWeek) {

		case "Tuesday":
			meetCouncil();
			break;

		case "Thursday":
			meetCouncil();
			break;

		default:
			{				
				callEnemy();
			}
			break;
		}

	}
	
	/**
	 * Call Random Enemy
	 */
	public void callEnemy() {

		BrandThread = new Brand(4);
		MithraThread = new Mithra(4);
		KhaleesiThread = new Khaleesi(4);
		
		Enemy[] enemyData = new Enemy[3];

		enemyData[0] = new Enemy(1);
		enemyData[1] = new Enemy(2);
		enemyData[2] = new Enemy(3);

		int i = 0;
		int running_index = 0;
		int[] running_enemy = new int[3];
		boolean status = false;

		do {

			Random rand = new Random();
			int random_enemy_select = rand.nextInt(3);

			for (int temp_index = 0; temp_index < 3; temp_index++) {

				if ((random_enemy_select + 1) == running_enemy[temp_index]) {
					status = true;
					break;

				} else {
					status = false;
				}
			}

			if (status == false) {
				running_enemy[running_index] = enemyData[random_enemy_select].id;
				running_index++;

				switch (enemyData[random_enemy_select].id) {
				case 1:
					BrandThread.start();
					break;

				case 2:
					MithraThread.start();
					break;

				case 3:
					KhaleesiThread.start();
					break;

				default:
				}

			}
			i++;

			try {
				Thread.sleep((long) (Math.random() * 100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} while (i < 50);
		
	}
}