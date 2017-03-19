package container;

import java.util.*;

abstract public class Mylet
{
    public void init()
    {
        System.out.println("In super init");
    }
    
    
    public void service(String method, Hashtable inputHeaders, Hashtable params, Hashtable outputHeaders, StringBuilder outputContent)
            throws Exception
    {
        if (method.equals("get"))
            doGet(method, inputHeaders, params, outputHeaders, outputContent);
        else if (method.equals("post"))
            doPost(method, inputHeaders, params, outputHeaders, outputContent);
        else
            throw new Exception("Illegal method passed to service method");
    }
    
    // If this not overridden then generate error that GET is not supported
    public void doGet(String method, Hashtable inputHeaders, Hashtable params, Hashtable outputHeaders, StringBuilder outputContent)
    {
        generateError("get", outputContent);
    }

    // If this not overridden then generate error that POST is not supported
    public void doPost(String method, Hashtable inputHeaders, Hashtable params, Hashtable outputHeaders, StringBuilder outputContent)
    {        
        generateError("post", outputContent);
    }
    
    private void generateError(String method, StringBuilder outputContext)
    {
        outputContext.append(String.format("<html><body><h1>%s not supported</h1></body></html>", method));
    }
}
