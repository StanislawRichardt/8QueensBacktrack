import static java.lang.Math.abs;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static boolean solutionCheck = true;

    public static boolean backtracking(int[] queens, int column) {

        if(column < queens.length) {
            if (checkingCorrectness(queens, column)) {
                backtracking(queens, column + 1);
            } else {
                if (queens[column] == queens.length - 1) {
                    queens[column] = 0;
                    if (column < queens.length - 1) {
                        backtracking(queens, column + 1);
                    }
                } else {
                    queens[column]++;
                    backtracking(queens, column);
                }
                solutionCheck = false;
            }
        }
        return solutionCheck;
    }

    public static boolean checkingCorrectness(int[] queens, int currentQueen) {
        for (int checkedQueen = 0; checkedQueen < queens.length; checkedQueen++) {
            int currentQueensRow = queens[currentQueen];
            int remainingQueensRow = queens[checkedQueen];

            if (currentQueen != checkedQueen) {
                //diagonal
                if (abs(currentQueensRow - remainingQueensRow) == checkedQueen - currentQueen) {
                    return false;
                } else if (currentQueensRow == remainingQueensRow) {
                    return false;
                }
            }

        }

        return true;
    }

    public static void display(int[] queens) {
        System.out.print("Solution is: ");
        for (int queen : queens) {
            System.out.print(queen + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
//        int[] queens = {0,0,0,0,0,0,0,3};
        int[] queens = new int[8];

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the 8 Queens Problem! Enter starting positions of Queens: ");
        for (int i = 0; i < queens.length; i++) {
            queens[i] = scanner.nextInt();
        }

        while (!backtracking(queens, 0)) {
            solutionCheck = true;
        }
        display(queens);
        
    }
}
