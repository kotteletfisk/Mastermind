import com.sun.jdi.IntegerType;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Game
{
    int strike = 0;
    boolean running = true;
    ArrayList<Integer> guesses = new ArrayList<>();
    TextUI textUI = new TextUI();
    static Random random = new Random();

   static ArrayList<Integer> targets = new ArrayList<>()
    {{
        add(random.nextInt(1, 10));
        add(random.nextInt(1, 10));
        add(random.nextInt(1, 10));
        add(random.nextInt(1, 10));
    }};


    public void runGame()
    {

        textUI.displayMessage("Welcome to Mastermind!\nEnter four digits separated by space,\nor enter H for feedback guide:");

        while (running)
        {
            try
            {
                guesses = textUI.getUserInput();


                ArrayList<Integer> result = compare(guesses, targets);

                textUI.displayStatus(result);

                if (checkIfWon(result))
                {
                    textUI.displayMessage("You cracked the code!");
                    running = false;
                }
            }

            catch (Exception e)
            {
                switch (strike)
                {
                    case 0:
                        textUI.displayMessage("dude, stop");
                        strike++;
                        break;

                    case 1:
                        textUI.displayMessage("seriously dude, stop");
                        strike++;
                        break;

                    case 2:
                        textUI.displayMessage("fucking stop, or ill crash the JVM");
                        strike++;
                        break;

                    case 3:
                        crashAndBurn();
                }
            }
        }

    }

    private boolean checkIfWon(ArrayList<Integer> result)
    {
        int total = 0;
        for (Integer i: result)
        {
            if (i == 2)
            {
                total++;
            }
        }
        return total > 3;
    }

    public static ArrayList<Integer> compare(ArrayList<Integer> guesses, ArrayList<Integer> targets)
    {
       ArrayList<Integer> evaluation = new ArrayList<>();
        for (int i = 0; i < targets.size(); i++)
        {
            if (guesses.get(i).equals(targets.get(i)))
            {
                evaluation.add(i, 2);
            }

            else if (targets.contains(guesses.get(i)))
            {
                evaluation.add(i, 1);
            }
            else evaluation.add(i, 0);
        }

        return evaluation;
    }

   static public ArrayList<Integer> getTargets()
    {
        return targets;
    }

    static public void crashAndBurn()
    {
        crashAndBurn();
    }
}
