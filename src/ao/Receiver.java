package ao;
import java.util.*;

public class Receiver {
    private List<Student> students;
    private IRW rw;
    private List<Command> commands;

    public Receiver(IRW reader, List<Student> students) {
        this.commands = new ArrayList<Command>();
        commands.add(Show.getInstance());
        commands.add(Delete.getInstance());
        this.rw = reader;
        this.students = students;
    }
    
    public int getOperation() {
        rw.writeln("本系统当前有" + students.size() + "条记录。");
		rw.writeln("系统具有以下功能：");
		for (int i = 0; i < commands.size(); i++) {
		    rw.writeln(commands.get(i).toString());
		}
        rw.write("请选择您需要操作的功能(0表示退出系统)：");
        return rw.readInt();
    }
    
    public void run(int operation) {
        switch (operation) {
            case Show.num:
                rw.writeln("------显示----------");
                rw.write(Show.getInstance().run(buildPara(students)));
                rw.writeln("----------结束显示-------");
                break;
            case 2:
            	rw.writeln("----------删除------------");
            	int itemId = getItemId();
            	while(itemId != 0){
            		rw.writeln(Delete.getInstance().run(buildParaForDelete(itemId, students)));
	            	itemId = getItemId();
            	}
            	rw.writeln("-------退出删除--------");
            	break;
            default:
                rw.writeln("请输入有效数字（0-1）。");
        }
    }

	protected ParaForDelete buildParaForDelete(int itemId, List<Student> students) {
		int isOk = 0;
		if(itemId >=1 && itemId <= students.size()){
			isOk = isOk(itemId);
			while(isOk != 1 && isOk != 0 ){
				rw.writeln("您输入的选项不存在。");
				isOk = isOk(itemId);
			}
		}
		return new ParaForDelete(students, itemId, isOk);
	}

	private ParaForCommand buildPara(List<Student> students2) {
		return new ParaForCommand(students);
	}

	protected int isOk(int itemId) {
		rw.writeln("请问是否需要删除序号为"+itemId+","+students.get(itemId-1));
		rw.writeln("1:是");
		rw.writeln("0:否");
		rw.write("请问您的选择：");
		int isOk = rw.readInt();
		return isOk;
	}

	protected int getItemId() {
		rw.write(show());
		rw.write("请选择您要删除的序号（0：退出删除）：");
		int itemId = rw.readInt();
		return itemId;
	}
    
    public String show(){//TODO 重构
        StringBuffer res = new StringBuffer();
        res.append("序号\t姓名\t学号" + "\r\n");
        for (int i = 0; i < students.size(); i++) {
            res.append(i + 1 + "\t" + students.get(i).toString() + "\r\n");
        }
        return res.toString();
    }
    
    
}


