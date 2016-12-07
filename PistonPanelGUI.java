package elevatorProject;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;

public class PistonPanelGUI extends JPanel {

	// object declarations
	private JLabel piston;
	private ImageIcon piston_0;
	private ImageIcon piston_1;
	private ImageIcon piston_2;
	private ImageIcon piston_3;
	private ImageIcon piston_4;
	private ImageIcon piston_5;
	private ImageIcon piston_6;
	private ImageIcon piston_7;
	private ImageIcon piston_8;
	private ImageIcon piston_9;
	private ImageIcon piston_10;
	private ImageIcon piston_11;
	private ImageIcon piston_12;
	private ImageIcon piston_13;
	private ImageIcon piston_14;
	private ImageIcon piston_15;
	private ImageIcon piston_16;
	private ImageIcon piston_17;
	private ImageIcon piston_18;
	private ImageIcon piston_19;
	private ImageIcon piston_20;
	private ImageIcon piston_21;
	private ImageIcon piston_22;
	private ImageIcon piston_23;
	private ImageIcon piston_24;
	private ImageIcon piston_25;
	
	
	// default constructor
	public PistonPanelGUI() {
		
		// initialize objects
		piston = new JLabel();
		piston_0 = new ImageIcon(getClass().getResource("/resources/piston00.png"));
		piston_1 = new ImageIcon(getClass().getResource("/resources/piston01.png"));
		piston_2 = new ImageIcon(getClass().getResource("/resources/piston02.png"));
		piston_3 = new ImageIcon(getClass().getResource("/resources/piston03.png"));
		piston_4 = new ImageIcon(getClass().getResource("/resources/piston04.png"));
		piston_5 = new ImageIcon(getClass().getResource("/resources/piston05.png"));
		piston_6 = new ImageIcon(getClass().getResource("/resources/piston06.png"));
		piston_7 = new ImageIcon(getClass().getResource("/resources/piston07.png"));
		piston_8 = new ImageIcon(getClass().getResource("/resources/piston08.png"));
		piston_9 = new ImageIcon(getClass().getResource("/resources/piston09.png"));
		piston_10 = new ImageIcon(getClass().getResource("/resources/piston10.png"));
		piston_11 = new ImageIcon(getClass().getResource("/resources/piston11.png"));
		piston_12 = new ImageIcon(getClass().getResource("/resources/piston12.png"));
		piston_13 = new ImageIcon(getClass().getResource("/resources/piston13.png"));
		piston_14 = new ImageIcon(getClass().getResource("/resources/piston14.png"));
		piston_15 = new ImageIcon(getClass().getResource("/resources/piston15.png"));
		piston_16 = new ImageIcon(getClass().getResource("/resources/piston16.png"));
		piston_17 = new ImageIcon(getClass().getResource("/resources/piston17.png"));
		piston_18 = new ImageIcon(getClass().getResource("/resources/piston18.png"));
		piston_19 = new ImageIcon(getClass().getResource("/resources/piston19.png"));
		piston_20 = new ImageIcon(getClass().getResource("/resources/piston20.png"));
		piston_21 = new ImageIcon(getClass().getResource("/resources/piston21.png"));
		piston_22 = new ImageIcon(getClass().getResource("/resources/piston22.png"));
		piston_23 = new ImageIcon(getClass().getResource("/resources/piston23.png"));
		piston_24 = new ImageIcon(getClass().getResource("/resources/piston24.png"));
		piston_25 = new ImageIcon(getClass().getResource("/resources/piston25.png"));
		
		
		// set up panel
		setupPistonPanel();
	}
	
	// sets up beginning display of the piston panel
	private void setupPistonPanel() {

		// default settings
		this.setBackground(Color.WHITE);
		this.setBorder(new MatteBorder(1,1,1,1, (Color) new Color(0,0,0)));
		this.setBounds(12,13,192,695);
		setLayout(null);
		this.add(piston);
		setPiston0();
	}
	
	public void setPiston(int level) {
		switch(level) {
		case 0:
			setPiston0();
			break;
		case 1:
			setPiston1();
			break;
		case 2:
			setPiston2();
			break;
		case 3:
			setPiston3();
			break;
		case 4:
			setPiston4();
			break;
		case 5:
			setPiston5();
			break;
		case 6:
			setPiston6();
			break;
		case 7:
			setPiston7();
			break;
		case 8:
			setPiston8();
			break;
		case 9:
			setPiston9();
			break;
		case 10:
			setPiston10();
			break;
		case 11:
			setPiston11();
			break;
		case 12:
			setPiston12();
			break;
		case 13:
			setPiston13();
			break;
		case 14:
			setPiston14();
			break;
		case 15:
			setPiston15();
			break;
		case 16:
			setPiston16();
			break;
		case 17:
			setPiston17();
			break;
		case 18:
			setPiston18();
			break;
		case 19:
			setPiston19();
			break;
		case 20:
			setPiston20();
			break;
		case 21:
			setPiston21();
			break;
		case 22:
			setPiston22();
			break;
		case 23:
			setPiston23();
			break;
		case 24:
			setPiston24();
			break;
		case 25:
			setPiston25();
			break;
		default:
			System.out.print("ERROR IN FLOOR SELECTION");
			break;
		}
			
	}
	
