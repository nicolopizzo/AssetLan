import ast.AssetLanVisitorConcrete;
import ast.Node;
import errorhandler.LexerErrorListener;
import errorhandler.SyntaxError;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.AssetLanLexer;
import parser.AssetLanParser;
import utils.Environment;
import utils.SemanticError;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        //import file containing the example program to compile
        String fileName = "src/res/inputProgram.assetlan";

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
        AssetLanVisitorConcrete visitor = new AssetLanVisitorConcrete();
        Node ast = visitor.visitInit(parser.init());
        //if there are syntax errors stop the compiler and return errors in lexicalErrors.txt file
        if (lexerErrorListener.getLexerErrors().size() > 0) {
            PrintWriter writer = new PrintWriter("lexicalErrors.txt");
            for (SyntaxError e : lexerErrorListener.getLexerErrors()) {
                writer.println(e.getMessage());
            }
            writer.close();
            System.out.println("Lexical Errors encountered. Aborting parsing. You can check the 'lexicalErrors.txt' file.");
        } else {
            Environment env = new Environment();
            if (ast != null) {
                ArrayList<SemanticError> errors = ast.checkSemantics(env);
                if (errors.size() > 0) {
//                  Print all semantic program errors
                    System.out.println("Semantic errors encountered. Aborting parsing. Semantic errors are:\n");
                    for (SemanticError e : errors) {
                        System.out.println(e.getMsg());
                    }
                }
                else {

                }
            }
            //there are no syntax errors, can continue to compile executing the parser
            System.out.println("All good.");
        }
    }
}
