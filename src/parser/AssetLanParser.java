package parser;// Generated from /home/nizzo/Documents/Projects/AssetLan/src/AssetLan.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AssetLanParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, BOOL=33, ID=34, NUMBER=35, WS=36, LINECOMMENTS=37, BLOCKCOMMENTS=38;
	public static final int
		RULE_init = 0, RULE_program = 1, RULE_field = 2, RULE_asset = 3, RULE_function = 4, 
		RULE_param = 5, RULE_bparam = 6, RULE_aparam = 7, RULE_statement = 8, 
		RULE_type = 9, RULE_assignment = 10, RULE_move = 11, RULE_print = 12, 
		RULE_transfer = 13, RULE_ret = 14, RULE_ite = 15, RULE_call = 16, RULE_initcall = 17, 
		RULE_exp = 18, RULE_aexp = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"init", "program", "field", "asset", "function", "param", "bparam", "aparam", 
			"statement", "type", "assignment", "move", "print", "transfer", "ret", 
			"ite", "call", "initcall", "exp", "aexp"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "';'", "'asset'", "'void'", "'('", "','", "')'", "'['", 
			"']'", "'{'", "'}'", "'int'", "'bool'", "'-o'", "'print'", "'transfer'", 
			"'return'", "'if'", "'else'", "'-'", "'!'", "'*'", "'/'", "'+'", "'<'", 
			"'<='", "'>'", "'>='", "'=='", "'!='", "'&&'", "'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "BOOL", "ID", "NUMBER", 
			"WS", "LINECOMMENTS", "BLOCKCOMMENTS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "AssetLan.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AssetLanParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class InitContext extends ParserRuleContext {
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public InitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).enterInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).exitInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssetLanVisitor ) return ((AssetLanVisitor<? extends T>)visitor).visitInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitContext init() throws RecognitionException {
		InitContext _localctx = new InitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_init);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			program();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgramContext extends ParserRuleContext {
		public InitcallContext initcall() {
			return getRuleContext(InitcallContext.class,0);
		}
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public List<AssetContext> asset() {
			return getRuleContexts(AssetContext.class);
		}
		public AssetContext asset(int i) {
			return getRuleContext(AssetContext.class,i);
		}
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssetLanVisitor ) return ((AssetLanVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_program);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(42);
					field();
					}
					} 
				}
				setState(47);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(48);
				asset();
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__11) | (1L << T__12))) != 0)) {
				{
				{
				setState(54);
				function();
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(60);
			initcall();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(AssetLanParser.ID, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).exitField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssetLanVisitor ) return ((AssetLanVisitor<? extends T>)visitor).visitField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			type();
			setState(63);
			match(ID);
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(64);
				match(T__0);
				setState(65);
				exp(0);
				}
			}

			setState(68);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssetContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AssetLanParser.ID, 0); }
		public AssetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asset; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).enterAsset(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).exitAsset(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssetLanVisitor ) return ((AssetLanVisitor<? extends T>)visitor).visitAsset(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssetContext asset() throws RecognitionException {
		AssetContext _localctx = new AssetContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_asset);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(T__2);
			setState(71);
			match(ID);
			setState(72);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AssetLanParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<AparamContext> aparam() {
			return getRuleContexts(AparamContext.class);
		}
		public AparamContext aparam(int i) {
			return getRuleContext(AparamContext.class,i);
		}
		public List<BparamContext> bparam() {
			return getRuleContexts(BparamContext.class);
		}
		public BparamContext bparam(int i) {
			return getRuleContext(BparamContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssetLanVisitor ) return ((AssetLanVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
			case T__12:
				{
				setState(74);
				type();
				}
				break;
			case T__3:
				{
				setState(75);
				match(T__3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(78);
			match(ID);
			setState(79);
			match(T__4);
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11 || _la==T__12) {
				{
				setState(80);
				param();
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(81);
					match(T__5);
					setState(82);
					param();
					}
					}
					setState(87);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(90);
			match(T__6);
			setState(91);
			match(T__7);
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(92);
				aparam();
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(93);
					match(T__5);
					setState(94);
					aparam();
					}
					}
					setState(99);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(102);
			match(T__8);
			setState(103);
			match(T__9);
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11 || _la==T__12) {
				{
				{
				setState(104);
				bparam();
				}
				}
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << ID))) != 0)) {
				{
				{
				setState(110);
				statement();
				}
				}
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(116);
			match(T__10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(AssetLanParser.ID, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssetLanVisitor ) return ((AssetLanVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			type();
			setState(119);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BparamContext extends ParserRuleContext {
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public BparamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bparam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).enterBparam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).exitBparam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssetLanVisitor ) return ((AssetLanVisitor<? extends T>)visitor).visitBparam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BparamContext bparam() throws RecognitionException {
		BparamContext _localctx = new BparamContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_bparam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			param();
			setState(122);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AparamContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AssetLanParser.ID, 0); }
		public AparamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aparam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).enterAparam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).exitAparam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssetLanVisitor ) return ((AssetLanVisitor<? extends T>)visitor).visitAparam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AparamContext aparam() throws RecognitionException {
		AparamContext _localctx = new AparamContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_aparam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(T__2);
			setState(125);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public MoveContext move() {
			return getRuleContext(MoveContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public TransferContext transfer() {
			return getRuleContext(TransferContext.class,0);
		}
		public RetContext ret() {
			return getRuleContext(RetContext.class,0);
		}
		public IteContext ite() {
			return getRuleContext(IteContext.class,0);
		}
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssetLanVisitor ) return ((AssetLanVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statement);
		try {
			setState(146);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				assignment();
				setState(128);
				match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				move();
				setState(131);
				match(T__1);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(133);
				print();
				setState(134);
				match(T__1);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(136);
				transfer();
				setState(137);
				match(T__1);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(139);
				ret();
				setState(140);
				match(T__1);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(142);
				ite();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(143);
				call();
				setState(144);
				match(T__1);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssetLanVisitor ) return ((AssetLanVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			_la = _input.LA(1);
			if ( !(_la==T__11 || _la==T__12) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AssetLanParser.ID, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssetLanVisitor ) return ((AssetLanVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(ID);
			setState(151);
			match(T__0);
			setState(152);
			exp(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MoveContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(AssetLanParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AssetLanParser.ID, i);
		}
		public MoveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_move; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).enterMove(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).exitMove(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssetLanVisitor ) return ((AssetLanVisitor<? extends T>)visitor).visitMove(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MoveContext move() throws RecognitionException {
		MoveContext _localctx = new MoveContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_move);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(ID);
			setState(155);
			match(T__13);
			setState(156);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).exitPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssetLanVisitor ) return ((AssetLanVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(T__14);
			setState(159);
			exp(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TransferContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AssetLanParser.ID, 0); }
		public TransferContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transfer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).enterTransfer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).exitTransfer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssetLanVisitor ) return ((AssetLanVisitor<? extends T>)visitor).visitTransfer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TransferContext transfer() throws RecognitionException {
		TransferContext _localctx = new TransferContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_transfer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(T__15);
			setState(162);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RetContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public RetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ret; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).enterRet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).exitRet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssetLanVisitor ) return ((AssetLanVisitor<? extends T>)visitor).visitRet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RetContext ret() throws RecognitionException {
		RetContext _localctx = new RetContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_ret);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(T__16);
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__19) | (1L << T__20) | (1L << BOOL) | (1L << ID) | (1L << NUMBER))) != 0)) {
				{
				setState(165);
				exp(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IteContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public IteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ite; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).enterIte(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).exitIte(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssetLanVisitor ) return ((AssetLanVisitor<? extends T>)visitor).visitIte(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IteContext ite() throws RecognitionException {
		IteContext _localctx = new IteContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ite);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(T__17);
			setState(169);
			match(T__4);
			setState(170);
			exp(0);
			setState(171);
			match(T__6);
			setState(172);
			statement();
			setState(175);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(173);
				match(T__18);
				setState(174);
				statement();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CallContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(AssetLanParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AssetLanParser.ID, i);
		}
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).enterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).exitCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssetLanVisitor ) return ((AssetLanVisitor<? extends T>)visitor).visitCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(ID);
			setState(178);
			match(T__4);
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__19) | (1L << T__20) | (1L << BOOL) | (1L << ID) | (1L << NUMBER))) != 0)) {
				{
				setState(179);
				exp(0);
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(180);
					match(T__5);
					setState(181);
					exp(0);
					}
					}
					setState(186);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(189);
			match(T__6);
			setState(190);
			match(T__7);
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(191);
				match(ID);
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(192);
					match(T__5);
					setState(193);
					match(ID);
					}
					}
					setState(198);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(201);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitcallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AssetLanParser.ID, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<AexpContext> aexp() {
			return getRuleContexts(AexpContext.class);
		}
		public AexpContext aexp(int i) {
			return getRuleContext(AexpContext.class,i);
		}
		public InitcallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initcall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).enterInitcall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).exitInitcall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssetLanVisitor ) return ((AssetLanVisitor<? extends T>)visitor).visitInitcall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitcallContext initcall() throws RecognitionException {
		InitcallContext _localctx = new InitcallContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_initcall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(ID);
			setState(204);
			match(T__4);
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__19) | (1L << T__20) | (1L << BOOL) | (1L << ID) | (1L << NUMBER))) != 0)) {
				{
				setState(205);
				exp(0);
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(206);
					match(T__5);
					setState(207);
					exp(0);
					}
					}
					setState(212);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(215);
			match(T__6);
			setState(216);
			match(T__7);
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__19) | (1L << T__20) | (1L << BOOL) | (1L << ID) | (1L << NUMBER))) != 0)) {
				{
				setState(217);
				aexp();
				setState(222);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(218);
					match(T__5);
					setState(219);
					aexp();
					}
					}
					setState(224);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(227);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BaseExpContext extends ExpContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public BaseExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).enterBaseExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).exitBaseExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssetLanVisitor ) return ((AssetLanVisitor<? extends T>)visitor).visitBaseExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinExpContext extends ExpContext {
		public ExpContext left;
		public Token op;
		public ExpContext right;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public BinExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).enterBinExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).exitBinExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssetLanVisitor ) return ((AssetLanVisitor<? extends T>)visitor).visitBinExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DerExpContext extends ExpContext {
		public TerminalNode ID() { return getToken(AssetLanParser.ID, 0); }
		public DerExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).enterDerExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).exitDerExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssetLanVisitor ) return ((AssetLanVisitor<? extends T>)visitor).visitDerExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValExpContext extends ExpContext {
		public TerminalNode NUMBER() { return getToken(AssetLanParser.NUMBER, 0); }
		public ValExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).enterValExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).exitValExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssetLanVisitor ) return ((AssetLanVisitor<? extends T>)visitor).visitValExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegExpContext extends ExpContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public NegExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).enterNegExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).exitNegExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssetLanVisitor ) return ((AssetLanVisitor<? extends T>)visitor).visitNegExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolExpContext extends ExpContext {
		public TerminalNode BOOL() { return getToken(AssetLanParser.BOOL, 0); }
		public BoolExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).enterBoolExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).exitBoolExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssetLanVisitor ) return ((AssetLanVisitor<? extends T>)visitor).visitBoolExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CallExpContext extends ExpContext {
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public CallExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).enterCallExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).exitCallExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssetLanVisitor ) return ((AssetLanVisitor<? extends T>)visitor).visitCallExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotExpContext extends ExpContext {
		public NotExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).enterNotExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).exitNotExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssetLanVisitor ) return ((AssetLanVisitor<? extends T>)visitor).visitNotExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				_localctx = new BaseExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(230);
				match(T__4);
				setState(231);
				exp(0);
				setState(232);
				match(T__6);
				}
				break;
			case 2:
				{
				_localctx = new NegExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(234);
				match(T__19);
				setState(235);
				exp(12);
				}
				break;
			case 3:
				{
				_localctx = new NotExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(236);
				match(T__20);
				}
				break;
			case 4:
				{
				_localctx = new DerExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(237);
				match(ID);
				}
				break;
			case 5:
				{
				_localctx = new CallExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(238);
				call();
				}
				break;
			case 6:
				{
				_localctx = new BoolExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(239);
				match(BOOL);
				}
				break;
			case 7:
				{
				_localctx = new ValExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(240);
				match(NUMBER);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(263);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(261);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
					case 1:
						{
						_localctx = new BinExpContext(new ExpContext(_parentctx, _parentState));
						((BinExpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(243);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(244);
						((BinExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__21 || _la==T__22) ) {
							((BinExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(245);
						((BinExpContext)_localctx).right = exp(10);
						}
						break;
					case 2:
						{
						_localctx = new BinExpContext(new ExpContext(_parentctx, _parentState));
						((BinExpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(246);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(247);
						((BinExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__19 || _la==T__23) ) {
							((BinExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(248);
						((BinExpContext)_localctx).right = exp(9);
						}
						break;
					case 3:
						{
						_localctx = new BinExpContext(new ExpContext(_parentctx, _parentState));
						((BinExpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(249);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(250);
						((BinExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27))) != 0)) ) {
							((BinExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(251);
						((BinExpContext)_localctx).right = exp(8);
						}
						break;
					case 4:
						{
						_localctx = new BinExpContext(new ExpContext(_parentctx, _parentState));
						((BinExpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(252);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(253);
						((BinExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__28 || _la==T__29) ) {
							((BinExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(254);
						((BinExpContext)_localctx).right = exp(7);
						}
						break;
					case 5:
						{
						_localctx = new BinExpContext(new ExpContext(_parentctx, _parentState));
						((BinExpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(255);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(256);
						((BinExpContext)_localctx).op = match(T__30);
						setState(257);
						((BinExpContext)_localctx).right = exp(6);
						}
						break;
					case 6:
						{
						_localctx = new BinExpContext(new ExpContext(_parentctx, _parentState));
						((BinExpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(258);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(259);
						((BinExpContext)_localctx).op = match(T__31);
						setState(260);
						((BinExpContext)_localctx).right = exp(5);
						}
						break;
					}
					} 
				}
				setState(265);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AexpContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public AexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).enterAexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssetLanListener ) ((AssetLanListener)listener).exitAexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssetLanVisitor ) return ((AssetLanVisitor<? extends T>)visitor).visitAexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AexpContext aexp() throws RecognitionException {
		AexpContext _localctx = new AexpContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_aexp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			exp(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 18:
			return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3(\u010f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\3\7\3.\n\3\f\3\16\3\61\13\3\3"+
		"\3\7\3\64\n\3\f\3\16\3\67\13\3\3\3\7\3:\n\3\f\3\16\3=\13\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\5\4E\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\5\6O\n\6\3\6\3\6"+
		"\3\6\3\6\3\6\7\6V\n\6\f\6\16\6Y\13\6\5\6[\n\6\3\6\3\6\3\6\3\6\3\6\7\6"+
		"b\n\6\f\6\16\6e\13\6\5\6g\n\6\3\6\3\6\3\6\7\6l\n\6\f\6\16\6o\13\6\3\6"+
		"\7\6r\n\6\f\6\16\6u\13\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\5\n\u0095\n\n\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\20\3\20\5\20\u00a9\n\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\5\21\u00b2\n\21\3\22\3\22\3\22\3\22\3\22\7\22\u00b9\n\22\f"+
		"\22\16\22\u00bc\13\22\5\22\u00be\n\22\3\22\3\22\3\22\3\22\3\22\7\22\u00c5"+
		"\n\22\f\22\16\22\u00c8\13\22\5\22\u00ca\n\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\23\3\23\7\23\u00d3\n\23\f\23\16\23\u00d6\13\23\5\23\u00d8\n\23\3\23"+
		"\3\23\3\23\3\23\3\23\7\23\u00df\n\23\f\23\16\23\u00e2\13\23\5\23\u00e4"+
		"\n\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\5\24\u00f4\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u0108\n\24\f\24\16\24\u010b"+
		"\13\24\3\25\3\25\3\25\2\3&\26\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 "+
		"\"$&(\2\7\3\2\16\17\3\2\30\31\4\2\26\26\32\32\3\2\33\36\3\2\37 \2\u0121"+
		"\2*\3\2\2\2\4/\3\2\2\2\6@\3\2\2\2\bH\3\2\2\2\nN\3\2\2\2\fx\3\2\2\2\16"+
		"{\3\2\2\2\20~\3\2\2\2\22\u0094\3\2\2\2\24\u0096\3\2\2\2\26\u0098\3\2\2"+
		"\2\30\u009c\3\2\2\2\32\u00a0\3\2\2\2\34\u00a3\3\2\2\2\36\u00a6\3\2\2\2"+
		" \u00aa\3\2\2\2\"\u00b3\3\2\2\2$\u00cd\3\2\2\2&\u00f3\3\2\2\2(\u010c\3"+
		"\2\2\2*+\5\4\3\2+\3\3\2\2\2,.\5\6\4\2-,\3\2\2\2.\61\3\2\2\2/-\3\2\2\2"+
		"/\60\3\2\2\2\60\65\3\2\2\2\61/\3\2\2\2\62\64\5\b\5\2\63\62\3\2\2\2\64"+
		"\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66;\3\2\2\2\67\65\3\2\2\28:\5"+
		"\n\6\298\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<>\3\2\2\2=;\3\2\2\2>?\5"+
		"$\23\2?\5\3\2\2\2@A\5\24\13\2AD\7$\2\2BC\7\3\2\2CE\5&\24\2DB\3\2\2\2D"+
		"E\3\2\2\2EF\3\2\2\2FG\7\4\2\2G\7\3\2\2\2HI\7\5\2\2IJ\7$\2\2JK\7\4\2\2"+
		"K\t\3\2\2\2LO\5\24\13\2MO\7\6\2\2NL\3\2\2\2NM\3\2\2\2OP\3\2\2\2PQ\7$\2"+
		"\2QZ\7\7\2\2RW\5\f\7\2ST\7\b\2\2TV\5\f\7\2US\3\2\2\2VY\3\2\2\2WU\3\2\2"+
		"\2WX\3\2\2\2X[\3\2\2\2YW\3\2\2\2ZR\3\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\]\7\t"+
		"\2\2]f\7\n\2\2^c\5\20\t\2_`\7\b\2\2`b\5\20\t\2a_\3\2\2\2be\3\2\2\2ca\3"+
		"\2\2\2cd\3\2\2\2dg\3\2\2\2ec\3\2\2\2f^\3\2\2\2fg\3\2\2\2gh\3\2\2\2hi\7"+
		"\13\2\2im\7\f\2\2jl\5\16\b\2kj\3\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2n"+
		"s\3\2\2\2om\3\2\2\2pr\5\22\n\2qp\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2"+
		"tv\3\2\2\2us\3\2\2\2vw\7\r\2\2w\13\3\2\2\2xy\5\24\13\2yz\7$\2\2z\r\3\2"+
		"\2\2{|\5\f\7\2|}\7\4\2\2}\17\3\2\2\2~\177\7\5\2\2\177\u0080\7$\2\2\u0080"+
		"\21\3\2\2\2\u0081\u0082\5\26\f\2\u0082\u0083\7\4\2\2\u0083\u0095\3\2\2"+
		"\2\u0084\u0085\5\30\r\2\u0085\u0086\7\4\2\2\u0086\u0095\3\2\2\2\u0087"+
		"\u0088\5\32\16\2\u0088\u0089\7\4\2\2\u0089\u0095\3\2\2\2\u008a\u008b\5"+
		"\34\17\2\u008b\u008c\7\4\2\2\u008c\u0095\3\2\2\2\u008d\u008e\5\36\20\2"+
		"\u008e\u008f\7\4\2\2\u008f\u0095\3\2\2\2\u0090\u0095\5 \21\2\u0091\u0092"+
		"\5\"\22\2\u0092\u0093\7\4\2\2\u0093\u0095\3\2\2\2\u0094\u0081\3\2\2\2"+
		"\u0094\u0084\3\2\2\2\u0094\u0087\3\2\2\2\u0094\u008a\3\2\2\2\u0094\u008d"+
		"\3\2\2\2\u0094\u0090\3\2\2\2\u0094\u0091\3\2\2\2\u0095\23\3\2\2\2\u0096"+
		"\u0097\t\2\2\2\u0097\25\3\2\2\2\u0098\u0099\7$\2\2\u0099\u009a\7\3\2\2"+
		"\u009a\u009b\5&\24\2\u009b\27\3\2\2\2\u009c\u009d\7$\2\2\u009d\u009e\7"+
		"\20\2\2\u009e\u009f\7$\2\2\u009f\31\3\2\2\2\u00a0\u00a1\7\21\2\2\u00a1"+
		"\u00a2\5&\24\2\u00a2\33\3\2\2\2\u00a3\u00a4\7\22\2\2\u00a4\u00a5\7$\2"+
		"\2\u00a5\35\3\2\2\2\u00a6\u00a8\7\23\2\2\u00a7\u00a9\5&\24\2\u00a8\u00a7"+
		"\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\37\3\2\2\2\u00aa\u00ab\7\24\2\2\u00ab"+
		"\u00ac\7\7\2\2\u00ac\u00ad\5&\24\2\u00ad\u00ae\7\t\2\2\u00ae\u00b1\5\22"+
		"\n\2\u00af\u00b0\7\25\2\2\u00b0\u00b2\5\22\n\2\u00b1\u00af\3\2\2\2\u00b1"+
		"\u00b2\3\2\2\2\u00b2!\3\2\2\2\u00b3\u00b4\7$\2\2\u00b4\u00bd\7\7\2\2\u00b5"+
		"\u00ba\5&\24\2\u00b6\u00b7\7\b\2\2\u00b7\u00b9\5&\24\2\u00b8\u00b6\3\2"+
		"\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb"+
		"\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00b5\3\2\2\2\u00bd\u00be\3\2"+
		"\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\7\t\2\2\u00c0\u00c9\7\n\2\2\u00c1"+
		"\u00c6\7$\2\2\u00c2\u00c3\7\b\2\2\u00c3\u00c5\7$\2\2\u00c4\u00c2\3\2\2"+
		"\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00ca"+
		"\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\u00c1\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca"+
		"\u00cb\3\2\2\2\u00cb\u00cc\7\13\2\2\u00cc#\3\2\2\2\u00cd\u00ce\7$\2\2"+
		"\u00ce\u00d7\7\7\2\2\u00cf\u00d4\5&\24\2\u00d0\u00d1\7\b\2\2\u00d1\u00d3"+
		"\5&\24\2\u00d2\u00d0\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4"+
		"\u00d5\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00cf\3\2"+
		"\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00da\7\t\2\2\u00da"+
		"\u00e3\7\n\2\2\u00db\u00e0\5(\25\2\u00dc\u00dd\7\b\2\2\u00dd\u00df\5("+
		"\25\2\u00de\u00dc\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0"+
		"\u00e1\3\2\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e3\u00db\3\2"+
		"\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6\7\13\2\2\u00e6"+
		"%\3\2\2\2\u00e7\u00e8\b\24\1\2\u00e8\u00e9\7\7\2\2\u00e9\u00ea\5&\24\2"+
		"\u00ea\u00eb\7\t\2\2\u00eb\u00f4\3\2\2\2\u00ec\u00ed\7\26\2\2\u00ed\u00f4"+
		"\5&\24\16\u00ee\u00f4\7\27\2\2\u00ef\u00f4\7$\2\2\u00f0\u00f4\5\"\22\2"+
		"\u00f1\u00f4\7#\2\2\u00f2\u00f4\7%\2\2\u00f3\u00e7\3\2\2\2\u00f3\u00ec"+
		"\3\2\2\2\u00f3\u00ee\3\2\2\2\u00f3\u00ef\3\2\2\2\u00f3\u00f0\3\2\2\2\u00f3"+
		"\u00f1\3\2\2\2\u00f3\u00f2\3\2\2\2\u00f4\u0109\3\2\2\2\u00f5\u00f6\f\13"+
		"\2\2\u00f6\u00f7\t\3\2\2\u00f7\u0108\5&\24\f\u00f8\u00f9\f\n\2\2\u00f9"+
		"\u00fa\t\4\2\2\u00fa\u0108\5&\24\13\u00fb\u00fc\f\t\2\2\u00fc\u00fd\t"+
		"\5\2\2\u00fd\u0108\5&\24\n\u00fe\u00ff\f\b\2\2\u00ff\u0100\t\6\2\2\u0100"+
		"\u0108\5&\24\t\u0101\u0102\f\7\2\2\u0102\u0103\7!\2\2\u0103\u0108\5&\24"+
		"\b\u0104\u0105\f\6\2\2\u0105\u0106\7\"\2\2\u0106\u0108\5&\24\7\u0107\u00f5"+
		"\3\2\2\2\u0107\u00f8\3\2\2\2\u0107\u00fb\3\2\2\2\u0107\u00fe\3\2\2\2\u0107"+
		"\u0101\3\2\2\2\u0107\u0104\3\2\2\2\u0108\u010b\3\2\2\2\u0109\u0107\3\2"+
		"\2\2\u0109\u010a\3\2\2\2\u010a\'\3\2\2\2\u010b\u0109\3\2\2\2\u010c\u010d"+
		"\5&\24\2\u010d)\3\2\2\2\33/\65;DNWZcfms\u0094\u00a8\u00b1\u00ba\u00bd"+
		"\u00c6\u00c9\u00d4\u00d7\u00e0\u00e3\u00f3\u0107\u0109";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}