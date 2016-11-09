package service;

import java.util.List;

import po.CustomResult;
import po.Manager;
import po.ManagerVo;
import po.statisticData;
/**
 * �ӿڣ�����Ա����װ���ҵ���߼�
 * @author Administrator
 *
 */
public interface ManagerService {
	public Manager findManager(ManagerVo managerVo);

	public List<statisticData> findStatisticByMajor(int majorId);

	public CustomResult<Manager> findManagers(ManagerVo managerVo);

	public int updateManagers(List<Manager> managers);
	/**
	 * �޸Ĺ���Ա����
	 * @param managerVo
	 * @return
	 */
	public boolean resetPassword(ManagerVo managerVo);
}
