package e4_average_gpa;
//@author - Eleanor Ezimah 
import java.util.Arrays;
import java.util.Random;

import e3_binary_search.BinarySearchST;

public class AverageGPA {
	public static void main(String[] args) {
        // Create symbol table
        BinarySearchST<String, Double> st = new BinarySearchST<>();
        String[] grades = {"A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D", "F"};
        Double[] gpas = {4.33, 4.00, 3.67, 3.33, 3.00, 2.67, 2.33, 2.00, 1.67, 1.00, 0.00};
        for (int i = 0; i < grades.length; i++) {
            st.put(grades[i], gpas[i]);
        }

        // Generate random input
        int n = 10;
        String[] input = new String[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            input[i] = grades[r.nextInt(grades.length)];
        }

        // Calculate average gpa
        double sum = 0;
        for (String s : input) {
            sum += st.get(s);
        }
        double gpa = sum / input.length;
        System.out.println("@author - Eleanor Ezimah");
        System.out.println();
        System.out.println(Arrays.toString(input));
        System.out.println();
        System.out.printf("%4.2f", gpa);
    }
}
