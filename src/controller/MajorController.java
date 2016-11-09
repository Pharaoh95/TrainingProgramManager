package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import po.BaseVo;
import po.Major;
import service.MajorService;

@Controller()
public class MajorController {
	@Autowired
	public MajorService majorService;

	@RequestMapping(value = "/majorlist", method = { RequestMethod.GET, RequestMethod.POST })
	public String MajorList(Major major) {
		return "index";
	}

	@RequestMapping("/findAllMajors")
	public @ResponseBody List<Major> findAllMajors(BaseVo baseVo) {
		List<Major> list = majorService.findAll();
		return list;
	}
}
