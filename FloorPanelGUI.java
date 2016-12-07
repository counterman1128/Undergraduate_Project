package Undergraduate_Project;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;

public class FloorPanelGUI extends JPanel {

	// object declarations
	private ImageIcon dwn_btn;
	private ImageIcon dwn_btn_on;
	private ImageIcon up_btn;
	private ImageIcon up_btn_on;
	private ImageIcon closed_door;
	
	private JPanel floor_five;
	private JButton down_five;
	private JPanel fl_display_five;
	private JLabel fl_num_five;
	private JLabel ele_door_five;
	private ImageIcon floor_num_5;
	
	private JPanel floor_four;
	private JButton down_four;
	private JButton up_four;
	private JPanel fl_display_four;
	private JLabel fl_num_four;
	private JLabel ele_door_four;
	private ImageIcon floor_num_4;
	
	private JPanel floor_three;
	private JButton down_three;
	private JButton up_three;
	private JPanel fl_display_three;
	private JLabel fl_num_three;
	private JLabel ele_door_three;
	private ImageIcon floor_num_3;
	
	private JPanel floor_two;
	private JButton down_two;
	private JButton up_two;
	private JPanel fl_display_two;
	private JLabel fl_num_two;
	private JLabel ele_door_two;
	private ImageIcon floor_num_2;
	
	private JPanel floor_one;
	private JButton up_one;
	private JPanel fl_display_one;
	private JLabel fl_num_one;
	private JLabel ele_door_one;
	private ImageIcon floor_num_1;
	
	public FloorPanelGUI() {
		
		// General Resources
		closed_door = new ImageIcon(getClass().getResource("/resources/floor_door_closed.png"));
		dwn_btn = new ImageIcon(getClass().getResource("/resources/buttonFloorDownOFF.jpg"));
		up_btn = new ImageIcon(getClass().getResource("/resources/buttonFloorUpOFF.jpg"));
		dwn_btn_on = new ImageIcon(getClass().getResource("/resources/buttonFloorDownOn.jpg"));
		up_btn_on = new ImageIcon(getClass().getResource("/resources/buttonFloorUpOn.jpg"));
		
		// Floor 5 objects and resources
		floor_five = new JPanel();
		fl_num_five = new JLabel();
		fl_display_five = new JPanel();
		ele_door_five = new JLabel();
		down_five = new JButton();
		floor_num_5 = new ImageIcon(getClass().getResource("/resources/floor_num_5.png"));
		
		// Floor 4 objects and resources
		floor_four = new JPanel();
		fl_num_four = new JLabel();
		fl_display_four = new JPanel();
		ele_door_four = new JLabel();
		up_four = new JButton();
		up_four.setBounds(189, 59, 35, -59);
		down_four = new JButton();
		floor_num_4 = new ImageIcon(getClass().getResource("/resources/floor_num_4.png"));
		
		// Floor 3 objects and resources
		floor_three = new JPanel();
		fl_num_three = new JLabel();
		fl_display_three = new JPanel();
		ele_door_three = new JLabel();
		up_three = new JButton();
		up_three.setBounds(189, 59, 35, -59);
		down_three = new JButton();
		floor_num_3 = new ImageIcon(getClass().getResource("/resources/floor_num_3.png"));
		
		// Floor 2 objects and resources
		floor_two = new JPanel();
		fl_num_two = new JLabel();
		fl_display_two = new JPanel();
		ele_door_two = new JLabel();
		up_two = new JButton();
		up_two.setBounds(189, 59, 35, -59);
		down_two = new JButton();
		floor_num_2 = new ImageIcon(getClass().getResource("/resources/floor_num_2.png"));
		
		// Floor 1 objects and resources
		floor_one = new JPanel();
		fl_num_one = new JLabel();
		fl_display_one = new JPanel();
		ele_door_one = new JLabel();
		up_one = new JButton();
		up_one.setBounds(189, 59, 35, -59);
		floor_num_1 = new ImageIcon(getClass().getResource("/resources/floor_num_1.png"));
		
		setupFloorPanel();
	}
	
