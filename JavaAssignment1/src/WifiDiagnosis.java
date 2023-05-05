/*
 * Class: CMSC203 
 * Instructor:
 * Description: (Give a brief description for each Class)
 * Due: 02/13/2022
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Nathan Loney
*/
import java.util.Scanner;
public class WifiDiagnosis {
	
	public static void main(String[] args) {
	System.out.println("If you have a problem with internet connectivity this WiFi Diagnosis might work. ");
	String response;
	Scanner blah = new Scanner(System.in);
	System.out.println("Reboot the computer and try to connect");
	System.out.println("Did that fix the problem?");
	response = blah.nextLine();
	if(response.equals("Yes") || response.equals("yes")) {
		System.out.println("Done");
		System.out.println("Programmer: Nathan Loney");
		response = blah.nextLine();
	}
	else if(response.equals("No") || response.equals("no")) {
		System.out.println("Reboot the router and try to connect");
		System.out.println("Did that fix the probelm?");
		response = blah.nextLine();
		if(response.equals("Yes")|| response.equals("yes")) {
			System.out.println("Done");
			System.out.println("Programmer: Nathan Loney");
		}
		else if(response.equals("No")|| response.equals("no")) {
			System.out.println("Make sure the cables connecting the router are firmly plugged in and power is getting to the router");
			System.out.println("Did that fix the problem?");
			response = blah.nextLine();
			if(response.equals("Yes")|| response.equals("yes")) {
				System.out.println("Done");
				System.out.println("Programmer: Nathan Loney");
			}
			else if(response.equals("No")|| response.equals("no")) {
				System.out.println("Move the computer closer to the router and try to connect");
				System.out.println("Did that fix the problem?");
				response = blah.nextLine();
				if(response.equals("Yes")|| response.equals("yes")) {
					System.out.println("Done");
					System.out.println("Programmer: Nathan Loney");
				}
				else if(response.equals("No")|| response.equals("no")) {
					System.out.println("Contact your ISP");
					System.out.println("Done");
					System.out.println("Programmer: Nathan Loney");
					
				}
				else {
					System.out.println("Invalid answer; try again");
					System.out.println("Programmer: Nathan Loney");
				}
			}
			else {
				System.out.println("Invalid answer; try again");
				System.out.println("Programmer: Nathan Loney");
			}
		}
		else {
			System.out.println("Invalid answer; try again");
			System.out.println("Programmer: Nathan Loney");
		}
	}
	else {
		System.out.println("Invalid answer; try again");
		System.out.println("Programmer: Nathan Loney");
	}
}
}
