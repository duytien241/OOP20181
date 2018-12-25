package enity;

public class Person extends Entity {
	private String job; // ngh�? nghiệp
	private int age;	// tuổi
	private String male;   // giới tính
	private String nationnal;
	public Person() {
		super();
	
	}
	public Person(String identifi,String label, String describe,String nationnal, String link,String date,String job,int age,String male) {
		this.setLabel(identifi);
		this.setName(label);
		this.setDescribe(describe);
		this.nationnal = nationnal;
		this.setLink(link);
		this.setDate(date);
		this.job = job;
		this.age = age;
		this.male = male;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age < 0) {
			System.out.println("Tuổi không được là số âm");
			return;
		}
		else
		this.age = age;
	}
	public String getMale() {
		return male;
	}
	public void setMale(String male) {
		this.male = male;
	}
	public void  showif() {
		System.out.println("Name: "+ getName());
		System.out.println("Label: "+getLabel());
		System.out.println("Age: "+ getAge());
		System.out.println("Male: "+ getMale());
		System.out.println("Link: "+getLink());
		System.out.println("Date: "+getDate());
	}
	public String getNationnal() {
		return nationnal;
	}
	public void setNationnal(String nationnal) {
		this.nationnal = nationnal;
	}
}
