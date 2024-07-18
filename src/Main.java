import static java.lang.Math.abs;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static boolean solutionCheck = true;
    public static boolean solutionFound = false;

    public static boolean backtracking(int[] queens, int column) {
        if(column < queens.length) {
            while (queens[column] < queens.length) {
                if (checkingCorrectness(queens, column)) {
                    backtracking(queens, column + 1);
                    if(column == queens.length - 1) {
                        solutionFound = true;
                    }
                }
                if(solutionFound) {
                    return true;
                }else{
                    if (queens[column] == queens.length - 1) {
                        queens[column] = 0;
                        break;
                    } else queens[column]++;
                    solutionCheck = false;
                }
            }
        }
        return solutionCheck;
    }

    public static boolean checkingCorrectness(int[] queens, int currentQueen) {
        for (int checkedQueen = 0; checkedQueen < currentQueen; checkedQueen++) {
            int currentQueensRow = queens[currentQueen];
            int remainingQueensRow = queens[checkedQueen];
                //diagonal
            if (abs(currentQueensRow - remainingQueensRow) == abs(checkedQueen - currentQueen)) {
                return false;
            } else if (currentQueensRow == remainingQueensRow) {
                return false;
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
