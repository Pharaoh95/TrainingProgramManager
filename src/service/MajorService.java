package service;

import java.util.List;

import po.AdvicedNorm;
import po.Major;
/**
 * �ӿڣ�רҵ����װ���ҵ���߼�
 * @author Administrator
 *
 */
public interface MajorService {
	public List<Major> findAll();

	public List<AdvicedNorm> findAdvicedNorms();

	public int updateAdvicedNorms(List<AdvicedNorm> advicedNorms);
}
