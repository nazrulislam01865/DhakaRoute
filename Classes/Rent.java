package Classes;

import javax.swing.*;  
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.file.*;
import java.awt.event.*;
public class Rent{
	String strtco,endco;
	double x1,y1,z1;
	double rentRatio,totalRent;
    ImageIcon icon = new ImageIcon("ALLPicture/ok1.png");
    int s1=0;
	
	public void Rent(){};

    //Rent Ratio
	public void RentRatio(){
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
                    double d=Double.parseDouble(r);
                    rentRatio= d;
                    s1=1;
                    
                }
               if(s1==1){
                    break;
               }
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
	}
    //DIstance Calculation
	public void PlaceDis(String strtco, String endco){
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
                String x = line;
                if (x.contains(strtco)) {
                    String txt1 = Files.readAllLines(Paths.get(file)).get(i+2);
                    double dis1 = Double.parseDouble(txt1);
                    x1= dis1;
                    break;
                    
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
//            JOptionPane.showMessageDialog(null, "Location not found!.", "Warning!",
//                    JOptionPane.WARNING_MESSAGE);
        }
        try {

            BufferedReader reader = new BufferedReader(new FileReader(file));
            int totalLines = 0;
            while (reader.readLine() != null)
                totalLines++;
            reader.close();

            for (int i = 0; i < totalLines; i++) {
                String line = Files.readAllLines(Paths.get(file)).get(i);
                String x = line;
                if (x.contains(endco)) {
                    String txt = Files.readAllLines(Paths.get(file)).get(i+2);
                    double dis2 = Double.parseDouble(txt);
                    y1= dis2;
                    break;
                    
                }
            }


        } catch (Exception ex) {
            System.out.println(ex);
        }


	}
	public double RentCal(){
		return (y1-x1)*rentRatio;

	}
    public double returnAll(){
        return totalRent;
    }
	public void showInfo(){
		System.out.println(x1);
		System.out.println(y1);
		System.out.println(rentRatio);
		System.out.println(totalRent);
	}
    public void updateRents(String rat, String newRat){

        String filePath = ".\\Data\\Rent.txt";

        try {
            // Read the file
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
            reader.close();

            // Replace the word
            String modifiedContent = content.toString().replace(rat, newRat);

            // Write the modified content back to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(modifiedContent);
            writer.close();

            JOptionPane.showMessageDialog(null, "Rent Ratio Updatetd.", "Local Bus Route",
                    JOptionPane.INFORMATION_MESSAGE,icon);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Cannot update Rent Ratio.", "Warning!",
                    JOptionPane.WARNING_MESSAGE);
        }

    }
	// public static void main(String[] args) {
	// 	Rent r = new Rent();
	// 	r.RentRatio();
	// 	r.PlaceDis();
	// 	r.RentCal();
	// }
}