package po;
/**
 * �ַ�������������Ŀγ�
 * @author Administrator
 *
 */
public class profProgram {
	private String id;
	private String name;//�γ���
	private String projectId;//�γ̴���
	private String score;
	private double sumHour;//��ѧʱ
	private double weekHour;//��ѧʱ
	private double practiceHour;//ʱ��ѧʱ
	private int teachTerm;//����ѧ��
	private String teachDept;//���εĶ���ѧԺ
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