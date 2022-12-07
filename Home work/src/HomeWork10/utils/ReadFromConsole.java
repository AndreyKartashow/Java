package HomeWork10.utils;

import java.util.Scanner;

public class ReadFromConsole {
	public String getMessage(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Insert: ");
		return scanner.nextLine();
	}
}
