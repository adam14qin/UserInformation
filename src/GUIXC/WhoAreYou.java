package GUIXC;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class WhoAreYou extends JFrame{
	
	public WhoAreYou(){
		setTitle("Who Are You?");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setLayout(new GridLayout(1,1));
		setSize(1200, 800);
//		setResizable(false);
		
		// Set menu bar
		JMenu menu=new JMenu("File");
		JMenuBar menuBar=new JMenuBar();
		setJMenuBar(menuBar);
		menu.add(creatFileExitItem());
		menuBar.add(menu);
		// Add main panel
		add(CreatePanel());
	}
	
	private JMenuItem creatFileExitItem()
	{
		JMenuItem item=new JMenuItem("Exit");
		class MenuItemListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		}
		item.addActionListener(new MenuItemListener());
		return item;
	}
	
	private JPanel CreatePanel(){
		Display feedbackText=new Display();
//		JPanel Main=new JPanel(new GridLayout(3,1));
		JPanel Main=new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		
		Font plainFont=new Font("Times New Roman", Font.PLAIN, 20);
		JPanel Top=new JPanel(new GridLayout(1,2));
		////////////////////////////////////////////
		JPanel TopLeft=new JPanel(new GridLayout(2,1));
		JLabel beverageLabel = new JLabel("Select your preferred beverages:");
		beverageLabel.setFont(plainFont);
		TopLeft.add(beverageLabel);
		JPanel beverages=new JPanel(new GridLayout(1,4));

		beverages.add(teaCheckBox(feedbackText));
		beverages.add(sodaCheckBox(feedbackText));
		beverages.add(coffeeCheckBox(feedbackText));
		beverages.add(waterCheckBox(feedbackText));
		TopLeft.add(beverages);
		//////////////////////////////////////////////
		JPanel TopRight=new JPanel(new GridLayout(2,1));
		JLabel activityLabel = new JLabel("Select your favoriate activities:"); 
		activityLabel.setFont(plainFont);
		TopRight.add(activityLabel);
		JPanel activities=new JPanel(new GridLayout(1,4));
		activities.add(gameCheckBox(feedbackText));
		activities.add(hikeCheckBox(feedbackText));
		activities.add(readCheckBox(feedbackText));
		activities.add(theaterCheckBox(feedbackText));
		TopRight.add(activities);
		Top.add(TopLeft);
		Top.add(TopRight);

		
		JPanel Center=new JPanel(new GridLayout(1,4));
		JPanel Movie=new JPanel(new FlowLayout());
		JLabel movieLabel = new JLabel("Enter your three favorite movies"); 
		movieLabel.setFont(plainFont);
		Movie.add(movieLabel,BorderLayout.NORTH);
		JPanel MovieDescription=new JPanel(new GridLayout(3,1));
		JTextArea  movie1=new JTextArea();
		movie1.setEditable(true);
		movie1.setEnabled(true);
		movie1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		movie1.setWrapStyleWord(true);
		TitledBorder mBorder=new TitledBorder (new EtchedBorder(), "");
		movie1.setBorder(mBorder);
		movie1.setMinimumSize(getMinimumSize());
		JTextArea  movie2=new JTextArea();
		movie2.setEditable(true);
		movie2.setEnabled(true);
		movie2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		movie2.setWrapStyleWord(true);
		movie2.setBorder(mBorder);
		movie2.setMinimumSize(getMinimumSize());
		JTextArea  movie3=new JTextArea();
		movie3.setEditable(true);
		movie3.setEnabled(true);
		movie3.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		movie3.setWrapStyleWord(true);
		movie3.setBorder(mBorder);
		movie3.setMinimumSize(getMinimumSize());
		MovieDescription.add(movie1);
		MovieDescription.add(movie2);
		MovieDescription.add(movie3);
		MovieDescription.setPreferredSize(new Dimension(300,420));
		Movie.add(MovieDescription,BorderLayout.SOUTH);
		TitledBorder movieBorder=new TitledBorder (new EtchedBorder(), "Movies");
		movieBorder.setTitleFont(plainFont);
		Movie.setBorder(movieBorder);
		Center.add(Movie);
		//////////////////////////////////////
		JPanel personInfo=new JPanel(new GridLayout(3,1));
		JPanel Height=new JPanel(new GridLayout(1,3));
		JPanel Weight=new JPanel(new GridLayout(1,3));
		JPanel Gender=new JPanel(new GridLayout(1,2));
		TitledBorder hBorder=new TitledBorder (new EtchedBorder(), "Height");
		hBorder.setTitleFont(plainFont);
		Height.setBorder(hBorder);
		Height.add(new JRadioButton("Short"));
		Height.add(new JRadioButton("Average"));
		Height.add(new JRadioButton("Tall"));
		personInfo.add(Height);
		TitledBorder wBorder=new TitledBorder (new EtchedBorder(), "Weight");
		wBorder.setTitleFont(plainFont);
		Weight.setBorder(wBorder);
		Weight.add(new JRadioButton("Thin"));
		Weight.add(new JRadioButton("Average"));
		Weight.add(new JRadioButton("Hefty"));
		personInfo.add(Weight);
		TitledBorder gBorder=new TitledBorder (new EtchedBorder(), "Gender");
		gBorder.setTitleFont(plainFont);
		Gender.setBorder(gBorder);
		Gender.add(new JRadioButton("Male"));
		Gender.add(new JRadioButton("Female"));
		personInfo.add(Gender);
		Center.add(personInfo);
		/////////////////////////////////////////
		JPanel Description=new JPanel(new FlowLayout());
		TitledBorder desBorder=new TitledBorder (new EtchedBorder(), "Free format Description");
		desBorder.setTitleFont(plainFont);
		Description.setBorder(desBorder);
		JLabel introLabel = new JLabel("Enter a description of yourself"); 
		introLabel.setFont(plainFont);
		Description.add(introLabel,BorderLayout.NORTH);
		JPanel Wrapper=new JPanel(new GridLayout(1,1));
		Wrapper.add(Intro());
		Wrapper.setPreferredSize(new Dimension(300,420));
		Description.add(Wrapper,BorderLayout.SOUTH);
		Center.add(Description);
		
		JPanel Bottom=new JPanel(new GridLayout(2,1));
		JLabel feedbackLabel = new JLabel("System Message"); 
		feedbackLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Bottom.add(feedbackLabel,BorderLayout.WEST);
		//Display feedback message
		Bottom.add(feedbackText.getDisplay(),BorderLayout.WEST);
		

		c.weightx = 0.5;
		c.ipadx = 50; // add padding
		c.ipady = 50;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.anchor=GridBagConstraints.NORTH;
		Main.add(Top,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 300;
		c.ipadx = 350; // add padding
		c.ipady = 350;
		Main.add(Center,c);
		c.ipadx = 20; // add padding
		c.ipady = 20;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		c.anchor=GridBagConstraints.SOUTH;
		Main.add(Bottom,c);
		return Main;
	}
	
	public JCheckBox teaCheckBox(Display disp){
		JCheckBox teaCheckBox=new JCheckBox("Tea");
		class CheckBoxListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JCheckBox checkbox = (JCheckBox) e.getSource();
				if (!checkbox.isSelected()) {disp.setMessage("");}		
				else { disp.setMessage("Does Green tea cure cancer?");
				}
			}
		}
		teaCheckBox.addActionListener(new CheckBoxListener());
		return teaCheckBox;
	}
	
	public JCheckBox sodaCheckBox(Display disp){
		JCheckBox sodaCheckBox=new JCheckBox("Soda");
		class CheckBoxListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JCheckBox checkbox = (JCheckBox) e.getSource();
				if (!checkbox.isSelected()) {disp.setMessage("");}		
				else { disp.setMessage("Better drink diet.");
				}
			}
		}
		sodaCheckBox.addActionListener(new CheckBoxListener());
		return sodaCheckBox;
	}
	
	public JCheckBox coffeeCheckBox(Display disp){
		JCheckBox coffeeCheckBox=new JCheckBox("Coffee");
		class CheckBoxListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JCheckBox checkbox = (JCheckBox) e.getSource();
				if (!checkbox.isSelected()) {disp.setMessage("");}		
				else { disp.setMessage("Do you know caffein prevents parkinson's disease?");
				}
			}
		}
		coffeeCheckBox.addActionListener(new CheckBoxListener());
		return coffeeCheckBox;
	}
	
	public JCheckBox waterCheckBox(Display disp){
		JCheckBox waterCheckBox=new JCheckBox("Water");
		class CheckBoxListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JCheckBox checkbox = (JCheckBox) e.getSource();
				if (!checkbox.isSelected()) {disp.setMessage("");}		
				else { disp.setMessage("A person needs to drink 6 glasses of water a day.");
				}
			}
		}
		waterCheckBox.addActionListener(new CheckBoxListener());
		return waterCheckBox;
	}
	
	public JCheckBox gameCheckBox(Display disp){
		JCheckBox gameCheckBox=new JCheckBox("Gamer");
		class CheckBoxListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JCheckBox checkbox = (JCheckBox) e.getSource();
				if (!checkbox.isSelected()) {disp.setMessage("");}		
				else { disp.setMessage("Don't get addicted to computer game otherwise you cann't find a gf/bf");
				}
			}
		}
		gameCheckBox.addActionListener(new CheckBoxListener());
		return gameCheckBox;
	}
	
	public JCheckBox hikeCheckBox(Display disp){
		JCheckBox hikeCheckBox=new JCheckBox("Hiking");
		class CheckBoxListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JCheckBox checkbox = (JCheckBox) e.getSource();
				if (!checkbox.isSelected()) {disp.setMessage("");}		
				else { disp.setMessage("Colorado is the right place to hike. You can also go mountain biking");
				}
			}
		}
		hikeCheckBox.addActionListener(new CheckBoxListener());
		return hikeCheckBox;
	}
	
	public JCheckBox readCheckBox(Display disp){
		JCheckBox readCheckBox=new JCheckBox("Reading");
		class CheckBoxListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JCheckBox checkbox = (JCheckBox) e.getSource();
				if (!checkbox.isSelected()) {disp.setMessage("");}		
				else { disp.setMessage("What's your favorite book?");
				}
			}
		}
		readCheckBox.addActionListener(new CheckBoxListener());
		return readCheckBox;
	}
	
	public JCheckBox theaterCheckBox(Display disp){
		JCheckBox theaterCheckBox=new JCheckBox("Watching Movie");
		class CheckBoxListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JCheckBox checkbox = (JCheckBox) e.getSource();
				if (!checkbox.isSelected()) {disp.setMessage("");}		
				else { disp.setMessage("What do you think of Dr Strange?");
				}
			}
		}
		theaterCheckBox.addActionListener(new CheckBoxListener());
		return theaterCheckBox;
	}
	
	public JTextArea Intro(){
		JTextArea Intro = new JTextArea(); 
		Intro.setEnabled(true);
		Intro.setEditable(true);
		Intro.setText("You, in a box");
		Intro.setFont(new Font("Times New Roman", Font.BOLD,30));
		Intro.setWrapStyleWord(true);
		Intro.setMinimumSize(getMinimumSize());
		Intro.setBorder(new TitledBorder (new EtchedBorder(), ""));
		return Intro;
	}
	
	public static void main(String[] args) {
		WhoAreYou gui = new WhoAreYou();
		gui.setVisible(true);
	}
}
