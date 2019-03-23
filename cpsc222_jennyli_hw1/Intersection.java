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
public class Intersection {
    private int collisions;
    private int[] grid;
    /* intersection is divided into 4 quadrants:
    
    0 1
    2 3
    
    */
    
    public Intersection(int n) {
        collisions = 0;
        grid = new int[n];
    }
    
    public void collide() {collisions++;}
    public int[] getGrid() {return grid;}
    public int getCollisions() {return collisions;}
    public void reset() {collisions = 0;}
    public void resetGrid() {
        for(int i: grid)
            i = 0;
    }
}
