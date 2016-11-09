package mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import po.AdvicedNorm;
import po.Major;

public interface MajorMapper {
	public List<Major> findAll();

	public Major findById(int id);

	public List<AdvicedNorm> findAdvicedNorms();

	public int updateAdvicedNorms(List<AdvicedNorm> advicedNorms);

}
