package service;

import java.util.List;

import po.Category;
import po.Manager;
import po.profProgram;
/**
 * 接口：分方向的培养方案，封装相关业务逻辑
 * @author Administrator
 *
 */
public interface profProgramService {
	public List<profProgram> getByCateId(String cateId);

	public int deleteBatch(List<profProgram> profPrograms);

	public void insertOne(profProgram program);

	public int updateBatch(List<profProgram> programs);

	public int insertCategory(Category category, Manager manager);

	public List<Category> getCategories(int majorId);

	public int deleteCategory(String cateId);

}
