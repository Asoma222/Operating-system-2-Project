/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unrealproblem;

import java.io.IOException;
import java.util.concurrent.Semaphore;

/**
 *
 * @author osama
 */

 public class Writer implements Runnable {
     // the threads are placed into a FIFO queue when blocked, so any starvation problems are solved.
     public static Semaphore writeLock = new Semaphore(1 , true);

    @Override
    public void run() {
        try {
            writeLock.acquire();
            System.out.println("Thread "+Thread.currentThread().getName() + " is WRITING");
            Thread.sleep(2500);
            System.out.println("Thread "+Thread.currentThread().getName() + " has finished WRITING");
            writeLock.release();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}