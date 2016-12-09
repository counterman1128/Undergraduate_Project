

package Undergraduate_Project;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.concurrent.TimeUnit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CarPanelGUI extends JPanel {
	
	private JLabel ele_bg;
	private JButton floor1;
	private JButton floor2;
	private JButton floor3;
	private JButton floor4;
	private JButton floor5;
	private JButton open_door;
	private JButton close_door;
	private JButton maint;
	private JButton emerg;
	private JLabel fan;
	private JLabel speaker;
	private JLabel alarm;
	
	private ImageIcon main_bg_closed;
	private ImageIcon main_bg_open;
	private ImageIcon main_bg_opening;
	private ImageIcon main_bg_closing;
	private ImageIcon main_bg_emerg;
	private ImageIcon fl_1_btn;
	private ImageIcon fl_2_btn;
	private ImageIcon fl_3_btn;
	private ImageIcon fl_4_btn;
	private ImageIcon fl_5_btn;
	private ImageIcon fl_1_btn_on;
	private ImageIcon fl_2_btn_on;
	private ImageIcon fl_3_btn_on;
	private ImageIcon fl_4_btn_on;
	private ImageIcon fl_5_btn_on;
	private ImageIcon maint_btn;
	private ImageIcon maint_turned;
	private ImageIcon emerg_btn;
	private ImageIcon door_open_btn;
	private ImageIcon door_open_btn_on;
	private ImageIcon door_close_btn;
	private ImageIcon door_close_btn_on;
	private ImageIcon fan_img;
	private ImageIcon fan_on;
	private ImageIcon speaker_img;
	
	private boolean buttons_pressed[] = new boolean[5];
	
	// false = door closed, true = door open
	private boolean doorStatus = false;
	private boolean alarmStatus = false;
	
	public JButton floor_buttons[] = new JButton[5];
	
	public CarPanelGUI() {
				
		// load objects
		floor1 = new JButton();
		floor1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(e);
				buttons_pressed[0] = true;
			}
		});
		floor2 = new JButton();
		floor2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(e);
				buttons_pressed[1] = true;
			}
		});
		floor3 = new JButton();
		floor3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(e);
				buttons_pressed[2] = true;
			}
		});
		floor4 = new JButton();
		floor4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(e);
				buttons_pressed[3] = true;
			}
		});
		floor5 = new JButton();
		floor5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(e);
				buttons_pressed[4] = true;
			}
		});
		
		// Sets an array with the states of each floor button
		for (int i = 0; i < 5; i++){
			buttons_pressed[i] = false;
		}
		
		// Fills an array with all the buttons for the floors
		floor_buttons[0] = floor1;
		floor_buttons[1] = floor2;
		floor_buttons[2] = floor3;
		floor_buttons[3] = floor4;
		floor_buttons[4] = floor5;

		open_door  = new JButton();
		open_door.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(getDoorStatus() == false) {
					doorOpenGif();
				}
			}
		});
		close_door = new JButton();
		close_door.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(getDoorStatus() == true) {
					doorCloseGif();
				}
			}
		});
		maint = new JButton();
		emerg = new JButton();
		emerg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(alarmStatus == false) {
					startAlarmMode();
				}
				else {
					endAlarmMode();
				}
			}
		});
		fan   = new JLabel();
		speaker = new JLabel();
		ele_bg = new JLabel();
		
		// load image resources for buttons
		fl_1_btn 		= new ImageIcon(getClass().getResource("/resources/button1OFF.jpg"));
		fl_2_btn 		= new ImageIcon(getClass().getResource("/resources/button2OFF.jpg"));
		fl_3_btn 		= new ImageIcon(getClass().getResource("/resources/button3OFF.jpg"));
		fl_4_btn 		= new ImageIcon(getClass().getResource("/resources/button4OFF.jpg"));
		fl_5_btn 		= new ImageIcon(getClass().getResource("/resources/button5OFF.jpg"));
		fl_1_btn_on 	= new ImageIcon(getClass().getResource("/resources/button1ON.jpg"));
		fl_2_btn_on 	= new ImageIcon(getClass().getResource("/resources/button2ON.jpg"));
		fl_3_btn_on	 	= new ImageIcon(getClass().getResource("/resources/button3ON.jpg"));
		fl_4_btn_on 	= new ImageIcon(getClass().getResource("/resources/button4ON.jpg"));
		fl_5_btn_on 	= new ImageIcon(getClass().getResource("/resources/button5ON.jpg"));
		door_close_btn 	= new ImageIcon(getClass().getResource("/resources/buttonCarCloseDoorOFF.jpg"));
		door_close_btn_on = new ImageIcon(getClass().getResource("/resources/buttonCarDoorCloseON.jpg"));
		door_open_btn 	= new ImageIcon(getClass().getResource("/resources/buttonCarOpenDoorOFF.jpg"));
		door_open_btn_on= new ImageIcon(getClass().getResource("/resources/buttonCarDoorOpenON.jpg"));
		maint_btn 		= new ImageIcon(getClass().getResource("/resources/buttonKeyHole.jpg"));
		maint_turned 	= new ImageIcon(getClass().getResource("/resources/buttonKeyHoleClockwise.jpg"));
		emerg_btn 		= new ImageIcon(getClass().getResource("/resources/buttonAlarm.jpg"));
		
		// load image resources for main elevator background and accessories
		main_bg_closed 	= new ImageIcon(getClass().getResource("/resources/ElevatorCar.png"));
		main_bg_open 	= new ImageIcon(getClass().getResource("/resources/CarDoorOpen5.png"));
		main_bg_emerg 	= new ImageIcon(getClass().getResource("/resources/alarm.gif"));
		main_bg_opening = new ImageIcon(getClass().getResource("/resources/carDoorOpen.gif"));
		main_bg_closing = new ImageIcon(getClass().getResource("/resources/carDoorClose.gif"));
		fan_img 		= new ImageIcon(getClass().getResource("/resources/fanOff.png"));
		fan_on 			= new ImageIcon(getClass().getResource("/resources/fanOn.gif"));
		
		setupCarPanel();
	}
	
	public boolean[] getButtonsPressed() {
		return buttons_pressed;
	}
	
	private void setupCarPanel() {
		this.setBackground(Color.WHITE);
		this.setBorder(new MatteBorder(1,1,1,1, (Color) new Color(0,0,0)));
		this.setBounds(459, 13, 480, 695);
		setLayout(null);
		
		this.add(floor1);
		floor1.setIcon(fl_1_btn);
		floor1.setBounds(400,361,24,24);
		
		this.add(floor2);
		floor2.setIcon(fl_2_btn);
		floor2.setBounds(375,392,24,24);
		
		this.add(floor3);
		floor3.setIcon(fl_3_btn);
		floor3.setBounds(425,392,24,24);
		
		this.add(floor4);
		floor4.setIcon(fl_4_btn);
		floor4.setBounds(375,427,24,24);
		
		this.add(floor5);
		floor5.setIcon(fl_5_btn);
		floor5.setBounds(425,427,24,24);
		
		this.add(close_door);
		close_door.setIcon(door_close_btn);
		close_door.setBounds(387,462,24,24);
		
		this.add(open_door);
		open_door.setIcon(door_open_btn);
		open_door.setBounds(413,462,24,24);
		
		this.add(maint);
		maint.setIcon(maint_btn);
		maint.setBounds(400,529,24,24);
		
		this.add(emerg);
		emerg.setIcon(emerg_btn);
		emerg.setBounds(400,498,24,24);
		
		this.add(fan);
		fan.setIcon(fan_img);
		fan.setBounds(372,110,85,54);
		
		this.add(ele_bg);
		ele_bg.setIcon(main_bg_closed);
		ele_bg.setBounds(5, 86, 470, 608);
	}
	
	// changes the ele_bg icon to the alarm bg
	public void startAlarmMode() {
		ele_bg.setIcon(main_bg_emerg);
		alarmStatus = true;
	}
	
	public void endAlarmMode() {
		ele_bg.setIcon(main_bg_closed);
		alarmStatus = false;
	}
	
	// set the ele_bg icon to be closed
	public void doorClosed() {
		ele_bg.setIcon(main_bg_closed);
		doorStatus = false;
	}
	
	// set the ele_bg icon to be open
	public void doorOpen() {
		ele_bg.setIcon(main_bg_open);
		doorStatus = true;
	}

	// plays the gif of the door opening
	public void doorOpenGif() {
		ele_bg.setIcon(main_bg_opening);
		doorStatus = true;
	}
	
	// plays the gif of the door closing
	public void doorCloseGif() {
		ele_bg.setIcon(main_bg_closing);
		doorStatus = false;
	}
	
	
	// turn on the image for each button	
	public void flOn(int f){
		int corrected_floor = f + 1; // Makes the correction for the floor
		String p1 = "/resources/button";
		String p2 = Integer.toString(corrected_floor); 
 		String p3 = "ON.jpg";
 		String source = p1.concat(p2).concat(p3);
 		Icon sourceIcon = new ImageIcon(getClass().getResource(source));
		floor_buttons[f].setIcon(sourceIcon);
	}
	
	// turn off the image for each button
	public void flOff(int f){
		int corrected_floor = f + 1; // Makes the correction for the floor
		String p1 = "/resources/button";
		String p2 = Integer.toString(corrected_floor); 
 		String p3 = "OFF.jpg";
 		String source = p1.concat(p2).concat(p3);
 		Icon sourceIcon = new ImageIcon(getClass().getResource(source));
		floor_buttons[f].setIcon(sourceIcon);
	}
	
	// changes the floor 1 button to the on image
	public void fl1On() {
		floor1.setIcon(fl_1_btn_on);
	}
	
	// changes the floor 2 button to the on image
	public void fl2On() {
		floor2.setIcon(fl_2_btn_on);
	}
	
	// changes the floor 3 button to the on image
	public void fl3On() {
		floor3.setIcon(fl_3_btn_on);
	}
	
	// changes the floor 4 button to the on image
	public void fl4On() {
		floor4.setIcon(fl_4_btn_on);
	}
	
	// changes the floor 5 button to the on image
	public void fl5On() {
		floor5.setIcon(fl_5_btn_on);
	}
	
	// changes the floor 1 button to the off image
	public void fl1Off() {
		floor1.setIcon(fl_1_btn);
	}
	
	// changes the floor 2 button to the off image
	public void fl2Off() {
		floor2.setIcon(fl_2_btn);
	}

	// changes the floor 3 button to the off image
	public void fl3Off() {
		floor3.setIcon(fl_3_btn);
	}
	
	// changes the floor 4 button to the off image
	public void fl4Off() {
		floor4.setIcon(fl_4_btn);
	}
	
	// changes the floor 5 button to the off image
	public void fl5Off() {
		floor5.setIcon(fl_5_btn);
	}
	
	// changes the open door button to the off image
	public void doorOpenOff() {
		open_door.setIcon(door_open_btn);
	}
	 
	// changes the open door button to the on image
	public void doorOpenOn() {
		open_door.setIcon(door_open_btn_on);
	}

	// changes the close door button to the off image
	public void doorCloseOn() {
		close_door.setIcon(door_close_btn);
	}
	
	// changes the close door button to the on image
	public void doorCloseOff() {
		close_door.setIcon(door_close_btn_on);
	}
	// changes maintenance button to usual position
	public void maintNorm() {
		maint.setIcon(maint_btn);
	}
	
	// changes maintenance button to turned state
	public void maintTurn() {
		maint.setIcon(maint_turned);
	}
	
	// turns the fan on
	public void fanOn() {
		fan.setIcon(fan_on);
	}

	// turns the fan off
	public void fanOff() {
		fan.setIcon(fan_img);
	}
	
	private boolean getDoorStatus() {
		return doorStatus;
	}
	/**
	 * TODO:
	 * 	FINISH FUNCTION TO UPDATE THE CAR DISPLAY
	 */
	
	// updates the car display
	public void updateCarDisp() {
		
	}
}

