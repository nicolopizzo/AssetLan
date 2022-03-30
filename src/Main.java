import errorhandler.LexerErrorListener;
import errorhandler.SyntaxError;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.AssetLanLexer;
import parser.AssetLanParser;

import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "src/res/inputProgram.assetlan";

        AssetLanLexer lexer = new AssetLanLexer(CharStreams.fromFileName(fileName));
        LexerErrorListener lexerErrorListener = new LexerErrorListener();

        lexer.removeErrorListeners();
        lexer.addErrorListener(lexerErrorListener);

        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        AssetLanParser parser = new AssetLanParser(tokenStream);

        parser.init();
//        List<SyntaxError> lexicalErrors = lexerErrorListener.getLexerErrors();
        if (lexerErrorListener.getLexerErrors().size() > 0) {
            PrintWriter writer = new PrintWriter("lexicalErrors.txt");
            for (SyntaxError e : lexerErrorListener.getLexerErrors()) {
                writer.println(e.getMessage());
            }

            writer.close();
            System.out.println("Lexical Errors encountered. Aborting parsing. You can check the 'lexicalErrors.txt' file.");
        } else {
            System.out.println("All good.");
        }
    }
}
