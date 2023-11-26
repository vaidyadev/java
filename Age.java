import java.util.*;
import javax.swing.*;
public class Age
{
	public static void main(String[] args)
	{
		GregorianCalendar now = new GregorianCalendar();
		int nowYear; // Current Year "nowYear"
		int birthYear; //User inputs their birthYear
		int yearsOld; // Stores age as yearsOld
		birthYear = Integer.parseInt(JOptionPane.showInputDialog(null, 
		"In what year were you born?")); //Ask the user to input their birthYear
		nowYear=now.get(GregorianCalendar.YEAR);//Finds birthYear in the GregorianCalendar
		yearsOld= nowYear - birthYear;//Does the math to find your age
		JOptionPane.showMessageDialog(null, 
		"This is the year you become " + yearsOld + " years old");//Outputs to the user how old they are
	}
}
