/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package os;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osama
 */
// this is the writer of the real problem 
public class Writer implements Runnable   {
     
    public void run(){
    FileOperation f = new FileOperation () ; 
        try { 
            f.write();
        } catch (IOException ex) {
           System.out.println("there's something wrong ") ; 
        }
    
        
      
       
    
    
}
}

