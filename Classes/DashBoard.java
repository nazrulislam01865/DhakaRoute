package Classes;

import javax.swing.*;  
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.file.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.time.LocalDate;


import static javax.swing.JOptionPane.showMessageDialog;

public class DashBoard implements ActionListener{
	private JFrame dashBoard;
	private JTextArea textArea;  
    private JScrollPane scrollableTextArea;
	private JLabel showBusData,showBusData1,welcome,welcome2,welcome3,frmLvl,toLvl,dashImg,dateLvl,logo,rentlbl1,rentlbl;
	private JTextField datefield,rent,rent1;
	private JComboBox strtCombo,endCombo;
	private JButton showBuses,back,logout,resetBtn;

	private Rent rents;
	String txt = " ";
	int s =0;

	public DashBoard(Rent rents){
		this.rents = rents;
		dashBoard = new JFrame();
		
		//Logo
		logo = new JLabel();
		logo.setIcon(new ImageIcon("ALLPicture/logolast.png"));
		logo.setBounds(70,15,100,100);
		dashBoard.add(logo);
		
		//Label Text
		welcome = new JLabel("Find Buses");
		welcome.setBounds(145, 40, 350, 25);
		welcome.setFont(new Font("Segoe UI", Font.BOLD, 24));
		welcome.setForeground(Color.decode("#000000"));
		dashBoard.add(welcome);


		welcome3 = new JLabel("Where you want to go!");
		welcome3.setBounds(140, 65, 350, 20);
		welcome3.setFont(new Font("Segoe UI", Font.BOLD, 15));
		welcome3.setForeground(Color.decode("#000000"));
		dashBoard.add(welcome3);

		welcome2 = new JLabel("Find Local Buses for different Road in Dhaka City");
		welcome2.setBounds(70, 110, 350, 15);
		welcome2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		welcome2.setForeground(Color.decode("#000000"));
		dashBoard.add(welcome2);

		

		//Strt Label
		frmLvl = new JLabel("From");
		frmLvl.setBounds(90, 175, 350, 15);
		frmLvl.setFont(new Font("Segoe UI", Font.BOLD, 15));
		frmLvl.setForeground(Color.decode("#000000"));
		dashBoard.add(frmLvl);

		//Start Combo
		String[] from = {"From","Abdullahpur","Agargaon","Azimpur","Azampur","Airport","Asad Gate","Bangla Motor","Banani","Bijoy Sarani","Badda","Banasree","Bosila","Basabo","Bashundhara","Dhanmondi","ECB","Elephant Road","Farmgate","Gulistan","Gabtoli","Gulshan 1","Gulshan 2","House Building","Jasimuddin","Jamuna Future Park","Jatrabari","Kuril Bishwa Road","Kakoli","Kallyanpur","Kalshi","Kamlapur","Khilgaon","Kamarpara","Khilkhet","Labaid","Link Road","Motijheel","Mohakhali","Mirpur 1","Mirpur 2","Mirpur 10","Mirpur 11","Moghbazar","Malibag","Merul","Madhya Badda","Mohammadpur","Mirpur DOHS","Notun Bazar","Nadda","Nilkhet","New Market","Paltan","Press Club","Purobi","Pallabi","Panthapath","Rajlakshmi","Rampura","Rajarbagh","Rupnagar","Shahbag","Shainik Club","Shyamoli","Shishu Mela","Shantinagar","Shiddheswari","Science lab","Shahjadpur","Sayedabad","Shonir Akhra","Sadarghat","Uttara","Uttar Badda","More are comming"};
		strtCombo = new JComboBox(from);
		strtCombo.setBounds(90, 195, 230, 25);
		strtCombo.setForeground(Color.black);
		dashBoard.add(strtCombo);

		//To Label
		toLvl = new JLabel("Destination");
		toLvl.setBounds(90,225,230,15);
		toLvl.setFont(new Font("Segoe UI", Font.BOLD, 15));
		toLvl.setForeground(Color.decode("#000000"));
		dashBoard.add(toLvl);

		//To Combo
		String[] to = {"To", "Abdullahpur","Agargaon","Azimpur","Azampur","Airport","Asad Gate","Bangla Motor","Banani","Bijoy Sarani","Badda","Banasree","Bosila","Basabo","Bashundhara","Dhanmondi","ECB","Elephant Road","Farmgate","Gulistan","Gabtoli","Gulshan 1","Gulshan 2","House Building","Jasimuddin","Jamuna Future Park","Jatrabari","Kuril Bishwa Road","Kakoli","Kallyanpur","Kalshi","Kamlapur","Khilgaon","Kamarpara","Khilkhet","Labaid","Link Road","Motijheel","Mohakhali","Mirpur 1","Mirpur 2","Mirpur 10","Mirpur 11","Moghbazar","Malibag","Merul","Madhya Badda","Mohammadpur","Mirpur DOHS","Notun Bazar","Nadda","Nilkhet","New Market","Paltan","Press Club","Purobi","Pallabi","Panthapath","Rajlakshmi","Rampura","Rajarbagh","Rupnagar","Shahbag","Shainik Club","Shyamoli","Shishu Mela","Shantinagar","Shiddheswari","Science lab","Shahjadpur","Sayedabad","Shonir Akhra","Sadarghat","Uttara","Uttar Badda","More are comming"};
		endCombo = new JComboBox(to);
		endCombo.setBounds(90,250,230,25);
		endCombo.setForeground(Color.black);
		dashBoard.add(endCombo);

		// Date lable and field
		dateLvl = new JLabel("Date:");
		dateLvl.setBounds(90, 280, 230, 30);
		dateLvl.setForeground(Color.decode("#000000"));
		dashBoard.add(dateLvl);

		datefield = new JTextField();
		datefield.setBounds(90, 310, 230, 30);
		datefield.setEditable(false);
		dashBoard.add(datefield);
		LocalDate date = LocalDate.now();
		datefield.setText("" + date);

		//Show Button
		showBuses = new JButton(new ImageIcon("AllPicture/src.png"));
		showBuses.setBounds(90, 352, 100, 25);
		showBuses.setBackground(new Color(96,191,193));
		showBuses.setFocusable(false);
		showBuses.setCursor(new Cursor(Cursor.HAND_CURSOR));
		showBuses.setVisible(true);
		dashBoard.add(showBuses);

		//Reset Button
		resetBtn = new JButton("Reset");
		resetBtn.setBounds(220, 353, 100, 25);
		resetBtn.setBackground(new Color(96,191,193));
		resetBtn.setFocusable(false);
		resetBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		resetBtn.setVisible(true);
		dashBoard.add(resetBtn);


		//Show Bus Label
		showBusData = new JLabel("Show Available Local buses,");
		showBusData.setBounds(550, 50, 350, 20);
		showBusData.setFont(new Font("Segoe UI", Font.BOLD, 15));
		showBusData.setForeground(Color.decode("#000000"));
		dashBoard.add(showBusData);

		showBusData1 = new JLabel("To your Destination");
		showBusData1.setBounds(570, 80, 350, 20);
		showBusData1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		showBusData1.setForeground(Color.decode("#000000"));
		dashBoard.add(showBusData1);

		//back Button
        back = new JButton("<-");
        back.setBounds(-15, 5, 90, 20);
        back.setFont(new Font("Segoe UI", Font.BOLD, 25));
        back.setForeground(new Color(0,0,0));
        back.setFocusPainted(false);
        back.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.setContentAreaFilled(false);
       	dashBoard.add(back);

        //logout Button
        logout = new JButton(new ImageIcon("AllPicture/logout.png"));
        logout.setBounds(780, 10, 90, 25);
        logout.setFont(new Font("Segoe UI", Font.BOLD, 16));
        logout.setForeground(new Color(255,255,255));
        logout.setFocusPainted(false);
        logout.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logout.setContentAreaFilled(false);
        dashBoard.add(logout);


		//ScrollBar Text Area
		dashBoard.getContentPane().setLayout(new FlowLayout());  
        textArea = new JTextArea(20, 20); 
        textArea.setFont(new Font("Segoe UI", Font.BOLD, 15));
        textArea.setEditable(false);
		textArea.setBackground(Color.decode("#ecf0f1"));
        JScrollPane scrollableTextArea = new JScrollPane(textArea);  
        scrollableTextArea.setBounds(490,120,305,220);
  		scrollableTextArea.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		  scrollableTextArea.setBackground(Color.decode("#ecf0f1"));
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
        dashBoard.getContentPane().add(scrollableTextArea);


		//Rent Text
        rent = new JTextField();
		rent.setBounds(545, 350, 200, 30);
		rent.setEditable(false);
		rent.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		rent.setBorder(null);
		rent.setBackground(new Color(255,255,255));;
		dashBoard.add(rent);

		//Rent Label
		rentlbl = new JLabel("Rent :");
		rentlbl.setBounds(500, 350, 50, 30);
		rentlbl.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		rentlbl.setForeground(Color.decode("#000000"));
		dashBoard.add(rentlbl);

		//Rent Text2
		rent1 = new JTextField();
		rent1.setBounds(600, 410, 200, 30);
		rent1.setEditable(false);
		rent1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		rent1.setBorder(null);
		rent1.setBackground(new Color(255,255,255));;
		dashBoard.add(rent1);

		//Rent Label2
		rentlbl1 = new JLabel("Student Rent :");
		rentlbl1.setBounds(500, 410, 100, 30);
		rentlbl1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		rentlbl1.setForeground(Color.decode("#000000"));
		dashBoard.add(rentlbl1);


		//Icon Change
		Image icon = Toolkit.getDefaultToolkit().getImage("AllPicture/title.png");
		dashBoard.setIconImage(icon);

        //Button Action Listener
		logout.addActionListener(this);
		showBuses.addActionListener(this);
		back.addActionListener(this);
		resetBtn.addActionListener(this);

		//Frame Image
		dashImg = new JLabel();
		//dashImg.setIcon(new ImageIcon("ALLPicture/Dash Last.jpg"));
		dashImg.setIcon(new ImageIcon("ALLPicture/Dash Last.jpg"));
		dashImg.setBounds(0,-290,1902,1076);
		dashBoard.add(dashImg);


		// Frame
		dashBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dashBoard.setSize(865,540);
		dashBoard.setTitle("Dhaka Route");
		dashBoard.setLocationRelativeTo(null);
		dashBoard.setLayout(null);
		dashBoard.setResizable(false);
		dashBoard.getContentPane().setBackground(Color.decode("#ecf0f1"));
		dashBoard.setVisible(true);

	}



