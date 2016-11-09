package mapper;

import java.util.List;

import po.BaseVo;
import po.Project;

public interface ProjectMapper {
	public int insertBatch(List<Project> projects);

	public Project findById(String projectId);

	public List<Project> findProject(BaseVo baseVo);

	public int getSum(BaseVo baseVo);

	public int deleteBatch(List<Project> projects);

	public List<Project> getRequired();

	public int updateProjects(List<Project> projects);
}
