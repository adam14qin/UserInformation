package GUIXC;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Display extends JPanel {
	private JTextArea display;
	private String message;
	
	public Display(){
		display=new JTextArea();
		display.setBorder(null);
		display.setEnabled(true);
		display.setEditable(true);
		display.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT,20));
		display.setWrapStyleWord(true);
		message="Welcome to CSCI306 survey";
		updateText();
		add(display);
	}

	public JTextArea getDisplay() {
		return display;
	}

	public void updateText(){
		display.setText(message);
	}

	public void setMessage(String message) {
		this.message = message;
		updateText();
	}
	
}
