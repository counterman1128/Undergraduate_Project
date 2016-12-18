package Undergraduate_Project;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.MatteBorder;

public class FloorPanelGUI extends JPanel {

   // object declarations
   private ImageIcon dwn_btn;
   private ImageIcon dwn_btn_on;
   private ImageIcon up_btn;
   private ImageIcon up_btn_on;
   private ImageIcon closed_door;
   private ImageIcon open_door;
   private ImageIcon door_closing;
   private ImageIcon door_opening;
   
   private JPanel floor_five;
   private JButton down_five;
   private JLabel fl_display_five;
   private JLabel fl_num_five;
   private JLabel ele_door_five;
   private ImageIcon floor_num_5;
   
   private JPanel floor_four;
   private JButton down_four;
   private JButton up_four;
   private JLabel fl_display_four;
   private JLabel fl_num_four;
   private JLabel ele_door_four;
   private ImageIcon floor_num_4;
   
   private JPanel floor_three;
   private JButton down_three;
   private JButton up_three;
   private JLabel fl_display_three;
   private JLabel fl_num_three;
   private JLabel ele_door_three;
   private ImageIcon floor_num_3;
   
   private JPanel floor_two;
   private JButton down_two;
   private JButton up_two;
   private JLabel fl_display_two;
   private JLabel fl_num_two;
   private JLabel ele_door_two;
   private ImageIcon floor_num_2;
   
   private JPanel floor_one;
   private JButton up_one;
//	private JPanel fl_display_one;
   private JLabel fl_display_one;

   private JLabel fl_num_one;
   private JLabel ele_door_one;
   private ImageIcon floor_num_1;
   
   // Hold the state of the buttons
   // false = off; true = on
   private boolean f1u = false;
   private boolean f2u = false;
   private boolean f2d = false;
   private boolean f3u = false;
   private boolean f3d = false;
   private boolean f4u = false;
   private boolean f4d = false;
   private boolean f5d = false;
   private boolean fStatus[] = new boolean[8];
   
   
   // Added function to update all pannels at once
   public void setDisplayTo(int f) {
      fl_display_one.setText(Integer.toString(f));
      fl_display_two.setText(Integer.toString(f));
      fl_display_three.setText(Integer.toString(f));
      fl_display_four.setText(Integer.toString(f));
      fl_display_five.setText(Integer.toString(f));
   }
   public FloorPanelGUI() {
      
      // General Resources
      closed_door = new ImageIcon(getClass().getResource("/resources/floor_door_closed.png"));
      open_door = new ImageIcon(getClass().getResource("/resources/floor_door_open.png"));
      dwn_btn = new ImageIcon(getClass().getResource("/resources/buttonFloorDownOFF.jpg"));
      up_btn = new ImageIcon(getClass().getResource("/resources/buttonFloorUpOFF.jpg"));
      dwn_btn_on = new ImageIcon(getClass().getResource("/resources/buttonFloorDownOn.jpg"));
      up_btn_on = new ImageIcon(getClass().getResource("/resources/buttonFloorUpOn.jpg"));
      door_closing = new ImageIcon(getClass().getResource("/resources/floorDoorClose.gif"));
      door_opening = new ImageIcon(getClass().getResource("/resources/floorDoorOpen.gif"));
      
      // Floor 5 objects and resources
      floor_five = new JPanel();
      fl_num_five = new JLabel();
      fl_display_five = new JLabel();
      ele_door_five = new JLabel();
      down_five = new JButton();
      floor_num_5 = new ImageIcon(getClass().getResource("/resources/floor_num_5.png"));
      
      // Floor 4 objects and resources
      floor_four = new JPanel();
      fl_num_four = new JLabel();
      fl_display_four = new JLabel();
      ele_door_four = new JLabel();
      up_four = new JButton();
      up_four.setBounds(189, 59, 35, -59);
      down_four = new JButton();
      floor_num_4 = new ImageIcon(getClass().getResource("/resources/floor_num_4.png"));
      
      // Floor 3 objects and resources
      floor_three = new JPanel();
      fl_num_three = new JLabel();
      fl_display_three = new JLabel();
      ele_door_three = new JLabel();
      up_three = new JButton();
      up_three.setBounds(189, 59, 35, -59);
      down_three = new JButton();
      floor_num_3 = new ImageIcon(getClass().getResource("/resources/floor_num_3.png"));
      
      // Floor 2 objects and resources
      floor_two = new JPanel();
      fl_num_two = new JLabel();
      fl_display_two = new JLabel();
      ele_door_two = new JLabel();
      up_two = new JButton();
      up_two.setBounds(189, 59, 35, -59);
      down_two = new JButton();
      floor_num_2 = new ImageIcon(getClass().getResource("/resources/floor_num_2.png"));
      
      // Floor 1 objects and resources
      floor_one = new JPanel();
      fl_num_one = new JLabel();
//		fl_display_one = new JPanel();
      fl_display_one = new JLabel();

      ele_door_one = new JLabel();
      up_one = new JButton();
      up_one.setBounds(189, 59, 35, -59);
      floor_num_1 = new ImageIcon(getClass().getResource("/resources/floor_num_1.png"));
      
      setupFloorPanel();
      floorClickResponse();
   }
   
