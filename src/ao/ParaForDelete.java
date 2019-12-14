package ao;
import java.util.List;

public class ParaForDelete extends ParaForCommand{
	private int itemId;
	private int isOk;

	public ParaForDelete(List<Student> students, int itemId, int isOk) {
		super(students);
		this.itemId = itemId;
		this.isOk = isOk;
	}

	public int getItemId() {
		return itemId;
	}

	public int getIsOk() {
		return isOk;
	}
}