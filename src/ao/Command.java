package ao;
public class Command {
    private int num;
    private String mes;
    public Command(int num, String mes) {
        this.num = num;
        this.mes = mes;
    }
    public String toString() {
        return num + ":" + mes;
    }
	public String run(ParaForCommand para) {
		return null;
	}
}