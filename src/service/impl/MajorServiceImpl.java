package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mapper.MajorMapper;
import po.AdvicedNorm;
import po.Major;
import service.MajorService;

public class MajorServiceImpl implements MajorService {
	@Autowired
	private MajorMapper majorMapper;

	@Override
	public List<Major> findAll() {
		return majorMapper.findAll();
	}

	@Override
	public List<AdvicedNorm> findAdvicedNorms() {
		return majorMapper.findAdvicedNorms();
	}

	@Override
	public int updateAdvicedNorms(List<AdvicedNorm> advicedNorms) {
		return majorMapper.updateAdvicedNorms(advicedNorms);
	}

}
