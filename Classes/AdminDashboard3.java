package Classes;

import java.awt.*;  
import javax.swing.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.file.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import static javax.swing.JOptionPane.showMessageDialog;

public class AdminDashboard3 extends AdminDashboard3M implements ActionListener{
	JFrame adminDashboard3;
	JButton addUser,back,logout;
	ImageIcon icon = new ImageIcon("ALLPicture/ok1.png");
	JLabel addUsers,fname,lname,email,userName,userPass,cvrimg;
	JTextField fnameTxt,lnameTxt,emailTxt,userNameTxt,userPassword;

	public AdminDashboard3(String firstName, String lastName, String email1, String username, String upassword){
		super(firstName,lastName,email1,username,upassword);
		adminDashboard3 = new JFrame();

		//Label
		addUsers = new JLabel("ADD New User");
		addUsers.setBounds(500,40,185,40);
		addUsers.setForeground(new Color(253,186,87));
		addUsers.setFont(new Font("Segoe UI", Font.BOLD, 25));
		addUsers.setBorder(BorderFactory.createMatteBorder(0,0,1,0,new Color(253,186,87)));
		adminDashboard3.add(addUsers);

		//First Name
		fname = new JLabel("First Name");
		fname.setBounds(480,100,200,30);
		fname.setForeground(Color.black);
		fname.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		adminDashboard3.add(fname);

		fnameTxt = new JTextField();
		fnameTxt.setBounds(480,130,200,30);
		fnameTxt.setBackground(new Color(101,155,211));
		fnameTxt.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		fnameTxt.setBorder(BorderFactory.createMatteBorder(0,0,1,0,new Color(255,255,255)));
		adminDashboard3.add(fnameTxt);

		//last Name
		lname = new JLabel("Last Name");
		lname.setBounds(480,160,200,30);
		lname.setForeground(Color.black);
		lname.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		adminDashboard3.add(lname);

		lnameTxt = new JTextField();
		lnameTxt.setBounds(480,190,200,30);
		lnameTxt.setBackground(new Color(101,155,211));
		lnameTxt.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lnameTxt.setBorder(BorderFactory.createMatteBorder(0,0,1,0,new Color(255,255,255)));
		adminDashboard3.add(lnameTxt);


		//Username
		userName = new JLabel("Username");
		userName.setBounds(480,220,200,30);
		userName.setForeground(Color.black);
		userName.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		adminDashboard3.add(userName);

		userNameTxt = new JTextField();
		userNameTxt.setBounds(480,250,200,30);
		userNameTxt.setBackground(new Color(101,155,211));
		userNameTxt.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		userNameTxt.setBorder(BorderFactory.createMatteBorder(0,0,1,0,new Color(255,255,255)));
		adminDashboard3.add(userNameTxt);


		//Email
		email = new JLabel("Email");
		email.setBounds(480,280,200,30);
		email.setForeground(Color.black);
		email.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		adminDashboard3.add(email);

		emailTxt = new JTextField();
		emailTxt.setBounds(480,310,200,30);
		emailTxt.setBackground(new Color(101,155,211));
		emailTxt.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		emailTxt.setBorder(BorderFactory.createMatteBorder(0,0,1,0,new Color(255,255,255)));
		adminDashboard3.add(emailTxt);


		//Password
		userPass = new JLabel("Password");
		userPass.setBounds(480,340,200,30);
		userPass.setForeground(Color.black);
		userPass.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		userPassword = new JPasswordField();
		userPassword.setBounds(480,370,200,30);
		userPassword.setBackground(new Color(101,155,211));
		userPassword.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		userPassword.setBorder(BorderFactory.createMatteBorder(0,0,1,0,new Color(255,255,255)));
		adminDashboard3.add(userPassword);
		adminDashboard3.add(userPass);




		//button
		addUser = new JButton("ADD User");
        addUser.setBounds(490, 420, 180,25);
        addUser.setFont(new Font("Segoe UI", Font.BOLD, 16));
        addUser.setForeground(new Color(255,255,255));
        addUser.setBackground(new Color(202,71,47));
        addUser.setFocusPainted(false);
        addUser.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        addUser.setCursor(new Cursor(Cursor.HAND_CURSOR));
        adminDashboard3.add(addUser);

        //back Button
        back = new JButton("<-");
        back.setBounds(8, 10, 90, 20);
        back.setFont(new Font("Segoe UI", Font.BOLD, 20));
        back.setForeground(new Color(0,0,0));
        back.setFocusPainted(false);
        back.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.setContentAreaFilled(false);
        adminDashboard3.add(back);

        //logout Button
        logout = new JButton(new ImageIcon("AllPicture/logout.png"));
        logout.setBounds(760, 10, 28, 28);
        logout.setFont(new Font("Segoe UI", Font.BOLD, 16));
        logout.setForeground(new Color(255,255,255));
        logout.setFocusPainted(false);
        logout.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logout.setContentAreaFilled(false);
        adminDashboard3.add(logout);

		//Icon Change
		Image icon = Toolkit.getDefaultToolkit().getImage("AllPicture/title.png");
		adminDashboard3.setIconImage(icon);


		//cover image
		cvrimg = new JLabel();
		cvrimg.setIcon(new ImageIcon("AllPicture/admin3.jpg"));
		cvrimg.setBounds(0,-20,820,530);
		adminDashboard3.add(cvrimg);

		//button listener
		addUser.addActionListener(this);
		back.addActionListener(this);


		//frame init
		adminDashboard3.setResizable(false);
		adminDashboard3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminDashboard3.setLayout(null);
		adminDashboard3.setTitle("Dhaka Route");
		adminDashboard3.setSize(815,530);
		adminDashboard3.setVisible(true);
		adminDashboard3.setLocationRelativeTo(null);
	}



	public void actionPerformed(ActionEvent e){
		 if(e.getSource()==addUser){

				String firstName = fnameTxt.getText(); // First Name
				String lastName = lnameTxt.getText(); // Last Name
                String email1 = emailTxt.getText().toLowerCase(); // User Name
                String username = userNameTxt.getText(); // Email
                String upassword = userPassword.getText(); // Password

                if (username.isEmpty() || upassword.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    if (firstName.isEmpty() || lastName.isEmpty() || email1.isEmpty() || username.isEmpty() || upassword.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",JOptionPane.WARNING_MESSAGE);
                    }else {

                    	AdminDashboard3(firstName,lastName,email1,username,upassword);
                    	if (s == 1) {
                            adminDashboard3.setVisible(false);
                        }
                    }
                }
		 }else if(e.getSource()==back){
		 	new AdminDashboard();
		 	adminDashboard3.setVisible(false);
		 }
		 else if(e.getSource()==logout){
		 	new Login("userName", "userPass");
		 	adminDashboard3.setVisible(false);
		 }
		}
}