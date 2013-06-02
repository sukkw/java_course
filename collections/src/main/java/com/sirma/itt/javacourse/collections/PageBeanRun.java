package com.sirma.itt.javacourse.collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * PageBean run class. Get text from file and put lines in array list. 
 * Allow user to chose different actions for text visualization in pages.
 * 
 * @version 1.1 09 May 2013
 * @author Stella Djulgerova
 */
public class PageBeanRun {

	public static void main(String[] args) {

		// read from text file and put lines into list
		String fileName = "info.txt";
		Path path = Paths.get(fileName);
		List<String> lines = new ArrayList<String>();
		String line = null;
		String repeat;
		Scanner input = new Scanner(System.in);
		
		try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		PageBean pages = new PageBean(10, lines);
		print(pages.firstPage());
		
		do {
			System.out.println(" 1-First / 2-Next / 3-Previous / 4-Last / 5-Exit");
			repeat = input.next();
			
			switch (repeat) {

				case "1":
					print(pages.firstPage());
					break;
				case "2":
					print(pages.next());
					break;
				case "3":
					print(pages.previous());
					break;
				case "4":
					print(pages.lastPage());
					break;
				default:
					break;
			}

		} while (!"5".equals(repeat));
	}
	
	/**
	 * Print page on the screen.
	 * @param string - List with strings to be print
	 */
	public static void print(List<String> string) {
		if(string != null) {
			for(int i=0; i<string.size(); i++) {
				System.out.println(string.get(i));
			}
		}
	}
}
