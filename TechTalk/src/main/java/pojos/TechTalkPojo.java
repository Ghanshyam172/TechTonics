package pojos;

public class TechTalkPojo {

	
	int id;
	String title;
	String description;
	String presenter;
	String date;
	String time;
	
	//class constructor
	public TechTalkPojo(int id, String title, String description, String presenter, String date, String time) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.presenter = presenter;
		this.date = date;
		this.time = time;
	}
	
	
	//class constructor
	public TechTalkPojo(String title, String description, String presenter, String date, String time) {
		super();
		this.title = title;
		this.description = description;
		this.presenter = presenter;
		this.date = date;
		this.time = time;
	}



	//getter-setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPresenter() {
		return presenter;
	}
	public void setPresenter(String presenter) {
		this.presenter = presenter;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	
	@Override
	public String toString() {
		return "TechTalkPojo [id=" + id + ", title=" + title + ", description=" + description + ", presenter="
				+ presenter + ", date=" + date + ", time=" + time + "]";
	}
	
	
	
}
