import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * lab6.java
 * fall 2025
 * 
 * Karissa.Merillat
 * 
 * convert String to double using Java Collection Stack and Queue
 */

public class lab6 {
    public static void main(String[] args) {

        // test cases - add x3 additional cases here
        test("6", 6.0);
        test("7,000,000", 7000000.0);
        test(" $$$7 000 000 ", 7000000.0);
        test("$5,678.13 ", 5678.13);
        test("$0.25", 0.25);
        test(" -$.25", -0.25);
        test("-8.96", -8.96);

        // *** add three additional test cases here
        test("1016.25", 1016.25);
        test("$3,160.25", 3160.25);
        test("-$152 000", -152000);

    }// main

    private static double toDouble(String a) {

        double answer = 0.0;

        Stack<Integer> s = new Stack<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();

        boolean decimalFound = false; // *** may or may not use this approach
        boolean negative = false; // *** may or may not use this approach

        // *** add code here ***

        a = a.trim();

        if (a.contains("-")) {
            negative = true;
        }

        a = a.replaceAll("[^0-9.]", "");
        

        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (c == '.'){
                decimalFound = true;
            } else if (!decimalFound) {
                s.push(c - '0');
            } else {
                q.add(c - '0');
            }
        }

        int place = 1;
        while (!s.isEmpty()) {
            answer += s.pop() * place;
            place *= 10;
        }

        double decimalPlace = 0.1;
        while (!q.isEmpty()) {
            answer += q.remove() * decimalPlace;
            decimalPlace /= 10;
        }

        if (negative) {
            answer = -answer;
        }



        return answer;

    }// toDouble

    // test method
    private static void test(String s, double expected) {

        double actual = toDouble(s);

        if (actual == expected)
            System.out.printf("Passed: %15s => %15f\n", s, actual);
        else
            System.out.printf(" Error: %15s => %15f   Expected: %15f\n", s, actual, expected);

    } // test

}// class
 