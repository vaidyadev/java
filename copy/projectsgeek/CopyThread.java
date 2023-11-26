/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsgeek;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.JProgressBar;

/**
 *
 * @author dev
 */
public class CopyThread implements Runnable{
    
    private String sourceFile;
    private String destinationFile;
    private javax.swing.JProgressBar jProgressBar1;
    
    // Setters and getters for sourceFile, destinationFile and progressbar
    public JProgressBar getjProgressBar1() {
        return jProgressBar1;
    }

    public void setjProgressBar1(JProgressBar jProgressBar1) {
        this.jProgressBar1 = jProgressBar1;
    }
    
    public String getSourceFile() {
        return sourceFile;
    }

    public String getDestinationFile() {
        return destinationFile;
    }

    public void setSourceFile(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    public void setDestinationFile(String destinationFile) {
        this.destinationFile = destinationFile;
    }

    // This is the run method which will do the real task of copying the file as well as updating the progress bar based on the current status 
    @Override
    public void run() {
        
        // Creating the input stream to read the file
        InputStream inputStream = null;
        // Creating the output stream to write the file
	OutputStream outputStream = null;
		
    	try{
    		
            // creating an instance of source file 
    	    File sourcefile =new File(sourceFile);
            // creating an instance of destination file
    	    File destinationfile =new File(destinationFile);
    	
            // Now reading the file and loading it in inputstream
    	    inputStream = new FileInputStream(sourcefile);
            // Now pointing output stream to the destination file
    	    outputStream = new FileOutputStream(destinationfile);
        	
    	    byte[] buffer = new byte[1024];
            // Taking the length of source file for updating progress bar
            long size = sourcefile.length();
            long count=0;
    		
    	    int length;
    	    // Now we will start byte by byte to read the inputstream and passing it to outputstream 
    	    while ((length = inputStream.read(buffer)) > 0){
    	    	outputStream.write(buffer, 0, length);
                count+=length;
                // Updating the progress bar in percentage
                jProgressBar1.setValue((int) (count*100/size));
                jProgressBar1.setString((int) (count*100/size)+"%");
    	    }
            // Now copied succesfully updating progress bar
            jProgressBar1.setValue(100);
            jProgressBar1.setString("Copied Successfully");
            
            // Closing input as well as outputstream
    	    inputStream.close();
    	    outputStream.close();
    	    
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    }
    
}