package com.sirma.itt.javacourse.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * TransferObject run class
 * 
 * @version 1.1 01 May 2013
 * @author Stella Djulgerova
 */
public class TransferObjectRun {

	/**
	 * Class main method. Create I/O objects and execute transfer.
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			InputStream in = new FileInputStream("testFile.txt");
			OutputStream out = new FileOutputStream("testTransfer.txt");
			
			TransferObject transfer = new TransferObject(in, out);
			int transferedBytes = transfer.transfer(12, 7);
			
			if(transferedBytes > 0) {
				System.out.println(transferedBytes + " bytes was transfered");
			} else {
				System.out.println("0 bytes was transfered");
			}
			
		} catch (IOException e) {
			System.out.println("Can not transfer bytes");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Can not transfer bytes");
		} catch (NumberFormatException e) {
			System.out.println("Can not transfer bytes");
		}
	}
}