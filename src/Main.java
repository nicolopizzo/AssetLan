import ast.AssetLanVisitorConcrete;
import ast.Node;
import errorhandler.LexerErrorListener;
import errorhandler.SyntaxError;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.AssetLanLexer;
import parser.AssetLanParser;
import utils.EffectsEnvironment;
import utils.Environment;
import utils.SemanticError;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

class ExitCode {
    public static final int SUCCESS = 0;
    public static final int LEXER_ERROR = 1;
    public static final int SYNTAX_ERROR = 2;
    public static final int SEMANTIC_ERROR = 3;
    public static final int TYPE_ERROR = 4;
    public static final int UNKNOWN_ERROR = 5;
}

public class Main {
    public static void main(String[] args) throws IOException {

        //import file containing the example program to compile
        String fileName = "src/res/input.assetlan";

        //create an instance of a lexer
        //AssetLanLexer is a class that extends the Antlr Lexer
        AssetLanLexer lexer = new AssetLanLexer(CharStreams.fromFileName(fileName));

        //LexerErrorListener is a class that extends the Antlr BaseErrorListener that manage lexical errors
        LexerErrorListener lexerErrorListener = new LexerErrorListener();

        //remove default error Listeners to instead use the lexerErrorListener declared above
        lexer.removeErrorListeners();
        lexer.addErrorListener(lexerErrorListener);

        //create the parser
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        AssetLanParser parser = new AssetLanParser(tokenStream);
        AssetLanParser.InitContext syntaxTree = parser.init();

        // parser.init() returns (automatically implemented) a ctx that includes all nodes properties (children nodes)
        // this ctx is the parameter for visit()
        // visit() (automatically implemented) visits the syntax tree (the ctx) and returns a new abstract syntax tree
        // (the root) with custom nodes
        // nodes refers to custom classes implementing the 'Node' interface
        // visit() calls visitInit(). See AssetLanVisitorConcrete

        //if there are syntax errors stop the compiler and return errors in lexicalErrors.txt file
        List<SyntaxError> lexicalErrors = lexerErrorListener.getLexerErrors();
        if (lexicalErrors.size() > 0) {
            PrintWriter writer = new PrintWriter("lexicalErrors.txt");
            for (SyntaxError e : lexicalErrors) {
                writer.println(e.getMessage());
            }
            writer.close();
            System.out.println("Lexical Errors encountered. Aborting parsing. You can check the 'lexicalErrors.txt' file.");
            System.exit(ExitCode.LEXER_ERROR);
        }
        System.out.println("No lexical errors encountered.");
        System.out.println("No syntax errors encountered.");

        AssetLanVisitorConcrete visitor = new AssetLanVisitorConcrete();
        Node ast = visitor.visit(syntaxTree);
        //Environment contains the sym table populated by checkSemantics (from custom classes)
        Environment env = new Environment();
        //semanticErrors is a list containing semantic errors (to print on terminal)
        ArrayList<SemanticError> semanticErrors = ast.checkSemantics(env);
        if (semanticErrors.size() > 0) {
            //Print all semantic program errors
            System.out.println("Semantic errors encountered. Semantic errors are:\n");
            for (SemanticError e : semanticErrors) {
                System.out.println(e.getMsg());
            }
            System.exit(ExitCode.SEMANTIC_ERROR);
        }
        System.out.println("No semantic errors encountered.");

        // Type checking
        ast.typeCheck(env);

        // TODO: codice1 non funziona, checkLiquidity: potrebbe essere necessario memorizzare all'interno di call il
        //       FunctionNode
        //System.out.println(type.toPrint("Type checking ok! Type of the program is: "));


        EffectsEnvironment sigma = new EffectsEnvironment();
        ast.checkEffects(sigma);

        // CODE GENERATION  prova.SimpLan.asm
//        String code=ast.codeGeneration(env);
//        BufferedWriter out = new BufferedWriter(new FileWriter(fileName+".asm"));
//        out.write(code);
//        out.close();
//        System.out.println("Code generated! Assembling and running generated code.");
//
//        //create an instance of a lexer
//        //AssetLanLexer is a class that extends the Antlr Lexer
//        SVMLexer lexerSVM = new SVMLexer(CharStreams.fromFileName(fileName+".asm"));
//        CommonTokenStream tokensSVM = new CommonTokenStream(lexerSVM);
//        SVMParser parserSVM = new SVMParser(tokensSVM);
//
//        SVMVisitorConcrete visitorSVM = new SVMVisitorConcrete();
//        visitorSVM.visit(parserSVM.assembly());
//
//        System.out.println("You had: "+lexerSVM.lexicalErrors+" lexical errors and "+parserSVM.getNumberOfSyntaxErrors()+" syntax errors.");
//        if (lexerSVM.lexicalErrors>0)
//            System.exit(ExitCode.LEXER_ERROR);
//        if (parserSVM.getNumberOfSyntaxErrors()>0)
//            System.exit(ExitCode.SYNTAX_ERROR);
//
//        System.out.println("Starting Virtual Machine...");
//
//        ExecuteVM vm = new ExecuteVM(visitorSVM.code);
//        vm.cpu();

        System.exit(ExitCode.SUCCESS);
    }
}