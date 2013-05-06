package com.sirma.itt.javacourse.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TransferObject {

	// class private members
	private InputStream in; 
	private OutputStream out;
	private static final int BUFFER_SIZE = 1024;
	
	/**
	 * Constructor.
	 * @param in - input stream
	 * @param out - output stream
	 */
	public TransferObject(InputStream in, OutputStream out) {
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
		
		byte[] buffer = new byte[BUFFER_SIZE];
		
		in.read(buffer);
        out.write(buffer, offset, numberOfBytes);

		return 0;
		
	}
}
