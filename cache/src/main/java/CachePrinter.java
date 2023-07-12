import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.Util;
import com.zeroc.Ice.ObjectPrx;
import Demo.PrinterPrx;
import com.zeroc.Ice.Current;
import java.util.HashMap;

public class CachePrinter implements Demo.Printer {
    private HashMap<String, String> cache;
    private String[] args;
    public CachePrinter(String[] args){
        cache = new HashMap<String, String>();
        this.args = args;
    }

    public String printString(String s, Current current ){
        if (cache.containsKey(s)){
            return cache.get(s);
        }
        else{
            try (Communicator communicator = Util.initialize(args)){
                ObjectPrx base = communicator.stringToProxy("SimplePrinter:default  -p 10000");
                
                PrinterPrx printer = PrinterPrx.checkedCast(base);
                
                if (printer == null ){
                    throw new Error("Invalid proxy");
                }
                String response = printer.printString(s);
                cache.put(s, response);
                return response;
            }
        }
    }
    
}
