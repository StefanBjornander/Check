package checklog;
import java.io.*;

public class CheckLog {
  private static PrintStream PrintStream;
  public static int m_count = 0, m_total = 0;

  public static void main(String[] args) {
    try {
      PrintStream = new PrintStream("C:\\Users\\Stefa\\Documents\\vagrant\\homestead\\code\\Test.result");
      //checkX("C:\\Users\\Stefa\\Documents\\vagrant\\homestead\\code\\code\\log64x",
      //       "C:\\Users\\Stefa\\Documents\\vagrant\\homestead\\code\\code\\log64");
      //checkX("c:\\d\\log16x", "c:\\d\\log16");
      //checkX("C:\\Users\\Stefa\\Documents\\vagrant\\homestead\\code\\code\\log64", "c:\\d\\log16");
      checkX("C:\\Users\\Stefa\\Documents\\vagrant\\homestead\\code\\code\\log64",
             "C:\\Users\\Stefa\\Documents\\vagrant\\homestead\\code\\code_old\\log64");
      //checkX("C:\\Users\\Stefa\\Documents\\vagrant\\homestead\\code\\code\\Time.asm",
      //       "C:\\Users\\Stefa\\Documents\\vagrant\\homestead\\code\\code\\TimeOld.asm");
      /*test("C:\\D\\Main.com", "C:\\D\\MainA.com", 1);
      test("C:\\D\\MainA.com", "C:\\D\\Main_Asm.com", 2);
      test("C:\\D\\Main.com", "C:\\D\\Main_Asm.com", 3);*/
    }
    catch (IOException e) {
      System.out.println(e.getMessage());
    }

/*    test("C:\\D\\Main.com", "C:\\D\\MainA.com", 1); // Documents\Check
    test("C:\\D\\MainA.com", "C:\\D\\Main_Asm.com", 2);
    test("C:\\D\\Main.com", "C:\\D\\Main_Asm.com", 3);*/

    args = new String[]{"Main.asm", "Malloc.asm", "CType.asm", "ErrNo.asm", "Locale.asm", "Math.asm", "SetJmp.asm",      
                        "Signal.asm", "File.asm", "Temp.asm", "Scanf.asm", "Printf.asm", "StdLib.asm", "Time.asm",
                        "String.asm", "PrintTest.asm", "CharacterTest.asm", "FloatTest.asm", "LimitsTest.asm",
                        "AssertTest.asm", "StringTest.asm",
                        "SetJmpTest.asm", "MathTest.asm", "FileTest.asm", "StdIOTest.asm",
                        "SignalTest.asm", "StackTest.asm", "MallocTest.asm",
                        "StdLibTest.asm", "TimeTest.asm"};

/*    args = new String[]{"Main.after", "Malloc.after", "CType.after", "ErrNo.after", "Locale.after", "Math.after", "SetJmp.after",      
                        "Signal.after", "File.after", "Temp.after", "Scanf.after", "Printf.after", "StdLib.after", "Time.after",
                        "String.after", "PrintTest.after", "CharacterTest.after", "FloatTest.after", "LimitsTest.after",
                        "AssertTest.after", "StringTest.after",
                        "SetJmpTest.after", "MathTest.after", "FileTest.after", "StdIOTest.after",
                        "SignalTest.after", "StackTest.after", "MallocTest.after",
                        "StdLibTest.after", "TimeTest.after", "Main_asm.asm"};*/

/*    try {
      PrintStream = new PrintStream("C:\\Users\\Stefa\\Documents\\vagrant\\homestead\\code\\Test.result");
      //check2(null);

      m_count = 0;
      for (String arg : args) {
        PrintStream.println(arg);
        checkAssembly(arg);
      }
      
      PrintStream.close();
      //System.out.println("Total: " + m_total);

      if (m_count == 0) {
        System.out.println("New Old Equal");
      }
      else {
        System.out.println("New Old Count: " + m_count);
      }
    }
    catch (IOException e) {
      System.out.println(e.getMessage());
    }*/
  }

