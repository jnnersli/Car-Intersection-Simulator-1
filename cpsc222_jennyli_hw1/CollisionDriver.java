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
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class CollisionDriver {
   private static Thread west, south, east;
   private static Car westCar, southCar, eastCar;
   private static Intersection intersection;
   
   public static void main(String[] args) throws FileNotFoundException, InterruptedException {
       PrintWriter writer = new PrintWriter("Experiments.txt");
       intersection = new Intersection(4);
       
       westCar = new Car(new char[] {'F', 'R'}, 'W', intersection);
       southCar = new Car(new char[] {'L', 'R'}, 'S', intersection);
       eastCar = new Car(new char[] {'F', 'L'}, 'E', intersection);
       
       //experiment 1
       writer.println("Experiment 1:");
       runExperiment(writer, 100);
       writer.println();
       intersection.reset();
       
       //experiment 2
       westCar.setLeftTime(100);
       westCar.setForwardTime(75);
       southCar.setLeftTime(100);
       southCar.setLeftTime(75);
       eastCar.setLeftTime(100);
       eastCar.setForwardTime(75);
       writer.println("Experiment 2:");
       runExperiment(writer, 100);
       writer.println();
       intersection.reset();
       
       //experiment 3
       westCar = new Car(new char[] {'R'}, 'W', intersection);
       southCar = new Car(new char[] {'R'}, 'S', intersection);
       eastCar = new Car(new char[] {'F'}, 'E', intersection);
       writer.println("Experiment 3:");
       runExperiment(writer, 100);
       intersection.reset();
       
       writer.close();
   }
   
   private static void runExperiment(PrintWriter writer, int n) throws InterruptedException {
       for(int i = 0; i < n; i++) {
           west = new Thread(westCar);
           south = new Thread(southCar);
           east = new Thread(eastCar);
           west.start();
           south.start();
           east.start();
           west.join();
           south.join();
           east.join();
           intersection.resetGrid();
       }
       writer.println("runs: " + n);
       writer.println("collisions: " + intersection.getCollisions());
       writer.flush();
       
       
   }
}
