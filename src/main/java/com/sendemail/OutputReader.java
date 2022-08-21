package com.sendemail;

import java.io.*;
//import java.io.IOException;
//import java.lang.*;

public class OutputReader {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File file=new File("C:\\Users\\sarat\\Desktop\\file.txt");
		
		PrintStream string=new PrintStream(file);
		
		PrintStream old=System.out;
		
		System.setOut(string);
		
		System.out.println("Hi This is the first word");
		
		System.setOut(old);
		
		System.out.println("This is normal output");

	}

}
