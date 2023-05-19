package Classes;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.file.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class Login extends LoginM implements ActionListener{
	JFrame loginFrame;
	private JLabel usernl,userpl,loginPImg,loginPTxt,usernl1,cpyrt,usernl2;
	ImageIcon icon = new ImageIcon("ALLPicture/ok1.png");
	private JTextField usernameText;
	private JPasswordField passwordText;
	private JButton loginBtn,adminloginbtn,signUpBtn,extBtn;
	private int mouseX,mouseY;


	public Login(String userName, String userPass){
		super(userName,userPass);
		loginFrame = new JFrame();


		//frame movable
		JPanel panel = new JPanel();
		panel.setBounds(0,0,830,30);
		loginFrame.getContentPane().add(panel);
		panel.setBackground(new Color(73,53,148));
		panel.setLayout(null);
		loginFrame.getContentPane().setLayout(null);
		loginFrame.getContentPane().setBackground(new Color(73,53,148));

		//copyright txt
		cpyrt = new JLabel("Copyright @2023, TEAM ROAR");
		cpyrt.setBounds(120,400,300,15);
		cpyrt.setForeground(Color.white);
		cpyrt.setFont(new Font("Segoe UI", Font.PLAIN, 10));

		//welcome label
		usernl1 = new JLabel("Welcome");
		usernl1.setBounds(470,80,150,20);
		usernl1.setForeground(Color.white);
		usernl1.setFont(new Font("Segoe UI", Font.BOLD, 20));

		//Project Title
		usernl2 = new JLabel("DHAKA ROUTE");
		usernl2.setBounds(230,80,150,18);
		usernl2.setForeground(Color.white);
		usernl2.setFont(new Font("Segoe UI", Font.BOLD, 18));

		//username label
		usernl = new JLabel("Username");
		usernl.setBounds(470,180,150,20);
		usernl.setForeground(new Color(119,85,163));
		usernl.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		//password label
		userpl = new JLabel("Password");
		userpl.setBounds(470,230,150,20);
		userpl.setForeground(new Color(119,85,163));
		userpl.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		//login txt
		loginPTxt = new JLabel("User Login");
		loginPTxt.setBounds(470,120,210,50);
		loginPTxt.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		loginPTxt.setForeground(new Color(119,85,163));
		loginPTxt.setBorder(BorderFactory.createMatteBorder(0,0,2,0,new Color(119,85,163)));

		//username txt field
		usernameText = new JTextField();
		usernameText.setBounds(470,200,220,25);
		usernameText.setBorder(BorderFactory.createMatteBorder(0,0,1,0,new Color(119,85,163)));

		//password text field
		passwordText = new JPasswordField();
		passwordText.setBounds(470,250,220,25);
		passwordText.setBorder(BorderFactory.createMatteBorder(0,0,1,0,new Color(119,85,163)));

		//login btn text field
		loginBtn = new JButton("Login");
		loginBtn.setBounds(470,290,220,30);
		loginBtn.setBackground(new Color(119,85,163));
		loginBtn.setForeground(Color.white);
		loginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		loginBtn.setFocusable(false);


		//exit btn
		extBtn = new JButton(new ImageIcon("AllPicture/exit.png"));
		extBtn.setBounds(785, 4, 30, 25);
		extBtn.setFont(new Font("Segoe UI", Font.BOLD, 20));
		extBtn.setForeground(new Color(0,0,0));
		extBtn.setFocusPainted(false);
		extBtn.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		extBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		extBtn.setContentAreaFilled(false);
		panel.add(extBtn);

		//Admin login Button
		adminloginbtn = new JButton(new ImageIcon("AllPicture/adminlogo.png"));
		adminloginbtn.setBounds(670, 80, 25, 25);
		adminloginbtn.setFont(new Font("Segoe UI", Font.BOLD, 25));
		adminloginbtn.setForeground(new Color(255,255,255));
		adminloginbtn.setFocusPainted(false);
		adminloginbtn.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		adminloginbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		adminloginbtn.setContentAreaFilled(false);

		// signup btn 
		signUpBtn = new JButton("Sign Up");
		signUpBtn.setBounds(470,325,220,30);
		signUpBtn.setBackground(new Color(119,85,163));
		signUpBtn.setForeground(Color.white);
		signUpBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		signUpBtn.setFocusable(false);

		//Icon change
		Image icon = Toolkit.getDefaultToolkit().getImage("AllPicture/title.png");
		loginFrame.setIconImage(icon);

		//background
		loginPImg = new JLabel();
		loginPImg.setIcon(new ImageIcon("AllPicture/Log.jpg"));
		loginPImg.setBounds(0,-290,1902,1076);


		// frame add component
		loginFrame.add(usernl);
		loginFrame.add(usernl1);
		loginFrame.add(usernl2);
		loginFrame.add(cpyrt);
		loginFrame.add(userpl);
		loginFrame.add(usernameText);
		loginFrame.add(passwordText);
		loginFrame.add(loginPTxt);
		loginFrame.add(adminloginbtn);
		loginFrame.add(loginBtn);
		loginFrame.add(signUpBtn);
		loginFrame.add(loginPImg);



		//button listener
		loginBtn.addActionListener(this);
		signUpBtn.addActionListener(this);
		adminloginbtn.addActionListener(this);
		extBtn.addActionListener(this);


		// frame
		loginFrame.setResizable(false);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setLayout(null);
		loginFrame.setUndecorated(true);
		loginFrame.setTitle("Dhaka Route");
		loginFrame.setSize(815,505);
		loginFrame.setVisible(true);
		loginFrame.setLocationRelativeTo(null);


		//mouse Action listener
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				loginFrame.setLocation(loginFrame.getX()+e.getX() - mouseX,loginFrame.getY() + e.getY() - mouseY);
			}
		});
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
	}
//action listener
	public void actionPerformed(ActionEvent e){
		 if(e.getSource()==loginBtn)
			{  
			

                String userName = usernameText.getText().toLowerCase(); // User Name 
                String userPass = passwordText.getText(); // Password

                if (userName.isEmpty() || userPass.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {

                	matchUser(userName, userPass);
                    if (s == 1) {
                    	loginFrame.setVisible(false);
                    }
                }	
        }
        else if(e.getSource()==signUpBtn){
        	new SignUp("dsff", "dfdf", "dfdfd", "dfdf", "fdfdf");
        	loginFrame.setVisible(false);
        }
        else if(e.getSource()==adminloginbtn){
        	new AdminLogin("userName", "userPass");
        	loginFrame.setVisible(false);
        }
        else if(e.getSource()==extBtn){
        	System.exit(0);
        }
	}

}