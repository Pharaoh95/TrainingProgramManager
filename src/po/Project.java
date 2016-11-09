package po;
/**
 * 课程
 * @author Administrator
 *
 */
public class Project {
	private String id;//课程代码
	private String name;//课程名称
	private double score;//课程学分
	private String weekHours;//课程周学时
	private double sumHours;//课程总学时
	private double theoryHours;//课程讲课学时
	private double practiceHours;//课程实践学时
	private String quality;//必修课，公选课或其他
	private String type;//课程类别（综合教育课，专业基础课或其他）
	private String level;//课程所属学历层次
	private String createdDpt;//开课学院
	private ProjectDetails projectDetails;

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

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public double getSumHours() {
		return sumHours;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", score=" + score + ", weekHours=" + weekHours + ", sumHours="
				+ sumHours + ", theoryHours=" + theoryHours + ", practiceHours=" + practiceHours + ", quality="
				+ quality + ", type=" + type + ", level=" + level + ", createdDpt=" + createdDpt + ", projectDetails="
				+ projectDetails + "]";
	}

	public void setSumHours(double sumHours) {
		this.sumHours = sumHours;
	}

	public double getTheoryHours() {
		return theoryHours;
	}

	public void setTheoryHours(double theoryHours) {
		this.theoryHours = theoryHours;
	}

	public double getPracticeHours() {
		return practiceHours;
	}

	public void setPracticeHours(double practiceHours) {
		this.practiceHours = practiceHours;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getCreatedDpt() {
		return createdDpt;
	}

	public void setCreatedDpt(String createdDpt) {
		this.createdDpt = createdDpt;
	}

	public ProjectDetails getProjectDetails() {
		return projectDetails;
	}

	public void setProjectDetails(ProjectDetails projectDetails) {
		this.projectDetails = projectDetails;
	}

	public String getWeekHours() {
		return weekHours;
	}

	public void setWeekHours(String weekHours) {
		this.weekHours = weekHours;
	}

	public String getProjectDetailsNote() {
		return projectDetails.getNote();
	}

	public void setProjectDetailsNote(String projectDetailsNote) {
		this.projectDetails.setNote(projectDetailsNote);
	}

}
