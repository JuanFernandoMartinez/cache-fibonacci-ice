import com.zeroc.Ice.Current;

public class HelloPrinter implements Demo.Printer {
    

    public String printString(String s, Current current){
        return "hello world";
    }
}
