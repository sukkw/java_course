package com.sirma.itt.javacourse.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Transfer small portion of bytes from one stream to another.
 * 
 * @version 1.1 01 May 2013
 * @author Stella Djulgerova
 */
public class TransferObject {

	// class private members
	private BufferedInputStream in; 
	private BufferedOutputStream out;
	
	/**
	 * Constructor.
	 * @param in - input stream
	 * @param out - output stream
	 */
	public TransferObject(InputStream in, OutputStream out) {
		if(in != null && out != null) {
			this.in = new BufferedInputStream(in);;
			this.out = new BufferedOutputStream(out);
		}
	}
	
	/**
	 * Transfer bytes from input to output stream
	 * @param numberOfBytes - number of bytes to be transfered
	 * @param offset - offset in bytes
	 * @return - transfered bytes
	 * @throws IOException 
	 */
	public int transfer(int numberOfBytes, int offset) throws IOException {
			
		if(in == null || out == null) {
			return 0;
		}
		
		int transferedBytes;																				
		byte[] data = new byte[1024];
		try {	
			transferedBytes = in.read(data, (int) in.skip(offset), numberOfBytes);	
			out.write(data, offset, numberOfBytes);				
		}
		finally {
			in.close();						
			out.close();						
		}
		return transferedBytes;	
	}
}
