package mapper;

import java.util.List;

import po.Category;
import po.profProgram;

public interface profProgramMapper {

	public List<profProgram> getProfProgramsByCate(String cateId);

	public int deleteBatch(List<profProgram> profPrograms);

	public void insertProfProgram(profProgram program);

	public int updateBatch(List<profProgram> programs);

	public int insertCategory(Category category);

	public List<Category> getCategories(int majorId);

	public int deleteCategory(String cateId);
}
