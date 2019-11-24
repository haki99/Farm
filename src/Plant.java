
public class Plant {
	private String name;
	private int growth;
	private int grow_time;
	
	public Plant(String n, int t) {
		name = n;
		growth = 0;
		grow_time = t;
	}
	
	public String get_name() {
		return name;
	}
	
	public int get_grow_time() {
		return grow_time;
	}
	
	public int get_growth() {
		return growth;
	}
	
	public void grow() {
		growth += 1;
	}
}
