package container;
import java.util.*;

public class Mylet2 extends Mylet
{
    @Override
    public void init()
    {
        System.out.println("In Mylet2.init");
    }
    
    @Override
    public void doGet(String method, Hashtable inputHeaders, Hashtable params, Hashtable outputHeaders, StringBuilder outputContent)
    {
    }

    @Override
    public void doPost(String method, Hashtable inputHeaders, Hashtable params, Hashtable outputHeaders, StringBuilder outputContent)
    {        
    }
    
}
