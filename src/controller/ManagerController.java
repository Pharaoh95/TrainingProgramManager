package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import po.CustomResult;
import po.Manager;
import po.ManagerVo;
import po.statisticData;
import service.ManagerService;

@Controller
public class ManagerController {
	@Autowired
	private ManagerService managerService;
	private int majorId = -1;

	@RequestMapping(value = "isLoginValid", method = { RequestMethod.POST })
	@ResponseBody
	public Manager isLoginValid(HttpSession session, ManagerVo managerVo) {
		Manager manager = managerService.findManager(managerVo);
		// 确定其登录的身份
		if (manager != null) {
			manager.setCharacter(managerVo.getCharacter());
			session.setAttribute("Manager", manager);
		}
		return manager;
	}

	@RequestMapping("loadStatistic")
	@ResponseBody
	public List<statisticData> loadStatistic(HttpSession session, Integer viewedMajorId) {
		Manager manager = (Manager) session.getAttribute("Manager");
		int majorId = viewedMajorId != null ? viewedMajorId : manager.getMaintainMajor().getId();
		return managerService.findStatisticByMajor(majorId);
	}

	@RequestMapping("findManagers")
	@ResponseBody
	public CustomResult<Manager> findManagers(ManagerVo managerVo) {
		return managerService.findManagers(managerVo);
	}

	@RequestMapping("resetPwd")
	@ResponseBody
	public boolean resetPassword(HttpSession session, ManagerVo managerVo) {
		Manager manager = (Manager) session.getAttribute("Manager");
		managerVo.setId(manager.getId());
		return managerService.resetPassword(managerVo);
	}

	@RequestMapping(value = "loadIndex")
	public String loadIndex(HttpSession session) {
		// 根据其登录的身份来跳转教师/管理员界面
		Manager manager = (Manager) session.getAttribute("Manager");
		if ("admin".equals(manager.getCharacter())) {
			return "adminView/adminIndex";
		}
		return "index";
	}

	@RequestMapping(value = "fixTab")
	public String fixTab(String tab) throws Exception {
		if (tab != null && !"".equals(tab)) {
			return tab;
		}
		return "error";
	}

	@RequestMapping("login")
	public String login() {
		return "login";
	}

	@RequestMapping("error")
	public String error() {
		return "error";
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
}
