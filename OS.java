/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package os;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 *
 * @author osama
 */
public class OS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      ExecutorService executor  = Executors.newFixedThreadPool(5) ;
      executor.execute(new Reader()) ;
      executor.execute(new Reader()) ; 
      executor.execute(new Writer())  ;
      executor.execute(new Reader()) ; 
      executor.execute(new Reader()) ; 
      executor.execute(new Reader()) ; 
      executor.shutdown();
      
 }
      
        
        
        
    }
    
    
    

