package po;
/**
 * 培养方案实体类，封装相关信息
 * @author Administrator
 *
 */
public class Program {
	private String id;
	private String name;//课程名称
	private String projectId;//课程代码
	private double score;//学分
	private double sumHour;//总学时
	private double theoryHour;//讲课学时
	private double practiceHour;//实践学时
	private int first;
	private int second;
	private int third;
	private int forth;
	private int fifth;
	private int sixth;
	private int seventh;
	private int eighth;
	private int startWeek;//起始周
	private int endWeek;//结束周
	private String teachDept;//授课单位
	private String scndCate;
	private int promd;

	public int getPromd() {
		return promd;
	}

	public void setPromd(int promd) {
		this.promd = promd;
	}

	private int majorId;

	public String getScndCate() {
		return scndCate;
	}

	public void setScndCate(String scndCate) {
		this.scndCate = scndCate;
	}

	public int getMajorId() {
		return majorId;
	}

	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}

	@Override
	public String toString() {
		return "Program [id=" + id + ", name=" + name + ", projectId=" + projectId + ", score=" + score + ", sumHour="
				+ sumHour + ", theoryHour=" + theoryHour + ", practiceHour=" + practiceHour + ", first=" + first
				+ ", second=" + second + ", third=" + third + ", forth=" + forth + ", fifth=" + fifth + ", sixth="
				+ sixth + ", seventh=" + seventh + ", eighth=" + eighth + ", startWeek=" + startWeek + ", endWeek="
				+ endWeek + ", teachDept=" + teachDept + ", scndCate=" + scndCate + ", promd=" + promd + ", majorId="
				+ majorId + "]";
	}

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

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
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

	public int getStartWeek() {
		return startWeek;
	}

	public void setStartWeek(int startWeek) {
		this.startWeek = startWeek;
	}

	public int getEndWeek() {
		return endWeek;
	}

	public void setEndWeek(int endWeek) {
		this.endWeek = endWeek;
	}

	public String getTeachDept() {
		return teachDept;
	}

	public void setTeachDept(String teachDept) {
		this.teachDept = teachDept;
	}
}
