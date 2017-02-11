package alllargestincreasingsubsets;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Robert Manos
 */
public class Solver {
//This helper function, for the ArrayList passed in,
//returns the least element Greater than the beg(beginning) index to the end index

    public static int minimiumGreater(ArrayList<Integer> input, int beg, int end) {
        int index = -1;
        int min = Integer.MAX_VALUE;
        if (beg >= end) {
            return -1;
        }
        for (int i = beg; i < end; i++) {
            if (input.get(i) < min && input.get(i) > input.get(beg)) {
                min = input.get(i);
                index = i;
            }
        }
        return index;
    }

    public static LinkedList< ArrayList<Integer>> generate(ArrayList<Integer> input_arr) {
        LinkedList< ArrayList<Integer>> output_list = new LinkedList<>();
        input_arr.add(0, Integer.MIN_VALUE);    //This line prepends a sentinel value of -2147483648
        int minIndex = minimiumGreater(input_arr, 0, input_arr.size() - 1); //This line finds the smallest value to build the first solution
        ArrayList<Integer> curr = new ArrayList<Integer>();     //curr is used as a temperary Ararylist to store the solutions as they are built
        curr.add(0);
        //The following loop executes aslong as minimiumGreater than the current least element finds a new least element
        while (minIndex != -1) {
            curr.add(minIndex);
            minIndex = minimiumGreater(input_arr, minIndex, input_arr.size());
        }
        //Once the loop is done it has found the first solution
        //The alogorithm looks in between the second to last(inclusive) and the last(exclusive) to find a new least element
        //This is done iteratively until the algorithm returns to the sentinel value at the beginning of the list
        output_list.add(new ArrayList<Integer>(curr));
        while (curr.size() != 1) {
            Integer j = curr.remove(curr.size() - 1);
            minIndex = minimiumGreater(input_arr, curr.get(curr.size() - 1), j);
            if (minIndex != -1) {
                while (minIndex != -1) {
                    curr.add(minIndex);
                    minIndex = minimiumGreater(input_arr, minIndex, input_arr.size());
                }
                output_list.add(new ArrayList<Integer>(curr));
            }
        }
        //What follows removes the Sentinels and converts the solutions from indices to the corresponding elements
        input_arr.remove(0);
        for (ArrayList<Integer> i : output_list) {
            i.remove(0);
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (Integer j : i) {
                temp.add(input_arr.get(j - 1));
            }
            i.clear();
            i.addAll(temp);
        }
        return output_list;
    }
}
