package test;

public class Mlita9
{
    public static class Changes
    {
        String [] firstStep = new String[4];
        String [] finishStep = new String[4];
    }

    public static void main(String[] args)
    {
        String startWord = "aaabababab";
        String finishWord = startWord;
        int counter = 0;
        Changes changes = new Changes();
        changes.firstStep[0] = "ab";
        changes.firstStep[1] = "aa";
        changes.firstStep[2] = "bb";
        changes.firstStep[3] = "\\+";
        changes.finishStep[0] = "ba";
        changes.finishStep[1] = "a";
        changes.finishStep[2] = "+";
        changes.finishStep[3] = "*+";

        for(int i = 0; i < changes.firstStep.length; i++)
        {
            while (finishWord.contains(changes.firstStep[i]))
            {
                finishWord = finishWord.replaceFirst(changes.firstStep[i], changes.finishStep[i]);
                counter++;
                if (counter == 100) break;
            }

        }

        System.out.println(finishWord);
        System.out.println(counter);
    }
}
