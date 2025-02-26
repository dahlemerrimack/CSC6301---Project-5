//Javadoc command to generate javadoc: javadoc -d javadoc sortedstacklist.java

/**
 * Class that takes in an array of integers from a scanner and sorts it using a stack list,
 * from the smallest to largest.
 *
 * <P> This program continuously prompts the user for a integer input until the user enters "done". 
 * The integers are added to a stack list and then sorted from smallest to largest. 
 * Prints the sorted stack list when the user enters "done".
 * 
 * @author Eric Dahle
 * @version 1.0
 * @since Week 5 of CSC6301
 */

import java.util.Scanner;
import java.util.Stack;


public class sortedstacklist {

    /**
     * Main entry point of the program.
     * <p> Uses the {@code userInput} method to receive a collection of integers to be stored in a stack list arranged from smallest to largest.
     * <p> Prints the sorted list after the user enters "done".
     * 
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Stack<Integer> stack = userInput(); 
        Stack<Integer> sortedStack = sortstackList(stack); 
        System.out.println("Sorted Stack List: " + sortedStack);
    }


    /** 
     * Prompts the user for a collection of integers to be stored in a stack list.
     * 
     * <p> Continuously prompts the user for a integer input until the user enters "done". 
     * The integers are added to a stack list.
     * 
     * @return A stack list of integers.
     */
    // reusing the userInput method from the previous project
    public static Stack<Integer> userInput() {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        while (true) {
            System.out.print("Enter an integer or \"done\" when finished: ");
            if (sc.hasNextInt()) {
                int input = sc.nextInt();
                stack.push(input);
            } else {
                String input = sc.next();
                if (input.equalsIgnoreCase("done")) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter an integer or \"done\".");
                }
            }
        }

        sc.close();
        return stack;
    }

    /**
     * Takes a unsorted stack list of integers and sorts it from smallest to largest using an insertion sort algorithm.
     * 
     * <p> This algorithm iterates through the passed stack list and sorts it by moving elements between
     * the original stack and a temporary sorted stack. 
     * 
     * <P>If the top element of the sorted stack is greater than the current element, elements are temporarily moved back to the original stack 
     * until the correct position is found. The element is then placed in the sorted stack.
     * 
     * <p> This process continues until all elements from the original stack have been transferred 
     * and sorted in the new stack.
     * 
     * @param stackList
     * @return
     */
    public static Stack<Integer> sortstackList(Stack<Integer> stackList) {
        Stack<Integer> sortedStack = new Stack<>();

        while (!stackList.isEmpty()) {
            int temp = stackList.pop();

            while (!sortedStack.isEmpty() && sortedStack.peek() > temp) {
                stackList.push(sortedStack.pop());
            }

            sortedStack.push(temp);
        }

        return sortedStack;
    }
}