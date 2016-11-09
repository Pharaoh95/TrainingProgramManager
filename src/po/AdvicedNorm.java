package po;
/**
 * 建议指标
 * @author Administrator
 *
 */
public class AdvicedNorm {
	private String majorCategory;//专业类别
	private int maxSumHour;//最大总学时
	private double minSumScore;//最大总学分
	private double maxSumScore;//最小总学分

	@Override
	public String toString() {
		return "AdviceNorm [majorCategory=" + majorCategory + ", maxSumHour=" + maxSumHour + ", minSumScore="
				+ minSumScore + ", maxSumScore=" + maxSumScore + "]";
	}

	public String getMajorCategory() {
		return majorCategory;
	}

	public void setMajorCategory(String majorCategory) {
		this.majorCategory = majorCategory;
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

}
