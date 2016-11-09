package service;

import java.util.List;

import po.CustomResult;
import po.Manager;
import po.Program;
import po.ProgramVo;
/**
 * 接口：培养方案，封装相关业务逻辑
 * @author Administrator
 *
 */
public interface ProgramService {
	public CustomResult<Program> findPrograms(ProgramVo programVo);

	public int insertBatchRequired(Manager manager);

	public int deleteProgram(ProgramVo programVo);

	public int updateRequired(List<Program> programs);

	public int updatePrograms(List<Program> programs);

	public int insertProgram(Program program);

	public Program SingledReqOption(Manager manager);

}
