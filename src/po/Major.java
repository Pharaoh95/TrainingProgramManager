package po;

/**
 * 专业实体类，封装相关信息
 * @author Administrator
 *
 */
public class Major {
	private int id;
	private String name;//专业名称
	private boolean level;//专业学历层次
	private String type;//专业类别（工科，理科。。。）
	private int maxSumHour;//该专业最大学时
	private double minSumScore;//该专业最小学分
	private double maxSumScore;//该专业最大学分

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
