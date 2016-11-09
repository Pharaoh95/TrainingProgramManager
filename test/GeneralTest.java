import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.TableIterator;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mapper.ManagerMapper;
import po.Project;
import po.ProjectDetails;
import service.ManagerService;

public class GeneralTest {
	@Test
	public void fun() throws Exception {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"Spring/applicationContext-dao.xml");
		ManagerService ms = applicationContext.getBean(ManagerService.class);
		System.out.println(ms);
		// FileInputStream fis = new FileInputStream("template.doc");
		// POIFSFileSystem pfs = new POIFSFileSystem(fis);
		// HWPFDocument doc = new HWPFDocument(pfs);
		// Range range = doc.getRange();
		//
		// TableIterator it = new TableIterator(range);
		// fis.close();
	}

	public void ImportProject() throws Exception {
		// ���·�������ļ���
		FileInputStream fis = new FileInputStream("�γ̿�2016.5.18.xlsx");
		// POI��������
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		// ֻ������һҳ��������
		XSSFSheet sheet = workbook.getSheetAt(0);
		// ��ȡ�������
		int rows = sheet.getLastRowNum();
		List<Project> projects = new ArrayList<>();
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
	}

}
