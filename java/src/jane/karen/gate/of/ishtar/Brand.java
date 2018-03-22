/**
 * The Gate Of Ishtar
 * 
 * Created by Jane Karen Kumar
 * 
 * Date: 17 March 2018
 * 
 * Description: This Brand class is used to accommodate all the activities which are to be done by the Demon-Brand.
 * 
 */

package jane.karen.gate.of.ishtar;

import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Brand extends Thread {

	private int type;
    int hp;
    int hours;
    Calendar calendar;
    
    // Constructor
	Brand(int input) {
		this.type = input;
	}
	
	/* 
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		boolean attackStatus;
		calendar = Calendar.getInstance();
		hours = calendar.get(Calendar.HOUR_OF_DAY); 
		System.out.println("Brand hours calendar --> "+hours);
		
		switch (type) {
		
		case 1:
			attackStatus = Human.getAttackStatus();
			
			if (attackStatus == false) {
				
				hp = Human.get_hp();
				
				ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
				ses.scheduleAtFixedRate(new Runnable() {
				    @Override
				    public void run() {
				    	
			    	    if (hp <= 0) {
							System.out.println("Brand Demon Attacked HUMAN :: HUMAN Lost the battle with BRAND");
							ses.shutdown();
						}else {		
							if(hours >= 0 && hours < 6) {
								hp = hp - 15;
								System.out.println("Brand Demon Attacked HUMAN :: HP Reduced by 15");
							}else if (hours >= 6 && hours < 12) {
								hp = hp - 17;
								System.out.println("Brand Demon Attacked HUMAN :: HP Reduced by 17");
							}else if (hours >= 12 && hours < 18) {
								hp = hp - 20;
								System.out.println("Brand Demon Attacked HUMAN :: HP Reduced by 20");
							}else {
								hp = hp - 25;
								System.out.println("Brand Demon Attacked HUMAN :: HP Reduced by 25");
							}
							System.out.println("HUMAN :: Continue running");
						}
						try {
							Human.set_hp(hp);
						} catch (NullPointerException e) {
							e.printStackTrace();
						}
						Human.setAttackStatus(true);
				    }
				}, 0, 1, TimeUnit.HOURS);				
			}
			else
			{
				try {
					Thread.sleep((long) (Math.random() * 1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			break;
			
		case 4:
			attackStatus = Giant.getAttackStatus();
			
			if (attackStatus == false) {
				
				hp = Giant.get_hp();
				
				ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
				ses.scheduleAtFixedRate(new Runnable() {
				    @Override
				    public void run() {
				    	    if (hp <= 0) {
							System.out.println("Brand Demon Attacked Giant :: Giant Lost the battle with BRAND");
							ses.shutdown();
						}else {
							if(hours >= 0 && hours < 6) {
								hp = hp - 15;
								System.out.println("Brand Demon Attacked Giant :: HP Reduced by 15");
							}else if (hours >= 6 && hours < 12) {
								hp = hp - 17;
								System.out.println("Brand Demon Attacked Giant :: HP Reduced by 17");
							}else if (hours >= 12 && hours < 18) {
								hp = hp - 20;
								System.out.println("Brand Demon Attacked Giant :: HP Reduced by 20");
							}else {
								hp = hp - 25;
								System.out.println("Brand Demon Attacked Giant :: HP Reduced by 25");

							}
						    System.out.println("Giant :: Continue running");
						}
						try {
							Giant.set_hp(hp);
						} catch (NullPointerException e) {
							e.printStackTrace();
						}
						Giant.setAttackStatus(true);
				    }
				}, 0, 1, TimeUnit.HOURS);
			}
			else
			{
				try {
					Thread.sleep((long) (Math.random() * 1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			break;
			
		case 5:
			attackStatus = Vampire.getAttackStatus();
			
			if (attackStatus == false) {
				
				hp = Vampire.get_hp();
				
				ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
				ses.scheduleAtFixedRate(new Runnable() {
				    @Override
				    public void run() {
				      	if (hp <= 0) {
							System.out.println("Brand Demon Attacked Vampire :: Vampire Lost the battle with BRAND");
							ses.shutdown();
						}else {
							if(hours >= 0 && hours < 6) {
								hp = hp - 15;
								System.out.println("Brand Demon Attacked Vampire :: HP Reduced by 15");
							}else if (hours >= 6 && hours < 12) {
								hp = hp - 17;
								System.out.println("Brand Demon Attacked Vampire :: HP Reduced by 17");
							}else if (hours >= 12 && hours < 18) {
								hp = hp - 20;
								System.out.println("Brand Demon Attacked Vampire :: HP Reduced by 20");
							}else {
								hp = hp - 25;
								System.out.println("Brand Demon Attacked Vampire :: HP Reduced by 25");

							}
						     System.out.println("Vampire :: Continue running");
						}
						try {
							Vampire.set_hp(hp);
						} catch (NullPointerException e) {
							e.printStackTrace();   
						}
						Vampire.setAttackStatus(true);
				    }
				}, 0, 1, TimeUnit.HOURS);
			}
			else
			{
				try {
					Thread.sleep((long) (Math.random() * 1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			break;

		}
	}
}
