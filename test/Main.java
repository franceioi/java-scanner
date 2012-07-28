//import java.util.Scanner;
import algorea.Scanner;

class Main 
{
   public static void main(String[] args) 
   {
      Scanner sc = new Scanner(System.in);
      int i = sc.nextInt();
      long l = sc.nextLong();
      float f = sc.nextFloat();
      double d = sc.nextDouble();
      String line = sc.nextLine();
      char c1 = sc.nextChar();
      char c2 = sc.nextChar();

      assert (i == 42);
      assert (l == 42000000000L);
      assert (f == 42.5);
      assert (d == 42.5);
      assert (line.equals("Test line"));
      assert (c1 == ' ');
      assert (c2 == 'a');
   }
}
