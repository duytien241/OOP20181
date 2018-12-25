package enity;

public class Time extends Entity {



	public Time(String label, String name, String describe, String link, String date) {
		super(label, name, describe, link, date);
		// TODO Auto-generated constructor stub
	}
	private String time;
	public Time(String time) {
		super();
		this.time = time;
	
	}
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	public void showif() {
		System.out.println("Name: "+this.getName());
		System.out.println("Label: "+this.getLabel());
		System.out.println("Th�?i Gian: "+getTime());
	}
}
