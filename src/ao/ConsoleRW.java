package ao;
import java.util.Scanner;
public class ConsoleRW implements IRW {
    private static ConsoleRW rw;
    private Scanner sc;

    private ConsoleRW() {
        sc = new Scanner(System.in);
    }
    public static IRW getInstance() {
        if (rw == null) {
            rw = new ConsoleRW();
        }
        return rw;
    }
    public int readInt() {
        return sc.nextInt();
    }
    public void writeln(String mes) {
        System.out.println(mes);
    }
    public void write(String s) {
        System.out.print(s);
    }
}