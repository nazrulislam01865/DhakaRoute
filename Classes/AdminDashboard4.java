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

public class AdminDashboard4 implements ActionListener{
    JFrame adminDash4;
	private ImageIcon icon = new ImageIcon("ALLPicture/ok1.png");
    private JLabel rent,busName,routeToTravel,searchBus,adminDashImg,welcmlvl,searchBus1;
    private JButton updatebtn,searchbtn,addbtn,deletebtn,back,logout;
    private JTextField busNameTxt,searchTxt,rentTxt;
	private JTextArea routeTxt;
	private JScrollPane scrollableTextArea;
	private Rent rents;
	private String up;
	int s2;

    public AdminDashboard4(Rent rents){
		this.rents = rents;
        adminDash4 = new JFrame();


		//Label
        welcmlvl = new JLabel("Update Info");
		welcmlvl.setBounds(500,5,300,40);
		welcmlvl.setForeground(new Color(0,0,0));
		welcmlvl.setFont(new Font("Segoe UI", Font.BOLD, 20));
		adminDash4.add(welcmlvl);

		//Rent Ratio
		rent = new JLabel("Rent Rate : ");
		rent.setBounds(400, 65, 90, 15);
		rent.setFont(new Font("Segoe UI", Font.BOLD, 15));
		rent.setForeground(new Color(0,0,0));
		adminDash4.add(rent);

		rentTxt = new JTextField();
		rentTxt.setBounds(490, 65, 100, 15);
		rentTxt.setBorder(BorderFactory.createMatteBorder(0,0,2,0,new Color(0,0,0)));
		rentTxt.setBackground(new Color(238,241,246));
		adminDash4.add(rentTxt);

		// rent show
		String file = ".\\Data\\Rent.txt";
		String temp = ".\\Data\\temp.txt";
		try {

			BufferedReader reader = new BufferedReader(new FileReader(file));
			int totalLines = 0;
			while (reader.readLine() != null)
				totalLines++;
			reader.close();

			for (int i = 0; i <= totalLines; i++) {
				String line = Files.readAllLines(Paths.get(file)).get(i);
				String x = line.substring(0,4);
				if (x.equals("Rent")) {
					String r = Files.readAllLines(Paths.get(file)).get(i).substring(7);
					rentTxt.setForeground(new Color(0,0,0));
					rentTxt.setText(r);
					s2=2;
				}
				if(s2==2){
					break;
				}
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

		//Rent Update Button
		updatebtn = new JButton("Update");
		updatebtn.setBounds(610, 65, 100, 25);
		updatebtn.setBackground(new Color(34,158,196));
		updatebtn.setForeground(Color.white);
		updatebtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		updatebtn.setFocusable(false);
		adminDash4.add(updatebtn);

		//Bus Name
		busName = new JLabel("Bus Name : ");
		busName.setBounds(400, 105, 125, 20);
		busName.setFont(new Font("Segoe UI", Font.BOLD, 20));
		busName.setForeground(new Color(0,0,0));
		adminDash4.add(busName);

		busNameTxt = new JTextField();
		busNameTxt.setBounds(520, 105, 200, 20);
		busNameTxt.setBorder(BorderFactory.createMatteBorder(0,0,2,0,new Color(0,0,0)));
		busNameTxt.setBackground(new Color(238,241,246));
		busNameTxt.setForeground(Color.BLACK);
		adminDash4.add(busNameTxt);

		//Route
		routeToTravel = new JLabel("Route : ");
		routeToTravel.setBounds(400, 145, 90, 20);
		routeToTravel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		routeToTravel.setForeground(new Color(0,0,0));
		adminDash4.add(routeToTravel);

		//Scroll
		adminDash4.getContentPane().setLayout(new FlowLayout());
		routeTxt = new JTextArea(20,20);
		routeTxt.setBorder(BorderFactory.createMatteBorder(0,0,2,0,new Color(0,0,0)));
		routeTxt.setBackground(new Color(238,241,246));
		routeTxt.setForeground(Color.BLACK);
		JScrollPane scrollableTextArea = new JScrollPane(routeTxt);
		scrollableTextArea.setBounds(475, 145,320,160);
		scrollableTextArea.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		scrollableTextArea.setBackground(Color.decode("#ecf0f1"));
		scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		adminDash4.getContentPane().add(scrollableTextArea);

		//Add Button
		addbtn = new JButton("Add Bus");
		addbtn.setBounds(480, 325, 130, 25);
		addbtn.setBackground(new Color(34,158,196));
		addbtn.setForeground(Color.white);
		addbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		addbtn.setFocusable(false);
		adminDash4.add(addbtn);

		//Delete Button
		deletebtn = new JButton("Delete");
		deletebtn.setBounds(630, 325, 130, 25);
		deletebtn.setBackground(new Color(34,158,196));
		deletebtn.setForeground(Color.white);
		deletebtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		deletebtn.setFocusable(false);
		adminDash4.add(deletebtn);

		//Search Button
		searchBus = new JLabel("Bus Name : ");
		searchBus.setBounds(400, 380, 140, 20);
		searchBus.setFont(new Font("Segoe UI", Font.BOLD, 20));
		searchBus.setForeground(new Color(0,0,0));
		adminDash4.add(searchBus);

		//Search Text
		searchTxt = new JTextField();
		searchTxt.setBounds(520, 380, 180, 20);
		searchTxt.setBorder(BorderFactory.createMatteBorder(0,0,2,0,new Color(0,0,0)));
		searchTxt.setBackground(new Color(238,241,246));
		searchTxt.setForeground(Color.BLACK);
		adminDash4.add(searchTxt);

		//Search Btn
		searchbtn = new JButton("Search");
		searchbtn.setBounds(530, 420, 130, 25);
		searchbtn.setBackground(new Color(34,158,196));
		searchbtn.setForeground(Color.white);
		searchbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		searchbtn.setFocusable(false);
		adminDash4.add(searchbtn);

		//back Button
        back = new JButton("<-");
        back.setBounds(3, 10, 90, 20);
        back.setFont(new Font("Segoe UI", Font.BOLD, 20));
        back.setForeground(new Color(0,0,0));
        back.setFocusPainted(false);
        back.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.setContentAreaFilled(false);
        adminDash4.add(back);

        //logout Button
        logout = new JButton(new ImageIcon("AllPicture/logout.png"));
        logout.setBounds(760, 10, 28, 28);
        logout.setFont(new Font("Segoe UI", Font.BOLD, 16));
        logout.setForeground(new Color(255,255,255));
        logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logout.setFocusPainted(false);
        logout.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logout.setContentAreaFilled(false);
        adminDash4.add(logout);

		//Icon Set
		Image icon = Toolkit.getDefaultToolkit().getImage("AllPicture/title.png");
		adminDash4.setIconImage(icon);

		//BackGround
		adminDashImg = new JLabel();
		adminDashImg.setIcon(new ImageIcon("AllPicture/admin4.jpg"));
		adminDashImg.setBounds(0,0,815,530);
		adminDash4.add(adminDashImg);
		
		//Button Listener
		searchbtn.addActionListener(this);
		addbtn.addActionListener(this);
		updatebtn.addActionListener(this);
		deletebtn.addActionListener(this);
		back.addActionListener(this);
		logout.addActionListener(this);

		//Frame
		adminDash4.setLayout(null);
		adminDash4.setTitle("Dhaka Route");
		adminDash4.setSize(815,530);
		adminDash4.setResizable(false);
		adminDash4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminDash4.setLocationRelativeTo(null);
		adminDash4.setVisible(true);
    }

	//Rent Update Method
	public void rentUpdate(String rentupdate){
		String file = ".\\Data\\Rent.txt";
		String temp = ".\\Data\\temp.txt";
		try {

			BufferedReader reader = new BufferedReader(new FileReader(file));
			int totalLines = 0;
			while (reader.readLine() != null)
				totalLines++;
			reader.close();

			for (int i = 0; i < totalLines; i++) {
				String line = Files.readAllLines(Paths.get(file)).get(i);
				String x = line.substring(0,4);
				if (x.equals("Rent")) {
					String r = Files.readAllLines(Paths.get(file)).get(i).substring(7);
					up = r;
					s2=1;
				}
				if(s2==1){
					break;
				}
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
		rents.updateRents(up,rentupdate);
		up = rentupdate;
		rentTxt.setText(up);
		rentTxt.setEditable(false);

	}

	//Search Bus Method
	public void searchBus(String s){
		String file = ".\\Data\\Buses2.txt";
		String temp = ".\\Data\\temp.txt";
		int st = s.length();
		// To input data in the table
		try {

			BufferedReader reader = new BufferedReader(new FileReader(file));
			int totalLines = 0;
			while (reader.readLine() != null)
				totalLines++;
			reader.close();

			for (int i = 0; i < totalLines; i++) {
				String line = Files.readAllLines(Paths.get(file)).get(i);
				if (line.contains(s)) {
					busNameTxt.setText(line.substring(0,st));
					routeTxt.setText(line.substring(29));
				}

			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	//Add Bus Method
	public void addBus(String name, String routes){
		String space="";
		if(name.length()<=25){
			for (int i = 0;i<=(26-(name.length()));i++){
				space +=" ";
			}
		}
		try {
			File file = new File(".\\Data\\Buses2.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);

			pw.println(name+space+"- "+routes);
			pw.close();

			JOptionPane.showMessageDialog(null, "Bus Successfully Added.",
					"Bus Added", JOptionPane.INFORMATION_MESSAGE, icon);
		}
		catch (Exception ex){
			JOptionPane.showMessageDialog(null, "Error! Faild to add.", "Warning!",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	//Delete Bus Method
	public void deleteBus(String bName){
		String filePath = ".\\Data\\Buses2.txt";
		File inputFile = new File(filePath);
		File tempFile = new File(".\\Data\\Temp.txt");
		int bNameL = bName.length();

		int q = 0;

		try {

			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			int totalLines = 0;
			while (reader.readLine() != null)
				totalLines++;
			reader.close();
			for (int i = 0; i < totalLines; i++) {
				String line = Files.readAllLines(Paths.get(filePath)).get(i);
				String x = line.substring(0, (bNameL));
				if (x.equals(bName)) {
					q=i;
				}
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "BUS Can't be deleted", "Warning!", JOptionPane.WARNING_MESSAGE);
		}

		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			 BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

			String currentLine;
			int lineNumber = 0;
			while ((currentLine = reader.readLine()) != null) {

				if (lineNumber != q) {
					writer.write(currentLine);
					writer.newLine();
				}
				lineNumber++;
			}
		} catch (IOException e) {
			System.out.println(e);
		}

		// Delete the original file
		if (inputFile.delete()) {
			// Rename the new file to the original file's name
			if (!tempFile.renameTo(inputFile)) {
				JOptionPane.showMessageDialog(null, "File Write Error Please Try again later!", "Warning!", JOptionPane.WARNING_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "File Delete Error Please Try again later!", "Warning!", JOptionPane.WARNING_MESSAGE);
		}
	}

	//Action Event
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == searchbtn) {
			String sc = searchTxt.getText().toString();
			if(sc.isEmpty()){
				JOptionPane.showMessageDialog(null, "Bus Name and Route is Empty", "Warning!", JOptionPane.WARNING_MESSAGE);
			}
			else {
				searchBus(sc);
			}
		}
		//addbtn
		else if(e.getSource() == addbtn){
			String busName = busNameTxt.getText().toString();
			String busRoute = routeTxt.getText().toString();
			if(busName.isEmpty() || busRoute.isEmpty()){
				JOptionPane.showMessageDialog(null, "Please fill Bus Name & Route Both fields.", "Warning!",
						JOptionPane.WARNING_MESSAGE);
			}
			else{
				addBus(busName,busRoute);
				Rent r = new Rent();
				new AdminDashboard4(r);
				adminDash4.setVisible(false);
			}
		}//update btn
		else if(e.getSource()==updatebtn){

				String newRent = rentTxt.getText().toString();
				rentUpdate(newRent);
		}
		//delete btn
		else if(e.getSource()==deletebtn){
			String bName = busNameTxt.getText().toString();
			if(bName.isEmpty()){
				JOptionPane.showMessageDialog(null, "Please fill Bus Name.", "Warning!",
						JOptionPane.WARNING_MESSAGE);
			}
			else{
				deleteBus(bName);
				Rent r = new Rent();
				new AdminDashboard4(r);
				adminDash4.setVisible(false);

			}


		}//back
		else if(e.getSource() == back){
			new AdminDashboard();
			adminDash4.setVisible(false);
		}//logout
		else if(e.getSource()==logout){
			new Login("userName","userPass");
			adminDash4.setVisible(false);
		}
	}

} 