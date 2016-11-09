package po;
/**
 * 
 * @author Administrator
 *
 */
public class Category {

	private String id;
	private String text;
	private int majorId;

	public int getMajorId() {
		return majorId;
	}

	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + text + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