  private static void checkX(String path1, String path2) throws IOException {
    FileInputStream oldFileStream = new FileInputStream(path1),
                    newFileStream = new FileInputStream(path2);
    DataInputStream oldStream = new DataInputStream(oldFileStream),
                    newStream = new DataInputStream(newFileStream);

    int index = 1;
    String oldLine, newLine;
    while (((oldLine = oldStream.readLine()) != null) &&
           ((newLine = newStream.readLine()) != null)) {
      if (!oldLine.equals(newLine)) {
        PrintStream.println(index + ":");
        PrintStream.println("old  <" + oldLine + ">");
        PrintStream.println("new  <" + newLine + ">");
        PrintStream.println();
        System.out.println(index + ":");
        System.out.println("old  <" + oldLine + ">");
        System.out.println("new  <" + newLine + ">");
        System.out.println();
        ++m_count;
      }
      ++index;
      
      if (!oldLine.isEmpty() || !newLine.isEmpty()) {
        ++m_total;
      }
    }

    if (m_count == 0) {
      PrintStream.println("Equal");
      System.out.println("Equal");
    }
    else {
      PrintStream.println("Log " + m_count);
      System.out.println("Log " + m_count);
    }

    oldStream.close();
    newStream.close();
  }

  public static void test(String file1, String file2, int i) {
    try {
      FileInputStream inStream1 = new FileInputStream(file1),
                      inStream2 = new FileInputStream(file2);

      PrintStream printStream = new PrintStream("C:\\Users\\Stefa\\Documents\\vagrant\\homestead\\code\\code\\Test" + i + ".debug");
      //PrintStream printStream = new PrintStream("C:\\Users\\Stefa\\Documents\\A A C_Compiler_Assembler - A 16 bits\\StdIO\\Test" + i + ".debug");

      int index = 256, errors = 0;
      while ((inStream1.available() > 0) && (inStream2.available() > 0)) {
        byte byte1 = (byte) inStream1.read(), byte2 = (byte) inStream2.read();        
        int int1 = (int) byte1, int2 = (int) byte2;
     
        if (int1 < 0) {
          int1 += 256;
        }

        if (int2 < 0) {
          int2 += 256;
        }

        if (int1 == int2) {
          printStream.println(index + ": " + int1 + " " + int2);
        }
        else {
          ++errors;
          printStream.println(index + ": ======" + int1 + " " + int2 + "======");
        }

        /*if (byte1 == byte2) {
          printStream.println(index + ": " + (byte1 + 256) + " " + (byte2 + 256));
        }
        else {
          ++errors;
          printStream.println(index + ": ======" + (byte1 + 256) + " " + (byte2 + 256) + "======");
        }*/

        ++index;
      }

      while (inStream1.available() > 0) {
        byte byte1 = (byte) inStream1.read();
        printStream.println(index + ": ======" + byte1 + " ? ======");
        ++index;
        ++errors;
      }

      while (inStream2.available() > 0) {
        byte byte2 = (byte) inStream2.read();
        printStream.println(index + ": ====== ? " + byte2 + "======");
        ++index;
        ++errors;
      }

      System.out.println((errors > 0) ? errors : "Equal");
      inStream1.close();
      inStream2.close();
      printStream.close();
    }
    catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  private static void checkAssembly(String arg) throws IOException {
    String oldPath = "C:\\Users\\Stefa\\Documents\\vagrant\\homestead\\code\\code_old\\" + arg,
           newPath = "C:\\Users\\Stefa\\Documents\\vagrant\\homestead\\code\\code\\" + arg;
    FileInputStream oldFileStream = new FileInputStream(oldPath),
                    newFileStream = new FileInputStream(newPath);
    DataInputStream oldStream = new DataInputStream(oldFileStream),
                    newStream = new DataInputStream(newFileStream);
    //PrintStream.println(arg);
    //System.out.println(arg);
//    PrintStream.print(arg);
//    System.out.print(arg);
//    PrintStream.print(oldPath);
//    System.out.print(newPath);

    //System.out.println(oldPath);
    //System.out.println(newPath);
    
    int index = 1;
    String oldLine, newLine;
    while (((oldLine = oldStream.readLine()) != null) &&
           ((newLine = newStream.readLine()) != null)) {
      if (!oldLine.equals(newLine)) {
        PrintStream.println(arg + " " + index + ":");
        PrintStream.println("old  <" + oldLine + ">");
        PrintStream.println("new  <" + newLine + ">");
        PrintStream.println();
        System.out.println(arg + " " + index + ":");
        System.out.println("old  <" + oldLine + ">");
        System.out.println("new  <" + newLine + ">");
        System.out.println();
        ++m_count;
      }
      ++index;
      
      if (!oldLine.isEmpty() || !newLine.isEmpty()) {
        ++m_total;
      }
    }

    //PrintStream.println(" " + index);
    //System.out.println(" " + index);

    oldStream.close();
    newStream.close();
  }

  private static void checkX(String arg) throws IOException {
    FileInputStream inFileStream1 = new FileInputStream("C:\\Users\\Stefa\\Documents\\A A C_Compiler_Assembler - A 16 bits\\StdIO\\Main_Asm.asm"),
                    inFileStream2 = new FileInputStream("C:\\Users\\Stefa\\Documents\\A A C_Compiler_Assembler - A 16 bits\\StdIO\\MainXAsm.asm");
    DataInputStream inStream1 = new DataInputStream(inFileStream1),
                    inStream2 = new DataInputStream(inFileStream2);

    int index = 1, index2 = 1;
    String lastLine1 = null, currLine1, lastLine2 = null, currLine2;
    while (((currLine1 = inStream1.readLine()) != null) &&
           ((currLine2 = inStream2.readLine()) != null)) {
      if (currLine1.contains(":")) {
        currLine1 = currLine1.substring(currLine1.indexOf(":") + 1);
      }
      
      if (currLine1.contains(";")) {
        currLine1 = currLine1.substring(0, currLine1.indexOf(";"));
      }

      currLine1 = currLine1.trim();

      if (currLine2.contains(":")) {
        currLine2 = currLine2.substring(currLine2.indexOf(":") + 1);
      }
      
      if (currLine2.contains(";")) {
        currLine2 = currLine2.substring(0, currLine2.indexOf(";"));
      }

      currLine2 = currLine2.trim();

      if((lastLine1 != null) && lastLine1.startsWith("j") && currLine1.startsWith("jmp")) {
        PrintStream.println("1 " + index + " " + index2 + ":");
        PrintStream.println("  <" + lastLine1 + ">");
        PrintStream.println("  <" + currLine2 + ">");
        PrintStream.println();
        inStream1.readLine();
      }
      else if ((lastLine1 != null) && lastLine2.startsWith("j") && currLine2.startsWith("jmp")) {
        /*PrintStream.println("2 " + index + ":");
        PrintStream.println("  <" + lastLine1 + ">");
        PrintStream.println("  <" + currLine2 + ">");
        PrintStream.println();*/
        inStream1.readLine();
        inStream2.readLine();
        inStream2.readLine();

        ++index;
        index2 += 2;

        lastLine1 = null;
        lastLine2 = null;
      }
      else {
        if ((lastLine1 != null) && !lastLine1.equals(lastLine2)) {
          PrintStream.println(index + " " + index2 + ":");
          PrintStream.println("  <" + lastLine1 + ">");
          PrintStream.println("  <" + lastLine2 + ">");
          PrintStream.println();
        }

        lastLine1 = currLine1;
        lastLine2 = currLine2;
      }

      ++index;
      ++index2;
    }

    inStream1.close();
    inStream2.close();
  }

  private static void check2(String arg) throws IOException {
    FileInputStream inFileStream1 = new FileInputStream("C:\\Users\\Stefa\\Documents\\A A C_Compiler_Assembler - A 16 bits\\StdIO\\Main_Asm.asm"),
                    inFileStream2 = new FileInputStream("C:\\D\\MainX.asm");
    DataInputStream inStream1 = new DataInputStream(inFileStream1),
                    inStream2 = new DataInputStream(inFileStream2);

    int index1 = 1, index2 = 1;
    String line1, line2;
    while (((line1 = inStream1.readLine()) != null) &&
           ((line2 = inStream2.readLine()) != null)) {
      if (line1.contains(":")) {
        line1 = line1.substring(line1.indexOf(":") + 1);
      }
      
      if (line1.contains(";")) {
        line1 = line1.substring(0, line1.indexOf(";"));
      }

      line1 = line1.trim();

      if (line1.equals("nop")) {
        line1 = inStream1.readLine();

        if (line1.contains(":")) {
          line1 = line1.substring(line1.indexOf(":") + 1);
        }
      
        if (line1.contains(";")) {
          line1 = line1.substring(0, line1.indexOf(";"));
        }

        line1 = line1.trim();
        ++index1;
      }

      if (!line2.trim().startsWith("db") && line2.contains(":")) {
        line2 = line2.substring(line2.indexOf(":") + 1);
      }

      if (line2.contains(";")) {
        line2 = line2.substring(0, line2.indexOf(";"));
      }

      line2 = line2.trim();

      if (!line1.equals(line2)) {
        PrintStream.println(index1 + " " + index2 + ":");
        PrintStream.println("  <" + line1 + ">");
        PrintStream.println("  <" + line2 + ">");
        PrintStream.println();
      }

      ++index1;
      ++index2;
    }

    inStream1.close();
    inStream2.close();
  }
}