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
        rw.writeln("��ϵͳ��ǰ��" + students.size() + "����¼��");
		rw.writeln("ϵͳ�������¹��ܣ�");
		for (int i = 0; i < commands.size(); i++) {
		    rw.writeln(commands.get(i).toString());
		}
        rw.write("��ѡ������Ҫ�����Ĺ���(0��ʾ�˳�ϵͳ)��");
        return rw.readInt();
    }
    
    public void run(int operation) {
        switch (operation) {
            case Show.num:
                rw.writeln("------��ʾ----------");
                rw.write(Show.getInstance().run(buildPara(students)));
                rw.writeln("----------������ʾ-------");
                break;
            case 2:
            	rw.writeln("----------ɾ��------------");
            	int itemId = getItemId();
            	while(itemId != 0){
            		rw.writeln(Delete.getInstance().run(buildParaForDelete(itemId, students)));
	            	itemId = getItemId();
            	}
            	rw.writeln("-------�˳�ɾ��--------");
            	break;
            default:
                rw.writeln("��������Ч���֣�0-1����");
        }
    }

	protected ParaForDelete buildParaForDelete(int itemId, List<Student> students) {
		int isOk = 0;
		if(itemId >=1 && itemId <= students.size()){
			isOk = isOk(itemId);
			while(isOk != 1 && isOk != 0 ){
				rw.writeln("�������ѡ����ڡ�");
				isOk = isOk(itemId);
			}
		}
		return new ParaForDelete(students, itemId, isOk);
	}

	private ParaForCommand buildPara(List<Student> students2) {
		return new ParaForCommand(students);
	}

	protected int isOk(int itemId) {
		rw.writeln("�����Ƿ���Ҫɾ�����Ϊ"+itemId+","+students.get(itemId-1));
		rw.writeln("1:��");
		rw.writeln("0:��");
		rw.write("��������ѡ��");
		int isOk = rw.readInt();
		return isOk;
	}

	protected int getItemId() {
		rw.write(show());
		rw.write("��ѡ����Ҫɾ������ţ�0���˳�ɾ������");
		int itemId = rw.readInt();
		return itemId;
	}
    
    public String show(){//TODO �ع�
        StringBuffer res = new StringBuffer();
        res.append("���\t����\tѧ��" + "\r\n");
        for (int i = 0; i < students.size(); i++) {
            res.append(i + 1 + "\t" + students.get(i).toString() + "\r\n");
        }
        return res.toString();
    }
    
    
}


