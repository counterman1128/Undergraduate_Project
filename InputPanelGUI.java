package Undergraduate_Project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

public class InputPanelGUI extends JPanel {

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
	
	public InputPanelGUI() {
		
		title = new JLabel();
		
		
		chSpeed = new JLabel();
		speedInput = new JTextField();
		spdSubmit = new JButton();

		chPos = new JLabel();
		posInput = new JTextField();
		posSubmit = new JButton();

		setFire = new JLabel();
		f_true = new JButton();
		f_false = new JButton();

		maint = new JLabel();
		m_true = new JButton();
		m_false = new JButton();

		weight = new JLabel();
		weightInput = new JTextField();
		weightSubmit = new JButton();

		obstruct = new JLabel();
		ob_true = new JButton();
		ob_false = new JButton();
		
		setUpInputPanel();
	}
	
	private void setUpInputPanel() {
		this.setBackground(Color.WHITE);
		this.setBounds(800,13,233,695);
		this.setBorder(new MatteBorder(1,1,1,1, (Color) new Color(0,0,0)));
		setLayout(null);
		
		this.add(title);
		title.setBounds(31, 12, 155, 64);
		title.setText("Test Input");
		title.setFont(new Font("Serif", Font.PLAIN, 36));
	
		this.add(chSpeed);
		chSpeed.setBounds(12, 89, 196, 22);
		chSpeed.setText("Change Speed (ft/s) :");
		this.add(speedInput);
		speedInput.setLocation(22, 124);
		speedInput.setSize(69, 20);
		this.add(spdSubmit);
		spdSubmit.setLocation(103, 124);
		spdSubmit.setSize(81, 20);
		spdSubmit.setText("Submit");
		
		this.add(chPos);
		chPos.setBounds(12, 262, 196, 22);
		chPos.setText("Change Position (ft) :");
		this.add(posInput);
		posInput.setLocation(22,287);
		posInput.setSize(69,20);
		this.add(posSubmit);
		posSubmit.setLocation(103,287);
		posSubmit.setSize(81,20);
		posSubmit.setText("Submit");

		this.add(setFire);
		setFire.setBounds(12,442, 196,22);
		setFire.setText("Create Smoke/Fire?");
		this.add(f_true);
		f_true.setLocation(22,472);
		f_true.setSize(69,20);
		f_true.setText("Yes");
		this.add(f_false);
		f_false.setLocation(115,472);
		f_false.setSize(69,20);
		f_false.setText("No");
		
		this.add(maint);
		maint.setBounds(12, 369, 196, 22);
		maint.setText("Turn on Maintenance Mode?");
		this.add(m_true);
		m_true.setSize(69,20);
		m_true.setLocation(22,399);
		m_true.setText("Yes");
		this.add(m_false);
		m_false.setSize(69,20);
		m_false.setLocation(115,399);
		m_false.setText("No");
		
		this.add(weight);
		weight.setBounds(12, 183, 196, 22);
		weight.setText("Change the current weight (lbs) :");
		this.add(weightInput);
		weightInput.setSize(69,20);
		weightInput.setLocation(22,209);
		this.add(weightSubmit);
		weightSubmit.setSize(81,20);
		weightSubmit.setLocation(103,209);
		weightSubmit.setText("Submit");
		
		this.add(obstruct);
		obstruct.setBounds(12, 524, 196, 22);
		obstruct.setText("Create a door obstruction?");
		this.add(ob_true);
		ob_true.setSize(69,20);
		ob_true.setLocation(22,558);
		ob_true.setText("Yes");
		this.add(ob_false);
		ob_false.setSize(69,20);
		ob_false.setLocation(115,558);
		ob_false.setText("No");
	}
	
	// returns the speed from the text field
	private String getSpeed() {
		return speedInput.getText();
	}
	// returns the weight from the text field
	private String getWeight() {
		return weightInput.getText();
	}
	// returns the position from the text box
	private String getPos() {
		return posInput.getText();
	}	
}
