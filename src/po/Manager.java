package po;

import java.util.List;
/**
 * 管理员
 * @author Administrator
 *
 */
public class Manager {
	private String id;
	private String name;//管理员姓名
	private int level;//管理员权限等级
	private Major maintainMajor;//管理员维护的专业
	private String scndCollege;//管理员所属二级学院
	private String character;//角色（）
	// 该字段为高级管理员可预览所在学院的专业列表
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
