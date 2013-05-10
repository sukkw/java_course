package com.sirma.itt.javacourse.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TransferObjectRun {

	public static void main(String[] args) {

		try {
			InputStream in = new FileInputStream("testFile.txt");
			OutputStream out = new FileOutputStream("testTransfer.txt");
			TransferObject transfer = new TransferObject(in, out);
			transfer.transfer(12, 7);
		} catch (IOException e) {
			System.out.println("Can not transfer bytes");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Can not transfer bytes");
		}
	}
}
