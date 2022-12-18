/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package os;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author osama
 */
public class FileOperation {

    public volatile static int readcount = 0;
    //public static Semaphore fairness = new Semaphore(1 , true)  ; 
    public static Semaphore readlock = new Semaphore(1 , true); // wirte it 1 in the argument semphore 
    public static Semaphore writeLock = new Semaphore(1, true);
    private static Lock lock = new ReentrantLock(); 
    private static Lock fairnessLock = new ReentrantLock() ; 
    File file = new File("D:\\Faculty\\Fourth\\OS2\\Project2\\Persons.txt");
    Scanner scan;

    public void read() throws FileNotFoundException, InterruptedException {
       // fairnessLock.lock();
        readlock.acquire();
        lock.lock();
        readcount++;
        lock.unlock();
        if (readcount == 1) {
            writeLock.acquire();  
        }
        readlock.release();
        //fairnessLock.unlock(); 
       // System.out.println(Thread.currentThread().getName()+" relesae the lock");
        try {
            
              scan = new Scanner(file);
                
           // while (true) {
                while (scan.hasNextLine()) { 
                     
                    System.out.println(scan.nextLine());
                    //Thread.sleep(500);

                }
           // }
          //  scan.close();
        } catch (Exception e) {
            System.out.println("dfsadsf");

        }
        finally {
            System.out.println("Thread number is " + Thread.currentThread().getId() + "\n") ;
        
        }
       
        readlock.acquire();
        lock.lock();
        readcount--;
        lock.unlock();
        if (readcount == 0) {
            writeLock.release();
        }
        readlock.release();
    }

    public void write() throws IOException {
        Scanner input  = new Scanner(System.in) ;  

        try {
           // Scanner scanner = new Scanner(System.in);
            //String statment =  scanner.nextLine();
           // fairnessLock.lock(); // replace fariness.acquire() ; 
            writeLock.acquire();
            //fairnessLock.unlock(); // replace fariness.realese() ; 
            System.out.println(Thread.currentThread().getName()+" writer get the lock");
            FileWriter writer = new FileWriter(file , true);
            String s  = input.nextLine() ;
            writer.write('\n'+s);
            writer.close();
            System.out.println("hi you should write and close"); 
            writeLock.release();
        } catch (InterruptedException ex) {
        } finally {
            System.out.println("hi writer is finished") ; 
        }

    }

}

//private static Condition Read = lock.newCondition() ; 
            //private static Condition Write = lock.newCondition() ; 
