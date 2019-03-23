/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpsc222_jennyli_hw1;

/**
 *
 * @author jenny
 */
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Car implements Runnable {
    private char direction;
    private int stopTime, lTime, fTime, rTime;
    private char[] D;
    private Intersection i;
    
    @Override
    public void run() {
        try {
            Thread.sleep(stopTime);
        } catch (InterruptedException ex) {
            Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        switch(direction()) {
            case 'L': {
                try {
                    left();
                } 
                catch (InterruptedException ex) {
                    Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;
            case 'F': {
                try {
                    forward();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;
            case 'R': {
                try {
                    right();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public Car(char[] d, char direction, Intersection i) {
        this.i = i;
        D = d;
        this.direction = direction;
        Random rand = new Random();
        stopTime = rand.nextInt(50);
        lTime = 50;
        rTime = 50;
        fTime = 50;
    }
    
    public void left() throws InterruptedException {
        //turning left requires crossing 3 grid quadrants
        
        switch(this.direction) {
            case 'S': { 
                //4th quad
                if(i.getGrid()[3] > 0)
                    i.collide();
                i.getGrid()[3]++;
                Thread.sleep(lTime/3);
                i.getGrid()[3]--;
                
                //2nd quad
                if(i.getGrid()[1] > 0)
                    i.collide();
                i.getGrid()[1]++;
                Thread.sleep(lTime/3);
                i.getGrid()[1]--;
                
                //1st quad
                if(i.getGrid()[0] > 0)
                    i.collide();
                i.getGrid()[0]++;
                Thread.sleep(lTime/3);
                i.getGrid()[0]--;
                break; }
            
            case 'E': { 
                //2nd quad
                if(i.getGrid()[1] > 0)
                    i.collide();
                i.getGrid()[1]++;
                Thread.sleep(lTime/3);
                i.getGrid()[1]--;
                
                //1st quad
                if(i.getGrid()[0] > 0)
                    i.collide();
                i.getGrid()[0]++;
                Thread.sleep(lTime/3);
                i.getGrid()[0]--;
                
                //3rd quad
                if(i.getGrid()[2] > 0)
                    i.collide();
                i.getGrid()[2]++;
                Thread.sleep(lTime/3);
                i.getGrid()[2]--;
                break; }
        }
    }
    
    public void right() throws InterruptedException {
        switch(this.direction) {
            case 'W': { 
                //3rd quad
                if(i.getGrid()[2] > 0)
                    i.collide();
                i.getGrid()[2]++; 
                Thread.sleep(rTime);
                i.getGrid()[2]--;
                break; }
            
            case 'S': { 
                //4th quad
                if(i.getGrid()[3] > 0)
                    i.collide();
                i.getGrid()[3]++; 
                Thread.sleep(rTime);
                i.getGrid()[3]--;
                break; }
        }
    }
    
    public void forward() throws InterruptedException {
        switch(this.direction) {
            case 'W': { 
                //goes into 3rd quadrant
                if(i.getGrid()[2] > 0)
                    i.collide();
                i.getGrid()[2]++;
                Thread.sleep(fTime/2);
                i.getGrid()[2]--;
                
                //goes into 4th quadrant
                if(i.getGrid()[3] > 0)
                    i.collide();
                i.getGrid()[3]++;
                Thread.sleep(fTime/2);
                i.getGrid()[3]--;
                break; }
            
            case 'E': { 
                //goes into second quadrant
                if(i.getGrid()[1] > 0)
                    i.collide();
                i.getGrid()[1]++;
                Thread.sleep(fTime/2);
                i.getGrid()[1]--;
                
                //1st quadrant
                if(i.getGrid()[0] > 0)
                    i.collide();
                i.getGrid()[0]++;
                Thread.sleep(fTime/2);
                i.getGrid()[0]--;
                break; }
        }
    }
    
    public char direction() {
        Random rand = new Random();
        return D[rand.nextInt(D.length)];
    }
    
    public void setStopTime(int ms) {stopTime = ms;}
    public void setLeftTime(int ms) {lTime = ms;}
    public void setForwardTime(int ms) {fTime = ms;}
    public void setRightTime(int ms) {rTime = ms;}
    public int getStopTime () {return stopTime;}
}
