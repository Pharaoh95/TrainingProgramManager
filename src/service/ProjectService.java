package service;

import java.util.List;

import po.BaseVo;
import po.CustomResult;
import po.Program;
import po.Project;
/**
 * 接口：课程，封装相关业务逻辑
 * @author Administrator
 *
 */
public interface ProjectService {
	public CustomResult<Project> findProject(BaseVo baseVo);

	public int deleteBatch(List<Project> projects);

	public Program findAndTrans(String projectId);

	public int updateProjects(List<Project> projects);

	public int addProjects(List<Project> projects);
}
