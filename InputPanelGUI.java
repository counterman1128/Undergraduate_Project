package Undergraduate_Project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.TextArea;
import javax.swing.JFormattedTextField;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.event.KeyEvent;

public class InputPanelGUI extends JPanel {

	private int 	inputSpeed				= 0;
	private int 	inputWeight 			= 0;
	private int 	inputPosition 			= 0;
	private boolean inputMaintenanceMode 	= false;
	private boolean inputFire				= false;
	private boolean inputDoorObstruction 	= false;
	private boolean iSpeed = false;
	private boolean iPos = false;
	
	TextArea errorMessage = new TextArea();

	private JLabel title;
	
	private JLabel chSpeed;
	private JTextField speedInput;
	private JButton spdSubmit;
	
	private JLabel chPos;
	private JTextField posInput;
	private JButton posSubmit;
	
	private JLabel setFire;
	private JButton f_true;
	private JButton f_false;
	
	private JLabel maint;
	private JButton m_true;
	private JButton m_false;
	
	private JLabel weight;
	private JTextField weightInput;
	private JButton weightSubmit;
	
	private JLabel obstruct;
	private JButton ob_true;
	private JButton ob_false;
	
	private JButton btnClear;
	
	public InputPanelGUI() {
		
		title = new JLabel();
		title.setHorizontalTextPosition(SwingConstants.CENTER);
		title.setDisplayedMnemonic(KeyEvent.VK_KP_DOWN);
		title.setAlignmentY(0.0f);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Color.DARK_GRAY);
		
		
		chSpeed = new JLabel();
		chSpeed.setHorizontalAlignment(SwingConstants.CENTER);
		speedInput = new JTextField();
		speedInput.setMaximumSize(new Dimension(5, 1));
		spdSubmit = new JButton();
		spdSubmit.setAlignmentX(Component.CENTER_ALIGNMENT);
		spdSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String speedText = speedInput.getText();
				try {
					inputSpeed = Integer.parseUnsignedInt(speedText);
					iSpeed = true;
					errorMessage.append("[+] New speed: " + inputSpeed + "\n");

				} catch (NumberFormatException s) {
					errorMessage.append("[-] Invalid entry: " + speedText + "\n");
				}
			}
		});

		weight = new JLabel();
		weight.setHorizontalAlignment(SwingConstants.CENTER);
		weightInput = new JTextField();
		weightInput.setMaximumSize(new Dimension(5, 1));
		weightSubmit = new JButton();
		weightSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String weightText = weightInput.getText();
				try {
					inputWeight = Integer.parseUnsignedInt(weightText);
					errorMessage.append("[+] New weight: " + inputWeight + "\n");
				} catch (NumberFormatException s) {
					errorMessage.append("[-] Invalid weight: " + weightText + "\n");
				}
			}
		});
		
		chPos = new JLabel();
		chPos.setHorizontalAlignment(SwingConstants.CENTER);
		posInput = new JTextField();
		posInput.setMaximumSize(new Dimension(5, 1));
		posSubmit = new JButton();
		posSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String posText = posInput.getText();		
				try {
					inputPosition = Integer.parseUnsignedInt(posText);
					iPos = true;
					errorMessage.append("[+] New position: " + inputPosition + "\n");
				} catch (NumberFormatException s) {
					errorMessage.append("[-] Invalid position: " + posText + "\n");
				}
			}
		});

		setFire = new JLabel();
		setFire.setHorizontalAlignment(SwingConstants.CENTER);
		f_true = new JButton();
		f_true.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				inputFire = true;
				f_true.setForeground(Color.RED);
				f_false.setForeground(Color.BLACK);
				errorMessage.append("[+] Fire: " + inputFire + "\n");
			}
		});
		
		f_false = new JButton();
		f_false.setForeground(Color.RED);
		f_false.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				inputFire = false;
				f_false.setForeground(Color.RED);
				f_true.setForeground(Color.BLACK);
				errorMessage.append("[+] Fire: " + inputFire + "\n");
			}
		});

		maint = new JLabel();
		maint.setHorizontalAlignment(SwingConstants.CENTER);
		m_true = new JButton();
		m_true.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				inputMaintenanceMode = true;
				m_true.setForeground(Color.RED);
				m_false.setForeground(Color.BLACK);
				errorMessage.append("[+] Maintenance: " + inputMaintenanceMode + "\n");

			}
		});
		
		m_false = new JButton();
		m_false.setForeground(Color.RED);
		m_false.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				inputMaintenanceMode = false;
				m_false.setForeground(Color.RED);
				m_true.setForeground(Color.BLACK);
				errorMessage.append("[+] Maintenance: " + inputMaintenanceMode + "\n");
			}
		});

		obstruct = new JLabel();
		obstruct.setHorizontalAlignment(SwingConstants.CENTER);
		obstruct.setBackground(Color.LIGHT_GRAY);
		ob_true = new JButton();
		ob_true.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		ob_true.setBackground(Color.LIGHT_GRAY);
		ob_true.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				inputDoorObstruction = true;
				ob_true.setForeground(Color.RED);
				ob_false.setForeground(Color.BLACK);
				errorMessage.append("[+] Obtruction: " + inputDoorObstruction + "\n");

			}
		});
		
		ob_false = new JButton();
		ob_false.setForeground(Color.RED);
		ob_false.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				inputDoorObstruction = false;
				ob_false.setForeground(Color.RED);
				ob_true.setForeground(Color.BLACK);
				errorMessage.append("[+] Obtruction: " + inputDoorObstruction + "\n");
			}
		});
		
		btnClear = new JButton("Clear");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				errorMessage.setText("");
			}
		});
				
		setUpInputPanel();
	}
	
	private void setUpInputPanel() {
		this.setBackground(Color.WHITE);
		this.setBounds(800,13,233,695);
		this.setBorder(new MatteBorder(1,1,1,1, (Color) new Color(0,0,0)));
		setLayout(null);
		
		this.add(title);
		title.setBounds(1, 10, 200, 60);
		title.setText("Control Panel");
		title.setFont(new Font("Serif", Font.PLAIN, 30));
	
		this.add(chSpeed);
		chSpeed.setBounds(15, 70, 200, 20);
		chSpeed.setText("New Speed (ft/s) :");
		this.add(speedInput);
		speedInput.setLocation(21, 100);
		speedInput.setSize(69, 20);
		this.add(spdSubmit);
		spdSubmit.setLocation(102, 100);
		spdSubmit.setSize(81, 20);
		spdSubmit.setText("Submit");
		
		this.add(chPos);
		chPos.setBounds(14, 210, 200, 22);
		chPos.setText("New Elevator Position (ft)");
		this.add(posInput);
		posInput.setLocation(21,240);
		posInput.setSize(69,20);
		this.add(posSubmit);
		posSubmit.setLocation(102,240);
		posSubmit.setSize(81,20);
		posSubmit.setText("Submit");

		this.add(setFire);
		setFire.setBounds(14,350, 196,22);
		setFire.setText("Create Smoke/Fire?");
		this.add(f_true);
		f_true.setLocation(21,380);
		f_true.setSize(69,20);
		f_true.setText("Yes");
		this.add(f_false);
		f_false.setLocation(114,380);
		f_false.setSize(69,20);
		f_false.setText("No");
		
		this.add(maint);
		maint.setBounds(14, 280, 200, 22);
		maint.setText("Maintenance Mode On?");
		this.add(m_true);
		m_true.setSize(69,20);
		m_true.setLocation(21,310);
		m_true.setText("Yes");
		this.add(m_false);
		m_false.setSize(69,20);
		m_false.setLocation(114,310);
		m_false.setText("No");
		
		this.add(weight);
		weight.setBounds(14, 140, 200, 22);
		weight.setText("New weight (lbs) :");
		this.add(weightInput);
		weightInput.setSize(69,20);
		weightInput.setLocation(23,170);
		this.add(weightSubmit);
		weightSubmit.setSize(81,20);
		weightSubmit.setLocation(104,170);
		weightSubmit.setText("Submit");
		
		this.add(obstruct);
		obstruct.setBounds(14, 420, 200, 20);
		obstruct.setText("Create a door obstruction?");
		this.add(ob_true);
		ob_true.setSize(69,20);
		ob_true.setLocation(21,450);
		ob_true.setText("Yes");
		this.add(ob_false);
		ob_false.setSize(69,20);
		ob_false.setLocation(114,450);
		ob_false.setText("No");
		
		errorMessage.setBounds(15, 490, 170, 170);
		this.add(errorMessage);
		
		btnClear.setBounds(44, 660, 117, 29);
		this.add(btnClear);
	}
	
	// returns the new speed of the car as set by the text box
	public int getSpeed() {
		return inputSpeed;
	}
	// returns the weight from the text field
	public int getWeight() {
		return inputWeight;
	}
	// returns the position from the text box
	public int getPos() {
		return inputPosition;
	}	
	
	public boolean getMaintenanceMode() {
		return inputMaintenanceMode;
	}
	
	public boolean getFire() {
		return inputFire;
	}
	
	public boolean getDoorObstruction() {
		return inputDoorObstruction;
	}
	
	public boolean getiSpeed() {
		return iSpeed;
	}
	
	public void setiSpeed(boolean s) {
		iSpeed = s;
	}
	
	public boolean getiPos() {
		return iPos;
	}
	
	public void setiPos(boolean s) {
		iPos = s;
	}
}