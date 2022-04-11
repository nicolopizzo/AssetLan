package parser;// Generated from /home/nizzo/Documents/Projects/AssetLan/src/AssetLan.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AssetLanParser}.
 */
public interface AssetLanListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AssetLanParser#init}.
	 * @param ctx the parse tree
	 */
	void enterInit(AssetLanParser.InitContext ctx);
	/**
	 * Exit a parse tree produced by {@link AssetLanParser#init}.
	 * @param ctx the parse tree
	 */
	void exitInit(AssetLanParser.InitContext ctx);
	/**
	 * Enter a parse tree produced by {@link AssetLanParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(AssetLanParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link AssetLanParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(AssetLanParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link AssetLanParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(AssetLanParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link AssetLanParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(AssetLanParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link AssetLanParser#asset}.
	 * @param ctx the parse tree
	 */
	void enterAsset(AssetLanParser.AssetContext ctx);
	/**
	 * Exit a parse tree produced by {@link AssetLanParser#asset}.
	 * @param ctx the parse tree
	 */
	void exitAsset(AssetLanParser.AssetContext ctx);
	/**
	 * Enter a parse tree produced by {@link AssetLanParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(AssetLanParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link AssetLanParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(AssetLanParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link AssetLanParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(AssetLanParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link AssetLanParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(AssetLanParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link AssetLanParser#bparam}.
	 * @param ctx the parse tree
	 */
	void enterBparam(AssetLanParser.BparamContext ctx);
	/**
	 * Exit a parse tree produced by {@link AssetLanParser#bparam}.
	 * @param ctx the parse tree
	 */
	void exitBparam(AssetLanParser.BparamContext ctx);
	/**
	 * Enter a parse tree produced by {@link AssetLanParser#aparam}.
	 * @param ctx the parse tree
	 */
	void enterAparam(AssetLanParser.AparamContext ctx);
	/**
	 * Exit a parse tree produced by {@link AssetLanParser#aparam}.
	 * @param ctx the parse tree
	 */
	void exitAparam(AssetLanParser.AparamContext ctx);
	/**
	 * Enter a parse tree produced by {@link AssetLanParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(AssetLanParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AssetLanParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(AssetLanParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AssetLanParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(AssetLanParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AssetLanParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(AssetLanParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AssetLanParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(AssetLanParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link AssetLanParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(AssetLanParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link AssetLanParser#move}.
	 * @param ctx the parse tree
	 */
	void enterMove(AssetLanParser.MoveContext ctx);
	/**
	 * Exit a parse tree produced by {@link AssetLanParser#move}.
	 * @param ctx the parse tree
	 */
	void exitMove(AssetLanParser.MoveContext ctx);
	/**
	 * Enter a parse tree produced by {@link AssetLanParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(AssetLanParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link AssetLanParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(AssetLanParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link AssetLanParser#transfer}.
	 * @param ctx the parse tree
	 */
	void enterTransfer(AssetLanParser.TransferContext ctx);
	/**
	 * Exit a parse tree produced by {@link AssetLanParser#transfer}.
	 * @param ctx the parse tree
	 */
	void exitTransfer(AssetLanParser.TransferContext ctx);
	/**
	 * Enter a parse tree produced by {@link AssetLanParser#ret}.
	 * @param ctx the parse tree
	 */
	void enterRet(AssetLanParser.RetContext ctx);
	/**
	 * Exit a parse tree produced by {@link AssetLanParser#ret}.
	 * @param ctx the parse tree
	 */
	void exitRet(AssetLanParser.RetContext ctx);
	/**
	 * Enter a parse tree produced by {@link AssetLanParser#ite}.
	 * @param ctx the parse tree
	 */
	void enterIte(AssetLanParser.IteContext ctx);
	/**
	 * Exit a parse tree produced by {@link AssetLanParser#ite}.
	 * @param ctx the parse tree
	 */
	void exitIte(AssetLanParser.IteContext ctx);
	/**
	 * Enter a parse tree produced by {@link AssetLanParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(AssetLanParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link AssetLanParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(AssetLanParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by {@link AssetLanParser#initcall}.
	 * @param ctx the parse tree
	 */
	void enterInitcall(AssetLanParser.InitcallContext ctx);
	/**
	 * Exit a parse tree produced by {@link AssetLanParser#initcall}.
	 * @param ctx the parse tree
	 */
	void exitInitcall(AssetLanParser.InitcallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code baseExp}
	 * labeled alternative in {@link AssetLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterBaseExp(AssetLanParser.BaseExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code baseExp}
	 * labeled alternative in {@link AssetLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitBaseExp(AssetLanParser.BaseExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binExp}
	 * labeled alternative in {@link AssetLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterBinExp(AssetLanParser.BinExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binExp}
	 * labeled alternative in {@link AssetLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitBinExp(AssetLanParser.BinExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code derExp}
	 * labeled alternative in {@link AssetLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterDerExp(AssetLanParser.DerExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code derExp}
	 * labeled alternative in {@link AssetLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitDerExp(AssetLanParser.DerExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valExp}
	 * labeled alternative in {@link AssetLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterValExp(AssetLanParser.ValExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valExp}
	 * labeled alternative in {@link AssetLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitValExp(AssetLanParser.ValExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negExp}
	 * labeled alternative in {@link AssetLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterNegExp(AssetLanParser.NegExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negExp}
	 * labeled alternative in {@link AssetLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitNegExp(AssetLanParser.NegExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExp}
	 * labeled alternative in {@link AssetLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterBoolExp(AssetLanParser.BoolExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExp}
	 * labeled alternative in {@link AssetLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitBoolExp(AssetLanParser.BoolExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code callExp}
	 * labeled alternative in {@link AssetLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterCallExp(AssetLanParser.CallExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code callExp}
	 * labeled alternative in {@link AssetLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitCallExp(AssetLanParser.CallExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExp}
	 * labeled alternative in {@link AssetLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterNotExp(AssetLanParser.NotExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExp}
	 * labeled alternative in {@link AssetLanParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitNotExp(AssetLanParser.NotExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link AssetLanParser#aexp}.
	 * @param ctx the parse tree
	 */
	void enterAexp(AssetLanParser.AexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link AssetLanParser#aexp}.
	 * @param ctx the parse tree
	 */
	void exitAexp(AssetLanParser.AexpContext ctx);
}