	// Sets the piston to position zero
	public void setPiston0() {
		piston.setIcon(piston_0);
		piston.setBounds(36, 550, 119, 154);
	}
	
	// Sets the piston to position one
	public void setPiston1() {
		piston.setIcon(piston_1);
		piston.setBounds(36, 539, 119, 154);
	}

	// Sets the piston to position two
	public void setPiston2() {
		piston.setIcon(piston_2);
		piston.setBounds(36, 511, 119, 186);
	}

	// Sets the piston to position three
	public void setPiston3() {
		piston.setIcon(piston_3);
		piston.setBounds(36, 486, 119, 215);
	}

	// Sets the piston to position four
	public void setPiston4() {
		piston.setIcon(piston_4);
		piston.setBounds(36, 446, 119, 273);
	}
	
	// Sets the piston to position five
	public void setPiston5() {
		piston.setIcon(piston_5);
		piston.setBounds(36, 410, 119, 323);
	}
	
	// Sets the piston to position six
	public void setPiston6() {
		piston.setIcon(piston_6);
		piston.setBounds(36, 382, 119, 356);
	}
	
	// Sets the piston to position seven
	public void setPiston7() {
		piston.setIcon(piston_7);
		piston.setBounds(36, 371, 119, 356);
	}

	// Sets the piston to position eight
	public void setPiston8() {
		piston.setIcon(piston_8);
		piston.setBounds(36, 360, 119, 356);
	}
	
	// Sets the piston to position nine
	public void setPiston9() {
		piston.setIcon(piston_9);
		piston.setBounds(36, 349, 119, 356);
	}
	
	// Sets the piston to position 10
	public void setPiston10() {
		piston.setIcon(piston_10);
		piston.setBounds(36, 317, 119, 397);
	}
	
	// Sets the piston to position 11
	public void setPiston11() {
		piston.setIcon(piston_11);
		piston.setBounds(36, 284, 119, 441);
	}
	
	// Sets the piston to position 12
	public void setPiston12() {
		piston.setIcon(piston_12);
		piston.setBounds(36, 267, 119, 451);
	}
	
	// Sets the piston to position 13
	public void setPiston13() {
		piston.setIcon(piston_13);
		piston.setBounds(36, 256, 119, 451);
	}
	
	// Sets the piston to position 14
	public void setPiston14() {
		piston.setIcon(piston_14);
		piston.setBounds(36, 245, 119, 451);
	}
	
	// Sets the piston to position 15
	public void setPiston15() {
		piston.setIcon(piston_15);
		piston.setBounds(36, 113, 119, 538);
	}
	
	// Sets the piston to position 16
	public void setPiston16() {
		piston.setIcon(piston_16);
		piston.setBounds(36, 191, 119, 517);
	}
	
	// Sets the piston to position 17
	public void setPiston17() {
		piston.setIcon(piston_17);
		piston.setBounds(36, 89, 119, 542);
	}

	// Sets the piston to position 18
	public void setPiston18() {
		piston.setIcon(piston_18);
		piston.setBounds(36, 128, 119, 594);
	}
	
	// Sets the piston to position 19
	public void setPiston19() {
		piston.setIcon(piston_19);
		piston.setBounds(36, 117, 119, 594);
	}
	
	// Sets the piston to position 20
	public void setPiston20() {
		piston.setIcon(piston_20);
		piston.setBounds(36, 107, 119, 594);
	}
	
	// Sets the piston to position 21
	public void setPiston21() {
		piston.setIcon(piston_21);
		piston.setBounds(36, 84, 119, 619);
	}
	
	// Sets the piston to position 22
	public void setPiston22() {
		piston.setIcon(piston_22);
		piston.setBounds(36, 67, 119, 628);
	}
	
	// Sets the piston to position 23
	public void setPiston23() {
		piston.setIcon(piston_23);
		piston.setBounds(36, 45, 119, 651);
	}
	
	// Sets the piston to position 24
	public void setPiston24() {
		piston.setIcon(piston_24);
		piston.setBounds(36, 18, 119, 683);
	}
	
	// Sets the piston to position 25
	public void setPiston25() {
		piston.setIcon(piston_25);
		piston.setBounds(36, -1, 119, 701);
	}
}


