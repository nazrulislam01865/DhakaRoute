package Classes;
import Interfaces.*;
import javax.swing.*;  
import javax.swing.border.Border;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;
import static javax.swing.JOptionPane.showMessageDialog;
public class LoginM implements ILoginOperation{
	ImageIcon icon = new ImageIcon("ALLPicture/ok1.png");
	String userName;
	String userPass;
	int s = 0;

	LoginM(String userName, String userPass) {
        this.userName = userName;
        this.userPass = userPass;

    }

    public void matchAdmin(String userName, String userPass){
    	try {

            String userNameS = "Username : " + userName;
            String passwordS = "Password : " + userPass;
            BufferedReader reader = new BufferedReader(new FileReader(".\\Data\\admin_data.txt"));
            int totalLines = 0;
            while (reader.readLine() != null)
                totalLines++;
            reader.close();

            for (int i = 0; i <= totalLines; i++) {
                String line = Files.readAllLines(Paths.get(".\\Data\\admin_data.txt")).get(i);
                if (line.equals(userNameS)) {
                    String line2 = Files.readAllLines(Paths.get(".\\Data\\admin_data.txt")).get((i + 1));
                    if (line2.equals(passwordS)) {
                        JOptionPane.showMessageDialog(null, "Login Successful.", "Dhaka Route",
                            JOptionPane.INFORMATION_MESSAGE,icon);  
                        new AdminDashboard();
                        s = 1;
                        break;
                    }
                }
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Invalid User Name or Password!", "Warning!",
                JOptionPane.WARNING_MESSAGE);
        }
    }


    //user
    public void matchUser(String userName, String userPass) {
    	try {
            String userNameS = "Username   : " + userName;
            String passwordS = "Password   : " + userPass;
            BufferedReader reader = new BufferedReader(new FileReader(".\\Data\\user_data.txt"));

            int totalLines = 0;
            while (reader.readLine() != null)
                totalLines++;
            reader.close();

            for (int i = 0; i <= totalLines; i++) {
                String line = Files.readAllLines(Paths.get(".\\Data\\user_data.txt")).get(i);
                if (line.equals(userNameS)) {
                    String line2 = Files.readAllLines(Paths.get(".\\Data\\user_data.txt")).get((i + 1));
                    if (line2.equals(passwordS)) {
                        JOptionPane.showMessageDialog(null, "Login Successful.", "Dhaka Route",
                            JOptionPane.INFORMATION_MESSAGE,icon);
                        Rent r = new Rent();
                        new DashBoard(r);
                        s=1;
                        break;
                    }
                }
            }
        } 
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Invalid User Name or Password!", "Warning!",
                JOptionPane.WARNING_MESSAGE);
        }

    }

}