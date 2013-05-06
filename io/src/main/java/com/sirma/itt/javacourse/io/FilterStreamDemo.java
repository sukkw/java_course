package com.sirma.itt.javacourse.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FilterStreamDemo {
   public static void main(String[] args) throws Exception {
      
      InputStream is = null; 
      FilterInputStream fis = null;
      int i=0;
      char c;
      byte[] buffer = new byte[20];
      
      try{
         // create input streams
         is = new FileInputStream("test.txt");
         fis = new BufferedInputStream(is);
         
         // returns number of bytes read to buffer
         i = fis.read(buffer,6,4);
         
         // prints
         System.out.println("Number of bytes read: "+i);
         
         // for each byte in buffer
         for(byte b:buffer)
         {
            // converts byte to character
            c=(char)b;
            
            // if byte is null
            if(b==0)
               c='-';
            // prints
            System.out.println("Char read from buffer b: "+c);
         }
      }catch(IOException e){
         
         // if any I/O error occurs
         e.printStackTrace();
      }finally{
         
         // releases any system resources associated with the stream
         if(is!=null)
            is.close();
         if(fis!=null)
            fis.close();
      }
   }
}