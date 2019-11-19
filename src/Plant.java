
public class Plant {
	private String name;
	private int grow_time;
	
	public Plant(String n, int t) {
		name = n;
		grow_time = t;
	}
	
	public String get_name() {
		return name;
	}
	
	public int get_grow_time() {
		return grow_time;
	}
}
