package Classes;

import javax.swing.*;  
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.file.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Font;

import static javax.swing.JOptionPane.showMessageDialog;

public class AdminDashboard2 implements ActionListener{
	JFrame adminDashboard2;
	private ImageIcon icon = new ImageIcon("ALLPicture/ok1.png");
	private JLabel usern,adminPic,uselopic,wel,wel2;
	private JTextField usernTxt;
	private JButton showUserDetails,back,logout,addUser;
	private JRadioButton jusername,jemail;
	private ButtonGroup bg1;
	private JScrollPane scroll;
    private JTable table;
    private DefaultTableModel model;

    private String[] column = { "First Name", "Last Name", "Email", "Username", "Password" };
    private String[] rows = new String[7];
	private int pc = 0;

	public AdminDashboard2(){

		adminDashboard2 = new JFrame();

		// Search Text
		wel = new JLabel("Search User using Email or username");
		wel.setBounds(68,150,250,20);
		wel.setForeground(new Color(255,255,255));
		wel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		adminDashboard2.add(wel);

		wel2 = new JLabel("User Details");
		wel2.setBounds(565,15,180,18);
		wel2.setForeground(new Color(255,255,255));
		wel2.setFont(new Font("Segoe UI", Font.BOLD, 18));
		adminDashboard2.add(wel2);

		//username label
		usern = new JLabel("Username or Email");
		usern.setBounds(90,230,180,20);
		usern.setForeground(new Color(255,255,255));
		usern.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		adminDashboard2.add(usern);

		//username txt box
		usernTxt = new JTextField();
		usernTxt.setBounds(90,260,180,20);
		usernTxt.setBorder(BorderFactory.createMatteBorder(0,0,2,0,new Color(59,44,118)));
		usernTxt.setBackground(new Color(103,82,162));
		usernTxt.setForeground(new Color(255,255,255));
		adminDashboard2.add(usernTxt);

		// Search btn
		showUserDetails = new JButton("Search User");
		showUserDetails.setBounds(85,310,180,30);
		showUserDetails.setBackground(new Color(34,158,196));
		showUserDetails.setForeground(Color.white);
		showUserDetails.setCursor(new Cursor(Cursor.HAND_CURSOR));
		showUserDetails.setFocusable(false);
		adminDashboard2.add(showUserDetails);

		//Add User Button
		addUser = new JButton("Add User");
		addUser.setBounds(85,350,180,30);
		addUser.setBackground(new Color(34,158,196));
		addUser.setForeground(Color.white);
		addUser.setCursor(new Cursor(Cursor.HAND_CURSOR));
		addUser.setFocusable(false);
		adminDashboard2.add(addUser);

		//back Button
        back = new JButton("<-");
        back.setBounds(3, 10, 90, 19);
        back.setFont(new Font("Segoe UI", Font.BOLD, 19));
        back.setForeground(new Color(0,0,0));
        back.setFocusPainted(false);
        back.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.setContentAreaFilled(false);
        adminDashboard2.add(back);

        //logout Button
        logout = new JButton(new ImageIcon("AllPicture/logout.png"));
        logout.setBounds(850, 10, 28, 28);
        logout.setFont(new Font("Segoe UI", Font.BOLD, 13));
        logout.setForeground(new Color(255,255,255));
        logout.setFocusPainted(false);
        logout.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logout.setContentAreaFilled(false);
        adminDashboard2.add(logout);

		//Icon Chnage
		Image icon = Toolkit.getDefaultToolkit().getImage("AllPicture/title.png");
		adminDashboard2.setIconImage(icon);


		//Radio  btn
		JRadioButton jusername=new JRadioButton("UserName");    
		JRadioButton jemail=new JRadioButton("Email");    
		jusername.setBounds(75,190,100,30);    
		jemail.setBounds(200,190,100,30);
		jusername.setContentAreaFilled(false); 
		jemail.setContentAreaFilled(false);  
		jusername.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		jemail.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));  
		jusername.setFocusPainted(false);
		jemail.setFocusPainted(false);
		ButtonGroup bg=new ButtonGroup();    
		bg.add(jusername);bg.add(jemail);    
		adminDashboard2.add(jusername);adminDashboard2.add(jemail); 




		//Table
		table = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(column);

        table.setModel(model);
        table.setSelectionBackground(Color.decode("#8AC5FF"));
        table.setBackground(Color.WHITE);
        table.setRowHeight(30);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(120);
        table.getColumnModel().getColumn(1).setPreferredWidth(120);
        table.getColumnModel().getColumn(2).setPreferredWidth(300);
        table.getColumnModel().getColumn(3).setPreferredWidth(220);
        table.getColumnModel().getColumn(4).setPreferredWidth(200);


        //Scroll
        scroll = new JScrollPane(table);
        scroll.setBounds(340, 40, 530, 440);
        scroll.setBackground(Color.cyan);
        adminDashboard2.add(scroll);

		//Button Group
		bg1 = new ButtonGroup();
		bg1.add(jusername);
		bg1.add(jemail);

		//logopic
		uselopic = new JLabel();
		uselopic.setIcon(new ImageIcon("AllPicture/usl.png"));
		uselopic.setBounds(150,80,50,50);
		adminDashboard2.add(uselopic);


		// background pic
		adminPic = new JLabel();
		adminPic.setIcon(new ImageIcon("AllPicture/admin2.png"));
		adminPic.setBounds(0,0,900,520);
		adminDashboard2.add(adminPic);


		//frame init
		adminDashboard2.setLayout(null);
		adminDashboard2.setTitle("Local Bus Route");
		adminDashboard2.setSize(900,530);
		//adminDashboard.setBackground(new Color(152,235,152));
		adminDashboard2.setResizable(false);
		adminDashboard2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminDashboard2.setLocationRelativeTo(null);
		
	
		// button listener
		jusername.addActionListener(this);
		jemail.addActionListener(this);
		logout.addActionListener(this);
		back.addActionListener(this);
		showUserDetails.addActionListener(this);
		addUser.addActionListener(this);

		adminDashboard2.setVisible(true);

		//Radio Button listener
		jusername.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jusername) {
					usern.setText("Username");
                    pc = 1;
                }
            }
        });

        jemail.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jemail) {
					usern.setText("Email");
                    pc = 2;
                }
            }
        });

	}


	// action listener
	public void actionPerformed(ActionEvent e){
		//Search button
		if(e.getSource()==showUserDetails){
			
        	String file = ".\\Data\\user_data.txt";
			String userName = usernTxt.getText().toLowerCase(); // User Name 
               
                if (userName.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {

                    if(pc==1){
                    	try {
	                        String userNameS = "Username   : " + userName;
	                        int check = 1;
	                        BufferedReader reader = new BufferedReader(new FileReader(".\\Data\\user_data.txt"));

	                        int totalLines = 0;
	                        while (reader.readLine() != null)
	                            totalLines++;
	                        reader.close();

	                        for (int i = 0; i <= totalLines; i++) {
	                            String line = Files.readAllLines(Paths.get(".\\Data\\user_data.txt")).get(i);
	                            if (line.equals(userNameS)) {
	                            	JOptionPane.showMessageDialog(null, "User Found.", "Local Bus Route",
	                                            JOptionPane.INFORMATION_MESSAGE,icon);
                                for (int j = (i-3); j <= totalLines; j++) {
					                
					                String line1 = Files.readAllLines(Paths.get(file)).get(j);
					                String x = line1.substring(0,10);
					                if (x.equals("First Name")) {
					                    rows[0] = Files.readAllLines(Paths.get(file)).get(j).substring(13); // First Name
					                    rows[1] = Files.readAllLines(Paths.get(file)).get((j + 1)).substring(13); // Last Name
					                    rows[2] = Files.readAllLines(Paths.get(file)).get((j + 2)).substring(13); // Email
					                    rows[3] = Files.readAllLines(Paths.get(file)).get((j + 3)).substring(13); // Username
					                    rows[4] = Files.readAllLines(Paths.get(file)).get((j + 4)).substring(13); // Password
					                    model.addRow(rows);
					                    break;
					                 
                					}
                					break;
            					}
            					break;
                            }

                        }
                    }
                    catch (Exception ex) {
                    	JOptionPane.showMessageDialog(null, "NO USER FOUND.", "Warning!", JOptionPane.WARNING_MESSAGE);
						System.out.println(ex);
                    }

                    }
                    else if(pc == 2){
                    	try {
                        String userNameS = "Email      : " + userName;
                        int check = 1;
                        BufferedReader reader = new BufferedReader(new FileReader(".\\Data\\user_data.txt"));

                        int totalLines = 0;
                        while (reader.readLine() != null)
                            totalLines++;
                        reader.close();

                        for (int i = 0; i <= totalLines; i++) {
                            String line = Files.readAllLines(Paths.get(".\\Data\\user_data.txt")).get(i);
                            if (line.equals(userNameS)) {
                            	JOptionPane.showMessageDialog(null, "User Found.", "Local Bus Route",
                                            JOptionPane.INFORMATION_MESSAGE,icon);
                                for (int j = (i-2); j <= totalLines; j++) {
					                
					                String line1 = Files.readAllLines(Paths.get(file)).get(j);
					                String x = line1.substring(0,10);
					                if (x.equals("First Name")) {
					                    rows[0] = Files.readAllLines(Paths.get(file)).get(j).substring(13); // First Name
					                    rows[1] = Files.readAllLines(Paths.get(file)).get((j + 1)).substring(13); // Last Name
					                    rows[2] = Files.readAllLines(Paths.get(file)).get((j + 2)).substring(13); // Email
					                    rows[3] = Files.readAllLines(Paths.get(file)).get((j + 3)).substring(13); // Username
					                    rows[4] = Files.readAllLines(Paths.get(file)).get((j + 4)).substring(13); // Password
					                    model.addRow(rows);
					                    break;
					                 
                					}
                					
            					}
            					break;
                            }

                        }
                    }
                    catch (Exception ex) {
                    	JOptionPane.showMessageDialog(null, "NO USER FOUND.", "Warning!", JOptionPane.WARNING_MESSAGE);
						System.out.println(ex);
                    }

                    }

                }
		
			
		}else if(e.getSource()==back){
		 	new AdminDashboard();
		 	adminDashboard2.setVisible(false);
		 }
		 else if(e.getSource()==logout){
		 	new Login("userName", "userPass");
		 	adminDashboard2.setVisible(false);
		 }
		 else if(e.getSource()==addUser){
		 	new AdminDashboard3("dsff", "dfdf", "dfdfd", "dfdf", "fdfdf");
		 	adminDashboard2.setVisible(false);
		 }
		
	}
}