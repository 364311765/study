package ao;
import java.util.List;
public class Show extends Command {
    public static final int num = 1;
    private static Command instance = new Show();

    private Show() {
        super(num, "显示数据");
    }
    public static Command getInstance() {
        return instance;
    }
    public String run(ParaForCommand p) {
    	List<Student> students = p.getStudents();
        StringBuffer res = new StringBuffer();
        res.append("序号\t姓名\t学号" + "\r\n");
        for (int i = 0; i < students.size(); i++) {
            res.append(i + 1 + "\t" + students.get(i).toString() + "\r\n");
        }
        return res.toString();
    }
}