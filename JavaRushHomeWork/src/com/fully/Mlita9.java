package com.fully;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mlita9
{
    public static class Changes
    {
        String [] firstStep = {"ab", "aa", "bb", "+"};
        String [] finishStep = {"ba", "a", "+", "*+"};
    }

    public static boolean checkWithRegExp(String userString, String element)
    {
        return matcherMad(userString, element).matches();
    }

    public static Matcher matcherMad(String userString,String element)
    {
        String newPattern = "\\"+element;
        Pattern p = Pattern.compile(newPattern);//^[a-z0-9_-]{3,15}$");
        Matcher m = p.matcher(userString);
        return m;
    }

    public static void main(String[] args)
    {
        String startWord = "aaabababab";
        String finishWord = startWord;
        int counter1 = 0, counter2 = 0;
        Changes changes = new Changes();

        for(int i = 0; i < changes.firstStep.length; i++)
        {
            while (finishWord.contains(changes.firstStep[i]))
            {
                if(checkWithRegExp(changes.firstStep[i],changes.firstStep[i]))
                {
                    finishWord = matcherMad(finishWord,changes.firstStep[i]).replaceFirst(changes.finishStep[i]);
                    counter1++;
                    if (counter1 == 100) break;
                }
                else
                {
                    finishWord = finishWord.replaceFirst(changes.firstStep[i], changes.finishStep[i]);
                    counter2++;
                    if (counter2 == 100) break;
                }
            }
        }

        System.out.println(finishWord);
        System.out.println(counter1 + " " + counter2);
    }
}
