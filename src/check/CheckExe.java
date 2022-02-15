package checkexe;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    try {
      FileInputStream inStream1 = new FileInputStream("C:\\D\\BinCom16.Com");      
      Vector<Byte> list1 = new Vector<>();
      
      while (inStream1.available() > 0) {
        list1.add((byte) inStream1.read());
      }
      inStream1.close();

      FileInputStream inStream2 = new FileInputStream("C:\\D\\BinCom32.Com");
      Vector<Byte> list2 = new Vector<>();
      
      while (inStream2.available() > 0) {
        list2.add((byte) inStream2.read());
      }
      inStream2.close();
      
      PrintStream printStream = new PrintStream("C:\\Users\\Stefan\\Documents\\A A C_Compiler_Assembler - A 16 bits\\StdIO\\Test1632.debug");
      int index1 = list1.size(), index2 = list2.size();
      System.out.println("size1: " + index1);
      System.out.println("size2: " + index2);

      while ((index1 > 0) || (index2 > 0)) {
        --index1;
        --index2;

        if ((index1 >= 0) && (index2 >= 0)) {
          if (list1.get(index1) == list2.get(index2)) {
            printStream.println(list1.get(index1) + "\t" + list2.get(index2));
            System.out.println(list1.get(index1) + "\t" + list2.get(index2));
          }
          else {
            printStream.println("!" + list1.get(index1) + "\t" + list2.get(index2));
            System.out.println("!" + list1.get(index1) + "\t" + list2.get(index2));
          }
        }
        else if (index1 >= 0) {
          printStream.println(list1.get(index1));
          System.out.println(list1.get(index1));
        }
        else {
          printStream.println("\t" + list2.get(index2));
          System.out.println("\t" + list2.get(index2));
        }
      }
      printStream.close();
    }
    catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
