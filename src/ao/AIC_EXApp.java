package ao;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class AIC_EXApp {
    public static void main(String[] args) throws IOException {
        IRW rw = ConsoleRW.getInstance();
        Receiver receiver = new Receiver(rw, getStudents());
        rw.writeln("欢迎来到学生管理系统。");
        
        int operation = receiver.getOperation();
        while (operation != 0) {
            receiver.run(operation);
            operation = receiver.getOperation();
        }
        rw.writeln("-----------退出系统----------");
    }

    private static List<Student> getStudents() throws IOException {
    	List<Student> students = new ArrayList<Student>();
    	FileReader reader=new FileReader("students.txt");
    	BufferedReader br=new BufferedReader(reader);
    	String str=null;
    	while ((str=br.readLine())!=null){
    		String[] s=str.split(",");
    	
    		students.add(new Student(s[0],s[1]));
    	}
    	
		return students;
	}
}