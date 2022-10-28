package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String filename;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            filename = reader.readLine();
        }

        //add-mode
        if (args.length != 0) {
            if(args[0].equals("-c")){
                String productName =args[1];
                String price = args[2];
                String quantity=args[3];
                String currentRow;
                String number;
                int maxNumber=-1;
                int currNumber;

                try(BufferedReader reader = new BufferedReader(new FileReader(filename));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))){
                    while (reader.ready()){
                        currentRow = reader.readLine();
                        number=currentRow.substring(0,8).trim();
                        if((currNumber=Integer.parseInt(number)) > maxNumber)
                            maxNumber = currNumber;
                    }
                    maxNumber = maxNumber+1;
                    String id = String.valueOf(maxNumber);
                    id = spaceAdder(id,8);
                    productName = spaceAdder(productName, 30);
                    price = spaceAdder(price,8);
                    quantity = spaceAdder(quantity,4);

                    writer.newLine();
                    writer.write(id.concat(productName)
                            .concat(price)
                            .concat(quantity));

                }
            }
        }
    }

    //adding spaces to row
    private static String spaceAdder(String stringToChange, int lengthDesire){
        String result=stringToChange;
        while (result.length() < lengthDesire) {
            result=result.concat(" ");
        }
        return result;
    }
}
