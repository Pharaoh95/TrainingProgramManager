package service;

import java.util.List;

import po.Category;
import po.Manager;
import po.profProgram;
/**
 * �ӿڣ��ַ����������������װ���ҵ���߼�
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
