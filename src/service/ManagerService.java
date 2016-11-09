package service;

import java.util.List;

import po.CustomResult;
import po.Manager;
import po.ManagerVo;
import po.statisticData;
/**
 * 接口：管理员，封装相关业务逻辑
 * @author Administrator
 *
 */
public interface ManagerService {
	public Manager findManager(ManagerVo managerVo);

	public List<statisticData> findStatisticByMajor(int majorId);

	public CustomResult<Manager> findManagers(ManagerVo managerVo);

	public int updateManagers(List<Manager> managers);
	/**
	 * 修改管理员密码
	 * @param managerVo
	 * @return
	 */
	public boolean resetPassword(ManagerVo managerVo);
}
