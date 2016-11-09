package po;
/**
 * 普通培养方案实体类，封装相关信息(未使用)
 * @author Administrator
 *
 */
public class GeneralProgram {
	private String id;
	private String name;
	private String projectId;
	private double programScore;
	private double sumHour;//总学时
	private double theoryHour;//理论课学时
	private double practiceHour;//实践课学时4
	private int first;//第一学期
	private int second;
	private int third;
	private int forth;
	private int fifth;
	private int sixth;
	private int seventh;
	private int eighth;//第八学期
	private String teachDept;//所属二级学院

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public double getProgramScore() {
		return programScore;
	}

	public void setProgramScore(double programScore) {
		this.programScore = programScore;
	}

	public double getSumHour() {
		return sumHour;
	}

	public void setSumHour(double sumHour) {
		this.sumHour = sumHour;
	}

	public double getTheoryHour() {
		return theoryHour;
	}

	public void setTheoryHour(double theoryHour) {
		this.theoryHour = theoryHour;
	}

	public double getPracticeHour() {
		return practiceHour;
	}

	public void setPracticeHour(double practiceHour) {
		this.practiceHour = practiceHour;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public int getThird() {
		return third;
	}

	public void setThird(int third) {
		this.third = third;
	}

	public int getForth() {
		return forth;
	}

	public void setForth(int forth) {
		this.forth = forth;
	}

	public int getFifth() {
		return fifth;
	}

	public void setFifth(int fifth) {
		this.fifth = fifth;
	}

	public int getSixth() {
		return sixth;
	}

	public void setSixth(int sixth) {
		this.sixth = sixth;
	}

	public int getSeventh() {
		return seventh;
	}

	public void setSeventh(int seventh) {
		this.seventh = seventh;
	}

	public int getEighth() {
		return eighth;
	}

	public void setEighth(int eighth) {
		this.eighth = eighth;
	}

	public String getTeachDept() {
		return teachDept;
	}

	public void setTeachDept(String teachDept) {
		this.teachDept = teachDept;
	}
}
