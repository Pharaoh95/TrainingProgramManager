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
		// ��������������ת������ǰ�˿ؼ������id,text����ȥ
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
		// ������majorId���������
		if (majorId != null) {
			// ���ڵ�������������ʽ�����Ϊ��֤�û����飬��׽���������ʱ�쳣��
			try {
				int mid = Integer.parseInt(majorId);
				// ��ֹurlע����Ȩ�޵�MajorId
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
