package po;
/**
 * 统计的数据
 * @author Administrator
 *
 */
public class statisticData {
	private String category;//分方向
	private int moduleHour;
	private double moduleScore;
	private int prctcGenSumHour;
	private double prctcGenSumScore;
	private int genSumHour;
	private double genSumScore;
	private int prctcModHour;
	private double prctcModScore;
	private int adviceHour;//建议学时
	private double adviceMinScore;//建议最小学分
	private double adviceMaxScore;//建议最大学分

	public int getAdviceHour() {
		return adviceHour;
	}

	public void setAdviceHour(int adviceHour) {
		this.adviceHour = adviceHour;
	}

	public double getAdviceMinScore() {
		return adviceMinScore;
	}

	public void setAdviceMinScore(double adviceMinScore) {
		this.adviceMinScore = adviceMinScore;
	}

	@Override
	public String toString() {
		return "statisticData [category=" + category + ", moduleHour=" + moduleHour + ", moduleScore=" + moduleScore
				+ ", prctcGenSumHour=" + prctcGenSumHour + ", prctcGenSumScore=" + prctcGenSumScore + ", genSumHour="
				+ genSumHour + ", genSumScore=" + genSumScore + ", prctcModHour=" + prctcModHour + ", prctcModScore="
				+ prctcModScore + "]";
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getModuleHour() {
		return moduleHour;
	}

	public void setModuleHour(int moduleHour) {
		this.moduleHour = moduleHour;
	}

	public double getModuleScore() {
		return moduleScore;
	}

	public void setModuleScore(double moduleScore) {
		this.moduleScore = moduleScore;
	}

	public int getPrctcGenSumHour() {
		return prctcGenSumHour;
	}

	public void setPrctcGenSumHour(int prctcGenSumHour) {
		this.prctcGenSumHour = prctcGenSumHour;
	}

	public double getPrctcGenSumScore() {
		return prctcGenSumScore;
	}

	public void setPrctcGenSumScore(double prctcGenSumScore) {
		this.prctcGenSumScore = prctcGenSumScore;
	}

	public int getGenSumHour() {
		return genSumHour;
	}

	public void setGenSumHour(int genSumHour) {
		this.genSumHour = genSumHour;
	}

	public double getGenSumScore() {
		return genSumScore;
	}

	public void setGenSumScore(double genSumScore) {
		this.genSumScore = genSumScore;
	}

	public int getPrctcModHour() {
		return prctcModHour;
	}

	public void setPrctcModHour(int prctcModHour) {
		this.prctcModHour = prctcModHour;
	}

	public double getPrctcModScore() {
		return prctcModScore;
	}

	public void setPrctcModScore(double prctcModScore) {
		this.prctcModScore = prctcModScore;
	}

	public int getStatistcSumHour() {
		return genSumHour + moduleHour + prctcGenSumHour + prctcModHour;
	}

	public double getStatistcSumScore() {
		return genSumScore + moduleScore + prctcGenSumScore + prctcModScore;
	}

	public double getAdviceMaxScore() {
		return adviceMaxScore;
	}

	public void setAdviceMaxScore(double adviceMaxScore) {
		this.adviceMaxScore = adviceMaxScore;
	}
}
