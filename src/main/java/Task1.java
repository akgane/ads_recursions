import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.pow;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1
//        System.out.println(sumOfSquares(4));

        //2
//        System.out.println(sumOfElements(3, new int[]{1, 3, 5, 7, 9}));

        //3
//        System.out.println(sumOfIntegers(5));

        //4
//        System.out.println(sumOfPowers(4, 3));

        //5
//        System.out.println("Enter n: ");
//        int n = scanner.nextInt();
//        System.out.println(reverseSequence(n, scanner));

        //6
//        int n = scanner.nextInt();
//        scanner.nextLine();
//        System.out.println(reverseSequence2(n, scanner));

        //7
//        int n = scanner.nextInt();
//        int[][] spiral = new int[n][n];
//        spiral = spiralOfNumbers(spiral, 0, 0, 0, 1);
//        for (int[] arr : spiral){
//            for(int num : arr) System.out.print(num + " ");
//            System.out.println();
//        }

        //8
        System.out.println(xSequences(2, 3));

        //9
//        char[] input = new char[]{'i', 'o', 'x'};
//        permutations(input, input.length);

        //10
//        for(int i = 0; i < 100000; i++){
        //two variants of printing result (uncomment only one line below)
//            System.out.println(i + " is" + (powerOfTwo(i) ? "": " not") + " a power of 2");
////            if(powerOfTwo(i)) System.out.println(i + " is a power of 2");
//        }
    }

    static int sumOfSquares(int n){
        if(n == 1) return 1;
        return n*n + sumOfSquares(n - 1);
    }

    static int sumOfElements(int n, int[] numbers){
        if(n - 1 == 0) return numbers[n - 1];
        return numbers[n - 1] + sumOfElements(--n, numbers);
    }

    static int sumOfIntegers(int n){
        if(n == 1) return 1;
        return n + sumOfIntegers(n - 1);
    }

    static int sumOfPowers(int b, int n){
        if(n == 0) return 1;
        return (int)pow(b, n) + sumOfPowers(b, --n);
    }

    static String reverseSequence(int n, Scanner scanner){
        if(n == 1) return scanner.nextInt() + " ";
        String num = scanner.nextInt() + " ";
        return reverseSequence(--n, scanner) + num;
    }

    static String reverseSequence2(int n, Scanner scanner){
        if(n == 1) return scanner.nextLine() + "\n";
        String seq = scanner.nextLine() + "\n";
        return reverseSequence2(--n, scanner) + seq;
    }

    static int[][] spiralOfNumbers(int[][] spiral, int row, int column, int dir, int number) {
        if (number > spiral.length * spiral.length) return spiral;

        spiral[column][row] = number++;

        switch (dir) {
            case 0:
                if (row < spiral[0].length - 1 && spiral[column][row + 1] == 0)
                    return spiralOfNumbers(spiral, row + 1, column, dir, number);
                else
                    return spiralOfNumbers(spiral, row, column + 1, 1, number);
            case 1:
                if (column < spiral.length - 1 && spiral[column + 1][row] == 0)
                    return spiralOfNumbers(spiral, row, column + 1, dir, number);
                else
                    return spiralOfNumbers(spiral, row - 1, column, 2, number);
            case 2:
                if (row > 0 && spiral[column][row - 1] == 0)
                    return spiralOfNumbers(spiral, row - 1, column, dir, number);
                else
                    return spiralOfNumbers(spiral, row, column - 1, 3, number);
            case 3:
                if (column > 0 && spiral[column - 1][row] == 0)
                    return spiralOfNumbers(spiral, row, column - 1, dir, number);
                else
                    return spiralOfNumbers(spiral, row + 1, column, 0, number);
        }
        return spiral;
    }

    /*
    xSequences(n, k, length, seq)
        
     */
    static String xSequences(int n, int k){
        return "TODO";
    }

    static void outputSequence(int n, int k){
        for(int i = n; i <= k; i++) System.out.print(i + " ");
        System.out.println();
    }

    /*
    permutations(input, size):
        if(size == 1) sout(input)
        else
            for(i in range(0, size)
                permutations(input, size - 1)
                if(i % 2 == 0) swap(0, size - 1)
                else swap(i, size - 1)
     */
    static void permutations(char[] input, int size) {
        if(size == 1) System.out.println(input);
        else{
            for (int i = 0; i < size; i++){
                permutations(input, size - 1);
                if(size % 2 == 0) swapChars(input, 0, size - 1);
                else swapChars(input, i, size - 1);
            }
        }
    }

    static char[] swapChars(char[] string, int i, int j){
        char temp = string[i];
        string[i] = string[j];
        string[j] = temp;
        return string;
    }

    static boolean powerOfTwo(int n){
        if(n == 1 || n == 0) return n == 1;
        for(int i = n; i > 1; i /= 2){
            int div = i / 2;
            if(div * 2 != i) return false;
        }
        return true;
    }
}
