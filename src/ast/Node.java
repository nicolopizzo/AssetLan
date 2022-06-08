package ast;

import utils.EffectsEnvironment;
import utils.Environment;
import utils.SemanticError;

import java.util.ArrayList;

public interface Node {
    ArrayList<SemanticError> checkSemantics(Environment env);

    TypeNode typeCheck(Environment env);

    void checkEffects(EffectsEnvironment env);

    String codeGeneration(Environment env);
}
