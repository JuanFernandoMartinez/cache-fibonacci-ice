import com.zeroc.Ice.Current;
import java.math.BigInteger;


public class PrinterI implements Demo.Printer {

    

    public String printString(String s,  Current current ){    
            return  fibonacci(new BigInteger(s))+"";  
    }

    private String fibonacci(BigInteger n){
        
        BigInteger i = BigInteger.TWO;
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;

        if (n.equals(BigInteger.ONE)) return n.toString();
        
        while (i.compareTo(n)  <= 0){
            BigInteger c = a.add(b);
            a = b;
            b = c;
            i = i.add(BigInteger.ONE);
        }

        return b.toString();
    }
}
