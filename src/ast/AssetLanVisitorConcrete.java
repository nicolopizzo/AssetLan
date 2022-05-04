package ast;

import parser.AssetLanBaseVisitor;
import parser.AssetLanParser.*;

import java.util.ArrayList;

public class AssetLanVisitorConcrete extends AssetLanBaseVisitor<Node> {
    @Override
    //visit() automatically (based on the parameter type - in this case ctx.program() ) redirects to the correct function (in this case visitProgram)
    public Node visitInit(InitContext ctx) {
        return visit(ctx.program());
    }

    @Override
    public Node visitProgram(ProgramContext ctx) {
        //ctx contains the actual node and his children
        ArrayList<Node> fields = new ArrayList<>();
        //for every 'field' child of ctx call his visit() function to return all his descendant (in a different form - custom classes)
        for (FieldContext field : ctx.field()) {
            fields.add(visit(field));
        }

        ArrayList<Node> assets = new ArrayList<>();
        for (AssetContext asset : ctx.asset()) {
            assets.add(visit(asset));
        }

        ArrayList<Node> functions = new ArrayList<>();
        for (FunctionContext function : ctx.function()) {
            functions.add(visit(function));
        }

        Node initCall = visit(ctx.initcall());

        return new ProgramNode(fields, assets, functions, initCall);
    }

    @Override
    public Node visitField(FieldContext ctx) {
        Node type = visit(ctx.type());
        String id = ctx.ID().getText();

        Node exp;
        if (ctx.exp() != null) {
            exp = visit(ctx.exp());
            return new FieldNode(type, id, exp);
        }

        return new FieldNode(type, id);
    }

    @Override
    public Node visitAsset(AssetContext ctx) {
        String id = ctx.ID().getText();
        return new AssetNode(id);
    }

    @Override
    public Node visitFunction(FunctionContext ctx) {
        Node type = visit(ctx.type());
        String id = ctx.ID().getText();

        ArrayList<Node> params = new ArrayList<>();
        for (ParamContext p : ctx.param()) {
            Node pType = visit(p.type());
            String pId = p.ID().getText();
            params.add(new ParamNode(pType, pId));
        }

        ArrayList<Node> assetParams = new ArrayList<>();
        for (AparamContext a : ctx.aparam()) {
            String assetId = a.ID().getText();
            assetParams.add(new ParamNode(TypeNode.ASSET, assetId));
        }

        ArrayList<Node> fields = new ArrayList<>();
        for (FieldContext b : ctx.field()) {
            fields.add(visit(b));
        }

        ArrayList<Node> statements = new ArrayList<>();
        for (StatementContext s : ctx.statement()) {
            statements.add(visit(s));
        }

        return new FunctionNode(type, id, params, assetParams, fields, statements);
    }

    @Override
    public Node visitStatement(StatementContext ctx) {
        // A statement rule can only have one child
        return visit(ctx.children.get(0));
    }

    @Override
    public Node visitType(TypeContext ctx) {
        return new TypeNode(ctx.getText());
    }

    @Override
    public Node visitAssignment(AssignmentContext ctx) {
        String id = ctx.ID().getText();
        Node expNode = visit(ctx.exp());

        return new AssignmentNode(id, expNode);
    }

    @Override
    public Node visitMove(MoveContext ctx) {
        String id1 = ctx.ID(0).getText();
        String id2 = ctx.ID(1).getText();

        return new MoveNode(id1, id2);
    }

    @Override
    public Node visitPrint(PrintContext ctx) {
        Node expNode = visit(ctx.exp());

        return new PrintNode(expNode);
    }

    @Override
    public Node visitTransfer(TransferContext ctx) {
        String id = ctx.ID().getText();

        return new TransferNode(id);
    }

    @Override
    public Node visitRet(RetContext ctx) {
        if (ctx.exp() != null) {
            Node expNode = visit(ctx.exp());
            return new RetNode(expNode);
        }

        return new RetNode();
    }

    @Override
    public Node visitIte(IteContext ctx) {
        Node expNode = visit(ctx.exp());
        Node ifStatement = visit(ctx.statement(0));
        if (ctx.statement(1) != null) {
            Node elseStatement = visit(ctx.statement(1));
            return new IteNode(expNode, ifStatement, elseStatement);
        }

        return new IteNode(expNode, ifStatement);
    }

    @Override
    public Node visitCall(CallContext ctx) {
        String id = ctx.ID(0).getText();

        ArrayList<Node> params = new ArrayList<>();
        for (ExpContext e : ctx.exp()) {
            params.add(visit(e));
        }

        ArrayList<String> assets = new ArrayList<>();
        for (int i = 1; i < ctx.ID().size(); i++) {
            assets.add(ctx.ID(i).getText());
        }

        return new CallNode(id, params, assets);
    }

    @Override
    public InitCallNode visitInitcall(InitcallContext ctx) {
        String id = ctx.ID().getText();

        ArrayList<Node> params = new ArrayList<>();
        for (ExpContext e : ctx.exp()) {
            params.add(visit(e));
        }

        ArrayList<Node> assets = new ArrayList<>();
        for (AexpContext e : ctx.aexp()) {
            assets.add(visit(e));
        }

        return new InitCallNode(id, params, assets);
    }

    @Override
    public Node visitBaseExp(BaseExpContext ctx) {
        Node exp = visit(ctx.exp());

        return new BaseExpNode(exp);
    }

    @Override
    public Node visitBinExp(BinExpContext ctx) {
        Node leftExp = visit(ctx.left);
        Node rightExp = visit(ctx.right);

        return new BinExpNode(leftExp, rightExp);
    }

    @Override
    public Node visitDerExp(DerExpContext ctx) {
        String id = ctx.ID().getText();

        return new DerExpNode(id);
    }

    @Override
    public Node visitValExp(ValExpContext ctx) {
        String value = ctx.NUMBER().getText();

        return new ValExpNode(value);
    }

    @Override
    public Node visitNegExp(NegExpContext ctx) {
        Node expNode = visit(ctx.exp());

        return new NegExpNode(expNode);
    }

    @Override
    public Node visitBoolExp(BoolExpContext ctx) {
        String bool = ctx.BOOL().getText();

        return new BoolExpNode(bool);
    }

    @Override
    public Node visitCallExp(CallExpContext ctx) {
        return visit(ctx.call());
    }

    @Override
    public Node visitNotExp(NotExpContext ctx) {
        return new NotExpNode();
    }
}