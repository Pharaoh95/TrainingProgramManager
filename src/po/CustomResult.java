package po;

import java.util.List;

/**
 * Ϊeasyui����ҳ�����Ľ��������
 * 
 * @author Administrator
 *
 * @param <T>
 */
public class CustomResult<T> {
	private int total;
	private List<T> rows;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> dataList) {
		this.rows = dataList;
	}
}
