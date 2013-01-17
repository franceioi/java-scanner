package algorea;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.lang.Character;

/**
 * Class to replace the java.Util.Scanner
 * - much much faster
 * - uses much less memory
 * - contains all necessary functions for algorithmic exercises 
 *   (but not all the original functions)
 * 
 */
class Locale {
   final static int US = 0;
}

public class Scanner {
   // BufferedInputStream is using less system calls than InputStream
   // when reading data
   private BufferedInputStream in;

   // c contains the next character that read() will return or -1 if EOF
   int c;

   boolean atStartOfLine;

   public Scanner(InputStream stream) {
      in = new BufferedInputStream(stream);
      try {
         atStartOfLine = true;
         c  = (char)in.read();
      } catch (IOException e) {
         c  = -1;
      }
   }

   public boolean hasNext() {
      if (!atStartOfLine) 
         throw new Error("hasNext ne fonctionne seulement apres un appel a nextLine");
      return c != -1;
   }

   public String next() {
      StringBuffer sb = new StringBuffer();
      atStartOfLine = false;
      try {
         // ignore blanks at the start
         while (c <= ' ') {
            c = in.read();
            if (c == -1)
              throw new NoSuchElementException();
         } 
         // eat everything that is not a space
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
      atStartOfLine = true;
      try {
         // eat all the line
         while (c != '\n') {
            sb.append((char)c);
            c = in.read();
            if (c == -1)
               throw new NoSuchElementException();// EOF
         }
         // eat the \n
         c = in.read();
      } catch (IOException e) {
         c = -1;
         return "";
      } catch (NoSuchElementException e) {//EOF
         //Nothing to do
          if (sb.length() == 1 && (int)sb.charAt(0) == ((1 << 16) - 1))
            throw new NoSuchElementException();
         // Last line with no newline...
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
   


   public void useLocale(int l) {} // we can ignore this call
}
