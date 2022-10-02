package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int num;
        int result;
        Integer twoNumbers[]= new Integer[2];
        try{

            while (twoNumbers[1] == null || twoNumbers[0] == null){
               if((num=Integer.parseInt(scanner.next()))>0)
                        if(twoNumbers[0] == null)
                            twoNumbers[0]=num;
                        else if(twoNumbers[1] == null)
                            twoNumbers[1]=num;
            }
            //Arrays.stream(twoNumbers).forEach(x -> System.out.println(x))

            result=evklid(twoNumbers[0],twoNumbers[1] );

            System.out.println(result);

            scanner.close();

        }
        catch (NumberFormatException e){e.printStackTrace();}
        catch (Exception e){e.printStackTrace();}
    }

    public static int evklid(int a, int b)
    {

        int res;
        int delimoe= Integer.max(a,b);
        int delitel = Integer.min(a,b);
        int ostatok= -1;;
        int maxNOD= delimoe % delitel;
       // int ert= maxNumber % minNumber;
        while (ostatok!=0)  {
           // res=delimoe / delitel;
            ostatok = delimoe % delitel;
            delimoe=delitel;
            maxNOD=delitel;
            delitel = ostatok;

        }
        ; //||(((delimoe / delitel) * delitel) !=delimoe));

        return maxNOD;
    }
}
