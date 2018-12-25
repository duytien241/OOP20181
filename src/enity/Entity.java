package enity;

public class Entity {
	private String identy;	// nhãn thực thể
	private String label;	// tên thực thể
	private String describe; // mô tả
	private String link;	// link trích rút
	private String date;	// ngay trich rut
	public Entity(String label,String name, String describe, String link,String date) {
		this.identy = label;
		this.label = name;
		this.describe = describe;
		this.link = link;
		this.date = date;
	}
	public Entity() {
	}
	public String getName() {
		return label;
	}
	public void setName(String name) {
		this.label = name;
	}
	public String getLabel() {
		return identy;
	}
	public void setLabel(String label) {
		this.identy = label;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void showif() {
		
	}
}
