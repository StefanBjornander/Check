package check;
import java.io.*;

public class Main {
  private static int m_count = 0;
  private static PrintStream printStreamAssembly;
  
  public static void main(String[] args) {
    testObject("C:\\D\\Main.com", "C:\\D\\MainA.com", 1);
    //testObject("C:\\D\\MainA.com", "C:\\D\\Main_Asm.com", 2);
    //testObject("C:\\D\\Main.com", "C:\\D\\Main_Asm.com", 3);
    
    args = new String[]{"Main.asm", "Malloc.asm", "CType.asm", "ErrNo.asm", "Locale.asm", "Math.asm", "SetJmp.asm",      
                        "Signal.asm", "File.asm", "Temp.asm", "Scanf.asm", "Printf.asm", "StdLib.asm", "Time.asm",
                        "String.asm", "PrintTest.asm", "CharacterTest.asm", "FloatTest.asm", "LimitsTest.asm",
                        "AssertTest.asm", "StringTest.asm",
                        "SetJmpTest.asm", "MathTest.asm", "FileTest.asm", "StdIOTest.asm",
                        "SignalTest.asm", "StackTest.asm", "MallocTest.asm",
                        "StdLibTest.asm", "TimeTest.asm"};

    try {
      printStreamAssembly = new PrintStream("C:\\Users\\Stefa\\Documents\\vagrant\\homestead\\code\\Test.result");

      for (String arg : args) {
        printStreamAssembly.println(arg);
        checkAssembly(arg);
      }
      
      printStreamAssembly.close();

      if (m_count == 0) {
        System.out.println("Assembly Equal");
      }
      else {
        System.out.println("Assembly Count: " + m_count);
      }
    }
    catch (IOException e) {
      System.out.println(e.getMessage());
    }    
  }

  public static void testObject(String file1, String file2, int i) {
    try {
      FileInputStream inStream1 = new FileInputStream(file1),
                      inStream2 = new FileInputStream(file2);

      PrintStream printStreamObject = new PrintStream("C:\\Users\\Stefa\\Documents\\vagrant\\homestead\\code\\code\\Test" + i + ".debug");

      int index = 256, errors = 0;
      while ((inStream1.available() > 0) && (inStream2.available() > 0)) {
        byte byte1 = (byte) inStream1.read(), byte2 = (byte) inStream2.read();
        int int1 = ((int) byte1), int2 = ((int) byte2);
             
        if (int1 < 0) {
          int1 = 256 + int1;
        }

        if (int2 < 0) {
          int2 = 256 + int2;
        }

        if (int1 == int2) {
          printStreamObject.println(index + ": " + int1 + " " + int2);
        }
        else {
          ++errors;
          printStreamObject.println(index + ": ======" + int1 + " " + int2 + "======");
        }

        ++index;
      }

      while (inStream1.available() > 0) {
        byte byte1 = (byte) inStream1.read();
        printStreamObject.println(index + ": ======" + byte1 + " ? ======");
        ++index;
        ++errors;
      }

      while (inStream2.available() > 0) {
        byte byte2 = (byte) inStream2.read();
        printStreamObject.println(index + ": ====== ? " + byte2 + "======");
        ++index;
        ++errors;
      }

      System.out.println("Object " + ((errors > 0) ? errors : "Equal"));
      inStream1.close();
      inStream2.close();
      printStreamObject.close();
    }
    catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
  
  private static void checkAssembly(String arg) throws IOException {
    String oldPath = "C:\\Users\\Stefa\\Documents\\vagrant\\homestead\\code\\code_old\\" + arg,
           newPath = "C:\\Users\\Stefa\\Documents\\vagrant\\homestead\\code\\code\\" + arg;
    FileReader oldFileStream = new FileReader(oldPath),
               newFileStream = new FileReader(newPath);
    BufferedReader oldStream = new BufferedReader(oldFileStream),
                   newStream = new BufferedReader(newFileStream);
    
    int oldIndex = 1, newIndex = 1;
    String oldLine, newLine;
    while (((oldLine = oldStream.readLine()) != null) &&
           ((newLine = newStream.readLine()) != null)) {
      while ((oldLine != null) && (oldLine.trim().isEmpty() || oldLine.trim().startsWith(";"))) {
        oldLine = oldStream.readLine();
        ++newIndex;
      }

      if (oldLine == null) {
        break;
      }

      while ((newLine != null) && (newLine.trim().isEmpty() || newLine.trim().startsWith(";"))) {
        newLine = newStream.readLine();
        ++oldIndex;
      }

      if (newLine == null) {
        break;
      }

      if (!oldLine.equals(newLine)) {
        printStreamAssembly.println("old " + oldIndex + " <" + oldLine + ">");
        printStreamAssembly.println("new " + newIndex + " <" + newLine + ">");
        printStreamAssembly.println();
        /*System.out.println("old " + oldIndex + " <" + oldLine + ">");
        System.out.println("new " + newIndex + " <" + newLine + ">");
        System.out.println();*/
        ++m_count;
      }

      ++oldIndex;
      ++newIndex;
    }

    while ((oldLine = oldStream.readLine()) != null) {
      while ((oldLine != null) && (oldLine.trim().isEmpty() || oldLine.trim().startsWith(";"))) {
        oldLine = oldStream.readLine();
        ++oldIndex;
      }

      if (oldLine == null) {
        break;
      }

      //printStreamAssembly.println("old rest " + oldIndex + " <" + oldLine + ">");
    }

    while ((newLine = newStream.readLine()) != null) {
      while ((newLine != null) && (newLine.trim().isEmpty() || newLine.trim().startsWith(";"))) {
        newLine = newStream.readLine();
        ++newIndex;
      }

      if (newLine == null) {
        break;
      }

      //printStreamAssembly.println("new rest " + newIndex + " <" + newLine + ">");
    }

    oldStream.close();
    newStream.close();
  }  
}
