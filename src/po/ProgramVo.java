package po;

import java.util.List;

public class ProgramVo extends BaseVo {
	private int majorId;
	private int moduleId;
	private List<Program> programs;

	public int getModuleId() {
		return moduleId;
	}

	@Override
	public String toString() {
		return "ProgramVo [majorId=" + majorId + ", moduleId=" + moduleId + ", programs=" + programs + "]";
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public List<Program> getPrograms() {
		return programs;
	}

	public void setPrograms(List<Program> programs) {
		this.programs = programs;
	}

	public int getMajorId() {
		return majorId;
	}

	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}
}