   public void floorClickResponse(){
      //up_one = new JButton();
      up_one.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            System.out.println(e);
            setFl1UpOn();
         }
      });
      
      up_two.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            System.out.println(e);
            setFl2UpOn();
         }
      });
      
      down_two.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            System.out.println(e);
            setFl2DownOn();
         }
      });
      
      up_three.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            System.out.println(e);
            setFl3UpOn();
         }
      });
      
      down_three.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            System.out.println(e);
            setFl3DownOn();
         }
      });
      
      up_four.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            System.out.println(e);
            setFl4UpOn();
         }
      });
      
      down_four.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            System.out.println(e);
            setFl4DownOn();
         }
      });
      
      down_five.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            System.out.println(e);
            setFl5DownOn();
         }
      });
   }
   public void panel_off(int f){
         int corrected_floor = f + 1; // Makes the correction for the floor
         String p1 = "/resources/button";
         String p2 = Integer.toString(corrected_floor); 
    		String p3 = "ON.jpg";
    		String source = p1.concat(p2).concat(p3);
    		Icon sourceIcon = new ImageIcon(getClass().getResource(source));
      //	floor_buttons[f].setIcon(sourceIcon); rename!
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
      fl_display_five.setBounds(89,6,49,23);
      floor_five.add(ele_door_five);
      ele_door_five.setIcon(closed_door);
      ele_door_five.setBounds(59,32,118,107);
      floor_five.add(down_five);
      down_five.setIcon(dwn_btn);
      down_five.setBounds(189,87,24,25);
      fl_display_five.setFont(new Font("Verdana",1,15));
      fl_display_five.setBackground(Color.BLACK);
      fl_display_five.setForeground(Color.YELLOW);
      fl_display_five.setOpaque(true);
      fl_display_five.setHorizontalAlignment(SwingConstants.CENTER);
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
      fl_display_four.setBounds(89,6,49,23);
      floor_four.add(ele_door_four);
      ele_door_four.setIcon(closed_door);
      ele_door_four.setBounds(59,32,118,107);
      floor_four.add(up_four);
      up_four.setIcon(up_btn);
      up_four.setBounds(189,53,24,25);
      floor_four.add(down_four);
      down_four.setIcon(dwn_btn);
      down_four.setBounds(189,87,24,25);
      fl_display_four.setFont(new Font("Verdana",1,15));
      fl_display_four.setBackground(Color.BLACK);
      fl_display_four.setForeground(Color.YELLOW);
      fl_display_four.setOpaque(true);
      fl_display_four.setHorizontalAlignment(SwingConstants.CENTER);
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
      fl_display_three.setBounds(89,6,49,23);
      floor_three.add(ele_door_three);
      ele_door_three.setIcon(closed_door);
      ele_door_three.setBounds(59,32,118,107);
      floor_three.add(up_three);
      up_three.setIcon(up_btn);
      up_three.setBounds(189,53,24,25);
      floor_three.add(down_three);
      down_three.setIcon(dwn_btn);
      down_three.setBounds(189,87,24,25);
      fl_display_three.setFont(new Font("Verdana",1,15));
      fl_display_three.setBackground(Color.BLACK);
      fl_display_three.setForeground(Color.YELLOW);
      fl_display_three.setOpaque(true);
      fl_display_three.setHorizontalAlignment(SwingConstants.CENTER);
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
      fl_display_two.setBounds(89,6,49,23);
      floor_two.add(ele_door_two);
      ele_door_two.setIcon(closed_door);
      ele_door_two.setBounds(59,32,118,107);
      floor_two.add(up_two);
      up_two.setIcon(up_btn);
      up_two.setBounds(189,53,24,25);
      floor_two.add(down_two);
      down_two.setIcon(dwn_btn);
      down_two.setBounds(189,87,24,25);
      fl_display_two.setFont(new Font("Verdana",1,15));
      fl_display_two.setBackground(Color.BLACK);
      fl_display_two.setForeground(Color.YELLOW);
      fl_display_two.setOpaque(true);
      fl_display_two.setHorizontalAlignment(SwingConstants.CENTER);
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
      fl_display_one.setBounds(89,6,49,23);
      floor_one.add(ele_door_one);
      ele_door_one.setIcon(closed_door);
      ele_door_one.setBounds(59,32,118,107);
      floor_one.add(up_one);
      up_one.setIcon(up_btn);
      up_one.setBounds(189,53,24,25);
      fl_display_one.setFont(new Font("Verdana",1,15));
      fl_display_one.setBackground(Color.BLACK);
      fl_display_one.setForeground(Color.YELLOW);
      fl_display_one.setOpaque(true);
      fl_display_one.setHorizontalAlignment(SwingConstants.CENTER);
   }
   
   // sets the floor one up button to on
   public void setFl1UpOn() {
      up_one.setIcon(up_btn_on);
      f1u = true;
   }
   
   // sets the floor one up button to off
   public void setFl1UpOff() {
      up_one.setIcon(up_btn);
      f1u = false;
   }
   
   // sets the floor two up button to on
   public void setFl2UpOn() {
      up_two.setIcon(up_btn_on);
      f2u = true;
   }
   
   // sets the floor two up button to off
   public void setFl2UpOff() {
      up_two.setIcon(up_btn);
      f2u = false;
   }
   
   // sets the floor two down button to on
   public void setFl2DownOn() {
      down_two.setIcon(dwn_btn_on);
      f2d = true;
   }
   
   // sets the floor two down button to off
   public void setFl2DownOff() {
      down_two.setIcon(dwn_btn);
      f2d = false;
   }

   // sets the floor three up button to on
   public void setFl3UpOn() {
      up_three.setIcon(up_btn_on);
      f3u = true;
   }
   
   // sets the floor three up button to off
   public void setFl3UpOff() {
      up_three.setIcon(up_btn);
      f3u = false;
   }
   
   // sets the floor three down button to on
   public void setFl3DownOn() {
      down_three.setIcon(dwn_btn_on);
      f3d = true;
   }
   
   // sets the floor three down button to off
   public void setFl3DownOff() {
      down_three.setIcon(dwn_btn);
      f3d = false;
   }
   // sets the floor four up button to on
   public void setFl4UpOn() {
      up_four.setIcon(up_btn_on);
      f4u = true;
   }
   
   // sets the floor four up button to off
   public void setFl4UpOff() {
      up_four.setIcon(up_btn);
      f4u = false;
   }
   
   // sets the floor four down button to on
   public void setFl4DownOn() {
      down_four.setIcon(dwn_btn_on);
      f4d = true;
   }
   
   // sets the floor four down button to off
   public void setFl4DownOff() {
      down_four.setIcon(dwn_btn);
      f4d = false;
   }
   
   // sets the floor five down button to on
   public void setFl5DownOn() {
      down_five.setIcon(dwn_btn_on);
      f5d = true;
   }
   
   // sets the floor five down button to off
   public void setFl5DownOff() {
      down_five.setIcon(dwn_btn);
      f5d = false;
   }
   
   public void setFlDownOff(int floorNum) {
      switch(floorNum) {
      case 2:
         setFl2DownOff();
         break;
      case 3:
         setFl3DownOff();
         break;
      case 4:
         setFl4DownOff();
         break;
      case 5:
         setFl5DownOff();
         break;
      default:
         break;
      }
   }
   
   public void setFlDownOn(int floorNum) {
      switch(floorNum) {
      case 2:
         setFl2DownOn();
         break;
      case 3:
         setFl3DownOn();
         break;
      case 4:
         setFl4DownOn();
         break;
      case 5:
         setFl5DownOn();
         break;
      default:
         break;
      }
   }
   
   public void setFlUpOff(int floorNum) {
      switch(floorNum) {
      case 1:
         setFl1UpOff();
         break;
      case 2:
         setFl2UpOff();
         break;
      case 3:
         setFl3UpOff();
         break;
      case 4:
         setFl4UpOff();
         break;
      default:
         break;
      }
   }
   
   public void setFlUpOn(int floorNum) {
      switch(floorNum) {
      case 1:
         setFl1UpOn();
         break;
      case 2:
         setFl2UpOn();
         break;
      case 3:
         setFl3UpOn();
         break;
      case 4:
         setFl4UpOn();
         break;
      default:
         break;
      }
   }
   
   // gets the current status of all floors
   public boolean[] getFloorStatus() {
      fStatus[0] = f1u;
      fStatus[1] = f2u;
      fStatus[2] = f2d;
      fStatus[3] = f3u;
      fStatus[4] = f3d;
      fStatus[5] = f4u;
      fStatus[6] = f4d;
      fStatus[7] = f5d;
      return fStatus;
   }
   
   // plays the door opening gif
   public void openDoorGif(int floorNum) {
      door_opening.getImage().flush();
      switch(floorNum) {
      case 1:
         ele_door_one.setIcon(door_opening);
         break;
      case 2:
         ele_door_two.setIcon(door_opening);
         break;
      case 3:
         ele_door_three.setIcon(door_opening);
         break;
      case 4:
         ele_door_four.setIcon(door_opening);
         break;
      case 5:
         ele_door_five.setIcon(door_opening);
         break;
      default:
         break;
      }
   }
   
   // plays the door closing gif
   public void closeDoorGif(int floorNum) {
      door_closing.getImage().flush();
      switch(floorNum) {
      case 1:
         ele_door_one.setIcon(door_closing);
         break;
      case 2:
         ele_door_two.setIcon(door_closing);
         break;
      case 3:
         ele_door_three.setIcon(door_closing);
         break;
      case 4:
         ele_door_four.setIcon(door_closing);
         break;
      case 5:
         ele_door_five.setIcon(door_closing);
         break;
      default:
         break;
      }
   } 
   
   // sets the floor door to open
   public void openDoor(int floorNum) {
	   switch(floorNum) {
	   case 1:
		   ele_door_one.setIcon(open_door);
		   break;
	   case 2:
		   ele_door_two.setIcon(open_door);
		   break;
	   case 3:
		   ele_door_three.setIcon(open_door);
		   break;
	   case 4:
		   ele_door_four.setIcon(open_door);
		   break;
	   case 5:
		   ele_door_five.setIcon(open_door);
		   break;
	   }
   }
   
   // sets the floor door to close
   public void closeDoor(int floorNum) {
	   switch(floorNum) {
	   case 1:
		   ele_door_one.setIcon(closed_door);
		   break;
	   case 2:
		   ele_door_two.setIcon(closed_door);
		   break;
	   case 3:
		   ele_door_three.setIcon(closed_door);
		   break;
	   case 4:
		   ele_door_four.setIcon(closed_door);
		   break;
	   case 5:
		   ele_door_five.setIcon(closed_door);
		   break;
	   }
   }
}
