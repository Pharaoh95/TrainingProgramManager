package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Category;
import po.Manager;
import po.profProgram;
import service.profProgramService;

@Controller
public class profProgramController {
	@Autowired
	private profProgramService profprogramService;

	// 数据查询操作
	@RequestMapping("getCategories")
	@ResponseBody
	public List<Category> getCategories(HttpSession session, Integer viewedMajorId) {
		Manager manager = (Manager) session.getAttribute("Manager");
		int majorId = viewedMajorId != null ? viewedMajorId : manager.getMaintainMajor().getId();
		return profprogramService.getCategories(majorId);
	}

	@RequestMapping("findprofPrograms")
	@ResponseBody
	public List<profProgram> findprofPrograms(String viewedCateId, HttpSession session) {
		String cateId = (String) session.getAttribute("cateId");
		if (cateId != null) {
			String cid = viewedCateId != null ? viewedCateId : cateId;
			if (cid != null) {
				return profprogramService.getByCateId(cid);
			}
		}
		return null;
	}

	// 数据更新操作
	@RequestMapping("deleteprofPrograms")
	@ResponseBody
	public int deleteprofPrograms(@RequestBody List<profProgram> profPrograms) {
		return profprogramService.deleteBatch(profPrograms);
	}

	@RequestMapping("insertProfProgram")
	@ResponseBody
	public boolean insertProfProgram(profProgram program, HttpSession session) {
		String cateId = (String) session.getAttribute("cateId");
		if (cateId != null) {
			program.setCateId(cateId);
			profprogramService.insertOne(program);
			return true;
		}
		return false;
	}

	@RequestMapping("updateProfPrograms")
	@ResponseBody
	public int updateProfPrograms(@RequestBody List<profProgram> programs, HttpSession session) {
		String cateId = (String) session.getAttribute("cateId");
		if (cateId != null) {
			for (profProgram profProgram : programs) {
				profProgram.setCateId(cateId);
			}
			return profprogramService.updateBatch(programs);
		}
		return -1;

	}

	@RequestMapping("insertCategory")
	@ResponseBody
	public int insertCategory(HttpSession session, Category category) {
		Manager manager = (Manager) session.getAttribute("Manager");
		return profprogramService.insertCategory(category, manager);
	}

	@RequestMapping("deleteCategory")
	@ResponseBody
	public int deleteCategory(HttpSession session) {
		int result = -1;
		String cateId = (String) session.getAttribute("cateId");
		if (cateId != null) {
			result = profprogramService.deleteCategory(cateId);
			session.removeAttribute("cateId");
		}
		return result;
	}

	@RequestMapping("setCateId")
	@ResponseBody
	public boolean setCateId(String cateId, HttpSession session) {
		session.setAttribute("cateId", cateId);
		return true;
	}

	@RequestMapping("statisticDetails")
	public String statisticDetails() {
		return "statisticDetails";
	}
}
