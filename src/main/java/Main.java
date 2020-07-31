//Autor: Jakub Iwon (236612)

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class Main
{

    public static String inputPath = "";
    public static String outputPath = "";

    public static void main(String[] args)
    {

        if(args.length<2)
        {
            System.err.println("Za mało argumentów wejściowych.");
            System.exit(-1);
        }
        else
        {
            inputPath = args[0];
            outputPath = args[1];
        }


        CharStream codePointCharStream = null;
        try
        {
            codePointCharStream = CharStreams.fromFileName(inputPath);
        } 
	   catch (IOException e)
        {
            e.printStackTrace();
        }

        compilerLexer lexer = new compilerLexer(codePointCharStream);
        compilerParser parser = new compilerParser(new CommonTokenStream(lexer));

        parser.removeErrorListeners();

        parser.addErrorListener(new BaseErrorListener()
        {
            @Override
            public void syntaxError(final Recognizer<?,?> recognizer, final Object offendingSymbol, final int line, final int charPositionInLine, final String msg, final RecognitionException e)
            {
                System.err.println("Syntax error, linia: " + line);
                System.exit(-1);
            }
        });

        ParseTree tree = parser.program();
        CompilerVisitor visitor = new CompilerVisitor();
        Attributes answer = visitor.visit(tree);
    }
}
