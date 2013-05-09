package com.sirma.itt.javacourse.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Read text from console and write it in text file.
 * 
 * @version 1.1 01 May 2013
 * @author Stella Djulgerova
 */
public class ConsoleWriter {

	// class private members
	private final static Charset ENCODING = StandardCharsets.UTF_8;
	private Scanner input = new Scanner(System.in);

	/**
	 * Read lines of text from console and write it to file.
	 * 
	 */
	public void writeToFile() {

		System.out.println("Enter path and file name: ");
		String fileName = input.nextLine() + ".txt";

		if (!createFile(fileName)) {
			return;
		}

		List<String> lines = readText();
		try {
			writeText(lines, fileName);
			System.out.println("Data was added.");
		} catch (IOException e) {
			System.out.println("Can not write data! please try again.");
		}
	}

	/**
	 * Read text from console.
	 * 
	 * @return - list with entered lines
	 */
	private List<String> readText() {

		String textLine;
		List<String> lines = new ArrayList<String>();

		System.out.println("Enter lines of text.");
		System.out.println("Enter '.' to quit.");

		do {
			textLine = input.nextLine();
			lines.add(textLine);
		} while (!textLine.equals("."));

		lines.remove(lines.size() - 1);
		return lines;
	}

	/**
	 * Create file.
	 * 
	 * @param fileName - path and file name
	 */
	private boolean createFile(String fileName) {
		boolean isCreated = false;

		try {
			Path path = Paths.get(fileName);
			if (Files.exists(path)) {
				isCreated = true;
			} else {
				Files.createFile(path);
				isCreated = true;
			}
		} catch (IOException e) {
			System.out.println("Wrong path please try again.");
		} catch (InvalidPathException e) {
			System.out.println("Wrong path please try again.");
		}
		return isCreated;
	}

	/**
	 * Write text to file
	 * @param lines - lines to be written
	 * @param fileName - file name
	 * @throws IOException
	 */
	public void writeText(List<String> lines, String fileName) throws IOException {
		Path path = Paths.get(fileName);
		Files.write(path, lines, ENCODING);
	}

	/**
	 * Write text to file using buffer
	 * @param lines - lines to be written
	 * @param fileName - file name
	 * @throws IOException
	 */
	public void writeBufferedText(List<String> lines, String fileName)
			throws IOException {
		Path path = Paths.get(fileName);
		try (BufferedWriter writer = Files.newBufferedWriter(path, ENCODING)) {
			for (String line : lines) {
				writer.write(line);
				writer.newLine();
			}
		}
	}
}
