package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mapper.ProjectDetailsMapper;
import mapper.ProjectMapper;
import po.BaseVo;
import po.CustomResult;
import po.Program;
import po.Project;
import po.ProjectDetails;
import service.ProjectService;
import service.generalUtils;

public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectMapper projectMapper;
	@Autowired
	private ProjectDetailsMapper projectDetailMapper;

	@Override
	public CustomResult<Project> findProject(BaseVo baseVo) {
		CustomResult<Project> customResult = new CustomResult<>();
		customResult.setRows(projectMapper.findProject(baseVo));
		customResult.setTotal(projectMapper.getSum(baseVo));
		return customResult;
	}

	@Override
	public int deleteBatch(List<Project> projects) {
		return projectMapper.deleteBatch(projects);
	}

	@Override
	public Program findAndTrans(String projectId) {
		Project project = projectMapper.findById(projectId);
		if (project != null) {
			return generalUtils.toPragram(project, -1);
		}
		return null;
	}

	@Override
	public int updateProjects(List<Project> projects) {
		return projectMapper.updateProjects(projects);
	}

	@Override
	public int addProjects(List<Project> projects) {
		int pdNum = projectDetailMapper.insertBatch(projects);
		int pNum = projectMapper.insertBatch(projects);
		return pdNum > pNum ? pdNum : pNum;
	}
}
