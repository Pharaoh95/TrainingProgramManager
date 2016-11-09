package service;

import java.util.List;

import po.AdvicedNorm;
import po.Major;
/**
 * 接口：专业，封装相关业务逻辑
 * @author Administrator
 *
 */
public interface MajorService {
	public List<Major> findAll();

	public List<AdvicedNorm> findAdvicedNorms();

	public int updateAdvicedNorms(List<AdvicedNorm> advicedNorms);
}
