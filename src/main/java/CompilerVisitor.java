//Autor: Jakub Iwon (236612)

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class CompilerVisitor extends compilerBaseVisitor<Attributes>
{
    private Map<String, Attributes> symbolTable = new HashMap<String, Attributes>();
    private long addressCounter = 15;
    private int lineCounter = 1;
    long oneRegister = 1;
    long minusRegister = 2;
    long multAregister = 3;
    long multBregister = 4;
    long modRegister = 5;
    long multCounter = 6;
    long isNegative = 7;
    long isNegativeB = 8;
    long isEqual = 9;
    long tempRegister = 10;

    List<String> lines = new ArrayList<String>();

    @Override
    public Attributes visitProgram(compilerParser.ProgramContext ctx)
    {
        sub(0);
        inc();
        store(oneRegister);
        dec();
        dec();
        store(minusRegister);
        visitChildren(ctx);
        addLine(Command.HALT);

        try {writeToFile(); }
        catch (IOException e) { e.printStackTrace(); }

        return null;
    }

    @Override
    public Attributes visitDeclarations(compilerParser.DeclarationsContext ctx)
    {
        String identifier = ctx.PIDENTIFIER().getText();
        Attributes attributes;

        if(ctx.NUM(0) != null && ctx.NUM(1) != null)
        {
            long from = Long.parseLong(ctx.NUM(0).toString());
            long to = Long.parseLong(ctx.NUM(1).toString());

            if(from > to)
            {
                int line = ctx.getStart().getLine();
                System.err.println("Niewłaściwy zakres tablicy " + identifier + ", linia: " + line);
                System.exit(-1);
            }

            attributes = new Attributes(identifier, addressCounter-from, from, to);
            addressCounter += attributes.arraySize;

            Attributes addressValue = generateNumber(attributes.address);
            attributes.startValueAddress = addressValue.address;
        }
        else
        {
            attributes = new Attributes(identifier, getAddress());
        }

        if(symbolTable.containsKey(identifier))
        {
            int line = ctx.getStart().getLine();
            System.err.println("Ponowna deklaracja zmiennej " + identifier + ", linia: " + line);
        }

        addIdentifier(identifier, attributes);
        return visitChildren(ctx);
    }

    @Override
    public Attributes visitAssign(compilerParser.AssignContext ctx)
    {
        Attributes expressionAttributes = visit(ctx.expression());

        String identifier = ctx.identifier().getText();

        int indexOf = identifier.indexOf('(');
        if(indexOf != -1)
            identifier = identifier.substring(0, indexOf);

        if(symbolTable.containsKey(identifier))
        {
            Attributes attributes = symbolTable.get(identifier);
            if(!attributes.isArray)
                attributes.initialised = true;
        }

        Attributes identifierAttributes = visit(ctx.identifier());

        if(identifierAttributes.controlVariable)
        {
            int line = ctx.getStart().getLine();

            System.err.println("Modyfikacja iteratora pętli " + identifier + ", linia: " + line);
            System.exit(-1);
        }

        load(expressionAttributes);
        store(identifierAttributes);

        return null;
    }

    @Override
    public Attributes visitSimpleIdentifier(compilerParser.SimpleIdentifierContext ctx)
    {
        String identifier = ctx.PIDENTIFIER().getText();
        int line = ctx.getStart().getLine();

        Attributes attributes = getFromSymbolTable(identifier, line);

        if(attributes.isArray)
        {
            System.err.println("Niewłaściwe użycie zmiennej tablicowej " + identifier + ", linia: " + line);
            System.exit(-1);
        }

        return attributes;
    }

    @Override
    public Attributes visitSimpleArray(compilerParser.SimpleArrayContext ctx)
    {
        String arrayIdentifier = ctx.PIDENTIFIER().getText();
        int line = ctx.getStart().getLine();

        Long index = Long.parseLong(ctx.NUM().getText());

        Attributes arrayAttributes = getFromSymbolTable(arrayIdentifier, line);
        arrayAttributes.isComplex = false;

        Attributes result = new Attributes(arrayAttributes.address + index);
        result.isComplex = false;
        result.isNumber = false;

        if(!arrayAttributes.isArray)
        {
            System.err.println("Niewłaściwe użycie zmiennej " + arrayIdentifier + ", linia: " + line);
            System.exit(-1);
        }

        return result;
    }

    @Override
    public Attributes visitComplexArray(compilerParser.ComplexArrayContext ctx)
    {
        String arrayIdentifier = ctx.PIDENTIFIER(0).getText();
        int line = ctx.getStart().getLine();

        Attributes arrayAttributes = getFromSymbolTable(arrayIdentifier, line);

        String indexIdentifier = ctx.PIDENTIFIER(1).getText();
        Attributes indexAttributes = getFromSymbolTable(indexIdentifier, line);

        load(arrayAttributes.startValueAddress);
        add(indexAttributes.address);
        long address = getAddress();
        store(address);

        if(!arrayAttributes.isArray)
        {
            System.err.println("Niewłaściwe użycie zmiennej " + arrayIdentifier + ", linia: " + line);
            System.exit(-1);
        }

        Attributes result = new Attributes(address);
        result.isComplex = true;

        return result;
    }

    @Override
    public Attributes visitIf(compilerParser.IfContext ctx)
    {
        visit(ctx.condition());

        int ifStartLine = lineCounter;

        compilerParser.ConditionContext conditionCtx = ctx.condition();
        String operator = conditionCtx.op.getText();

        if(operator.equals("EQ") || operator.equals("LE") || operator.equals("GE"))
            addLine();

        addLine();

        visitChildren(ctx.commands());

        switch(conditionCtx.op.getType())
        {
            case compilerParser.EQ:
            {
                setLine(ifStartLine-1, Command.JPOS, (lineCounter-1));
                setLine(ifStartLine, Command.JNEG, (lineCounter-1));
                break;
            }
            case compilerParser.NEQ:
            {
                setLine(ifStartLine-1, Command.JZERO, (lineCounter-1));
                break;
            }
            case compilerParser.LE:
            {
                setLine(ifStartLine-1, Command.JPOS, (lineCounter-1));
                setLine(ifStartLine, Command.JZERO, (lineCounter-1));
                break;
            }
            case compilerParser.GE:
            {
                setLine(ifStartLine-1, Command.JNEG, (lineCounter-1));
                setLine(ifStartLine, Command.JZERO, (lineCounter-1));
                break;
            }
            case compilerParser.LEQ:
            {
                setLine(ifStartLine-1, Command.JPOS, (lineCounter-1));
                break;
            }
            case compilerParser.GEQ:
            {
                setLine(ifStartLine-1, Command.JNEG, (lineCounter-1));
                break;
            }
        }

        return null;
    }


    @Override
    public Attributes visitIfElse(compilerParser.IfElseContext ctx)
    {
        visit(ctx.condition());

        int ifStartLine = lineCounter;

        compilerParser.ConditionContext conditionCtx = ctx.condition();
        String operator = conditionCtx.op.getText();

        if(operator.equals("EQ") || operator.equals("LE") || operator.equals("GE"))
            addLine();

        addLine();

        visitChildren(ctx.commands(0));

        addLine();
        int elseLine = lineCounter;

        visitChildren(ctx.commands(1));

        setLine(elseLine-2, Command.JUMP, (lineCounter-1));

        switch(conditionCtx.op.getType())
        {
            case compilerParser.EQ:
            {
                setLine(ifStartLine-1, Command.JPOS, (elseLine-1));
                setLine(ifStartLine, Command.JNEG, (elseLine-1));
                break;
            }
            case compilerParser.NEQ:
            {
                setLine(ifStartLine-1, Command.JZERO, (elseLine-1));
                break;
            }
            case compilerParser.LE:
            {
                setLine(ifStartLine-1, Command.JPOS, (elseLine-1));
                setLine(ifStartLine, Command.JZERO, (elseLine-1));
                break;
            }
            case compilerParser.GE:
            {
                setLine(ifStartLine-1, Command.JNEG, (elseLine-1));
                setLine(ifStartLine, Command.JZERO, (elseLine-1));
                break;
            }
            case compilerParser.LEQ:
            {
                setLine(ifStartLine-1, Command.JPOS, (elseLine-1));
                break;
            }
            case compilerParser.GEQ:
            {
                setLine(ifStartLine-1, Command.JNEG, (elseLine-1));
                break;
            }
        }

        return null;
    }

    @Override
    public Attributes visitCondition(compilerParser.ConditionContext ctx)
    {
        Attributes a = visit(ctx.value(0));
        Attributes b = visit(ctx.value(1));

        subtract(a, b);
        return null;
    }

    @Override
    public Attributes visitFor(compilerParser.ForContext ctx)
    {
        String loopIdentifier = ctx.PIDENTIFIER().getText();
        Attributes loopIdentifierAttributes = new Attributes(getAddress());
        loopIdentifierAttributes.initialised = true;
        loopIdentifierAttributes.controlVariable = true;

        int line = ctx.getStart().getLine();

        addIdentifier(loopIdentifier, loopIdentifierAttributes, line);

        Attributes startAttributes = visit(ctx.value(0));
        load(startAttributes);


        store(loopIdentifierAttributes);

        Attributes endAttributes = visit(ctx.value(1));

        long realCounterAddress = getAddress();

        load(endAttributes);
        store(realCounterAddress);

        int startLine = lineCounter;
        load(realCounterAddress);
        sub(loopIdentifierAttributes.address);
//        addLine();
//        inc();
        int jumpLine = lineCounter;
        addLine();

        visit(ctx.commands());

        increment(loopIdentifierAttributes);

        addLine(Command.JUMP, (startLine-1));
//        setLine(jumpLine-1, Command.JZERO, (lineCounter-1));
        setLine(jumpLine-1, Command.JNEG, (lineCounter-1));

        symbolTable.remove(loopIdentifier);

        return null;
    }

    @Override
    public Attributes visitForDown(compilerParser.ForDownContext ctx)
    {
        String loopIdentifier = ctx.PIDENTIFIER().getText();

        Attributes loopIdentifierAttributes = new Attributes(getAddress());
        loopIdentifierAttributes.initialised = true;
        loopIdentifierAttributes.controlVariable = true;

        int line = ctx.getStart().getLine();

        addIdentifier(loopIdentifier, loopIdentifierAttributes, line);

        Attributes startAttributes = visit(ctx.value(0));
        load(startAttributes);

        store(loopIdentifierAttributes);

        Attributes endAttributes = visit(ctx.value(1));

        long realCounterAddress = getAddress();

        load(endAttributes);
        store(realCounterAddress);

        int startLine = lineCounter;
        load(loopIdentifierAttributes.address);
        sub(realCounterAddress);
//        addLine();
//        inc();
        int jumpLine = lineCounter;
        addLine();

        visit(ctx.commands());

        decrement(loopIdentifierAttributes);

        addLine(Command.JUMP, (startLine-1));
//        setLine(jumpLine-1, Command.JZERO, (lineCounter-1));
        setLine(jumpLine-1, Command.JNEG, (lineCounter-1));

        symbolTable.remove(loopIdentifier);

        return null;
    }

    @Override
    public Attributes visitWhile(compilerParser.WhileContext ctx)
    {
        int startLine = lineCounter;

        visit(ctx.condition());

        compilerParser.ConditionContext conditionCtx = ctx.condition();
        String operator = conditionCtx.op.getText();


        if(operator.equals("EQ") || operator.equals("LE") || operator.equals("GE"))
            addLine();

        int conditionLine = lineCounter;
        addLine();

        visitChildren(ctx.commands());
        addLine(Command.JUMP, (startLine-1));

        switch(conditionCtx.op.getType())
        {
            case compilerParser.EQ:
            {
                setLine(conditionLine-2, Command.JPOS, (lineCounter-1));
                setLine(conditionLine-1, Command.JNEG, (lineCounter-1));
                break;
            }
            case compilerParser.NEQ:
            {
                setLine(conditionLine-1, Command.JZERO, (lineCounter-1));
                break;
            }
            case compilerParser.LE:
            {
                setLine(conditionLine-2, Command.JPOS, (lineCounter-1));
                setLine(conditionLine-1, Command.JZERO, (lineCounter-1));
                break;
            }
            case compilerParser.GE:
            {
                setLine(conditionLine-2, Command.JNEG, (lineCounter-1));
                setLine(conditionLine-1, Command.JZERO, (lineCounter-1));
                break;
            }
            case compilerParser.LEQ:
            {
                setLine(conditionLine-1, Command.JPOS, (lineCounter-1));
                break;
            }
            case compilerParser.GEQ:
            {
                setLine(conditionLine-1, Command.JNEG, (lineCounter-1));
                break;
            }
        }

        return null;
    }


    @Override
    public Attributes visitDoWhile(compilerParser.DoWhileContext ctx)
    {
        int startLine = lineCounter;

        visit(ctx.commands());

        visit(ctx.condition());

        compilerParser.ConditionContext conditionCtx = ctx.condition();
        String operator = conditionCtx.op.getText();

        switch(conditionCtx.op.getType())
        {
            case compilerParser.EQ:
            {
                addLine(Command.JZERO, (startLine-1));
                break;
            }
            case compilerParser.NEQ:
            {
                addLine(Command.JPOS, (startLine-1));
                addLine(Command.JNEG, (startLine-1));
                break;
            }
            case compilerParser.LE:
            {
                addLine(Command.JNEG, (startLine-1));
                break;
            }
            case compilerParser.GE:
            {
                addLine(Command.JPOS, (startLine-1));
                break;
            }
            case compilerParser.LEQ:
            {
                addLine(Command.JNEG, (startLine-1));
                addLine(Command.JZERO, (startLine-1));
                break;
            }
            case compilerParser.GEQ:
            {
                addLine(Command.JPOS, (startLine-1));
                addLine(Command.JZERO, (startLine-1));
                break;
            }
        }

        return null;
    }


    @Override
    public Attributes visitAddition(compilerParser.AdditionContext ctx)
    {
        Attributes a = this.visit(ctx.value(0));
        Attributes b = this.visit(ctx.value(1));

        Attributes result = new Attributes(getAddress());

        switch (ctx.op.getType())
        {
            case compilerParser.PLUS:
            {
                add(a, b);
                break;
            }
            case compilerParser.MINUS:
            {
                subtract(a, b);
                break;
            }
        }

        store(result);
        return result;
    }


    @Override
    public Attributes visitMultiplication(compilerParser.MultiplicationContext ctx)
    {
        Attributes a = this.visit(ctx.value(0));
        Attributes b = this.visit(ctx.value(1));

        Attributes result = null;

        switch (ctx.op.getType())
        {
            case compilerParser.TIMES:
            {
                result = multiply(a, b);
                break;
            }
            case compilerParser.DIV:
            {
                result = divide(a, b);
                break;
            }
            case compilerParser.MOD:
            {
                result = modulo(a, b);
                break;
            }
        }

        return result;
    }

    @Override
    public Attributes visitValue(compilerParser.ValueContext ctx)
    {
        if(ctx.identifier() != null)
            return visitChildren(ctx);
        else
        {
            long num = Long.parseLong(ctx.NUM().toString());
            Attributes numAttributes = generateNumber(num);
            return numAttributes;
        }
    }

    @Override
    public Attributes visitWrite(compilerParser.WriteContext ctx)
    {
        Attributes valueAttributes = visit(ctx.value());

        load(valueAttributes);
        addLine(Command.PUT);

        return null;
    }

    @Override
    public Attributes visitRead(compilerParser.ReadContext ctx)
    {
        String identifier = ctx.identifier().getText();

        int indexOf = identifier.indexOf('(');
        if(indexOf != -1)
            identifier = identifier.substring(0, indexOf);

        if(symbolTable.containsKey(identifier))
        {
            Attributes attributes = symbolTable.get(identifier);
            if(!attributes.isArray)
                attributes.initialised = true;
        }


        Attributes identifierAttributes = visit(ctx.identifier());

        addLine(Command.GET);
        store(identifierAttributes);

        return null;
    }

    private Attributes generateNumber(long num)
    {
        List<String> factors = new ArrayList<String>();

        Command command;
        if(num<0)
            command = Command.DEC;
        else
            command = Command.INC;

        long address = getAddress();
        factors.add(Command.STORE + " " + address);

        long value = num;

        while(num != 0)
        {
            if(num % 2 == 0)
            {
                factors.add(Command.SHIFT + " " + oneRegister);
                num /= 2;
            }
            else
            {
                factors.add(command.toString());
                if(num>0)
                    num -= 1;
                else
                    num += 1;
            }
        }

        factors.add(Command.SUB + " " + 0);

        Collections.reverse(factors);

        for(String factor : factors)
            addLine(factor);

        Attributes result = new Attributes();
        result.isNumber = true;
        result.address = address;

        return result;
    }


    public Attributes addIdentifier(String identifier, Attributes attributes)
    {
        if(symbolTable.containsKey(identifier))
            System.exit(-1);

        return symbolTable.put(identifier, attributes);
    }

    public Attributes addIdentifier(String identifier, Attributes attributes, int line)
    {
        if(symbolTable.containsKey(identifier))
        {
            System.err.println("Ponowna deklaracja zmiennej " + identifier + ", linia: " + line);
            System.exit(-1);
        }

        return symbolTable.put(identifier, attributes);
    }

    public Attributes getFromSymbolTable(String identifier)
    {
        if(!symbolTable.containsKey(identifier))
            System.exit(-1);

        return symbolTable.get(identifier);
    }

    public Attributes getFromSymbolTable(String identifier, int line)
    {
        if(!symbolTable.containsKey(identifier))
        {
            System.err.println("Użycie niezadeklarowanej zmiennej " + identifier + ", linia: " + line);
            System.exit(-1);
        }

        Attributes attributes = symbolTable.get(identifier);

        if(!attributes.isArray && !attributes.initialised)
        {
            System.err.println("Użycie niezainicjalizowanej zmiennej " + identifier + ", linia: " + line);
            System.exit(-1);
        }

        return attributes;
    }

    public void load(Attributes attributes)
    {
        if(attributes.isComplex)
        {
            addLine(Command.LOADI, attributes.address);
        }
        else
        {
            addLine(Command.LOAD, attributes.address);
        }
    }

    public void store(Attributes attributes)
    {
        if(attributes.isComplex)
        {
            addLine(Command.STOREI, attributes.address);
        }
        else
        {
            addLine(Command.STORE, attributes.address);
        }
    }

    public void load(long address)
    {
        addLine(Command.LOAD, address);
    }

    public void store(long address)
    {
        addLine(Command.STORE, address);
    }

    public void loadi(long address)
    {
        addLine(Command.LOADI, address);
    }

    public void storei(long address)
    {
        addLine(Command.STOREI, address);
    }

    public void add(long address)
    {
        addLine(Command.ADD, address);
    }

    public void sub(long address)
    {
        addLine(Command.SUB, address);
    }

    public void shift(long address)
    {
        addLine(Command.SHIFT, address);
    }

    public void inc()
    {
        addLine(Command.INC);
    }

    public void dec()
    {
        addLine(Command.DEC);
    }

    public void add(Attributes a1, Attributes a2)
    {
        if(a2.isComplex)
        {
            long address = getAddress();

            if(a1.isComplex)
            {
                loadi(a2.address);
                store(address);
                loadi(a1.address);
                add(address);
            }
            else
            {
                loadi(a2.address);
                store(address);
                load(a1.address);
                add(address);
            }
        }
        else
        {
            if(a1.isComplex)
            {
                loadi(a1.address);
                add(a2.address);
            }
            else
            {
                load(a1.address);
                add(a2.address);
            }
        }
    }

    public void subtract(Attributes a1, Attributes a2)
    {
        if(a2.isComplex)
        {
            long address = getAddress();

            if(a1.isComplex)
            {
                loadi(a2.address);
                store(address);
                loadi(a1.address);
                sub(address);
            }
            else
            {
                loadi(a2.address);
                store(address);
                load(a1.address);
                sub(address);
            }
        }
        else
        {
            if(a1.isComplex)
            {
                loadi(a1.address);
                sub(a2.address);
            }
            else
            {
                load(a1.address);
                sub(a2.address);
            }
        }
    }

    public Attributes multiply(Attributes a, Attributes b)
    {
        long address = getAddress();

        sub(0);
        store(address);
        store(multCounter);
        store(modRegister);
        store(isNegative);

        load(a);
        store(multAregister);
        load(b);
        store(multBregister);


        /*  Zamiana kolejności argumentów */


        store(isNegativeB);
        addLine(Command.JPOS, (lineCounter+4));
        addLine(Command.JZERO, (lineCounter+3));
        sub(isNegativeB);
        sub(isNegativeB);
        store(isNegativeB);

        load(multAregister);
        store(tempRegister);
        addLine(Command.JPOS, (lineCounter+4));
        addLine(Command.JZERO, (lineCounter+3));
        sub(tempRegister);
        sub(tempRegister);
        store(tempRegister);

        sub(isNegativeB);
        addLine(Command.JPOS, (lineCounter+7));
        addLine(Command.JZERO, (lineCounter+6));
        load(multAregister);
        store(tempRegister);
        load(multBregister);
        store(multAregister);
        load(tempRegister);
        store(multBregister);

        /* ____________________ */

        load(multBregister);
        addLine(Command.JPOS, (lineCounter+5));
        addLine(Command.JZERO, (lineCounter+4));
        sub(multBregister);
        sub(multBregister);
        store(multBregister);
        store(isNegative);


        int whileLine = lineCounter;
        load(multBregister);
        addLine();
        shift(minusRegister);
        store(modRegister);
        load(multBregister);
        sub(modRegister);
        sub(modRegister);
        store(modRegister);
        int ifLine = lineCounter;
        addLine(Command.JZERO, (lineCounter + 5));
        load(multAregister);
        shift(multCounter);
        store(modRegister);
        add(address);
        store(address);

        load(multCounter);
        inc();
        store(multCounter);
        load(multBregister);
        shift(minusRegister);
        store(multBregister);

        addLine(Command.JUMP, (whileLine-1));
        setLine(whileLine, Command.JZERO, (lineCounter-1));

        load(isNegative);
        addLine(Command.JZERO, (lineCounter+6));
        load(address);
        sub(address);
        sub(address);
        store(address);
        sub(0);
        store(isNegative);

        return new Attributes(address);
    }


    public Attributes divide(Attributes a, Attributes b)
    {
        long address = getAddress();

        sub(0);
        store(isNegative);
        store(isNegativeB);
        store(modRegister);
        store(multCounter);
        store(isEqual);
        store(address);

        load(a);
        store(multAregister);
        addLine(Command.JPOS, (lineCounter + 7));
        int zeroLine1 = lineCounter;
        addLine();
        sub(multAregister);
        sub(multAregister);
        store(multAregister);
        sub(0);
        inc();
        store(isNegative);

        load(b);
        store(multBregister);
        addLine(Command.JPOS, (lineCounter + 7));
        int zeroLine2 = lineCounter;
        addLine();
        sub(multBregister);
        sub(multBregister);
        store(multBregister);
        sub(0);
        inc();
        store(isNegativeB);

        load(multBregister);
        shift(multCounter);
        sub(multAregister);
        addLine(Command.JPOS, (lineCounter + 4));
        load(multCounter);
        inc();
        store(multCounter);
        addLine(Command.JUMP, (lineCounter - 8));

        load(multCounter);
        int startLine = lineCounter;
        addLine();

        load(multBregister);
        shift(multCounter);
        add(modRegister);
        store(tempRegister);
        sub(multAregister);
        addLine(Command.JPOS, (lineCounter + 11));
        load(tempRegister);
        store(modRegister);
        sub(multAregister);
        addLine(Command.JPOS, (lineCounter + 3));
        addLine(Command.JNEG, (lineCounter + 2));
        inc();
        store(isEqual);

        load(oneRegister);
        shift(multCounter);
        add(address);
        store(address);

        load(multCounter);
        dec();
        store(multCounter);

        addLine(Command.JUMP, (startLine - 1));

        setLine(startLine - 1, Command.JNEG, (lineCounter - 1));

        load(isNegative);
        sub(isNegativeB);
        addLine(Command.JZERO, (lineCounter + 9));
        load(address);
        sub(address);
        sub(address);
        store(address);
        load(isEqual);
        addLine(Command.JPOS, (lineCounter + 3));
        load(address);
        dec();
        store(address);

        setLine(zeroLine1 - 1, Command.JZERO, (lineCounter - 1));
        setLine(zeroLine2 - 1, Command.JZERO, (lineCounter - 1));

        return new Attributes(address);
    }

    public Attributes modulo(Attributes a, Attributes b)
    {
        long address = getAddress();

        sub(0);
        store(address);

        load(b);
        int zeroLine = lineCounter;
        addLine();

        Attributes result1 = divide(a, b);

        Attributes result2 = multiply(result1, b);

        load(a);
        sub(result2.address);
        store(address);

        setLine(zeroLine-1, Command.JZERO, (lineCounter-1));

        return new Attributes(address);
    }


    public void decrement(Attributes attributes)
    {
        load(attributes.address);
        dec();
        store(attributes.address);
    }

    public void increment(Attributes attributes)
    {
        load(attributes.address);
        inc();
        store(attributes.address);
    }

    public long getAddress()
    {
        long a = this.addressCounter;
        this.addressCounter++;
        return a;
    }

    public void addLine(Command command)
    {
        this.lines.add(command.toString());
        this.lineCounter++;
    }

    public void addLine(Command command, long address)
    {
        String s = command.toString() + " " + address;
        this.lines.add(s);
        this.lineCounter++;
    }

    public void addLine()
    {
        this.lines.add("");
        this.lineCounter++;
    }

    public void addLine(String line)
    {
        this.lines.add(line);
        this.lineCounter++;
    }

    public void setLine(int lineNo, Command command)
    {
        this.lines.set(lineNo, command.toString());
    }

    public void setLine(int lineNo, Command command, long address)
    {
        String s = command.toString() + " " + address;
        this.lines.set(lineNo, s);
    }

    public void writeToFile() throws IOException
    {
        FileWriter fileWriter = new FileWriter(Main.outputPath);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        for(String line : lines)
        {
            printWriter.println(line);
        }

        printWriter.close();
    }
}
