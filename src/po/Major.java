package po;

/**
 * רҵʵ���࣬��װ�����Ϣ
 * @author Administrator
 *
 */
public class Major {
	private int id;
	private String name;//רҵ����
	private boolean level;//רҵѧ�����
	private String type;//רҵ��𣨹��ƣ���ơ�������
	private int maxSumHour;//��רҵ���ѧʱ
	private double minSumScore;//��רҵ��Сѧ��
	private double maxSumScore;//��רҵ���ѧ��

	@Override
	public String toString() {
		return "Major [id=" + id + ", name=" + name + ", level=" + level + ", type=" + type + ", maxSumHour="
				+ maxSumHour + ", minSumScore=" + minSumScore + ", maxSumScore=" + maxSumScore + "]";
	}

	public int getMaxSumHour() {
		return maxSumHour;
	}

	public void setMaxSumHour(int maxSumHour) {
		this.maxSumHour = maxSumHour;
	}

	public double getMinSumScore() {
		return minSumScore;
	}

	public void setMinSumScore(double minSumScore) {
		this.minSumScore = minSumScore;
	}

	public double getMaxSumScore() {
		return maxSumScore;
	}

	public void setMaxSumScore(double maxSumScore) {
		this.maxSumScore = maxSumScore;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isLevel() {
		return level;
	}

	public void setLevel(boolean level) {
		this.level = level;
	}

	public String getType() {
		return type;
	}

	public void setType(String category) {
		this.type = category;
	}

}
