package mapper;

import java.util.List;

import po.Project;
import po.ProjectDetails;

public interface ProjectDetailsMapper {
	public int insertBatch(List<Project> projects);
}
