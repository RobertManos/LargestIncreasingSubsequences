/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alllargestincreasingsubsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author Robert Manos
 */
public class AllLargestIncreasingSubsets {

    public static void main(String[] args) {
        //Here are some Example cases to show the algorithm   
        Integer[] test1 = {15, 38, 5, -18, -3, -82, 63, -27, 66, -6, 87};
        ArrayList<Integer> Example1 = new ArrayList<Integer>(Arrays.asList(test1));
        Integer[] test2 = {15, 51, 47, 60, 14, 76, -8, 21, 78, -45, 64, -98, 93, -82, 29, 52};
        ArrayList<Integer> Example2 = new ArrayList<Integer>(Arrays.asList(test2));
        Integer[] test3 = {47, -81, 82, -90, 70, -79, -44, 25, 3, -14, 44, 67, -56, -45, -58, -95, -27, 27};
        ArrayList<Integer> Example3 = new ArrayList<Integer>(Arrays.asList(test3));
        LinkedList< ArrayList<Integer>> solution1 = Solver.generate(Example1);
        LinkedList< ArrayList<Integer>> solution2 = Solver.generate(Example2);
        LinkedList<ArrayList<Integer>> solution3 = Solver.generate(Example3);
        System.out.println("__________Printing_Solution_#1_________");
        for (ArrayList<Integer> i : solution1) {
            System.out.println(i);
        }
        System.out.println("_________Printing_Solution_#2_________");
        for (ArrayList<Integer> i : solution2) {
            System.out.println(i);
        }
        System.out.println("__________Printing_Solution_#3_________");
        for (ArrayList<Integer> i : solution3) {
            System.out.println(i);
        }

    }

}
