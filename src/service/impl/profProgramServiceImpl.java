package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mapper.profProgramMapper;
import po.Category;
import po.Manager;
import po.profProgram;
import service.generalUtils;
import service.profProgramService;

public class profProgramServiceImpl implements profProgramService {
	@Autowired
	private profProgramMapper profprogramMapper;

	@Override
	public List<Category> getCategories(int majorId) {
		return profprogramMapper.getCategories(majorId);
	}

	@Override
	public List<profProgram> getByCateId(String cateId) {
		return profprogramMapper.getProfProgramsByCate(cateId);
	}

	@Override
	public int deleteBatch(List<profProgram> profPrograms) {
		return profprogramMapper.deleteBatch(profPrograms);
	}

	@Override
	public void insertOne(profProgram program) {
		program.setId(generalUtils.getRamdomId());
		profprogramMapper.insertProfProgram(program);
	}

	@Override
	public int updateBatch(List<profProgram> programs) {
		return profprogramMapper.updateBatch(programs);
	}

	@Override
	public int insertCategory(Category category, Manager manager) {
		category.setId(generalUtils.getRamdomId());
		category.setMajorId(manager.getMaintainMajor().getId());
		return profprogramMapper.insertCategory(category);
	}

	@Override
	public int deleteCategory(String cateId) {
		return profprogramMapper.deleteCategory(cateId);
	}

}
