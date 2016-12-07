package Undergraduate_Project;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.concurrent.TimeUnit;

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
	
	
	
	public CarPanelGUI() {
		
		// load objects
		floor1 = new JButton();
		floor2 = new JButton();
		floor3 = new JButton();
		floor4 = new JButton();
		floor5 = new JButton();
		open_door = new JButton();
		close_door = new JButton();
		maint = new JButton();
		emerg = new JButton();
		fan = new JLabel();
		speaker = new JLabel();
		ele_bg = new JLabel();
		
		// load image resources for buttons
		fl_1_btn = new ImageIcon(getClass().getResource("/resources/button1OFF.jpg"));
		fl_2_btn = new ImageIcon(getClass().getResource("/resources/button2OFF.jpg"));
		fl_3_btn = new ImageIcon(getClass().getResource("/resources/button3OFF.jpg"));
		fl_4_btn = new ImageIcon(getClass().getResource("/resources/button4OFF.jpg"));
		fl_5_btn = new ImageIcon(getClass().getResource("/resources/button5OFF.jpg"));
		fl_1_btn_on = new ImageIcon(getClass().getResource("/resources/button1ON.jpg"));
		fl_2_btn_on = new ImageIcon(getClass().getResource("/resources/button2ON.jpg"));
		fl_3_btn_on = new ImageIcon(getClass().getResource("/resources/button3ON.jpg"));
		fl_4_btn_on = new ImageIcon(getClass().getResource("/resources/button4ON.jpg"));
		fl_5_btn_on = new ImageIcon(getClass().getResource("/resources/button5ON.jpg"));
		door_close_btn = new ImageIcon(getClass().getResource("/resources/buttonCarCloseDoorOFF.jpg"));
		door_close_btn_on = new ImageIcon(getClass().getResource("/resources/buttonCarDoorCloseON.jpg"));
		door_open_btn = new ImageIcon(getClass().getResource("/resources/buttonCarOpenDoorOFF.jpg"));
		door_open_btn_on = new ImageIcon(getClass().getResource("/resources/buttonCarDoorOpenON.jpg"));
		maint_btn = new ImageIcon(getClass().getResource("/resources/buttonKeyHole.jpg"));
		maint_turned = new ImageIcon(getClass().getResource("/resources/buttonKeyHoleClockwise.jpg"));
		emerg_btn = new ImageIcon(getClass().getResource("/resources/buttonAlarm.jpg"));
		
		// load image resources for main elevator background and accessories
		main_bg_closed = new ImageIcon(getClass().getResource("/resources/ElevatorCar.png"));
		main_bg_open = new ImageIcon(getClass().getResource("/resources/CarDoorOpen5.png"));
		main_bg_emerg = new ImageIcon(getClass().getResource("/resources/alarm.gif"));
		main_bg_opening = new ImageIcon(getClass().getResource("/resources/carDoorOpen.gif"));
		main_bg_closing = new ImageIcon(getClass().getResource("/resources/carDoorClose.gif"));
		fan_img = new ImageIcon(getClass().getResource("/resources/fanOff.png"));
		fan_on = new ImageIcon(getClass().getResource("/resources/fanOn.gif"));
		
		setupCarPanel();
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
	}
	
	// set the ele_bg icon to be closed
	public void doorClosed() {
		ele_bg.setIcon(main_bg_closed);
	}
	
	// set the ele_bg icon to be open
	public void doorOpen() {
		ele_bg.setIcon(main_bg_open);
	}

	// plays the gif of the door opening
	public void doorOpenGif() {
		ele_bg.setIcon(main_bg_opening);
	}
	
	// plays the gif of the door closing
	public void doorCloseGif() {
		ele_bg.setIcon(main_bg_closing);
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
	
	/**
	 * TODO:
	 * 	FINISH FUNCTION TO UPDATE THE CAR DISPLAY
	 */
	
	// updates the car display
	public void updateCarDisp() {
		
	}
}
