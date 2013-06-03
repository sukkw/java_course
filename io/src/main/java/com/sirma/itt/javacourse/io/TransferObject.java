package com.sirma.itt.javacourse.io;

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
	private InputStream in; 
	private OutputStream out;
	
	/**
	 * Constructor.
	 * @param in - input stream
	 * @param out - output stream
	 */
	public TransferObject(InputStream in, OutputStream out) {
		
		if(in == null || out == null) {
			System.out.println(" Invalid Stream ");
			System.exit(0);
		}
		
		this.in = in;
		this.out = out;
	}
	
	/**
	 * Transfer bytes from input to output stream
	 * @param numberOfBytes - number of bytes to be transfered
	 * @param offset - offset in bytes
	 * @return - transfered bytes
	 * @throws IOException 
	 */
	public int transfer(int numberOfBytes, int offset) throws IOException {
		
		int ch;								
		int count = 0;								
		int writtenBytes = 0;							
		int start = offset;					
		int stop  = (offset + numberOfBytes) - 1;	
		
		try {	
			// read InputStream from start position(offset) to end position
			// and write to OutputStream
			while(( ch = in.read()) != -1 ) {	
				if((count >= start)&&(count <= stop)) {
					out.write(ch);				
					writtenBytes++;
				}
				count++;
			}
		}
		finally {
			in.close();						
			out.close();						
		}
		return writtenBytes;	
	}
}
