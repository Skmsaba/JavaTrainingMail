package com.sendemail;

//
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadRecipientFromFile {

	public String[] recipientIDs() throws IOException {
		Pattern required = Pattern.compile("[a-zA-Z0-9]" + "[a-zA-Z0-9_.]" + "*@[a-zA-Z0-9]" + "+([.][a-zA-Z]+)+");

		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\sarat\\\\Desktop\\file.txt"));

		String line = null;
		String mailID = null;
		List<String> list = new ArrayList<>();

		while ((line = br.readLine()) != null) {

			Matcher mat = required.matcher(line);

			while (mat.find()) {
				mailID = (mat.group());
				list.add(mailID);
			}
		}

		br.close();
		return list.toArray(new String[0]);
	}
}