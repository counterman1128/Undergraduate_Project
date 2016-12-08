package Undergraduate_Project;
//This is a test change_2
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import java.awt.Image.*;
import java.util.*;
//Files

import Undergraduate_Project.CarPanelGUI;
import Undergraduate_Project.FloorPanelGUI;
import Undergraduate_Project.PistonPanelGUI;
import Undergraduate_Project.InputPanelGUI;
import Undergraduate_Project.ControlSystem;

public class MainDisplay {

	private JFrame frame;
	private static PistonPanelGUI pp;
	private static FloorPanelGUI fp;
	private static CarPanelGUI cp;
	private static InputPanelGUI ip;
	private static ControlSystem cs = new ControlSystem();
	//private static ElevatorCarPiston daPiston = new ElevatorCarPiston();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws InterruptedException{
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainDisplay window = new MainDisplay();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
		
	/**
	 * Control Application from here
	 */
		MainDisplay window = new MainDisplay();
		window.frame.setVisible(true);
		for(double x = 0; x<41;x=x+1.6){//This is for a test. Use a while loop when running full program
			Thread.sleep(1000);
			pp.piston_main(x);
			System.out.println(x);
		}
		
		/*
		for(int i=0;i<26;i++){
			Thread.sleep(1000);
			pp.setPiston(i);
		}*/
	}

	/**
	 * Create the application.
	 */
	public MainDisplay() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		// creates main application window
		frame = new JFrame("Undergrad Elevator Control System");
		frame.setBounds(100, 100, 1190, 763);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// creates the beginning piston panel
		pp = new PistonPanelGUI();
		frame.getContentPane().add(pp);
		
		// creates the beginning floor panel
		fp = new FloorPanelGUI();
		frame.getContentPane().add(fp);
		
		// creates the beginning elevator car panel
		cp = new CarPanelGUI();
		frame.getContentPane().add(cp);
		
		// creates the beginning test input panel
		ip = new InputPanelGUI();
		ip.setSize(207, 695);
		ip.setLocation(953, 13);
		frame.getContentPane().add(ip);
	}
	
	public double piston_pos(){
		return cs.getElevatorPosition();
	}
	
}
