// Generated from /home/nizzo/Documents/Projects/AssetLan/src/SVM.g4 by ANTLR 4.10.1
package parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SVMParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PUSH=1, POP=2, ADD=3, SUB=4, MULT=5, DIV=6, STOREW=7, LOADW=8, BRANCH=9, 
		BRANCHEQ=10, BRANCHLESSEQ=11, BRANCHLESST=12, BRANCHGREATEREQ=13, BRANCHGREATERT=14, 
		JS=15, LOADRA=16, STORERA=17, LOADRV=18, STORERV=19, LOADFP=20, STOREFP=21, 
		COPYFP=22, LOADHP=23, STOREHP=24, PRINT=25, HALT=26, COL=27, LABEL=28, 
		NUMBER=29, WHITESP=30, ERR=31;
	public static final int
		RULE_assembly = 0, RULE_instruction = 1;
	private static String[] makeRuleNames() {
		return new String[] {
			"assembly", "instruction"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'push'", "'pop'", "'add'", "'sub'", "'mult'", "'div'", "'sw'", 
			"'lw'", "'b'", "'beq'", "'bleq'", "'blt'", "'bgeq'", "'bgt'", "'js'", 
			"'lra'", "'sra'", "'lrv'", "'srv'", "'lfp'", "'sfp'", "'cfp'", "'lhp'", 
			"'shp'", "'print'", "'halt'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PUSH", "POP", "ADD", "SUB", "MULT", "DIV", "STOREW", "LOADW", 
			"BRANCH", "BRANCHEQ", "BRANCHLESSEQ", "BRANCHLESST", "BRANCHGREATEREQ", 
			"BRANCHGREATERT", "JS", "LOADRA", "STORERA", "LOADRV", "STORERV", "LOADFP", 
			"STOREFP", "COPYFP", "LOADHP", "STOREHP", "PRINT", "HALT", "COL", "LABEL", 
			"NUMBER", "WHITESP", "ERR"
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
	public String getGrammarFileName() { return "SVM.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SVMParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class AssemblyContext extends ParserRuleContext {
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public AssemblyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assembly; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterAssembly(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitAssembly(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitAssembly(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssemblyContext assembly() throws RecognitionException {
		AssemblyContext _localctx = new AssemblyContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_assembly);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(7);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PUSH) | (1L << POP) | (1L << ADD) | (1L << SUB) | (1L << MULT) | (1L << DIV) | (1L << STOREW) | (1L << LOADW) | (1L << BRANCH) | (1L << BRANCHEQ) | (1L << BRANCHLESSEQ) | (1L << BRANCHLESST) | (1L << BRANCHGREATEREQ) | (1L << BRANCHGREATERT) | (1L << JS) | (1L << LOADRA) | (1L << STORERA) | (1L << LOADRV) | (1L << STORERV) | (1L << LOADFP) | (1L << STOREFP) | (1L << COPYFP) | (1L << LOADHP) | (1L << STOREHP) | (1L << PRINT) | (1L << HALT) | (1L << LABEL))) != 0)) {
				{
				{
				setState(4);
				instruction();
				}
				}
				setState(9);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class InstructionContext extends ParserRuleContext {
		public Token n;
		public Token l;
		public TerminalNode PUSH() { return getToken(SVMParser.PUSH, 0); }
		public TerminalNode POP() { return getToken(SVMParser.POP, 0); }
		public TerminalNode ADD() { return getToken(SVMParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(SVMParser.SUB, 0); }
		public TerminalNode MULT() { return getToken(SVMParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(SVMParser.DIV, 0); }
		public TerminalNode STOREW() { return getToken(SVMParser.STOREW, 0); }
		public TerminalNode LOADW() { return getToken(SVMParser.LOADW, 0); }
		public TerminalNode COL() { return getToken(SVMParser.COL, 0); }
		public TerminalNode BRANCH() { return getToken(SVMParser.BRANCH, 0); }
		public TerminalNode BRANCHEQ() { return getToken(SVMParser.BRANCHEQ, 0); }
		public TerminalNode BRANCHLESSEQ() { return getToken(SVMParser.BRANCHLESSEQ, 0); }
		public TerminalNode BRANCHLESST() { return getToken(SVMParser.BRANCHLESST, 0); }
		public TerminalNode BRANCHGREATEREQ() { return getToken(SVMParser.BRANCHGREATEREQ, 0); }
		public TerminalNode BRANCHGREATERT() { return getToken(SVMParser.BRANCHGREATERT, 0); }
		public TerminalNode JS() { return getToken(SVMParser.JS, 0); }
		public TerminalNode LOADRA() { return getToken(SVMParser.LOADRA, 0); }
		public TerminalNode STORERA() { return getToken(SVMParser.STORERA, 0); }
		public TerminalNode LOADRV() { return getToken(SVMParser.LOADRV, 0); }
		public TerminalNode STORERV() { return getToken(SVMParser.STORERV, 0); }
		public TerminalNode LOADFP() { return getToken(SVMParser.LOADFP, 0); }
		public TerminalNode STOREFP() { return getToken(SVMParser.STOREFP, 0); }
		public TerminalNode COPYFP() { return getToken(SVMParser.COPYFP, 0); }
		public TerminalNode LOADHP() { return getToken(SVMParser.LOADHP, 0); }
		public TerminalNode STOREHP() { return getToken(SVMParser.STOREHP, 0); }
		public TerminalNode PRINT() { return getToken(SVMParser.PRINT, 0); }
		public TerminalNode HALT() { return getToken(SVMParser.HALT, 0); }
		public TerminalNode NUMBER() { return getToken(SVMParser.NUMBER, 0); }
		public TerminalNode LABEL() { return getToken(SVMParser.LABEL, 0); }
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMListener ) ((SVMListener)listener).exitInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SVMVisitor ) return ((SVMVisitor<? extends T>)visitor).visitInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_instruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(10);
				match(PUSH);
				setState(11);
				((InstructionContext)_localctx).n = match(NUMBER);
				}
				break;
			case 2:
				{
				setState(12);
				match(PUSH);
				setState(13);
				((InstructionContext)_localctx).l = match(LABEL);
				}
				break;
			case 3:
				{
				setState(14);
				match(POP);
				}
				break;
			case 4:
				{
				setState(15);
				match(ADD);
				}
				break;
			case 5:
				{
				setState(16);
				match(SUB);
				}
				break;
			case 6:
				{
				setState(17);
				match(MULT);
				}
				break;
			case 7:
				{
				setState(18);
				match(DIV);
				}
				break;
			case 8:
				{
				setState(19);
				match(STOREW);
				}
				break;
			case 9:
				{
				setState(20);
				match(LOADW);
				}
				break;
			case 10:
				{
				setState(21);
				((InstructionContext)_localctx).l = match(LABEL);
				setState(22);
				match(COL);
				}
				break;
			case 11:
				{
				setState(23);
				match(BRANCH);
				setState(24);
				((InstructionContext)_localctx).l = match(LABEL);
				}
				break;
			case 12:
				{
				setState(25);
				match(BRANCHEQ);
				setState(26);
				((InstructionContext)_localctx).l = match(LABEL);
				}
				break;
			case 13:
				{
				setState(27);
				match(BRANCHLESSEQ);
				setState(28);
				((InstructionContext)_localctx).l = match(LABEL);
				}
				break;
			case 14:
				{
				setState(29);
				match(BRANCHLESST);
				setState(30);
				((InstructionContext)_localctx).l = match(LABEL);
				}
				break;
			case 15:
				{
				setState(31);
				match(BRANCHGREATEREQ);
				setState(32);
				((InstructionContext)_localctx).l = match(LABEL);
				}
				break;
			case 16:
				{
				setState(33);
				match(BRANCHGREATERT);
				setState(34);
				((InstructionContext)_localctx).l = match(LABEL);
				}
				break;
			case 17:
				{
				setState(35);
				match(JS);
				}
				break;
			case 18:
				{
				setState(36);
				match(LOADRA);
				}
				break;
			case 19:
				{
				setState(37);
				match(STORERA);
				}
				break;
			case 20:
				{
				setState(38);
				match(LOADRV);
				}
				break;
			case 21:
				{
				setState(39);
				match(STORERV);
				}
				break;
			case 22:
				{
				setState(40);
				match(LOADFP);
				}
				break;
			case 23:
				{
				setState(41);
				match(STOREFP);
				}
				break;
			case 24:
				{
				setState(42);
				match(COPYFP);
				}
				break;
			case 25:
				{
				setState(43);
				match(LOADHP);
				}
				break;
			case 26:
				{
				setState(44);
				match(STOREHP);
				}
				break;
			case 27:
				{
				setState(45);
				match(PRINT);
				}
				break;
			case 28:
				{
				setState(46);
				match(HALT);
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

	public static final String _serializedATN =
		"\u0004\u0001\u001f2\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0001"+
		"\u0000\u0005\u0000\u0006\b\u0000\n\u0000\f\u0000\t\t\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u00010\b\u0001\u0001\u0001\u0000\u0000\u0002\u0000\u0002\u0000"+
		"\u0000K\u0000\u0007\u0001\u0000\u0000\u0000\u0002/\u0001\u0000\u0000\u0000"+
		"\u0004\u0006\u0003\u0002\u0001\u0000\u0005\u0004\u0001\u0000\u0000\u0000"+
		"\u0006\t\u0001\u0000\u0000\u0000\u0007\u0005\u0001\u0000\u0000\u0000\u0007"+
		"\b\u0001\u0000\u0000\u0000\b\u0001\u0001\u0000\u0000\u0000\t\u0007\u0001"+
		"\u0000\u0000\u0000\n\u000b\u0005\u0001\u0000\u0000\u000b0\u0005\u001d"+
		"\u0000\u0000\f\r\u0005\u0001\u0000\u0000\r0\u0005\u001c\u0000\u0000\u000e"+
		"0\u0005\u0002\u0000\u0000\u000f0\u0005\u0003\u0000\u0000\u00100\u0005"+
		"\u0004\u0000\u0000\u00110\u0005\u0005\u0000\u0000\u00120\u0005\u0006\u0000"+
		"\u0000\u00130\u0005\u0007\u0000\u0000\u00140\u0005\b\u0000\u0000\u0015"+
		"\u0016\u0005\u001c\u0000\u0000\u00160\u0005\u001b\u0000\u0000\u0017\u0018"+
		"\u0005\t\u0000\u0000\u00180\u0005\u001c\u0000\u0000\u0019\u001a\u0005"+
		"\n\u0000\u0000\u001a0\u0005\u001c\u0000\u0000\u001b\u001c\u0005\u000b"+
		"\u0000\u0000\u001c0\u0005\u001c\u0000\u0000\u001d\u001e\u0005\f\u0000"+
		"\u0000\u001e0\u0005\u001c\u0000\u0000\u001f \u0005\r\u0000\u0000 0\u0005"+
		"\u001c\u0000\u0000!\"\u0005\u000e\u0000\u0000\"0\u0005\u001c\u0000\u0000"+
		"#0\u0005\u000f\u0000\u0000$0\u0005\u0010\u0000\u0000%0\u0005\u0011\u0000"+
		"\u0000&0\u0005\u0012\u0000\u0000\'0\u0005\u0013\u0000\u0000(0\u0005\u0014"+
		"\u0000\u0000)0\u0005\u0015\u0000\u0000*0\u0005\u0016\u0000\u0000+0\u0005"+
		"\u0017\u0000\u0000,0\u0005\u0018\u0000\u0000-0\u0005\u0019\u0000\u0000"+
		".0\u0005\u001a\u0000\u0000/\n\u0001\u0000\u0000\u0000/\f\u0001\u0000\u0000"+
		"\u0000/\u000e\u0001\u0000\u0000\u0000/\u000f\u0001\u0000\u0000\u0000/"+
		"\u0010\u0001\u0000\u0000\u0000/\u0011\u0001\u0000\u0000\u0000/\u0012\u0001"+
		"\u0000\u0000\u0000/\u0013\u0001\u0000\u0000\u0000/\u0014\u0001\u0000\u0000"+
		"\u0000/\u0015\u0001\u0000\u0000\u0000/\u0017\u0001\u0000\u0000\u0000/"+
		"\u0019\u0001\u0000\u0000\u0000/\u001b\u0001\u0000\u0000\u0000/\u001d\u0001"+
		"\u0000\u0000\u0000/\u001f\u0001\u0000\u0000\u0000/!\u0001\u0000\u0000"+
		"\u0000/#\u0001\u0000\u0000\u0000/$\u0001\u0000\u0000\u0000/%\u0001\u0000"+
		"\u0000\u0000/&\u0001\u0000\u0000\u0000/\'\u0001\u0000\u0000\u0000/(\u0001"+
		"\u0000\u0000\u0000/)\u0001\u0000\u0000\u0000/*\u0001\u0000\u0000\u0000"+
		"/+\u0001\u0000\u0000\u0000/,\u0001\u0000\u0000\u0000/-\u0001\u0000\u0000"+
		"\u0000/.\u0001\u0000\u0000\u00000\u0003\u0001\u0000\u0000\u0000\u0002"+
		"\u0007/";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}