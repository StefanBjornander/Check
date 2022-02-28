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
    
String list[] = {"mainX",
"mainXXX",
"main",
"malloc",
"calloc",
"free",
"realloc",
"print_heap",
"islower",
"isupper",
"isalpha",
"isdigit",
"isalnum",
"isxdigit",
"isgraph",
"isprint",
"ispunct",
"iscntrl",
"isspace",
"tolower",
"toupper",
"setlocale",
"localeconv",
"exp",
"log",
"log10",
"pow",
"ldexp",
"log2",
"frexp",
"sqrt",
"modf",
"fmod",
"sin",
"cos",
"tan",
"asin",
"acos",
"atan",
"atan2",
"sinh",
"cosh",
"tanh",
"floor",
"ceil",
"round",
"fabs",
"setjmp",
"longjmp",
"signal",
"raise",
"filecreate",
"fileexistsX",
"fileexists",
"fileopen",
"fopen",
"freopen",
"fflush",
"fclose",
"remove",
"rename",
"setvbuf",
"setbuf",
"fgetc",
"fgets",
"fputs",
"getchar",
"gets",
"puts",
"ungetc",
"fread",
"fwrite",
"fseek",
"ftell",
"rewind",
"fgetpos",
"fsetpos",
"clearerr",
"feof",
"ferror",
"perror",
"generateName",
"tmpnam",
"tmpfile",
"scanChar",
"unscanChar",
"strnchr",
"scanPattern",
"scanString",
"isDigitInBase",
"digitToValue",
"scanLongInt",
"scanUnsignedLongInt",
"scanLongDouble",
"scanFormat",
"scanf",
"vscanf",
"fscanf",
"vfscanf",
"sscanf",
"vsscanf",
"putc",
"fputc",
"putchar",
"printChar",
"printString",
"printLongIntRec",
"printLongInt",
"digitToChar",
"printUnsignedLongRec",
"printUnsignedLong",
"printLongDoubleFraction",
"printLongDoublePlain",
"printLongDoubleExpo",
"checkWidthAndPrecision",
"printArgument",
"printFormat",
"printf",
"vprintf",
"fprintf",
"vfprintf",
"sprintf",
"vsprintf",
"atoi",
"atol",
"strtol",
"strtoul",
"atof",
"strtod",
"strtol_test",
"strtoul_test",
"abort",
"getenv",
"system",
"bsearch",
"rand",
"srand",
"atexit",
"exit",
"memswap",
"qsort",
"@abs",
"labs",
"div",
"ldiv",
"clock",
"isLeapYear",
"time",
"mktime",
"gmtime",
"localtime",
"difftime",
"asctime",
"ctime",
"getWeekNumber",
"strftime",
"strcpy",
"strncpy",
"strcat",
"strncat",
"strcmp",
"strncmp",
"strchr",
"strrchr",
"strspn",
"strcspn",
"strpbrk",
"strstr",
"strlen",
"strerror",
"strtok",
"memcpy",
"memmove",
"memcmp",
"memchr",
"memset",
"print_test",
"character_testX",
"character_test",
"float_test",
"limits_test",
"assert_test",
"assert_testX",
"assert_test2",
"string_test",
"locale_test",
"main",
"inverse",
"divide",
"test",
"setjmp_test",
"math_test_1x",
"acos_test",
"atan_test",
"math_test",
"math_test_1",
"math_test_2",
"file_test",
"temp_file",
"stdio_test",
"floating_point_error",
"exit_handle1",
"exit_handle2",
"exit_handle3",
"signal_test",
"stack_test",
"heap_test",
"malloc_test2",
"malloc_test3",
"rec",
"malloc_test4",
"malloc_test",
"malloc_test6",
"compare",
"reverse_compare",
"print_div",
"print_ldiv",
"exit_handle1x",
"exit_handle2x",
"exit_handle3x",
"hello",
"qtest",
"stdlib_testZ",
"stdlib_test",
"time_test"};

    for (String file : list) {
      test(file);
    }
  }

  
  public static void test(String file) {
    try {
      //System.out.println(file);
      String path1 = "C:\\Users\\stefa\\Documents\\Vagrant\\Homestead\\code\\code\\",
             path2 = "C:\\Users\\stefa\\Documents\\Vagrant\\Homestead\\code\\codeX\\";
      //String path1 = "C:\\Users\\stefa\\Documents\\A A C_Compiler_CSharp_10\\C_Compiler_CSharp_10\\",
      //       path2 = "C:\\Users\\stefa\\Documents\\A A C_Compiler_CSharp_10 Original\\C_Compiler_CSharp_10\\";
      FileInputStream inStream1 = new FileInputStream(path1 + file + ".middleafter"),
                      inStream2 = new FileInputStream(path2 + file + ".middleafter");
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
          
/*          for (int index = 0; index < line1.length(); ++index) {
            System.out.println(index + " " + line1.charAt(index) + " " + ((int) line1.charAt(index)));
          }
          System.out.println();
          
          for (int index = 0; index < line2.length(); ++index) {
            System.out.println(index + " " + line2.charAt(index) + " " + ((int) line2.charAt(index)));
          }
          System.exit(0);*/
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
