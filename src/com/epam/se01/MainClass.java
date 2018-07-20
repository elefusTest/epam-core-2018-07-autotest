package com.epam.se01;

public class MainClass {

	/**
	 *
	 */
	public static void main(String[] args) {     
		/*
		Thread.sleep(10_000);
		*/
		AboutJava object = new AboutJava();        
		object.printReleaseData();    
		
		for (int i = 0; i < args.length; ++i) {
			System.out.println(args[i]);
		}
	}
}

