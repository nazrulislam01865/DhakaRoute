package Classes;

import javax.swing.*;  
import javax.swing.border.Border;
import java.awt.event.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.file.*;
import static javax.swing.JOptionPane.showMessageDialog;
public class AdminDashboard implements ActionListener{

	JFrame adminDashboard;
	private JLabel welcmlvl,adminPic;
	private JButton logoutbtn,updatelocRentbtn,userDatabtn,addorDeletebtn,searchuserbtn,userData,updatelocRent,addorDelete,searchuser;

	public AdminDashboard(){
		adminDashboard = new JFrame();

        // Welcome Text
		welcmlvl = new JLabel("Admin DashBoard");
		welcmlvl.setBounds(550,35,300,40);
		welcmlvl.setForeground(new Color(34,158,196));
		welcmlvl.setFont(new Font("Segoe UI", Font.BOLD, 20));
		adminDashboard.add(welcmlvl);

        //logout Button
		logoutbtn = new JButton(new ImageIcon("AllPicture/logout.png"));
       	logoutbtn.setBounds(760, 10, 28, 28);
        logoutbtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        logoutbtn.setForeground(new Color(119,85,163));
        logoutbtn.setFocusPainted(false);
        logoutbtn.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        logoutbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logoutbtn.setContentAreaFilled(false);
        adminDashboard.add(logoutbtn);

        //Show User Data Button
		userDatabtn = new JButton();
        userDatabtn.setIcon(new ImageIcon("AllPicture/userinfo.jpg"));
        userDatabtn.setBounds(460, 100, 150, 150);
        userDatabtn.setFocusPainted(false);
        userDatabtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        userDatabtn.setBackground(Color.white);
        userData = new JButton("User Information");
        userData.setBounds(440, 250, 180, 20);
        userData.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        userData.setForeground(new Color(34,158,196));
        userData.setFocusPainted(false);
        userData.setCursor(new Cursor(Cursor.HAND_CURSOR));
        userData.setContentAreaFilled(false);
        userData.setBorderPainted(false);
		adminDashboard.add(userDatabtn);
		adminDashboard.add(userData);

        // user search Button
		searchuserbtn = new JButton();
        searchuserbtn.setIcon(new ImageIcon("AllPicture/search.png"));
        searchuserbtn.setBounds(620, 100, 150, 150);
        searchuserbtn.setFocusPainted(false);
        searchuserbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        searchuserbtn.setBackground(Color.white);
        searchuser = new JButton("Search User");
        searchuser.setBounds(600, 250, 180, 20);
        searchuser.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        searchuser.setForeground(new Color(34,158,196));
        searchuser.setFocusPainted(false);
        searchuser.setCursor(new Cursor(Cursor.HAND_CURSOR));
        searchuser.setContentAreaFilled(false);
        searchuser.setBorderPainted(false);
		adminDashboard.add(searchuserbtn);
		adminDashboard.add(searchuser);

        //Add button
		addorDeletebtn = new JButton();
        addorDeletebtn.setIcon(new ImageIcon("AllPicture/add.png"));
        addorDeletebtn.setBounds(460, 280, 150, 150);
        addorDeletebtn.setFocusPainted(false);
        addorDeletebtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addorDeletebtn.setBackground(Color.white);
        addorDelete = new JButton("User ADD");
        addorDelete.setBounds(440, 440, 180, 20);
        addorDelete.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        addorDelete.setForeground(new Color(34,158,196));
        addorDelete.setFocusPainted(false);
        addorDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addorDelete.setContentAreaFilled(false);
        addorDelete.setBorderPainted(false);
		adminDashboard.add(addorDeletebtn);
		adminDashboard.add(addorDelete);

        //Icon Chnage
        Image icon = Toolkit.getDefaultToolkit().getImage("AllPicture/title.png");
        adminDashboard.setIconImage(icon);


        // Update Button
		updatelocRentbtn = new JButton();
        updatelocRentbtn.setIcon(new ImageIcon("AllPicture/loc.png"));
        updatelocRentbtn.setBounds(620, 280, 150, 150);
        updatelocRentbtn.setFocusPainted(false);
        updatelocRentbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        updatelocRentbtn.setBackground(Color.white);
        updatelocRent = new JButton("Information Update");
        updatelocRent.setBounds(600, 440, 180, 20);
        updatelocRent.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        updatelocRent.setForeground(new Color(34,158,196));
        updatelocRent.setFocusPainted(false);
        updatelocRent.setCursor(new Cursor(Cursor.HAND_CURSOR));
        updatelocRent.setContentAreaFilled(false);
        updatelocRent.setBorderPainted(false);
		adminDashboard.add(updatelocRentbtn);
		adminDashboard.add(updatelocRent);



        //BackGround Image
		adminPic = new JLabel();
		adminPic.setIcon(new ImageIcon("AllPicture/AdminDash1.png"));
		adminPic.setBounds(0,-20,825,530);
		adminDashboard.add(adminPic);


		//Frame
		adminDashboard.setLayout(null);
		adminDashboard.setTitle("Dhaka Route");
		adminDashboard.setSize(815,530);
		adminDashboard.setResizable(false);
		adminDashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminDashboard.setLocationRelativeTo(null);
		
	
        //Button Listener
		userDatabtn.addActionListener(this);
		logoutbtn.addActionListener(this);
		searchuserbtn.addActionListener(this);
		addorDeletebtn.addActionListener(this);
        updatelocRentbtn.addActionListener(this);
		adminDashboard.setVisible(true);
	}




    public void actionPerformed(ActionEvent e){
         if(e.getSource()==userDatabtn)
        {
            new AdminDashboard1();
            adminDashboard.setVisible(false);
        }else if(e.getSource()==searchuserbtn){
        	new AdminDashboard2();
        	adminDashboard.setVisible(false);
        }else if(e.getSource()==logoutbtn){
            new Login("userName", "userPass");
            adminDashboard.setVisible(false);
        }
        else if(e.getSource()==addorDeletebtn){
            new AdminDashboard3("dsff", "dfdf", "dfdfd", "dfdf", "fdfdf");
            adminDashboard.setVisible(false);
        }
         else if(e.getSource()==updatelocRentbtn){
             Rent r= new Rent();
             new AdminDashboard4(r);
             adminDashboard.setVisible(false);
         }
        
    }



}
