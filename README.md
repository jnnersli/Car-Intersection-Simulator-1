# Car-Intersection-Simulator-1
Assignment 1 for CPSC 222: Introduction to Distributed and Concurrent Programming

This assignment is focused on counting the number of collisions in an intersection if cars had no regard for one another. To ease into the problem, we will start with a 3-way stop.

There are three ways to come into the intersection, which we label W for West, S for South, and E for East. Cars are denoted by where they originate. That is, CW is the car coming from the western street.

Each car approaches the intersection, and waits at the stop line (dotted line) for some arbitrary time period Tstop. Cars in general have only three options for going through the intersection: left turn L, right turn R, or go forward F. However, not every car can necessarily turn all of these ways in this type of intersection (eg. CE cannot turn right [CE   → R]). After stopping at the stop line for time Tstop, the cars can progress through the intersection. The time it takes for a car to travel through the intersection depends on whether they decide to turn left, right, or go forward, labeled TL, TR, and TF respectively.

Algorithm : 
Car coming from some direction P Forever:
CP waits for time Tstop at the stop line;
D = randomly chosen direction (L, R, or F); 
//not all cars can travel all directions
CP enters and crosses the intersection for time TD; 
CP magically returns back to its origin (P street);

