package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import po.AdvicedNorm;
import po.Category;
import po.CustomResult;
import po.Major;
import po.Manager;
import po.Program;
import po.ProgramVo;
import po.Project;
import service.MajorService;
import service.ManagerService;
import service.ProgramService;
import service.ProjectService;
import service.generalUtils;

@Controller
@RequestMapping("adminController")
public class AdminController {
	@Autowired
	private ManagerService managerService;
	@Autowired
	private ProgramService programService;
	@Autowired
	private MajorService majorService;
	@Autowired
	private ProjectService projectService;
	private List<Category> majorCates;

	@ResponseBody
	@RequestMapping("loadQuerableMajors")
	public List<Category> loadQuerableMajors(HttpSession session) {
		Manager manager = (Manager) session.getAttribute("Manager");
		List<Major> majors = manager.getQuerableMajors();
		// 在这里做个属性转换，把前端控件所需的id,text传过去
		if (majorCates == null) {
			majorCates = new ArrayList<Category>();
			for (Major major : majors) {
				Category category = new Category();
				category.setId(major.getId() + "");
				category.setText(major.getName());
				majorCates.add(category);
			}
		}
		return majorCates;
	}

	@ResponseBody
	@RequestMapping("findPrograms")
	public CustomResult<Program> findPrograms(ProgramVo programVo) {
		return programService.findPrograms(programVo);
	}

	@ResponseBody
	@RequestMapping("findAdvicedNorms")
	public List<AdvicedNorm> findAdvicedNorms() {
		return majorService.findAdvicedNorms();
	}

	@RequestMapping("updateAdvicedNorms")
	@ResponseBody
	public int updateAdvicedNorms(@RequestBody List<AdvicedNorm> advicedNorms) {
		return majorService.updateAdvicedNorms(advicedNorms);
	}

	@RequestMapping("importFile")
	@ResponseBody
	public int importFile(MultipartFile projsFile) {
		long start = System.currentTimeMillis();
		List<Project> projects = null;
		if (projsFile != null) {
			try {
				projects = generalUtils.parseXlsxFile(projsFile.getInputStream());
			} catch (Exception e) {
				return 2;
			}
			projectService.addProjects(projects);
			System.out.println(System.currentTimeMillis() - start);
			return 1;
		}
		
		return 0;
	}

	@RequestMapping("isViewedValid")
	@ResponseBody
	public boolean isViewedValid(String majorId, HttpSession session) {
		Manager manager = (Manager) session.getAttribute("Manager");
		List<Major> majors = manager.getQuerableMajors();
		// 不存在majorId参数则错误
		if (majorId != null) {
			// 存在但不符合整数格式则错误（为保证用户体验，捕捉下这个运行时异常）
			try {
				int mid = Integer.parseInt(majorId);
				// 防止url注入无权限的MajorId
				for (Major major : majors) {
					if (mid == major.getId()) {
						return true;
					}
				}
			} catch (NumberFormatException e) {
				return false;
			}
		}
		return false;
	}

	@RequestMapping("updateManagers")
	@ResponseBody
	public int updateManagers(@RequestBody List<Manager> managers) {
		return managerService.updateManagers(managers);
	}

	@RequestMapping("queryMajorProgs")
	public String queryMajorProgs(HttpSession session) {
		return "adminView/majorPrograms";
	}

}
