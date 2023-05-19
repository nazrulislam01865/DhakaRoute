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

public class AdminDashboard1 implements ActionListener{

	JFrame adminDashboard1;
	private JButton logout,back,deleteuser;
	private JLabel admin1Img;
	private JPanel panel1;
    private JScrollPane scroll;
    private JTable table;
    private DefaultTableModel model;

    private String[] column = { "First Name", "Last Name", "Email", "Username", "Password" };
    private String[] rows = new String[7];

	public AdminDashboard1(){
		adminDashboard1 = new JFrame();

        //logout Button
        logout = new JButton(new ImageIcon("AllPicture/logout.png"));
        logout.setBounds(900, 10, 28, 28);
        logout.setFont(new Font("Segoe UI", Font.BOLD, 25));
        logout.setForeground(new Color(34,158,196));
        logout.setFocusPainted(false);
        logout.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logout.setContentAreaFilled(false);
        adminDashboard1.add(logout);


        //back Button
        back = new JButton("<-");
        back.setBounds(4, 10, 90, 18);
        back.setFont(new Font("Segoe UI", Font.BOLD, 18));
        back.setForeground(new Color(34,158,196));
        back.setFocusPainted(false);
        back.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.setContentAreaFilled(false);
        adminDashboard1.add(back);


        deleteuser = new JButton("Delete User");
        deleteuser.setBounds(750,440,180,30);
        deleteuser.setBackground(new Color(34,158,196));
        deleteuser.setForeground(Color.white);
        deleteuser.setCursor(new Cursor(Cursor.HAND_CURSOR));
        deleteuser.setFocusable(false);
        adminDashboard1.add(deleteuser);

        // table
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
        scroll.setBounds(400, 50, 530, 380);
        scroll.setBackground(Color.cyan);
        adminDashboard1.add(scroll);


        // data read and input
        String file = ".\\Data\\user_data.txt";
        String temp = ".\\Data\\temp.txt";

        // To input data in the table
        try {

            BufferedReader reader = new BufferedReader(new FileReader(file));
            int totalLines = 0;
            while (reader.readLine() != null)
                totalLines++;
            reader.close();

            for (int i = 0; i < totalLines; i++) {
                String line = Files.readAllLines(Paths.get(file)).get(i);
                String x = line.substring(0,5);
                if (x.equals("First")) {
                    rows[0] = Files.readAllLines(Paths.get(file)).get(i).substring(13); // First Name
                    rows[1] = Files.readAllLines(Paths.get(file)).get((i + 1)).substring(13); // Last Name
                    rows[2] = Files.readAllLines(Paths.get(file)).get((i + 2)).substring(13); // Email
                    rows[3] = Files.readAllLines(Paths.get(file)).get((i + 3)).substring(13); // Username
                    rows[4] = Files.readAllLines(Paths.get(file)).get((i + 4)).substring(13); // Password
                    model.addRow(rows);
                }
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }


        //Icon Change
        Image icon = Toolkit.getDefaultToolkit().getImage("AllPicture/title.png");
        adminDashboard1.setIconImage(icon);

        // background img
		admin1Img = new JLabel();
		admin1Img.setIcon(new ImageIcon("AllPicture/admin1.jpg"));
		admin1Img.setBounds(0,-20,930,530);
		adminDashboard1.add(admin1Img);



        //btn listener
        logout.addActionListener(this);
        back.addActionListener(this);
        deleteuser.addActionListener(this);
		
        //frame init
		adminDashboard1.setTitle("Dhaka Route");
		adminDashboard1.setSize(950,530);
		adminDashboard1.setBackground(new Color(152,235,152));
		adminDashboard1.setLayout(null);
		adminDashboard1.setResizable(false);
		adminDashboard1.setLocationRelativeTo(null);
		adminDashboard1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminDashboard1.setVisible(true);
		
	}


    //Action Listener
    public void actionPerformed(ActionEvent e){
         if(e.getSource()==logout)
        {
            new Login("userName", "userPass");
            adminDashboard1.setVisible(false);
        }
        else if(e.getSource()==back)
        {
            new AdminDashboard();
            adminDashboard1.setVisible(false);
        }
        else if(e.getSource()==deleteuser)
        {
                String file = ".\\Data\\user_data.txt";
                String temp = ".\\Data\\temp.txt";

                if (table.getSelectionModel().isSelectionEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please select a user to delete", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                } else {

                    String removeUser = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();

                    File oldFile = new File(file);
                    File newFile = new File(temp);

                    int q = 0;

                    try {

                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        int totalLines = 0;
                        while (reader.readLine() != null)
                            totalLines++;
                        reader.close();

                        for (int i = 0; i < totalLines; i++) {
                            String line = Files.readAllLines(Paths.get(file)).get(i);
                            String x = line.substring(0, 10);
                            if (x.equals("First Name")) {
                                String userName = Files.readAllLines(Paths.get(file)).get(i);
                                if (userName.substring(13).equals(removeUser)) {
                                    q = i;
                                }
                            }
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "User Can't be deleted", "Warning!", JOptionPane.WARNING_MESSAGE);
                    }

                    try {

                        FileWriter fw = new FileWriter(temp, true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter pw = new PrintWriter(bw);

                        FileReader fr = new FileReader(file);
                        BufferedReader br = new BufferedReader(fr);

                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        int totalLines = 0;
                        while (reader.readLine() != null)
                            totalLines++;
                        reader.close();

                        for (int j = 0; j < totalLines; j++) {
                            String line = Files.readAllLines(Paths.get(file)).get(j);
                            String x = line.substring(0, 10);

                            if (q != 0 && (j == q || j == (q + 1) || j == (q + 2) || j == (q + 3) || j == (q + 4)
                                    )) {
                                String userName = Files.readAllLines(Paths.get(file)).get(j);
                                pw.println("#Removed! " + userName);
                            } else {
                                String userName = Files.readAllLines(Paths.get(file)).get(j);
                                pw.println(userName);
                            }
                        }
                        pw.flush();
                        pw.close();
                        fr.close();
                        br.close();
                        bw.close();
                        fw.close();

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "User Can't be deleted", "Warning!", JOptionPane.WARNING_MESSAGE);
                    }

                    oldFile.delete();
                    File dump = new File(file);
                    newFile.renameTo(dump);

                    new AdminDashboard1();
                    adminDashboard1.setVisible(false);
                }
        }
    }
	
}