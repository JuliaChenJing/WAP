package container;
import java.util.*;

public class Mylet1 extends Mylet
{
    @Override
    public void init()
    {
        System.out.println("In Mylet1.init");
    }
    
    @Override
    public void doGet(String method, Hashtable inputHeaders, Hashtable params, Hashtable outputHeaders, StringBuilder outputContent)
    {
        outputContent.append("<html>This is from doGet method of Mylet1</html>");
    }

    @Override
    public void doPost(String method, Hashtable inputHeaders, Hashtable params, Hashtable outputHeaders, StringBuilder outputContent)
    {        
    }
    
}
