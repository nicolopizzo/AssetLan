package ast;

import utils.Environment;
import utils.STEntry;
import utils.SemanticError;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MoveNode implements Node {

    private String id1;
    private String id2;

    public MoveNode(String id1, String id2) {
        this.id1 = id1;
        this.id2 = id2;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors = new ArrayList<>();

        if (!env.isEntityDeclared(id1))
            env.addEntry(id1, new STEntry(env.getNestLevel(), env.getOffset()));
        else
            semanticErrors.add(SemanticError.duplicateDeclaration(id1));


        if (!env.isEntityDeclared(id2))
            env.addEntry(id2, new STEntry(env.getNestLevel(), env.getOffset()));
        else
            semanticErrors.add(SemanticError.duplicateDeclaration(id2));

        return semanticErrors;
    }
}