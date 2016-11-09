package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import po.BaseVo;
import po.CustomResult;
import po.Program;
import po.Project;
import service.ProjectService;

@Controller
public class ProjectController {
	@Autowired
	private ProjectService projectService;

	@RequestMapping("/findProject")
	@ResponseBody
	public CustomResult<Project> findProject(BaseVo baseVo) {
		return projectService.findProject(baseVo);
	}

	@RequestMapping(value = "/deleteProjects", method = { RequestMethod.POST })
	@ResponseBody
	public int deleteBatch(@RequestBody List<Project> projects) {
		return projectService.deleteBatch(projects);
	}

	@RequestMapping(value = "/updateProjects", method = { RequestMethod.POST })
	@ResponseBody
	public int updateProjects(@RequestBody List<Project> projects) {
		return projectService.updateProjects(projects);
	}

	@RequestMapping("/findTransedProgram")
	@ResponseBody
	public Program findTransedProgram(String projectId) {
		return projectService.findAndTrans(projectId);
	}
}
