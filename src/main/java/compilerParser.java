// Generated from compiler.g4 by ANTLR 4.7
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class compilerParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, NUM=6, PLUS=7, MINUS=8, TIMES=9, 
		DIV=10, MOD=11, EQ=12, NEQ=13, LE=14, GE=15, LEQ=16, GEQ=17, IF=18, THEN=19, 
		ELSE=20, ENDIF=21, WHILE=22, DO=23, ENDDO=24, FOR=25, FROM=26, TO=27, 
		DOWNTO=28, ENDFOR=29, ENDWHILE=30, ASSIGN=31, READ=32, WRITE=33, DECLARE=34, 
		BEGIN=35, END=36, PIDENTIFIER=37, WHITE=38, COMMENT=39, OTHER=40;
	public static final int
		RULE_program = 0, RULE_declarations = 1, RULE_commands = 2, RULE_command = 3, 
		RULE_expression = 4, RULE_condition = 5, RULE_value = 6, RULE_identifier = 7;
	public static final String[] ruleNames = {
		"program", "declarations", "commands", "command", "expression", "condition", 
		"value", "identifier"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'('", "':'", "')'", "';'", null, "'PLUS'", "'MINUS'", "'TIMES'", 
		"'DIV'", "'MOD'", "'EQ'", "'NEQ'", "'LE'", "'GE'", "'LEQ'", "'GEQ'", "'IF'", 
		"'THEN'", "'ELSE'", "'ENDIF'", "'WHILE'", "'DO'", "'ENDDO'", "'FOR'", 
		"'FROM'", "'TO'", "'DOWNTO'", "'ENDFOR'", "'ENDWHILE'", "'ASSIGN'", "'READ'", 
		"'WRITE'", "'DECLARE'", "'BEGIN'", "'END'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "NUM", "PLUS", "MINUS", "TIMES", "DIV", 
		"MOD", "EQ", "NEQ", "LE", "GE", "LEQ", "GEQ", "IF", "THEN", "ELSE", "ENDIF", 
		"WHILE", "DO", "ENDDO", "FOR", "FROM", "TO", "DOWNTO", "ENDFOR", "ENDWHILE", 
		"ASSIGN", "READ", "WRITE", "DECLARE", "BEGIN", "END", "PIDENTIFIER", "WHITE", 
		"COMMENT", "OTHER"
	};
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
	public String getGrammarFileName() { return "compiler.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public compilerParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode DECLARE() { return getToken(compilerParser.DECLARE, 0); }
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(compilerParser.BEGIN, 0); }
		public CommandsContext commands() {
			return getRuleContext(CommandsContext.class,0);
		}
		public TerminalNode END() { return getToken(compilerParser.END, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compilerVisitor ) return ((compilerVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			setState(26);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECLARE:
				enterOuterAlt(_localctx, 1);
				{
				setState(16);
				match(DECLARE);
				setState(17);
				declarations(0);
				setState(18);
				match(BEGIN);
				setState(19);
				commands(0);
				setState(20);
				match(END);
				}
				break;
			case BEGIN:
				enterOuterAlt(_localctx, 2);
				{
				setState(22);
				match(BEGIN);
				setState(23);
				commands(0);
				setState(24);
				match(END);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class DeclarationsContext extends ParserRuleContext {
		public TerminalNode PIDENTIFIER() { return getToken(compilerParser.PIDENTIFIER, 0); }
		public List<TerminalNode> NUM() { return getTokens(compilerParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(compilerParser.NUM, i);
		}
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public DeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarations; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compilerVisitor ) return ((compilerVisitor<? extends T>)visitor).visitDeclarations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationsContext declarations() throws RecognitionException {
		return declarations(0);
	}

	private DeclarationsContext declarations(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DeclarationsContext _localctx = new DeclarationsContext(_ctx, _parentState);
		DeclarationsContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_declarations, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(29);
				match(PIDENTIFIER);
				}
				break;
			case 2:
				{
				setState(30);
				match(PIDENTIFIER);
				setState(31);
				match(T__1);
				setState(32);
				match(NUM);
				setState(33);
				match(T__2);
				setState(34);
				match(NUM);
				setState(35);
				match(T__3);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(51);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(49);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new DeclarationsContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_declarations);
						setState(38);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(39);
						match(T__0);
						setState(40);
						match(PIDENTIFIER);
						}
						break;
					case 2:
						{
						_localctx = new DeclarationsContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_declarations);
						setState(41);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(42);
						match(T__0);
						setState(43);
						match(PIDENTIFIER);
						setState(44);
						match(T__1);
						setState(45);
						match(NUM);
						setState(46);
						match(T__2);
						setState(47);
						match(NUM);
						setState(48);
						match(T__3);
						}
						break;
					}
					} 
				}
				setState(53);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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

	public static class CommandsContext extends ParserRuleContext {
		public CommandContext command() {
			return getRuleContext(CommandContext.class,0);
		}
		public CommandsContext commands() {
			return getRuleContext(CommandsContext.class,0);
		}
		public CommandsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commands; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compilerVisitor ) return ((compilerVisitor<? extends T>)visitor).visitCommands(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandsContext commands() throws RecognitionException {
		return commands(0);
	}

	private CommandsContext commands(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CommandsContext _localctx = new CommandsContext(_ctx, _parentState);
		CommandsContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_commands, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(55);
			command();
			}
			_ctx.stop = _input.LT(-1);
			setState(61);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CommandsContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_commands);
					setState(57);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(58);
					command();
					}
					} 
				}
				setState(63);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public static class CommandContext extends ParserRuleContext {
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
	 
		public CommandContext() { }
		public void copyFrom(CommandContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ReadContext extends CommandContext {
		public TerminalNode READ() { return getToken(compilerParser.READ, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ReadContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compilerVisitor ) return ((compilerVisitor<? extends T>)visitor).visitRead(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DoWhileContext extends CommandContext {
		public TerminalNode DO() { return getToken(compilerParser.DO, 0); }
		public CommandsContext commands() {
			return getRuleContext(CommandsContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(compilerParser.WHILE, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode ENDDO() { return getToken(compilerParser.ENDDO, 0); }
		public DoWhileContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compilerVisitor ) return ((compilerVisitor<? extends T>)visitor).visitDoWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForDownContext extends CommandContext {
		public TerminalNode FOR() { return getToken(compilerParser.FOR, 0); }
		public TerminalNode PIDENTIFIER() { return getToken(compilerParser.PIDENTIFIER, 0); }
		public TerminalNode FROM() { return getToken(compilerParser.FROM, 0); }
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TerminalNode DOWNTO() { return getToken(compilerParser.DOWNTO, 0); }
		public TerminalNode DO() { return getToken(compilerParser.DO, 0); }
		public CommandsContext commands() {
			return getRuleContext(CommandsContext.class,0);
		}
		public TerminalNode ENDFOR() { return getToken(compilerParser.ENDFOR, 0); }
		public ForDownContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compilerVisitor ) return ((compilerVisitor<? extends T>)visitor).visitForDown(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForContext extends CommandContext {
		public TerminalNode FOR() { return getToken(compilerParser.FOR, 0); }
		public TerminalNode PIDENTIFIER() { return getToken(compilerParser.PIDENTIFIER, 0); }
		public TerminalNode FROM() { return getToken(compilerParser.FROM, 0); }
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TerminalNode TO() { return getToken(compilerParser.TO, 0); }
		public TerminalNode DO() { return getToken(compilerParser.DO, 0); }
		public CommandsContext commands() {
			return getRuleContext(CommandsContext.class,0);
		}
		public TerminalNode ENDFOR() { return getToken(compilerParser.ENDFOR, 0); }
		public ForContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compilerVisitor ) return ((compilerVisitor<? extends T>)visitor).visitFor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileContext extends CommandContext {
		public TerminalNode WHILE() { return getToken(compilerParser.WHILE, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode DO() { return getToken(compilerParser.DO, 0); }
		public CommandsContext commands() {
			return getRuleContext(CommandsContext.class,0);
		}
		public TerminalNode ENDWHILE() { return getToken(compilerParser.ENDWHILE, 0); }
		public WhileContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compilerVisitor ) return ((compilerVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfElseContext extends CommandContext {
		public TerminalNode IF() { return getToken(compilerParser.IF, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode THEN() { return getToken(compilerParser.THEN, 0); }
		public List<CommandsContext> commands() {
			return getRuleContexts(CommandsContext.class);
		}
		public CommandsContext commands(int i) {
			return getRuleContext(CommandsContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(compilerParser.ELSE, 0); }
		public TerminalNode ENDIF() { return getToken(compilerParser.ENDIF, 0); }
		public IfElseContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compilerVisitor ) return ((compilerVisitor<? extends T>)visitor).visitIfElse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfContext extends CommandContext {
		public TerminalNode IF() { return getToken(compilerParser.IF, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode THEN() { return getToken(compilerParser.THEN, 0); }
		public CommandsContext commands() {
			return getRuleContext(CommandsContext.class,0);
		}
		public TerminalNode ENDIF() { return getToken(compilerParser.ENDIF, 0); }
		public IfContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compilerVisitor ) return ((compilerVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WriteContext extends CommandContext {
		public TerminalNode WRITE() { return getToken(compilerParser.WRITE, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public WriteContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compilerVisitor ) return ((compilerVisitor<? extends T>)visitor).visitWrite(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignContext extends CommandContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(compilerParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compilerVisitor ) return ((compilerVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_command);
		try {
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new AssignContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				identifier();
				setState(65);
				match(ASSIGN);
				setState(66);
				expression();
				setState(67);
				match(T__4);
				}
				break;
			case 2:
				_localctx = new IfElseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				match(IF);
				setState(70);
				condition();
				setState(71);
				match(THEN);
				setState(72);
				commands(0);
				setState(73);
				match(ELSE);
				setState(74);
				commands(0);
				setState(75);
				match(ENDIF);
				}
				break;
			case 3:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(77);
				match(IF);
				setState(78);
				condition();
				setState(79);
				match(THEN);
				setState(80);
				commands(0);
				setState(81);
				match(ENDIF);
				}
				break;
			case 4:
				_localctx = new WhileContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(83);
				match(WHILE);
				setState(84);
				condition();
				setState(85);
				match(DO);
				setState(86);
				commands(0);
				setState(87);
				match(ENDWHILE);
				}
				break;
			case 5:
				_localctx = new DoWhileContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(89);
				match(DO);
				setState(90);
				commands(0);
				setState(91);
				match(WHILE);
				setState(92);
				condition();
				setState(93);
				match(ENDDO);
				}
				break;
			case 6:
				_localctx = new ForContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(95);
				match(FOR);
				setState(96);
				match(PIDENTIFIER);
				setState(97);
				match(FROM);
				setState(98);
				value();
				setState(99);
				match(TO);
				setState(100);
				value();
				setState(101);
				match(DO);
				setState(102);
				commands(0);
				setState(103);
				match(ENDFOR);
				}
				break;
			case 7:
				_localctx = new ForDownContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(105);
				match(FOR);
				setState(106);
				match(PIDENTIFIER);
				setState(107);
				match(FROM);
				setState(108);
				value();
				setState(109);
				match(DOWNTO);
				setState(110);
				value();
				setState(111);
				match(DO);
				setState(112);
				commands(0);
				setState(113);
				match(ENDFOR);
				}
				break;
			case 8:
				_localctx = new ReadContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(115);
				match(READ);
				setState(116);
				identifier();
				setState(117);
				match(T__4);
				}
				break;
			case 9:
				_localctx = new WriteContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(119);
				match(WRITE);
				setState(120);
				value();
				setState(121);
				match(T__4);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SingleValueContext extends ExpressionContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public SingleValueContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compilerVisitor ) return ((compilerVisitor<? extends T>)visitor).visitSingleValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiplicationContext extends ExpressionContext {
		public Token op;
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TerminalNode TIMES() { return getToken(compilerParser.TIMES, 0); }
		public TerminalNode DIV() { return getToken(compilerParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(compilerParser.MOD, 0); }
		public MultiplicationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compilerVisitor ) return ((compilerVisitor<? extends T>)visitor).visitMultiplication(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AdditionContext extends ExpressionContext {
		public Token op;
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(compilerParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(compilerParser.MINUS, 0); }
		public AdditionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compilerVisitor ) return ((compilerVisitor<? extends T>)visitor).visitAddition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expression);
		int _la;
		try {
			setState(134);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new SingleValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				value();
				}
				break;
			case 2:
				_localctx = new MultiplicationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				value();
				setState(127);
				((MultiplicationContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TIMES) | (1L << DIV) | (1L << MOD))) != 0)) ) {
					((MultiplicationContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(128);
				value();
				}
				break;
			case 3:
				_localctx = new AdditionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(130);
				value();
				setState(131);
				((AdditionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
					((AdditionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(132);
				value();
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

	public static class ConditionContext extends ParserRuleContext {
		public Token op;
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TerminalNode EQ() { return getToken(compilerParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(compilerParser.NEQ, 0); }
		public TerminalNode LE() { return getToken(compilerParser.LE, 0); }
		public TerminalNode GE() { return getToken(compilerParser.GE, 0); }
		public TerminalNode LEQ() { return getToken(compilerParser.LEQ, 0); }
		public TerminalNode GEQ() { return getToken(compilerParser.GEQ, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compilerVisitor ) return ((compilerVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			value();
			setState(137);
			((ConditionContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << LE) | (1L << GE) | (1L << LEQ) | (1L << GEQ))) != 0)) ) {
				((ConditionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(138);
			value();
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

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(compilerParser.NUM, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compilerVisitor ) return ((compilerVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_value);
		try {
			setState(142);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				match(NUM);
				}
				break;
			case PIDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
				identifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class IdentifierContext extends ParserRuleContext {
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
	 
		public IdentifierContext() { }
		public void copyFrom(IdentifierContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SimpleArrayContext extends IdentifierContext {
		public TerminalNode PIDENTIFIER() { return getToken(compilerParser.PIDENTIFIER, 0); }
		public TerminalNode NUM() { return getToken(compilerParser.NUM, 0); }
		public SimpleArrayContext(IdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compilerVisitor ) return ((compilerVisitor<? extends T>)visitor).visitSimpleArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SimpleIdentifierContext extends IdentifierContext {
		public TerminalNode PIDENTIFIER() { return getToken(compilerParser.PIDENTIFIER, 0); }
		public SimpleIdentifierContext(IdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compilerVisitor ) return ((compilerVisitor<? extends T>)visitor).visitSimpleIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComplexArrayContext extends IdentifierContext {
		public List<TerminalNode> PIDENTIFIER() { return getTokens(compilerParser.PIDENTIFIER); }
		public TerminalNode PIDENTIFIER(int i) {
			return getToken(compilerParser.PIDENTIFIER, i);
		}
		public ComplexArrayContext(IdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compilerVisitor ) return ((compilerVisitor<? extends T>)visitor).visitComplexArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_identifier);
		try {
			setState(153);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new SimpleIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				match(PIDENTIFIER);
				}
				break;
			case 2:
				_localctx = new ComplexArrayContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
				match(PIDENTIFIER);
				setState(146);
				match(T__1);
				setState(147);
				match(PIDENTIFIER);
				setState(148);
				match(T__3);
				}
				break;
			case 3:
				_localctx = new SimpleArrayContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(149);
				match(PIDENTIFIER);
				setState(150);
				match(T__1);
				setState(151);
				match(NUM);
				setState(152);
				match(T__3);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return declarations_sempred((DeclarationsContext)_localctx, predIndex);
		case 2:
			return commands_sempred((CommandsContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean declarations_sempred(DeclarationsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean commands_sempred(CommandsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3*\u009e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\5\2\35\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5"+
		"\3\'\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\64\n\3\f\3\16"+
		"\3\67\13\3\3\4\3\4\3\4\3\4\3\4\7\4>\n\4\f\4\16\4A\13\4\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\5\5~\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u0089\n\6"+
		"\3\7\3\7\3\7\3\7\3\b\3\b\5\b\u0091\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\5\t\u009c\n\t\3\t\2\4\4\6\n\2\4\6\b\n\f\16\20\2\5\3\2\13\r\3\2\t"+
		"\n\3\2\16\23\2\u00a7\2\34\3\2\2\2\4&\3\2\2\2\68\3\2\2\2\b}\3\2\2\2\n\u0088"+
		"\3\2\2\2\f\u008a\3\2\2\2\16\u0090\3\2\2\2\20\u009b\3\2\2\2\22\23\7$\2"+
		"\2\23\24\5\4\3\2\24\25\7%\2\2\25\26\5\6\4\2\26\27\7&\2\2\27\35\3\2\2\2"+
		"\30\31\7%\2\2\31\32\5\6\4\2\32\33\7&\2\2\33\35\3\2\2\2\34\22\3\2\2\2\34"+
		"\30\3\2\2\2\35\3\3\2\2\2\36\37\b\3\1\2\37\'\7\'\2\2 !\7\'\2\2!\"\7\4\2"+
		"\2\"#\7\b\2\2#$\7\5\2\2$%\7\b\2\2%\'\7\6\2\2&\36\3\2\2\2& \3\2\2\2\'\65"+
		"\3\2\2\2()\f\6\2\2)*\7\3\2\2*\64\7\'\2\2+,\f\5\2\2,-\7\3\2\2-.\7\'\2\2"+
		"./\7\4\2\2/\60\7\b\2\2\60\61\7\5\2\2\61\62\7\b\2\2\62\64\7\6\2\2\63(\3"+
		"\2\2\2\63+\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66\5\3\2"+
		"\2\2\67\65\3\2\2\289\b\4\1\29:\5\b\5\2:?\3\2\2\2;<\f\4\2\2<>\5\b\5\2="+
		";\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@\7\3\2\2\2A?\3\2\2\2BC\5\20\t"+
		"\2CD\7!\2\2DE\5\n\6\2EF\7\7\2\2F~\3\2\2\2GH\7\24\2\2HI\5\f\7\2IJ\7\25"+
		"\2\2JK\5\6\4\2KL\7\26\2\2LM\5\6\4\2MN\7\27\2\2N~\3\2\2\2OP\7\24\2\2PQ"+
		"\5\f\7\2QR\7\25\2\2RS\5\6\4\2ST\7\27\2\2T~\3\2\2\2UV\7\30\2\2VW\5\f\7"+
		"\2WX\7\31\2\2XY\5\6\4\2YZ\7 \2\2Z~\3\2\2\2[\\\7\31\2\2\\]\5\6\4\2]^\7"+
		"\30\2\2^_\5\f\7\2_`\7\32\2\2`~\3\2\2\2ab\7\33\2\2bc\7\'\2\2cd\7\34\2\2"+
		"de\5\16\b\2ef\7\35\2\2fg\5\16\b\2gh\7\31\2\2hi\5\6\4\2ij\7\37\2\2j~\3"+
		"\2\2\2kl\7\33\2\2lm\7\'\2\2mn\7\34\2\2no\5\16\b\2op\7\36\2\2pq\5\16\b"+
		"\2qr\7\31\2\2rs\5\6\4\2st\7\37\2\2t~\3\2\2\2uv\7\"\2\2vw\5\20\t\2wx\7"+
		"\7\2\2x~\3\2\2\2yz\7#\2\2z{\5\16\b\2{|\7\7\2\2|~\3\2\2\2}B\3\2\2\2}G\3"+
		"\2\2\2}O\3\2\2\2}U\3\2\2\2}[\3\2\2\2}a\3\2\2\2}k\3\2\2\2}u\3\2\2\2}y\3"+
		"\2\2\2~\t\3\2\2\2\177\u0089\5\16\b\2\u0080\u0081\5\16\b\2\u0081\u0082"+
		"\t\2\2\2\u0082\u0083\5\16\b\2\u0083\u0089\3\2\2\2\u0084\u0085\5\16\b\2"+
		"\u0085\u0086\t\3\2\2\u0086\u0087\5\16\b\2\u0087\u0089\3\2\2\2\u0088\177"+
		"\3\2\2\2\u0088\u0080\3\2\2\2\u0088\u0084\3\2\2\2\u0089\13\3\2\2\2\u008a"+
		"\u008b\5\16\b\2\u008b\u008c\t\4\2\2\u008c\u008d\5\16\b\2\u008d\r\3\2\2"+
		"\2\u008e\u0091\7\b\2\2\u008f\u0091\5\20\t\2\u0090\u008e\3\2\2\2\u0090"+
		"\u008f\3\2\2\2\u0091\17\3\2\2\2\u0092\u009c\7\'\2\2\u0093\u0094\7\'\2"+
		"\2\u0094\u0095\7\4\2\2\u0095\u0096\7\'\2\2\u0096\u009c\7\6\2\2\u0097\u0098"+
		"\7\'\2\2\u0098\u0099\7\4\2\2\u0099\u009a\7\b\2\2\u009a\u009c\7\6\2\2\u009b"+
		"\u0092\3\2\2\2\u009b\u0093\3\2\2\2\u009b\u0097\3\2\2\2\u009c\21\3\2\2"+
		"\2\13\34&\63\65?}\u0088\u0090\u009b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}