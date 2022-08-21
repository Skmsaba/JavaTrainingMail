package com.sendemail;

import java.io.*;
import java.util.*;

public class CountWordCSV {

	public static void main(String[] args) throws Exception {
		
		//Scanner sc=new Scanner(new File("C:\\Users\\sarat\\Desktop\\new.csv"));
				
		BufferedReader br =new BufferedReader(new FileReader("C:\\Users\\sarat\\Desktop\\new.csv"));
		
		String line=null;
		
		//String words = br.readLine();
		
		//sc.useDelimiter(",");
		
		int wordcount = 0;
		int linecount=0;
		int charcount=0;
		//String word;
		
		while((line=br.readLine())!=null) {	
			
			linecount++;
			
			String[] words=line.split(",");
			
			wordcount=wordcount+words.length;
			
			for(String word: words) {
				
				charcount=charcount+word.length();
				
			}
			
			System.out.println(line);
			//wordcount++;
		}
		
		System.out.println("Number of line in a given file:" + linecount);
		System.out.println("Number of word in a given file:" + wordcount);
		System.out.println("Number of char in a given file:" + charcount);
		
		
		
		
		br.close();

	}

}
