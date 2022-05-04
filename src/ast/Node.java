package ast;

import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public interface Node {
    ArrayList<SemanticError> checkSemantics(Environment env);

    Node typeCheck(Environment env);
}
