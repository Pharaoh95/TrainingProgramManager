package po;
/**
 * 课程明细实体类，封装相关信息
 * @author Administrator
 *
 */
public class ProjectDetails {

	private Project project;
	private double computerHours;
	private double innerActionHours;
	private double innerComputerHours;
	private double outterComputerHours;
	private double missionHours;
	private double outterHours;
	private String belongTo;
	private String testMethod;
	private int dptId;
	private String researchSection;
	private String experimentDptId;
	private String listeningFlag;
	private double weight;
	private String preProject;
	private String introduction;
	private boolean unQuickChosen;
	private String roleAndGoal;
	private String referenceBooks;
	private String replacableProjectId;
	private String workLoad;
	private String useBook;
	private String experimentNums;
	private String note;
	private String teachMethod;
	private String sexxedMission;
	private String unchargeFlag;
	private String projectClass;
	private String chosenObject;
	private String mainTeacher;
	private String actionType;
	private String useMajor;
	private String mainDpt;
	private String testModel;
	private String qualityEvaluation;

	@Override
	public String toString() {
		return "ProjectDetails [" + ", computerHours=" + computerHours + ", innerActionHours="
				+ innerActionHours + ", innerComputerHours=" + innerComputerHours + ", outterComputerHours="
				+ outterComputerHours + ", missionHours=" + missionHours + ", outterHours=" + outterHours
				+ ", belongTo=" + belongTo + ", testMethod=" + testMethod + ", dptId=" + dptId + ", researchSection="
				+ researchSection + ", experimentDptId=" + experimentDptId + ", listeningFlag=" + listeningFlag
				+ ", weight=" + weight + ", preProject=" + preProject + ", introduction=" + introduction
				+ ", unQuickChosen=" + unQuickChosen + ", roleAndGoal=" + roleAndGoal + ", referenceBooks="
				+ referenceBooks + ", replacableProjectId=" + replacableProjectId + ", workLoad=" + workLoad
				+ ", useBook=" + useBook + ", experimentNums=" + experimentNums + ", note=" + note + ", teachMethod="
				+ teachMethod + ", sexxedMission=" + sexxedMission + ", unchargeFlag=" + unchargeFlag
				+ ", projectClass=" + projectClass + ", chosenObject=" + chosenObject + ", mainTeacher=" + mainTeacher
				+ ", actionType=" + actionType + ", useMajor=" + useMajor + ", mainDpt=" + mainDpt + ", testModel="
				+ testModel + ", qualityEvaluation=" + qualityEvaluation + "]";
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public double getComputerHours() {
		return computerHours;
	}

	public void setComputerHours(double computerHours) {
		this.computerHours = computerHours;
	}

	public double getInnerActionHours() {
		return innerActionHours;
	}

	public void setInnerActionHours(double innerActionHours) {
		this.innerActionHours = innerActionHours;
	}

	public double getInnerComputerHours() {
		return innerComputerHours;
	}

	public void setInnerComputerHours(double innerComputerHours) {
		this.innerComputerHours = innerComputerHours;
	}

	public double getOutterComputerHours() {
		return outterComputerHours;
	}

	public void setOutterComputerHours(double outterComputerHours) {
		this.outterComputerHours = outterComputerHours;
	}

	public double getMissionHours() {
		return missionHours;
	}

	public void setMissionHours(double missionHours) {
		this.missionHours = missionHours;
	}

	public double getOutterHours() {
		return outterHours;
	}

	public void setOutterHours(double outterHours) {
		this.outterHours = outterHours;
	}

	public String getBelongTo() {
		return belongTo;
	}

	public void setBelongTo(String belongTo) {
		this.belongTo = belongTo;
	}

	public String getTestMethod() {
		return testMethod;
	}

	public void setTestMethod(String testMethod) {
		this.testMethod = testMethod;
	}

	public int getDptId() {
		return dptId;
	}

	public void setDptId(int dptId) {
		this.dptId = dptId;
	}

	public String getResearchSection() {
		return researchSection;
	}

	public void setResearchSection(String researchSection) {
		this.researchSection = researchSection;
	}

	public String getExperimentDptId() {
		return experimentDptId;
	}

	public void setExperimentDptId(String experimentDptId) {
		this.experimentDptId = experimentDptId;
	}

	public String getListeningFlag() {
		return listeningFlag;
	}

	public void setListeningFlag(String listeningFlag) {
		this.listeningFlag = listeningFlag;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getPreProject() {
		return preProject;
	}

	public void setPreProject(String preProject) {
		this.preProject = preProject;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public boolean isUnQuickChosen() {
		return unQuickChosen;
	}

	public void setUnQuickChosen(boolean unQuickChosen) {
		this.unQuickChosen = unQuickChosen;
	}

	public String getRoleAndGoal() {
		return roleAndGoal;
	}

	public void setRoleAndGoal(String roleAndGoal) {
		this.roleAndGoal = roleAndGoal;
	}

	public String getReferenceBooks() {
		return referenceBooks;
	}

	public void setReferenceBooks(String referenceBooks) {
		this.referenceBooks = referenceBooks;
	}

	public String getReplacableProjectId() {
		return replacableProjectId;
	}

	public void setReplacableProjectId(String replacableProjectId) {
		this.replacableProjectId = replacableProjectId;
	}

	public String getWorkLoad() {
		return workLoad;
	}

	public void setWorkLoad(String workLoad) {
		this.workLoad = workLoad;
	}

	public String getUseBook() {
		return useBook;
	}

	public void setUseBook(String useBook) {
		this.useBook = useBook;
	}

	public String getExperimentNums() {
		return experimentNums;
	}

	public void setExperimentNums(String experimentNums) {
		this.experimentNums = experimentNums;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getTeachMethod() {
		return teachMethod;
	}

	public void setTeachMethod(String teachMethod) {
		this.teachMethod = teachMethod;
	}

	public String getSexxedMission() {
		return sexxedMission;
	}

	public void setSexxedMission(String sexxedMission) {
		this.sexxedMission = sexxedMission;
	}

	public String getUnchargeFlag() {
		return unchargeFlag;
	}

	public void setUnchargeFlag(String unchargeFlag) {
		this.unchargeFlag = unchargeFlag;
	}

	public String getProjectClass() {
		return projectClass;
	}

	public void setProjectClass(String projectClass) {
		this.projectClass = projectClass;
	}

	public String getChosenObject() {
		return chosenObject;
	}

	public void setChosenObject(String chosenObject) {
		this.chosenObject = chosenObject;
	}

	public String getMainTeacher() {
		return mainTeacher;
	}

	public void setMainTeacher(String mainTeacher) {
		this.mainTeacher = mainTeacher;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getUseMajor() {
		return useMajor;
	}

	public void setUseMajor(String useMajor) {
		this.useMajor = useMajor;
	}

	public String getMainDpt() {
		return mainDpt;
	}

	public void setMainDpt(String mainDpt) {
		this.mainDpt = mainDpt;
	}

	public String getTestModel() {
		return testModel;
	}

	public void setTestModel(String testModel) {
		this.testModel = testModel;
	}

	public String getQualityEvaluation() {
		return qualityEvaluation;
	}

	public void setQualityEvaluation(String qualityEvaluation) {
		this.qualityEvaluation = qualityEvaluation;
	}

}
