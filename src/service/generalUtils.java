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
 * ͨ�ù�����
 * @author D'm
 *
 */
public class generalUtils {
	/**
	 * �γ�ת������������Ϣ
	 * 
	 * @param project
	 *            �γ���Ϣ
	 * @param majorId
	 *            ����רҵid
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

		// �����ܽ���
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
		// Ĭ�ϵ���ʼ��������
		program.setStartWeek(startWeek);
		program.setEndWeek(endWeek);
		return program;
	}

	public static List<Project> parseXlsxFile(InputStream is) throws Exception {
		// POI��������
		XSSFWorkbook workbook = null;
		List<Project> projects = null;
		try {
			workbook = new XSSFWorkbook(is);
		} catch (IOException e) {
			throw new Exception(e);
		} 
		// ֻ������һҳ��������
		XSSFSheet sheet = workbook.getSheetAt(0);
		// ��ȡ�������
		int rows = sheet.getLastRowNum();
		projects = new ArrayList<>();
		// ���н���
		for (int rowIndex = 3; rowIndex < rows; rowIndex++) {
			XSSFRow row = sheet.getRow(rowIndex);
			Project project = new Project();
			// �γ̴������
			project.setId(row.getCell(0).getRichStringCellValue().toString());
			// �γ����ƽ���
			project.setName(row.getCell(1).getRichStringCellValue().toString());
			// ѧ�ֽ���
			XSSFCell scoreCell = row.getCell(3);
			if (scoreCell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
				project.setScore(2d);
			} else {
				project.setScore(scoreCell.getNumericCellValue());
			}
			// ��ѧʱ����
			String weekHours = row.getCell(4).getRichStringCellValue().toString();
			if (weekHours.trim().equals("")) {
				project.setWeekHours("+2");
			} else {
				project.setWeekHours(weekHours);
			}
			// ��ѧʱ����
			XSSFCell sumHoursCell = row.getCell(5);
			if (sumHoursCell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
				project.setSumHours(32d);
			} else {
				project.setSumHours(sumHoursCell.getNumericCellValue());
			}
			// ����ѧʱ����
			XSSFCell theoryHours = row.getCell(6);
			if (theoryHours.getCellType() == HSSFCell.CELL_TYPE_STRING) {
				project.setTheoryHours(32d);
			} else {
				project.setTheoryHours(theoryHours.getNumericCellValue());
			}
			double pHours = project.getSumHours() - project.getTheoryHours();
			project.setPracticeHours(pHours);
			// �γ�������
			project.setType(row.getCell(14).getRichStringCellValue().toString());
			// �γ����ʽ���
			project.setQuality(row.getCell(22).getRichStringCellValue().toString());
			// ���貿�Ž���
			project.setCreatedDpt(row.getCell(49).getRichStringCellValue().toString());
			String level = row.getCell(32).getRichStringCellValue().toString();
			if (level.equals("")) {
				project.setLevel("����");
			} else {
				project.setLevel(level);
			}
			// ��ϸ��Ϣ����
			ProjectDetails details = new ProjectDetails();
			// �γ̹�������
			String belongTo = row.getCell(15).getRichStringCellValue().toString();
			if (!belongTo.equals("")) {
				details.setBelongTo(belongTo);
			}
			// ���β��Ŵ������
			details.setDptId((int) row.getCell(17).getNumericCellValue());
			// Ȩ��ϵ������
			if (row.getCell(21).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
				details.setWeight(row.getCell(21).getNumericCellValue());
			}
			// ������ƽ���
			details.setQualityEvaluation(row.getCell(27).getRichStringCellValue().toString());
			// ������ѡ�α�ǽ���
			if (row.getCell(28).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
				details.setUnQuickChosen(true);
			}
			// ��ע����
			String note = row.getCell(36).getRichStringCellValue().toString();
			if (!note.equals("")) {
				details.setNote(note);
			}
			project.setProjectDetails(details);
			details.setProject(project);
			// ��ӡ����
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
