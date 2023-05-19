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

public class AdminLogin extends LoginM implements ActionListener{
	JFrame adminLogin;
	private JLabel adminUserNameLabel,adminUserPassLabel,welcomLvl,welcomLvl1,cpyrt,coverLogo,logo;

	private JTextField adminUserNameTxt;
	private JPasswordField adminUserPassTxt;
	private JButton loginBtn,userloginbtn;


	public AdminLogin(String userName, String userPass){
		super(userName,userPass);
		adminLogin = new JFrame();

		logo = new JLabel();
		logo.setIcon(new ImageIcon("ALLPicture/logolast.png"));
		logo.setBounds(380,70,60,60);
		adminLogin.add(logo);

		//welcome label
		welcomLvl = new JLabel("Welcome");
		welcomLvl.setBounds(330,130,250,40);
		welcomLvl.setForeground(new Color(255,255,255));
		welcomLvl.setFont(new Font("Segoe UI", Font.BOLD, 35));
		adminLogin.add(welcomLvl);

		welcomLvl1 = new JLabel("Admin");
		welcomLvl1.setBounds(370,170,250,25);
		welcomLvl1.setForeground(new Color(255,255,255));
		welcomLvl1.setFont(new Font("Segoe UI", Font.BOLD, 25));
		adminLogin.add(welcomLvl1);

		//username Label
		adminUserNameLabel = new JLabel("Username");
		adminUserNameLabel.setBounds(300,270,150,20);
		adminUserNameLabel.setForeground(new Color(34,158,196));
		adminUserNameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		adminLogin.add(adminUserNameLabel);

		//Admin Usertxt
		adminUserNameTxt = new JTextField();
		adminUserNameTxt.setBounds(300,300,220,25);
		adminUserNameTxt.setBorder(BorderFactory.createMatteBorder(0,0,1,0,new Color(34,158,196)));
		adminLogin.add(adminUserNameTxt);


		//admin pass label
		adminUserPassLabel = new JLabel("Password");
		adminUserPassLabel.setBounds(300,330,150,20);
		adminUserPassLabel.setForeground(new Color(34,158,196));
		adminUserPassLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		adminLogin.add(adminUserPassLabel);

		//admin pass txt
		adminUserPassTxt = new JPasswordField();
		adminUserPassTxt.setBounds(300,360,220,25);
		adminUserPassTxt.setBorder(BorderFactory.createMatteBorder(0,0,1,0,new Color(34,158,196)));
		adminLogin.add(adminUserPassTxt);

		// copy right label
		cpyrt = new JLabel("Copyright @2023, TEAM ROAR");
		cpyrt.setBounds(650,470,300,15);
		cpyrt.setForeground(Color.black);
		cpyrt.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		adminLogin.add(cpyrt);

		//login btn
		loginBtn = new JButton("Login");
		loginBtn.setBounds(290,400,110,30);
		loginBtn.setBackground(new Color(34,158,196));
		loginBtn.setForeground(Color.white);
		loginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		loginBtn.setFocusable(false);
		adminLogin.add(loginBtn);


		//userlogin btn
		userloginbtn = new JButton("User Login");
		userloginbtn.setBounds(425,400,110,30);
		userloginbtn.setBackground(new Color(34,158,196));
		userloginbtn.setForeground(Color.white);
		userloginbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		userloginbtn.setFocusable(false);
		adminLogin.add(userloginbtn);



        // background
		coverLogo = new JLabel();
		coverLogo.setIcon(new ImageIcon("AllPicture/adminlog.jpg"));
		coverLogo.setBounds(-10,0,815,530);
		adminLogin.add(coverLogo);

		//Icon Chnage
		Image icon = Toolkit.getDefaultToolkit().getImage("AllPicture/title.png");
		adminLogin.setIconImage(icon);

		///Button listener
		loginBtn.addActionListener(this);
		userloginbtn.addActionListener(this);

		//frame
		adminLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminLogin.setLayout(null);
		adminLogin.setTitle("Dhaka Route");
		adminLogin.setSize(815,530);
		adminLogin.setVisible(true);
		adminLogin.setLocationRelativeTo(null);

	}

	public void actionPerformed(ActionEvent e){
		 if(e.getSource()==loginBtn)
		{
                String userName = adminUserNameTxt.getText().toLowerCase(); // User Name 
                String userPass = adminUserPassTxt.getText(); // Password

                if (userName.isEmpty() || userPass.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    matchAdmin(userName, userPass);
                    if (s == 1) {
                    	adminLogin.setVisible(false);
                    }

                }
        }
        else if(e.getSource()==userloginbtn){
        	new Login("userName", "userPass");
        	adminLogin.setVisible(false);
        }
       
	}

}

