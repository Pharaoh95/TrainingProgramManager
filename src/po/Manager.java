package po;

import java.util.List;
/**
 * ����Ա
 * @author Administrator
 *
 */
public class Manager {
	private String id;
	private String name;//����Ա����
	private int level;//����ԱȨ�޵ȼ�
	private Major maintainMajor;//����Աά����רҵ
	private String scndCollege;//����Ա��������ѧԺ
	private String character;//��ɫ����
	// ���ֶ�Ϊ�߼�����Ա��Ԥ������ѧԺ��רҵ�б�
	private List<Major> querableMajors;

	public Major getMaintainMajor() {
		return maintainMajor;
	}

	public void setMaintainMajor(Major maintainMajor) {
		this.maintainMajor = maintainMajor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", level=" + level + ", maintainMajor=" + maintainMajor
				+ ", scndCollege=" + scndCollege + ", character=" + character + ", querableMajors=" + querableMajors
				+ "]";
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public List<Major> getQuerableMajors() {
		return querableMajors;
	}

	public void setQuerableMajors(List<Major> querableMajors) {
		this.querableMajors = querableMajors;
	}

	public String getScndCollege() {
		return scndCollege;
	}

	public void setScndCollege(String scndCollege) {
		this.scndCollege = scndCollege;
	}

	public String getMaintainMajorName() {
		return this.maintainMajor.getName();
	}

	public void setMaintainMajorName(String name) {
		this.maintainMajor.setName(name);
	}

}
