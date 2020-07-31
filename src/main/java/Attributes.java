//Autor: Jakub Iwon (236612)

public class Attributes
{
    public boolean isArray = false;
    public long address;
    public long from;
    public long to;
    public long arraySize;
    public long startValueAddress;
    public boolean isComplex = false;
    public boolean isNumber = false;
    public boolean initialised = false;
    public boolean controlVariable = false;

    public Attributes() { }

    public Attributes(long address)
    {
        this.address = address;
    }

    public Attributes(String identifier, long address)
    {
        this.address = address;
    }

    public Attributes(String identifier, long address, long from, long to)
    {
        this.isArray = true;
        this.address = address;
        this.from = from;
        this.to = to;
        this.arraySize = to - from + 1;
    }
}