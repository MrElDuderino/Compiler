// Generated from compiler.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link compilerParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface compilerVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link compilerParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(compilerParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link compilerParser#declarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarations(compilerParser.DeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link compilerParser#commands}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommands(compilerParser.CommandsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link compilerParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(compilerParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifElse}
	 * labeled alternative in {@link compilerParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElse(compilerParser.IfElseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if}
	 * labeled alternative in {@link compilerParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(compilerParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code while}
	 * labeled alternative in {@link compilerParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(compilerParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doWhile}
	 * labeled alternative in {@link compilerParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhile(compilerParser.DoWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code for}
	 * labeled alternative in {@link compilerParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor(compilerParser.ForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forDown}
	 * labeled alternative in {@link compilerParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForDown(compilerParser.ForDownContext ctx);
	/**
	 * Visit a parse tree produced by the {@code read}
	 * labeled alternative in {@link compilerParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRead(compilerParser.ReadContext ctx);
	/**
	 * Visit a parse tree produced by the {@code write}
	 * labeled alternative in {@link compilerParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWrite(compilerParser.WriteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleValue}
	 * labeled alternative in {@link compilerParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleValue(compilerParser.SingleValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiplication}
	 * labeled alternative in {@link compilerParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplication(compilerParser.MultiplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addition}
	 * labeled alternative in {@link compilerParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddition(compilerParser.AdditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link compilerParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(compilerParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link compilerParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(compilerParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleIdentifier}
	 * labeled alternative in {@link compilerParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleIdentifier(compilerParser.SimpleIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code complexArray}
	 * labeled alternative in {@link compilerParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComplexArray(compilerParser.ComplexArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleArray}
	 * labeled alternative in {@link compilerParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleArray(compilerParser.SimpleArrayContext ctx);
}