

import java.util.ArrayList;
import java.util.Scanner;

public class TextUI
{
   public void displayMessage(String msg)
   {
       System.out.println(msg);
   }

   public ArrayList<Integer> getUserInput()
   {
       Scanner scan = new Scanner(System.in);
       int i = 0;
       String input = "";
       ArrayList<Integer> values = new ArrayList<>();

       input = scan.nextLine();

       //cheatcode
       if (input.equals("print"))
       {
           System.out.println(Game.targets);
           input = scan.nextLine();
       }

       if (input.equalsIgnoreCase("H"))
       {
           showHelp();
           input = scan.nextLine();
       }

        String[] arr = input.split(" ");

       for (String s: arr)
       {
           values.add(Integer.parseInt(s));
       }
       return values;
   }

    private void showHelp()
    {
        System.out.println("""
                'W' means number is not present.
                'P' means number is present, but out of place
                'C' means number is correct
                """);

    }

    public void displayStatus(ArrayList<Integer> result)
    {
        String msg = "";
        for (int i = 0; i < result.size(); i++)
        {
            switch (result.get(i))
            {
                case 0:
                    msg += "W ";
                    break;

                case 1:
                    msg += "P ";
                    break;

                case 2:
                    msg += "C ";
                    break;
            }
        }
        System.out.println(msg);
    }
}
