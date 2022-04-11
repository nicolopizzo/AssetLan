package ast;

import parser.AssetLanBaseVisitor;
import parser.AssetLanParser.*;

import java.util.ArrayList;

public class AssetLanVisitorConcrete extends AssetLanBaseVisitor<Node> {
    @Override
    public Node visitInit(InitContext ctx) {
        return visitProgram(ctx.program());
    }

    @Override
    public ProgramNode visitProgram(ProgramContext ctx) {
        ArrayList<FieldNode> fields = new ArrayList<>();
        for (FieldContext field : ctx.field()) {
            fields.add((FieldNode) visit(field));
        }

        ArrayList<AssetNode> assets = new ArrayList<>();
        for (AssetContext asset : ctx.asset()) {
            assets.add((AssetNode) visit(asset));
        }

        ArrayList<FunctionNode> functions = new ArrayList<>();
        for (FunctionContext function : ctx.function()) {
            functions.add((FunctionNode) visit(function));
        }

        InitCallNode initCall = (InitCallNode) visit(ctx.initcall());

        return new ProgramNode(fields, assets, functions, initCall);
    }

    @Override
    public FieldNode visitField(FieldContext ctx) {
        TypeNode type = visitType(ctx.type());
        String id = ctx.ID().getText();

        ExpNode exp = null;
        if (ctx.exp() != null) {
            exp = (ExpNode) visit(ctx.exp());
        }

        return new FieldNode(type, id, exp);
    }

    @Override
    public AssetNode visitAsset(AssetContext ctx) {
        String id = ctx.ID().getText();
        return new AssetNode(id);
    }

    @Override
    public FunctionNode visitFunction(FunctionContext ctx) {
        TypeNode type = (TypeNode) visit(ctx.type());
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
}