package mapper;

import java.util.List;

import po.Program;
import po.ProgramVo;

public interface ProgramMapper {
	
	public List<Program> findPrograms(ProgramVo programVo);

	public int insertBatchRequired(List<Program> programs);

	public int deleteRequiredByMajor(int majorId);

	public int updateRequired(List<Program> programs);

	public int deleteProgram(ProgramVo programVo);

	public int updatePrograms(List<Program> programs);

	public int insertProgram(Program program);
	
	public int getSum(ProgramVo programVo);
	
	public Program getReqOptioned(int majorId);
}
