package Classes;
import Interfaces.*;
import javax.swing.*;  
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.file.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class AdminDashboard3M implements IAdminDashboard3Operation{
	String firstName;
	String lastName;
	String email1;
	String username;
	String upassword;
	ImageIcon icon = new ImageIcon("ALLPicture/ok1.png");
	int s=0;

	AdminDashboard3M(String firstName, String lastName, String email1, String username, String upassword) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email1 = email1;
    this.username = username;
    this.upassword = upassword;
    }

    public void AdminDashboard3(String firstName, String lastName, String email1, String username, String upassword){
    	try {
            File file = new File(".\\Data\\user_data.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println("First Name : " + firstName);
            pw.println("Last Name  : " + lastName);
            pw.println("Email      : " + email1);
            pw.println("Username   : " + username);
            pw.println("Password   : " + upassword);
            pw.println("===============================================");
            pw.close();

            JOptionPane.showMessageDialog(null, "Registration Successfully Completed.",
	        "Registration Complete", JOptionPane.INFORMATION_MESSAGE,icon);
	        new AdminDashboard();
	        s=1;
        }
        catch (Exception ex) {
            System.out.print(ex);
        }

        
    }
}