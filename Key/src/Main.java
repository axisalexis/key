import java.util.Scanner;

public class Main
{
    private static Scanner scanner = new Scanner(System.in).useDelimiter("\n");;
    private static String[] saves = new String[10];
    private static int snl;

    public static void main(String[] args)
    {
        menue();
    }
    private static void menue()
    {
        System.out.println("This is the menue, please make a decision");
        System.out.println();
        System.out.println("1. Save a String in an Array");
        System.out.println("2. encode a prewritten String");
        System.out.println("3. Decoode a prewritten String");
        System.out.println("4. Read a prewritten String");
        int n = scanner.nextInt();

        switch (n)
        {
            case 1:
                write();
                break;
            case 2:
                encode();
                break;
            case 3:
                decode();
                break;
            case 4:
                read();
                break;
            default:
                menue();
                break;
        }
    }
    private static void write()
    {
        System.out.println("Please insert a string you want to save in the array");
        String write = scanner.next();
        System.out.println();
        savenload();
        saves[snl]=write;
        System.out.println("This was saved in Slot " + snl +1 + ": " + write);
        menue();
    }
    private static void savenload()
    {
        System.out.println("In which row do you want to save/load from your Scan (You can only chose between 0-9");
        snl = scanner.nextInt();
        if (snl <= 9 && snl >= 0)
        {
        }
        else
        {
         System.out.println("error, number too high/ too low");
         System.out.println("this proces will begin anew");
         savenload();
        }

    }
   private static void encode()
   {
    System.out.println("With this function, you encode a message");
    savenload();
    String load = saves[snl];
    char letter = ' ';
    String newwrite = "";

    for (int i = 0; i < load.length(); i++)
    {
        letter = load.charAt(i);
        if (letter >= 97 && letter <= 126 )
        {
            letter = (char) (letter - 64);
        }
        else
        {
            if (letter >= 32 && letter <= 41) {
                letter = (char) (letter + 80);
            }
            else
            {
                letter = (char) (letter + 20);
            }
        }
        System.out.println(letter);

        newwrite = newwrite + letter;
        saves[snl]=newwrite;
    }
    menue();
   }
   private static void decode() {
       System.out.println("With this function, you decode a message");
       savenload();
       String load = saves[snl];
       char letter = ' ';
       String newwrite = "";

       for (int i = 0; i < load.length(); i++) {
           letter = load.charAt(i);
           if (letter >= 33 && letter <= 62 ) {
               letter = (char) (letter + 64);
           }
           else
           {
               if (letter >= 112 && letter <= 121) {
                   letter = (char) (letter - 80);
               }
               else
               {
                   letter = (char) (letter - 20);
               }
           }
           System.out.println(letter);

           newwrite = newwrite + letter;
           saves[snl] = newwrite;
       }
       menue();
   }

   private static void read()
   {
       System.out.println("With this function you can output a saved string");
       savenload();
       System.out.println("Your String states:");
       System.out.println(saves[snl]);

       menue();
   }
}