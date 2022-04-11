package ast;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import parser.AssetLanParser.*;
import parser.AssetLanVisitor;

import java.util.ArrayList;

public class AssetLanVisitorConcrete implements AssetLanVisitor<Node> {
    @Override
    public Node visitInit(InitContext ctx) {
        return visitProgram(ctx.program());
    }

    @Override
    public ProgramNode visitProgram(ProgramContext ctx) {
        ArrayList<FieldNode> fields = new ArrayList<>();
        for (FieldContext field : ctx.field()) {
            fields.add(visitField(field));
        }

        ArrayList<AssetNode> assets = new ArrayList<>();
        for (AssetContext asset : ctx.asset()) {
            assets.add(visitAsset(asset));
        }

        ArrayList<FunctionNode> functions = new ArrayList<>();
        for (FunctionContext function : ctx.function()) {
            functions.add(visitFunction(function));
        }

        InitCallNode initCall = visitInitcall(ctx.initcall());

        return new ProgramNode(fields, assets, functions, initCall);
    }

    @Override
    public FieldNode visitField(FieldContext ctx) {
        TypeNode type = visitType(ctx.type());
        String id = ctx.ID().getText();
        ExpNode exp = null;
        return new FieldNode(type, id, exp);
    }

    @Override
    public AssetNode visitAsset(AssetContext ctx) {
        return null;
    }

    @Override
    public FunctionNode visitFunction(FunctionContext ctx) {
        return null;
    }

    @Override
    public Node visitDec(DecContext ctx) {
        return null;
    }

    @Override
    public Node visitAdec(AdecContext ctx) {
        return null;
    }

    @Override
    public Node visitStatement(StatementContext ctx) {
        return null;
    }

    @Override
    public TypeNode visitType(TypeContext ctx) {
        return null;
    }

    @Override
    public Node visitAssignment(AssignmentContext ctx) {
        return null;
    }

    @Override
    public Node visitMove(MoveContext ctx) {
        return null;
    }

    @Override
    public Node visitPrint(PrintContext ctx) {
        return null;
    }

    @Override
    public Node visitTransfer(TransferContext ctx) {
        return null;
    }

    @Override
    public Node visitRet(RetContext ctx) {
        return null;
    }

    @Override
    public Node visitIte(IteContext ctx) {
        return null;
    }

    @Override
    public Node visitCall(CallContext ctx) {
        return null;
    }

    @Override
    public InitCallNode visitInitcall(InitcallContext ctx) {
        return null;
    }

    @Override
    public Node visitBaseExp(BaseExpContext ctx) {
        return null;
    }

    @Override
    public Node visitBinExp(BinExpContext ctx) {
        return null;
    }

    @Override
    public Node visitDerExp(DerExpContext ctx) {
        return null;
    }

    @Override
    public Node visitValExp(ValExpContext ctx) {
        return null;
    }

    @Override
    public Node visitNegExp(NegExpContext ctx) {
        return null;
    }

    @Override
    public Node visitBoolExp(BoolExpContext ctx) {
        return null;
    }

    @Override
    public Node visitCallExp(CallExpContext ctx) {
        return null;
    }

    @Override
    public NotExpContext visitNotExp(NotExpContext ctx) {
        return null;
    }

    private ExpNode visitExp(ExpContext ctx) {
        return null;
    }

    @Override
    public Node visit(ParseTree parseTree) {
        return null;
    }

    @Override
    public Node visitChildren(RuleNode ruleNode) {
        return null;
    }

    @Override
    public Node visitTerminal(TerminalNode terminalNode) {
        return null;
    }

    @Override
    public Node visitErrorNode(ErrorNode errorNode) {
        return null;
    }
}