package Classes;

import Interfaces.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.file.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class SignUp extends SignUpM implements ActionListener{
	JFrame signUpFrame;
	private JLabel fName,lName;
	ImageIcon icon = new ImageIcon("ALLPicture/ok1.png");
	private JLabel signUpImg,userName,email,userPass,cpyrt,usernl1;
	private JTextField fNameText,lNameText,emailText,userNameText;
	private JPasswordField userPassword;
	private JButton signBtn,backBtn,extBtn;
	int mouseX,mouseY;

	public SignUp(String firstName, String lastName, String email1, String username, String upassword){
		//JFrame and Parent Class call
		super(firstName,lastName,email1,username,upassword);
		signUpFrame = new JFrame();

		JPanel panel = new JPanel();
		panel.setBounds(0,0,830,30);
		signUpFrame.getContentPane().add(panel);
		panel.setBackground(new Color(204,227,219));
		panel.setLayout(null);
		signUpFrame.getContentPane().setLayout(null);
		signUpFrame.getContentPane().setBackground(new Color(204,227,219));

		//exit btn
		extBtn = new JButton(new ImageIcon("AllPicture/exit.png"));
		extBtn.setBounds(520, 4, 30, 25);
		extBtn.setFont(new Font("Segoe UI", Font.BOLD, 20));
		extBtn.setForeground(new Color(0,0,0));
		extBtn.setFocusPainted(false);
		extBtn.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		extBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		extBtn.setContentAreaFilled(false);
		panel.add(extBtn);

		//copyrite Text
		cpyrt = new JLabel("Copyright @2023, TEAM ROAR");
		cpyrt.setBounds(200,490,300,15);
		cpyrt.setForeground(new Color(0,0,0));
		cpyrt.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		signUpFrame.add(cpyrt);

		//Create Account Label
		usernl1 = new JLabel("Create an Account");
		usernl1.setBounds(175,30,220,25);
		usernl1.setForeground(new Color(0,0,0));
		usernl1.setFont(new Font("Segoe UI", Font.BOLD, 25));
		signUpFrame.add(usernl1);
		

		//First Name Label
		fName = new JLabel("First Name");
		fName.setBounds(175,76,200,30);
		fName.setForeground(new Color(0,0,0));
		fName.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		signUpFrame.add(fName);

		//First name Text
		fNameText = new JTextField();
		fNameText.setBounds(175,105,200,30);
		fNameText.setBackground(new Color(204,227,219));
		fNameText.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		fNameText.setBorder(BorderFactory.createMatteBorder(0,0,1,0,new Color(0,0,0)));
		signUpFrame.add(fNameText);

		//Last Name Label
		lName = new JLabel("Last Name");
		lName.setBounds(175,135,200,30);
		lName.setForeground(new Color(0,0,0));
		lName.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		signUpFrame.add(lName);

		//Last Name Text
		lNameText = new JTextField();
		lNameText.setBounds(175,165,200,30);
		lNameText.setBackground(new Color(204,227,219));
		lNameText.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lNameText.setBorder(BorderFactory.createMatteBorder(0,0,1,0,new Color(0,0,0)));
		signUpFrame.add(lNameText);

		//Username Label
		userName = new JLabel("Username");
		userName.setBounds(175,196,200,30);
		userName.setForeground(new Color(0,0,0));
		userName.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		signUpFrame.add(userName);

		//Username Txt
		userNameText = new JTextField();
		userNameText.setBounds(175,225,200,30);
		userNameText.setBackground(new Color(204,227,219));
		userNameText.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		userNameText.setBorder(BorderFactory.createMatteBorder(0,0,1,0,new Color(0,0,0)));
		signUpFrame.add(userNameText);

		//Email Label
		email = new JLabel("Email");
		email.setBounds(175,255,200,30);
		email.setForeground(new Color(0,0,0));
		email.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		signUpFrame.add(email);

		//Email Text
		emailText = new JTextField();
		emailText.setBounds(175,285,200,30);
		emailText.setBackground(new Color(204,227,219));
		emailText.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		emailText.setBorder(BorderFactory.createMatteBorder(0,0,1,0,new Color(0,0,0)));
		signUpFrame.add(emailText);


		
		//userpassword Label
		userPass = new JLabel("Password");
		userPass.setBounds(175,315,200,30);
		userPass.setForeground(new Color(0,0,0));
		userPass.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		signUpFrame.add(userPass);

		//Userpassword Text
		userPassword = new JPasswordField();
		userPassword.setBounds(175,345,200,30);
		userPassword.setBackground(new Color(204,227,219));
		userPassword.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		userPassword.setBorder(BorderFactory.createMatteBorder(0,0,1,0,new Color(0,0,0)));
		signUpFrame.add(userPassword);


		//SignUp Button
		signBtn = new JButton("SignUp");
		signBtn.setBounds(150,390,120,30);
		signBtn.setForeground(new Color(0,0,0));
		signBtn.setBackground(new Color(204,227,219));
		signBtn.setBorder(BorderFactory.createBevelBorder(0));
		signBtn.setFont(new Font("Segoe UI", Font.BOLD, 15));
		signBtn.setFocusable(false);
		signUpFrame.add(signBtn);

		//Back Button
		backBtn = new JButton("Back");
		backBtn.setBounds(300,390,120,30);		
		backBtn.setForeground(new Color(0,0,0));
		backBtn.setBackground(new Color(204,227,219));
		backBtn.setBorder(BorderFactory.createBevelBorder(0));
		backBtn.setFont(new Font("Segoe UI", Font.BOLD, 15));
		backBtn.setFocusable(false);
		signUpFrame.add(backBtn);


		//Icon Change
		Image icon = Toolkit.getDefaultToolkit().getImage("AllPicture/title.png");
		signUpFrame.setIconImage(icon);

		//BackGround Image
		signUpImg = new JLabel();
		signUpImg.setIcon(new ImageIcon("ALLPicture/SignLast.jpg"));
		signUpImg.setBounds(0,0,550,550);
		signUpFrame.add(signUpImg);
		signUpFrame.setResizable(false);
		

		//button action perform
		signBtn.addActionListener(this);
		backBtn.addActionListener(this);
		extBtn.addActionListener(this);


		//frame build
		signUpFrame.setSize(550,550);
		signUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		signUpFrame.setLayout(null);
		signUpFrame.setUndecorated(true);
		signUpFrame.setTitle("Dhaka Route");
		signUpFrame.setVisible(true);
		signUpFrame.setLocationRelativeTo(null);

		//mouse Action listener
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				signUpFrame.setLocation(signUpFrame.getX()+e.getX() - mouseX,signUpFrame.getY() + e.getY() - mouseY);
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

	public void actionPerformed(ActionEvent e) {
        if(e.getSource()==signBtn)
		{  
				
				String firstName = fNameText.getText(); // First Name
				String lastName = lNameText.getText(); // Last Name
                String email1 = emailText.getText().toLowerCase(); // Email
                String username = userNameText.getText(); // User name
                String upassword = userPassword.getText(); // Password

                if (username.isEmpty() || upassword.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    if (firstName.isEmpty() || lastName.isEmpty() || email1.isEmpty() || username.isEmpty()
                            || upassword.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                                JOptionPane.WARNING_MESSAGE);
                    }else {
                        SignUp(firstName,lastName,email1,username,upassword);

                        if (s == 1) {
                            signUpFrame.setVisible(false);
                        }
                    }
                }
            
			
        }else if(e.getSource()==backBtn)
		{  
			new Login("userName", "userPass");
			signUpFrame.setVisible(false);
			//System.exit(0);
        }
		else if(e.getSource()==extBtn){
			System.exit(0);
		}
}
	
}	