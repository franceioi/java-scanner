//import java.util.Scanner;
//import algorea.Scanner;

class Speed 
{
   public static void main(String[] args) 
   {
      if (args.length != 1)
      {
         System.out.println("One argument needed : 'algorea' or 'java'");
         return;
      }
      if (args[0].equals("algorea"))
      { 
         algorea.Scanner sc = new algorea.Scanner(System.in);
         int nbVals = sc.nextInt();
         int sum = 0;
         for (int i = 0; i < nbVals; i++)
            sum += sc.nextInt();
         System.out.println(sum);
      }
      else if (args[0].equals("java"))
      {
         java.util.Scanner sc = new java.util.Scanner(System.in);
         int nbVals = sc.nextInt();
         int sum = 0;
         for (int i = 0; i < nbVals; i++)
            sum += sc.nextInt();
         System.out.println(sum);
      }
      else
         System.out.println("Wrong argument.");
      
   }
}
