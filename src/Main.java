import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Main {

    public static boolean positionCheck=true;
    public static boolean solutionCheck=true;

    public static boolean backtracking(int []queens, int length)
    {
            for(int i=length;i<queens.length;i++) {

                if(checkingCorrectness(queens,i))
                {
                    backtracking(queens,length+1);
                }
                else
                {
                    if(queens[i]==queens.length-1)
                    {
                        queens[i]=0;
                        if(i<queens.length-1)
                        {
                            backtracking(queens, length+1);
                        }
                    }
                    else {
                        queens[i]++;
                        backtracking(queens, length);
                    }
                    solutionCheck=false;
                }
                break;
            }
            return solutionCheck;
        }

    public static boolean checkingCorrectness(int [] queens, int position)
    {
        positionCheck=true;
        for(int i=0;i<queens.length;i++)
        {
            if(position==i)
            {
                continue;
            }
            else {
                if (abs((queens[position] - queens[i])) == ((i) - position)) {
                    positionCheck = false;
                } else if (queens[position] == queens[i]) {
                    positionCheck = false;
                } else {
                    continue;
                }
            }

        }
        return positionCheck;
    }
public static void display(int[]queens)
{
    System.out.print("Solution is: ");
    for (int i = 0; i < queens.length; i++) {
        System.out.print(queens[i] + " ");
    }
}

    public static void main(String[] args)
    {
            int[] queens=new int[8];

            do {
                solutionCheck=true;
                display(queens);
            }while(!backtracking(queens, 0));



        }

}
