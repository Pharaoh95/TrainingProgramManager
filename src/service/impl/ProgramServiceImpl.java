package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mapper.ProgramMapper;
import mapper.ProjectMapper;
import po.CustomResult;
import po.Manager;
import po.Program;
import po.ProgramVo;
import po.Project;
import service.ProgramService;
import service.generalUtils;

public class ProgramServiceImpl implements ProgramService {
	@Autowired
	private ProgramMapper programMapper;
	@Autowired
	private ProjectMapper projectMapper;

	@Override
	public CustomResult<Program> findPrograms(ProgramVo programVo) {
		CustomResult<Program> customResult = new CustomResult<>();
		customResult.setRows(programMapper.findPrograms(programVo));
		customResult.setTotal(programMapper.getSum(programVo));
		return customResult;
	}

	@Override
	public int updateRequired(List<Program> programs) {
		return programMapper.updateRequired(programs);
	}

	@Override
	public int insertBatchRequired(Manager manager) {
		List<Project> projects = projectMapper.getRequired();
		int majorId = manager.getMaintainMajor().getId();
		programMapper.deleteRequiredByMajor(majorId);
		List<Program> programs = new ArrayList<>();
		for (Project project : projects) {
			Program program = generalUtils.toPragram(project, majorId);
			program.setPromd(1);
			programs.add(program);
		}
//		 追加默认的选修课,当前废弃
//		Program optedProgram = new Program();
//		optedProgram.setId(generalUtils.getRamdomId());
//		programs.add(optedProgram);
		return programMapper.insertBatchRequired(programs);
	}

	@Override
	public int deleteProgram(ProgramVo programVo) {
		return programMapper.deleteProgram(programVo);
	}

	@Override
	public int updatePrograms(List<Program> programs) {
		return programMapper.updatePrograms(programs);
	}

	@Override
	public int insertProgram(Program program) {
		program.setId(generalUtils.getRamdomId());
		return programMapper.insertProgram(program);
	}

	@Override
	public Program SingledReqOption(Manager manager) {
		int majorId = manager.getMaintainMajor().getId();
		Program program = programMapper.getReqOptioned(majorId);
		// 没有则为默认
		if (program == null) {
			program = new Program();
			program.setId(generalUtils.getRamdomId());
			program.setName("综合教育选修课");
			program.setScore(6);
			program.setPromd(40);
			program.setSumHour(96);
			program.setTheoryHour(96);
			program.setMajorId(majorId);
			// 然后插入数据库中
			programMapper.insertProgram(program);
		}
		return program;
	}

}
