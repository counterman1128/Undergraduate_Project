package Undergraduate_Project;

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
import Undergraduate_Project.ElevatorCarPiston;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainDisplay {

	private JFrame frame;
	private static PistonPanelGUI pp;
	private static FloorPanelGUI fp;
	private static CarPanelGUI cp;
	private static InputPanelGUI ip;

	 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws InterruptedException{
		MainDisplay window = new MainDisplay();
		window.frame.setVisible(true);
		ControlSystem controlSystem = new ControlSystem(pp, fp, cp, ip);
		pp.setLayout(new CardLayout(0, 0));

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
	public void initialize() {

		// creates main application window
		frame = new JFrame("Undergrad Elevator Control System");
		frame.setBounds(100, 100, 1190, 763);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// creates the beginning piston panel
		pp = new PistonPanelGUI();
		pp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Piston Clicked");

			}
		});

		pp.setLocation(10, 13);
		frame.getContentPane().add(pp);
		
		
		// creates the beginning floor panel
		fp = new FloorPanelGUI();
		frame.getContentPane().add(fp);
		
		// creates the beginning elevator car panel
		cp = new CarPanelGUI();
		cp.setLocation(459, 23);
		frame.getContentPane().add(cp);
		
	
		// creates the beginning test input panel
		ip = new InputPanelGUI();
		ip.setSize(207, 695);
		ip.setLocation(953, 13);
		frame.getContentPane().add(ip);
	}
	public CarPanelGUI getCp() {
		return cp;
	}
}
