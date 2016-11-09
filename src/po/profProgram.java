package po;
/**
 * 分方向的培养方案的课程
 * @author Administrator
 *
 */
public class profProgram {
	private String id;
	private String name;//课程名
	private String projectId;//课程代码
	private String score;
	private double sumHour;//总学时
	private double weekHour;//周学时
	private double practiceHour;//时间学时
	private int teachTerm;//开课学期
	private String teachDept;//开课的二级学院
	private String cateId;

	@Override
	public String toString() {
		return "profProgram [id=" + id + ", name=" + name + ", projectId=" + projectId + ", score=" + score
				+ ", sumHour=" + sumHour + ", weekHour=" + weekHour + ", practiceHour=" + practiceHour + ", teachTerm="
				+ teachTerm + ", teachDept=" + teachDept + ", cateId=" + cateId + "]";
	}

	public String getCateId() {
		return cateId;
	}

	public void setCateId(String cateId) {
		this.cateId = cateId;
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

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public double getSumHour() {
		return sumHour;
	}

	public void setSumHour(double sumHour) {
		this.sumHour = sumHour;
	}

	public double getWeekHour() {
		return weekHour;
	}

	public void setWeekHour(double theoryHour) {
		this.weekHour = theoryHour;
	}

	public double getPracticeHour() {
		return practiceHour;
	}

	public void setPracticeHour(double practiceHour) {
		this.practiceHour = practiceHour;
	}

	public int getTeachTerm() {
		return teachTerm;
	}

	public void setTeachTerm(int teachTerm) {
		this.teachTerm = teachTerm;
	}

	public String getTeachDept() {
		return teachDept;
	}

	public void setTeachDept(String teachDept) {
		this.teachDept = teachDept;
	}
}