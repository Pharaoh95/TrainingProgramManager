package po;
/**
 * ����ָ��
 * @author Administrator
 *
 */
public class AdvicedNorm {
	private String majorCategory;//רҵ���
	private int maxSumHour;//�����ѧʱ
	private double minSumScore;//�����ѧ��
	private double maxSumScore;//��С��ѧ��

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
