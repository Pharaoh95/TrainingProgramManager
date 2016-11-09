package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mapper.MajorMapper;
import mapper.ManagerMapper;
import po.CustomResult;
import po.Major;
import po.Manager;
import po.ManagerVo;
import po.statisticData;
import service.ManagerService;

public class ManagerServiceImpl implements ManagerService {
	@Autowired
	private ManagerMapper managerMapper;
	@Autowired
	private MajorMapper majorMapper;

	@Override
	public Manager findManager(ManagerVo managerVo) {
		return managerMapper.findById(managerVo);
	}

	@Override
	public List<statisticData> findStatisticByMajor(int majorId) {
		// 这里需要改进，具体改为一次数据库查询操作
		List<statisticData> statisticDatas = managerMapper.getStatisticByMajor(majorId);
		Major major = majorMapper.findById(majorId);
		for (statisticData statisticData : statisticDatas) {
			statisticData.setAdviceHour(major.getMaxSumHour());
			statisticData.setAdviceMinScore(major.getMinSumScore());
			statisticData.setAdviceMaxScore(major.getMaxSumScore());
		}
		return statisticDatas;
	}

	@Override
	public CustomResult<Manager> findManagers(ManagerVo managerVo) {
		CustomResult<Manager> result = new CustomResult<>();
		List<Manager> list = managerMapper.findManager(managerVo);
		result.setRows(list);
		result.setTotal(list.size());
		return result;
	}

	@Override
	public int updateManagers(List<Manager> managers) {
		return managerMapper.updateManagers(managers);
	}

	@Override
	public boolean resetPassword(ManagerVo managerVo) {
		if (this.findManager(managerVo) != null) {
			managerMapper.updatePwd(managerVo);
			return true;
		}
		return false;
	}
}