	private void setupFloorPanel() {
		this.setBackground(Color.WHITE);
		this.setBounds(214,13,233,695);
		this.setBorder(new MatteBorder(1,1,1,1, (Color) new Color(0,0,0)));
		this.add(floor_five);
		this.add(floor_four);
		this.add(floor_three);
		this.add(floor_two);
		this.add(floor_one);
		
		setupFloorFive();
		setupFloorFour();
		setupFloorThree();
		setupFloorTwo();
		setupFloorOne();
	}
	
	private void setupFloorFive() {
		floor_five.setBackground(Color.WHITE);
		floor_five.setBorder(new MatteBorder(1,1,1,1, (Color) new Color(0,0,0)));
		floor_five.setBounds(0,0,233,139);
		setLayout(null);
		floor_five.setLayout(null);
		floor_five.add(fl_num_five);
		fl_num_five.setIcon(floor_num_5);
		fl_num_five.setBounds(12, 29, 35, 60);
		floor_five.add(fl_display_five);
		fl_display_five.setBounds(89,1,49,23);
		floor_five.add(ele_door_five);
		ele_door_five.setIcon(closed_door);
		ele_door_five.setBounds(59,32,118,107);
		floor_five.add(down_five);
		down_five.setIcon(dwn_btn);
		down_five.setBounds(189,87,24,25);
	}
	
	private void setupFloorFour() {
		floor_four.setBackground(Color.WHITE);
		floor_four.setBorder(new MatteBorder(1,1,1,1, (Color) new Color(0,0,0)));
		floor_four.setBounds(0,139,233,139);
		setLayout(null);
		floor_four.setLayout(null);
		floor_four.add(fl_num_four);
		fl_num_four.setIcon(floor_num_4);
		fl_num_four.setBounds(12, 29, 35, 60);
		floor_four.add(fl_display_four);
		fl_display_four.setBounds(89,1,49,23);
		floor_four.add(ele_door_four);
		ele_door_four.setIcon(closed_door);
		ele_door_four.setBounds(59,32,118,107);
		floor_four.add(up_four);
		up_four.setIcon(up_btn);
		up_four.setBounds(189,53,24,25);
		floor_four.add(down_four);
		down_four.setIcon(dwn_btn);
		down_four.setBounds(189,87,24,25);
	}
	
	private void setupFloorThree() {
		floor_three.setBackground(Color.WHITE);
		floor_three.setBorder(new MatteBorder(1,1,1,1, (Color) new Color(0,0,0)));
		floor_three.setBounds(0,278,233,139);
		setLayout(null);
		floor_three.setLayout(null);
		floor_three.add(fl_num_three);
		fl_num_three.setIcon(floor_num_3);
		fl_num_three.setBounds(12, 29, 35, 60);
		floor_three.add(fl_display_three);
		fl_display_three.setBounds(89,1,49,23);
		floor_three.add(ele_door_three);
		ele_door_three.setIcon(closed_door);
		ele_door_three.setBounds(59,32,118,107);
		floor_three.add(up_three);
		up_three.setIcon(up_btn);
		up_three.setBounds(189,53,24,25);
		floor_three.add(down_three);
		down_three.setIcon(dwn_btn);
		down_three.setBounds(189,87,24,25);
	}
	
