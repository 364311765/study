package ao;

import java.util.*;

public class Delete extends Command {
    public static final int num = 2;
    private static Command instance = new Delete();

    private Delete() {
        super(num, "删除数据");
    }
    public static Command getInstance() {
        return instance;
    }
	public String run(ParaForCommand para) {
		ParaForDelete paraD = (ParaForDelete)para;
		int itemId = paraD.getItemId();
    	int isOk = paraD.getIsOk();
    	List<Student> students = paraD.getStudents();
    	String res = null;
		if(itemId >=1 && itemId <= students.size()){
    		if(isOk == 1){
    			students.remove(itemId-1);
    			res = "1条记录被删除。";
    		}else if(isOk == 0){
    			res = "0条记录被删除。";
    		}
    	}else{
    		res = "请输入有效数字（0-"+students.size()+")。";
    	}
		return res;
	}
}
