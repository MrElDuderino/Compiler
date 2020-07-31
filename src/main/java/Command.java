//Autor: Jakub Iwon (236612)

public enum Command
{
    GET("GET"),
    PUT("PUT"),
    LOAD("LOAD"),
    STORE("STORE"),
    LOADI("LOADI"),
    STOREI("STOREI"),
    ADD("ADD"),
    SUB("SUB"),
    SHIFT("SHIFT"),
    INC("INC"),
    DEC("DEC"),
    JUMP("JUMP"),
    JPOS("JPOS"),
    JZERO("JZERO"),
    JNEG("JNEG"),
    HALT("HALT");

    private String command;

    Command(String command)
    {
        this.command = command;
    }

    @Override
    public String toString()
    {
        return this.command;
    }

}