	private void setupFloorTwo() {
		floor_two.setBackground(Color.WHITE);
		floor_two.setBorder(new MatteBorder(1,1,1,1, (Color) new Color(0,0,0)));
		floor_two.setBounds(0,417,233,139);
		setLayout(null);
		floor_two.setLayout(null);
		floor_two.add(fl_num_two);
		fl_num_two.setIcon(floor_num_2);
		fl_num_two.setBounds(12, 29, 35, 60);
		floor_two.add(fl_display_two);
		fl_display_two.setBounds(89,1,49,23);
		floor_two.add(ele_door_two);
		ele_door_two.setIcon(closed_door);
		ele_door_two.setBounds(59,32,118,107);
		floor_two.add(up_two);
		up_two.setIcon(up_btn);
		up_two.setBounds(189,53,24,25);
		floor_two.add(down_two);
		down_two.setIcon(dwn_btn);
		down_two.setBounds(189,87,24,25);
	}
	
	private void setupFloorOne() {
		floor_one.setBackground(Color.WHITE);
		floor_one.setBorder(new MatteBorder(1,1,1,1, (Color) new Color(0,0,0)));
		floor_one.setBounds(0,556,233,139);
		setLayout(null);
		floor_one.setLayout(null);
		floor_one.add(fl_num_one);
		fl_num_one.setIcon(floor_num_1);
		fl_num_one.setBounds(20, 29, 35, 60);
		floor_one.add(fl_display_one);
		fl_display_one.setBounds(89,1,49,23);
		floor_one.add(ele_door_one);
		ele_door_one.setIcon(closed_door);
		ele_door_one.setBounds(59,32,118,107);
		floor_one.add(up_one);
		up_one.setIcon(up_btn);
		up_one.setBounds(189,53,24,25);
	}
	
	// sets the floor one up button to on
	public void setFl1UpOn() {
		up_one.setIcon(up_btn_on);
	}
	
	// sets the floor one up button to off
	public void setFl1UpOff() {
		up_one.setIcon(up_btn);
	}
	
	// sets the floor two up button to on
	public void setFl2UpOn() {
		up_two.setIcon(up_btn_on);
	}
	
	// sets the floor two up button to off
	public void setFl2UpOff() {
		up_two.setIcon(up_btn);
	}
	
	// sets the floor two down button to on
	public void setFl2DownOn() {
		down_two.setIcon(dwn_btn_on);
	}
	
	// sets the floor two down button to off
	public void setFl2DownOff() {
		down_two.setIcon(dwn_btn);
	}

	// sets the floor three up button to on
	public void setFl3UpOn() {
		up_three.setIcon(up_btn_on);
	}
	
	// sets the floor three up button to off
	public void setFl3UpOff() {
		up_three.setIcon(up_btn);
	}
	
	// sets the floor three down button to on
	public void setFl3DownOn() {
		down_three.setIcon(dwn_btn_on);
	}
	
	// sets the floor three down button to off
	public void setFl3DownOff() {
		down_three.setIcon(dwn_btn);
	}
	// sets the floor four up button to on
	public void setFl4UpOn() {
		up_four.setIcon(up_btn_on);
	}
	
	// sets the floor four up button to off
	public void setFl4UpOff() {
		up_four.setIcon(up_btn);
	}
	
	// sets the floor four down button to on
	public void setFl4DownOn() {
		down_four.setIcon(dwn_btn_on);
	}
	
	// sets the floor four down button to off
	public void setFl4DownOff() {
		down_four.setIcon(dwn_btn);
	}
	
	// sets the floor five down button to on
	public void setFl5DownOn() {
		down_five.setIcon(dwn_btn_on);
	}
	
	// sets the floor five down button to off
	public void setFl5DownOff() {
		down_five.setIcon(dwn_btn);
	}
	
	/**
	 * TODO:
	 * 	FINISH FUNCTIONS TO UPDATE FLOOR DISPLAYS
	 */
	
	// updates the first floor display
	public void updateFl1Disp() {
		
	}
	
	// updates the second floor display
	public void updateFl2Disp() {
		
	}
	
	// updates the third floor display
	public void updateFl3Disp() {
		
	}
	
	// updates the fourth floor display
	public void updateFl4Disp() {
		
	}
	
	// updates the fifth floor display
	public void updateFl5Disp() {
	
	}
	
}
