package com.sendemail;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;

public class ReadFile {

	public String staticsOfFile() throws IOException {
		
		ClassLoader	loader=Thread.currentThread().getContextClassLoader();
		
		InputStream stream=loader.getResourceAsStream("config.properties");
		
		Properties prop=new Properties();
		
		prop.load(stream);
		
		String path=prop.getProperty("path");

		try {
			BufferedReader br = new BufferedReader(new FileReader(path));

			String line = null;

			String output = "";

			int wordcount = 0;
			int linecount = 0;
			int charcount = 0;

			while ((line = br.readLine()) != null) {

				linecount++;

				String[] words = line.split(",");

				wordcount = wordcount + words.length;

				for (String word : words) {

					charcount = charcount + word.length();
				}

				System.out.println(line);
				System.out.println(path);

			}

			br.close();

			output = output + "Given Task to Sabari was completed";
			output = output + "\nThe results were below";
			output = output + "\n";
			output = output + "\nNumber of line in a given file: " + linecount;
			output = output + "\nNumber of word in a given file: " + wordcount;
			output = output + "\nNumber of char in a given file: " + charcount;

			return output;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
