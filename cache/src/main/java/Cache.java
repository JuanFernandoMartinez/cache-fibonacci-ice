import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.Util;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.Object;

public class Cache {
    
    public static void main (String[] args){
        try(Communicator communicator = Util.initialize(args)){
            ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("CachePrinterAdapter", "default -p 9000");
            Object object = new CachePrinter(args);
            
            adapter.add(object, Util.stringToIdentity("CachePrinter"));
            
            adapter.activate();
            communicator.waitForShutdown();
        }
        
    }
}
