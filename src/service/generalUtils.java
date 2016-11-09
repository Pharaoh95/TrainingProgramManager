package service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import po.Program;
import po.Project;
import po.ProjectDetails;
/**
 * 通用工具类
 * @author D'm
 *
 */
public class generalUtils {
	/**
	 * 课程转成培养方案信息
	 * 
	 * @param project
	 *            课程信息
	 * @param majorId
	 *            所属专业id
	 */
	public static Program toPragram(Project project, int majorId) {
		Program program = new Program();
		String id = getRamdomId();
		program.setId(id);
		program.setName(project.getName());
		program.setProjectId(project.getId());
		program.setScore(project.getScore());
		program.setSumHour(project.getSumHours());
		program.setTheoryHour(project.getTheoryHours());
		program.setPracticeHour(project.getPracticeHours());
		program.setMajorId(majorId);
		program.setTeachDept(project.getCreatedDpt());

		// 结束周解析
		int endWeek = 0;
		int startWeek = 1;
		double perWeek = 0;
		String weekHour = project.getWeekHours();
		if (weekHour.contains("-")) {
			String[] hours = weekHour.split("-");
			perWeek = Double.parseDouble(hours[0]) + Double.parseDouble(hours[1]);
			endWeek = (int) (program.getSumHour() / perWeek);
		} else {
			perWeek = Double.parseDouble(weekHour);
			if (perWeek <= 0.0f) {
				startWeek = 0;
			} else {
				endWeek = (int) (program.getSumHour() / perWeek);
			}
		}
		// 默认的起始周数设置
		program.setStartWeek(startWeek);
		program.setEndWeek(endWeek);
		return program;
	}

	public static List<Project> parseXlsxFile(InputStream is) throws Exception {
		// POI解析该流
		XSSFWorkbook workbook = null;
		List<Project> projects = null;
		try {
			workbook = new XSSFWorkbook(is);
		} catch (IOException e) {
			throw new Exception(e);
		} 
		// 只解析第一页表格的数据
		XSSFSheet sheet = workbook.getSheetAt(0);
		// 获取表格行数
		int rows = sheet.getLastRowNum();
		projects = new ArrayList<>();
		// 逐行解析
		for (int rowIndex = 3; rowIndex < rows; rowIndex++) {
			XSSFRow row = sheet.getRow(rowIndex);
			Project project = new Project();
			// 课程代码解析
			project.setId(row.getCell(0).getRichStringCellValue().toString());
			// 课程名称解析
			project.setName(row.getCell(1).getRichStringCellValue().toString());
			// 学分解析
			XSSFCell scoreCell = row.getCell(3);
			if (scoreCell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
				project.setScore(2d);
			} else {
				project.setScore(scoreCell.getNumericCellValue());
			}
			// 周学时解析
			String weekHours = row.getCell(4).getRichStringCellValue().toString();
			if (weekHours.trim().equals("")) {
				project.setWeekHours("+2");
			} else {
				project.setWeekHours(weekHours);
			}
			// 总学时解析
			XSSFCell sumHoursCell = row.getCell(5);
			if (sumHoursCell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
				project.setSumHours(32d);
			} else {
				project.setSumHours(sumHoursCell.getNumericCellValue());
			}
			// 讲课学时解析
			XSSFCell theoryHours = row.getCell(6);
			if (theoryHours.getCellType() == HSSFCell.CELL_TYPE_STRING) {
				project.setTheoryHours(32d);
			} else {
				project.setTheoryHours(theoryHours.getNumericCellValue());
			}
			double pHours = project.getSumHours() - project.getTheoryHours();
			project.setPracticeHours(pHours);
			// 课程类别解析
			project.setType(row.getCell(14).getRichStringCellValue().toString());
			// 课程性质解析
			project.setQuality(row.getCell(22).getRichStringCellValue().toString());
			// 开设部门解析
			project.setCreatedDpt(row.getCell(49).getRichStringCellValue().toString());
			String level = row.getCell(32).getRichStringCellValue().toString();
			if (level.equals("")) {
				project.setLevel("本科");
			} else {
				project.setLevel(level);
			}
			// 详细信息解析
			ProjectDetails details = new ProjectDetails();
			// 课程归属解析
			String belongTo = row.getCell(15).getRichStringCellValue().toString();
			if (!belongTo.equals("")) {
				details.setBelongTo(belongTo);
			}
			// 开课部门代码解析
			details.setDptId((int) row.getCell(17).getNumericCellValue());
			// 权重系数解析
			if (row.getCell(21).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
				details.setWeight(row.getCell(21).getNumericCellValue());
			}
			// 质量审计解析
			details.setQualityEvaluation(row.getCell(27).getRichStringCellValue().toString());
			// 不快速选课标记解析
			if (row.getCell(28).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
				details.setUnQuickChosen(true);
			}
			// 备注解析
			String note = row.getCell(36).getRichStringCellValue().toString();
			if (!note.equals("")) {
				details.setNote(note);
			}
			project.setProjectDetails(details);
			details.setProject(project);
			// 打印测试
			// workbook.close();
			projects.add(project);
		}
		workbook.close();
		return projects;
	}

	public static String getRamdomId() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
