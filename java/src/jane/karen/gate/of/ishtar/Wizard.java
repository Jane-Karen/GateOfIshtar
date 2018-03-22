/**
 * The Gate Of Ishtar
 * 
 * Created by Jane Karen Kumar
 * 
 * Date: 19 March 2018
 * 
 * Description: This Wizard class is used to accomodate all the activities which are to be done by the Champion-Wizard.
 * 
 */

package jane.karen.gate.of.ishtar;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Wizard extends Thread  {
	
	static String dayOfWeek;
	static boolean AttackStatus = false;
	static int hp;

	//Sets the Wizard HP
	void set_hp(int HP) {
		hp = HP;
	}
	
	//Returns the Wizard HP
	static int get_hp() {
		return hp;
	}
	
	//Set the attack status
	static void setAttackStatus(boolean attack)
	{
		AttackStatus = attack;
	}

	//Returns the attack status
	static boolean getAttackStatus()
	{
		return AttackStatus;
	}

	//Function to be called when Wizard has to meet the Council
	static void meetCouncil() {
		
		// The time in given format
		SimpleDateFormat simpleDateformat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();

		System.out.println("Wizard Met Council " + "HH:MM:SS :: " + simpleDateformat.format(date) + " HP :: " + get_hp());
	}
	
	public void run() {
		
		// the day of the week spelled out completely
        Date now = new Date();
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE");
        dayOfWeek = simpleDateformat.format(now);

		System.out.println("Wizard Running : " + "HH:MM:SS :: " + " HP :: " + get_hp());
		try {
			Thread.sleep((long) (Math.random() * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		meetCouncil();
	
	}
}