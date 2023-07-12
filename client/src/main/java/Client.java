import java.util.Scanner;

import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.Util;
import com.zeroc.Ice.ObjectPrx;
import Demo.PrinterPrx;

public class Client {
    public static void main(String[] args) {
        try (Communicator communicator = Util.initialize(args)){
            ObjectPrx base = communicator.stringToProxy("CachePrinter:default  -p 9000");
            
             PrinterPrx printer = PrinterPrx.checkedCast(base);
             
             if (printer == null ){
                throw new Error("Invalid proxy");
             }
             Scanner sc = new Scanner(System.in);
             while (true){
                long initTime = System.currentTimeMillis();
                String response = printer.printString(sc.next());
                long endTime = System.currentTimeMillis();
                
             System.out.println(response+" "+(endTime-initTime));
             }
        }
    }
}
