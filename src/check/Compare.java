package check;
import java.io.*;

public class Main {
  public static void main(String[] args) {
    /*test("C:\\D\\Main.com", "C:\\D\\MainA.com", 1);
    test("C:\\D\\MainA.com", "C:\\D\\Main_Asm.com", 2);
    test("C:\\D\\Main.com", "C:\\D\\Main_Asm.com", 3);*/
    
    String[] files = {"AssemblyCode.cs", "AssemblyCodeGenerator.cs", "AssemblyCodeGeneratorOld.cs",
                     "AssemblyOperator.cs", "Assert.cs", "ConstantExpression.cs", "Declarator.cs",
                     "Expression.cs", "ExpressionParser.cs", "ExpressionScanner.cs",
                     "GenerateAutoInitializer.cs", //"GenerateStaticInitializer.cs",
                     "GlobalUsing.cs", "Graph.cs", "IfElseChain.cs", "Linker.cs",
                     "Macro.cs", "Main.cs", "MainParser.cs", "MainScanner.cs", "Mask.cs",
                     "Message.cs", "MiddleCode.cs", "MiddleCodeGenerator.cs",
                     "MiddleCodeOptimizer.cs", "MiddleOperator.cs","ModifyInitializer.cs",
                     "ObjectCodeComparer.cs", "ObjectCodeInfo.cs", // "ObjectCodeTable.cs",
                     "Pair.cs", "PartialExpressionParser.cs", "PartialMainParser.cs",
                     "PartialPreprocessorParser.cs", "PreParser.cs", "Preprocessor.cs",
                     "PreScanner.cs", "Register.cs", "RegisterAllocator.cs", "Scope.cs",
                     "Slash.cs", "Sort.cs", "Specifier.cs", "Statement.cs", "StaticBase.cs",
                     "StaticExpression.cs", "StaticSymbol.cs", "StaticSymbolLinux.cs",
                     "StaticSymbolWindows.cs", "Storage.cs", "Symbol.cs", "SymbolTable.cs",
                     "Token.cs", "Track.cs", "Type.cs", "TypeCast.cs", "TypeSize.cs"};
    
    for (String file : files) {
      test(file);
    }
  }

  
  public static void test(String file) {
    try {
      //System.out.println(file);
      String path1 = "C:\\Users\\stefa\\Documents\\A A C_Compiler_CSharp_10\\C_Compiler_CSharp_10\\",
             path2 = "C:\\Users\\stefa\\Documents\\A A C_Compiler_CSharp_10 Original\\C_Compiler_CSharp_10\\";
      FileInputStream inStream1 = new FileInputStream(path1 + file),
                      inStream2 = new FileInputStream(path2 + file);
      DataInputStream dataStream1 = new DataInputStream(inStream1),
                      dataStream2 = new DataInputStream(inStream2);

      //PrintStream printStream = new PrintStream("C:\\Users\\Stefa\\Documents\\vagrant\\homestead\\code\\code\\Test" +  + ".debug");
      //PrintStream printStream = new PrintStream("C:\\Users\\Stefa\\Documents\\A A C_Compiler_Assembler - A 16 bits\\StdIO\\Test" + i + ".debug");

      /*System.out.println();
      System.out.println(path1 + file);
      System.out.println(path2 + file);*/
      
      String line1 = dataStream1.readLine(), line2 = dataStream2.readLine();
      int index1 = 1, index2 = 1;
      while ((line1 != null) && (line2 != null)) {        
        while ((line1 != null) && (line1.trim().isEmpty() || line1.trim().startsWith("//"))) {
          line1 = dataStream1.readLine();
          ++index1;
        }

         if (line1 == null) {
          break;
        }

        while ((line2 != null) && (line2.trim().isEmpty() || line2.trim().startsWith("//"))) {
          line2 = dataStream2.readLine();
          ++index2;
        }
        
        if (line2 == null) {
          break;
        }

        if (!line1.trim().equals(line2.trim())) {
          line1 = line1.trim();
          line2 = line2.trim();
          System.out.println(file + " " + index1 + " " + index2 + ": <" + line1 + "> <" + line2 + ">");
          System.out.println(line1.length() + " " + line2.length());
          
          for (int index = 0; index < line1.length(); ++index) {
            System.out.println(index + " " + line1.charAt(index) + " " + ((int) line1.charAt(index1)));
          }
          System.out.println();
          
          for (int index = 0; index < line2.length(); ++index) {
            System.out.println(index + " " + line2.charAt(index) + " " + ((int) line2.charAt(index2)));
          }
          System.exit(0);
        }

        line1 = dataStream1.readLine();
        line2 = dataStream2.readLine();
        
        ++index1;
        ++index2;
      }

      while (line1 != null) {
        if (!line1.trim().isEmpty() && !line1.trim().startsWith("//")) {
          System.out.println(file + " 1: " + index1 + " <" + line1 + ">");
        }

        line1 = dataStream1.readLine();
        ++index1;
      }

      while (line2 != null) {
        if (!line2.trim().isEmpty() && !line2.trim().startsWith("//")) {
          System.out.println(file + " 2: " + index2 + " <" + line2 + ">");
        }

        line2 = dataStream2.readLine();
        ++index2;
      }
    }
    catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
