package mapper;

import java.util.List;

import po.Major;
import po.Manager;
import po.ManagerVo;
import po.statisticData;

public interface ManagerMapper {
	public Manager findById(ManagerVo managerVo);

	public List<statisticData> getStatisticByMajor(int majorId);

	public List<Manager> findManager(ManagerVo managerVo);

	public int updateManagers(List<Manager> managers);

	public int updatePwd(ManagerVo managerVo);
}
