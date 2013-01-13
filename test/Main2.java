//import java.util.Scanner;
import algorea.Scanner;

class Main 
{
   public static void main(String[] args) 
   {
      Scanner sc = new Scanner(System.in);
      String line = sc.nextLine();

      assert (line.length() == 6);
      assert (line.equals("azerty"));
   }
}