	public void actionPerformed(ActionEvent e) {
        if(e.getSource()==showBuses){

			if (strtCombo.getSelectedIndex()==endCombo.getSelectedIndex()) {
				JOptionPane.showMessageDialog(null,  "You have selected same Departure and Arrival", "WARNING",JOptionPane.WARNING_MESSAGE);
			}
			else if (strtCombo.getSelectedIndex()==0) {
				JOptionPane.showMessageDialog(null, " Please select departure", "WARNING!!",JOptionPane.WARNING_MESSAGE);
			}
			else if (endCombo.getSelectedIndex()==0) {
				JOptionPane.showMessageDialog(null, " Please select Arival", "WARNING!!",JOptionPane.WARNING_MESSAGE);
			}
			else {
				String file = ".\\Data\\Buses2.txt";
        		String temp = ".\\Data\\temp.txt";
        		String x2 = endCombo.getSelectedItem().toString();
				String x1 = strtCombo.getSelectedItem().toString();

		        // To input data in the table
		   		try {

		            BufferedReader reader = new BufferedReader(new FileReader(file));
		            int totalLines = 0;
		            while (reader.readLine() != null)
		                totalLines++;
		            reader.close();

					for (int i = 0; i < totalLines; i++) {
						String line = Files.readAllLines(Paths.get(file)).get(i);
						if (line.contains(x1) && line.contains(x2)) {
							 txt = Files.readAllLines(Paths.get(file)).get(i).substring(0,26)+"\n"+txt;
							textArea.setText(txt);
							s =1;
						}
					}
		        } 
		        catch (Exception ex) {
		            System.out.println(ex);
				}


				try{
					rents.RentRatio();
					rents.PlaceDis(x1,x2);
					//rents.RentCal();
					if(rents.RentCal()<=10){
						rent.setText("10 TK");
						rent1.setText("5 TK");
					}
					else{
						double ren = rents.RentCal();
						double sturent = ren/2;
						String str1 = Double.toString(sturent);
						String str = Double.toString(ren);
						rent.setText(str+" TK");
						rent1.setText(str1+" TK");
					}
				} catch (Exception exc){
					System.out.println(exc);
				}
				if(s==0){
					rent.setText("");
					rent1.setText("");
					JOptionPane.showMessageDialog(null, " No Bus Available", "WARNING!!",JOptionPane.WARNING_MESSAGE);
				}
			}
		}
		else if(e.getSource()==resetBtn){
			Rent r = new Rent();
			new DashBoard(r);
			dashBoard.setVisible(false);
		}
        else if(e.getSource()==back)
		{  
			new Login("userName", "userPass");
			dashBoard.setVisible(false);
			//System.exit(0);	
        } 
        else if(e.getSource()==logout)
		{  
			new Login("userName", "userPass");
			dashBoard.setVisible(false);
			//System.exit(0);	
        }
	}
}


