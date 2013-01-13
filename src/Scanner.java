package algorea;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.lang.Character;

/**
 * Classe de remplacement pour Scanner
 * - est plus rapide
 * - permet de soumettre un programme à un juge qui ne connait que JDK1.1
 * 
 */
class Locale {
   final static int US=0;
}

public class Scanner {
   // le BufferedInputStream a l'avantage par rapport au InputStream
   // de faire moins d'appels systeme lors de la lecture
   private BufferedInputStream in;

   // c contient le prochain caractere que read() va rendre, ou -1 si EOF
   int c;

   boolean enDebutDeLigne;

   public Scanner(InputStream stream) {
      in = new BufferedInputStream(stream);
      try {
         enDebutDeLigne = true;
         c  = (char)in.read();
      } catch (IOException e) {
         c  = -1;
      }
   }

   public boolean hasNext() {
      if (!enDebutDeLigne) 
         throw new Error("hasNext ne fonctionne seulement apres un appel a nextLine");
      return c != -1;
   }

   public String next() {
      StringBuffer sb = new StringBuffer();
      enDebutDeLigne = false;
      try {
         // ignorer les blancs en debut
         while (c <= ' ') {
            c = in.read();
            if (c == -1)
              throw new NoSuchElementException();
         } 
         // consommer tout ce qui n'est pas blanc
         while (c > ' ') {
            sb.append((char)c);
            c = in.read();
         }
         // ignore blanks at the end
         while (Character.isWhitespace(c)) {
            c = in.read();
            if (c == -1)
              break;
         } 
      } catch (IOException e) {
         c = -1;
         return "";
      }
      return sb.toString();
   }

   public char nextChar()
   {
      char car;
      try {
         car = (char)c;
         c = in.read();
      } catch (IOException e) {
         c = -1;
         return ' ';
      }
      return car;
   }

   public String nextLine() {
      StringBuffer sb = new StringBuffer();
      enDebutDeLigne = true;
      try {
         // consommer toute la ligne
         while (c != '\n') {
            sb.append((char)c);
            c = in.read();
            if (c == -1)
               throw new NoSuchElementException();// EOF
         }
         // consommer aussi le retour chariot
         c = in.read();
      } catch (IOException e) {
         c = -1;
         return "";
      } catch (NoSuchElementException e) {//EOF
         return sb.toString();
      }
      return sb.toString();   
   }

   public int nextInt() {
      String s = next();
      try {
         return Integer.parseInt(s);
      } catch (NumberFormatException e) {
         throw new InputMismatchException();
      }
   }

   public long nextLong() {
      try {
        return Long.parseLong(next());
      } catch (NumberFormatException e) {
        throw new InputMismatchException();
      }
   }

   public float nextFloat() {
      try {
        return new Float(next());
      } catch (NumberFormatException e) {
        throw new InputMismatchException();
      }
   }

   public double nextDouble() {
      try {
        return new Double(next());
      } catch (NumberFormatException e) {
        throw new InputMismatchException();
      }
   }
   


   public void useLocale(int l) {} // on peut ignorer cet appel
}
