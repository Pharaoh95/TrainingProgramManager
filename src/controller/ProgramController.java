package controller;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import po.CustomResult;
import po.Manager;
import po.Program;
import po.ProgramVo;
import service.ProgramService;

@Controller
public class ProgramController {
	@Autowired
	private ProgramService programService;

	@RequestMapping("findPrograms")
	@ResponseBody
	public CustomResult<Program> findPrograms(HttpSession session, ProgramVo programVo) {
		Manager manager = (Manager) session.getAttribute("Manager");
		programVo.setMajorId(manager.getMaintainMajor().getId());
		return programService.findPrograms(programVo);
	}

	@RequestMapping("requiredBatch")
	@ResponseBody
	public int requiredBatch(HttpSession session, ProgramVo programVo) {
		Manager manager = (Manager) session.getAttribute("Manager");
		return programService.insertBatchRequired(manager);
	}

	@RequestMapping("deletePrograms")
	@ResponseBody
	public int deletePrograms(HttpSession session, ProgramVo programVo, @RequestBody List<Program> programs) {
		Manager manager = (Manager) session.getAttribute("Manager");
		programVo.setMajorId(manager.getMaintainMajor().getId());
		programVo.setPrograms(programs);
		return programService.deleteProgram(programVo);
	}

	@RequestMapping("ReqOptProgarm")
	@ResponseBody
	public Program ReqOptProgarm(HttpSession session) {
		Manager manager = (Manager) session.getAttribute("Manager");
		return programService.SingledReqOption(manager);
	}

	@RequestMapping("updateRequired")
	@ResponseBody
	public int updateRequired(@RequestBody List<Program> programs) {
		return programService.updateRequired(programs);
	}

	@RequestMapping("updatePrograms")
	@ResponseBody
	public int updatePrograms(@RequestBody List<Program> programs) {
		return programService.updatePrograms(programs);
	}

	@RequestMapping("insertProgram")
	@ResponseBody
	public int insertPrograms(@RequestBody Program program, HttpSession session) {
		Manager manager = (Manager) session.getAttribute("Manager");
		int scndCate = (int) session.getAttribute("scndCate");
		program.setMajorId(manager.getMaintainMajor().getId());
		program.setPromd(scndCate);
		return programService.insertProgram(program);

	}

	@RequestMapping("genDialog")
	public String genDialog(ServletRequest request) {
		return "dialogContext/genDialog";
	}

	@RequestMapping("setScndCateAndTid")
	@ResponseBody
	public boolean setScndCateAndTid(int scndCate, String tableId, HttpSession session) {
		session.setAttribute("tableId", tableId);
		if (scndCate > 0) {
			session.setAttribute("scndCate", scndCate);
		}
		return true;
	}
}
