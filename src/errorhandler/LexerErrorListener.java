package errorhandler;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import java.util.ArrayList;
import java.util.List;

public class LexerErrorListener extends BaseErrorListener {
    //list of Syntax errors
    private final List<SyntaxError> lexerErrors = new ArrayList<>();

    public List<SyntaxError> getLexerErrors() {
        return lexerErrors;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        this.lexerErrors.add(new SyntaxError(recognizer, offendingSymbol, line, charPositionInLine, msg, e));
    }
}
