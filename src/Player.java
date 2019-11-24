public class Player {
	private String name;
	private int diff;
	private Plant[][] garden_matrix;
	private int a;
	private int b;
	
	public void set_data(String n, int d, int x, int y) {
		name = n;
		diff = d;
		a = y;
		b = x;
		garden_matrix = new Plant[a][b];
		
		for(int i = 0; i < a; i++) {
			for(int j = 0; j < b; j++) {
				garden_matrix[i][j] = null;
			}
		}
	}
	
	public int getdiff() {
		return diff;
	}
	
	public String getname() {
		return name;
	}
	
	public Plant get_plant(int i, int j) {
		return garden_matrix[i][j];
	}
	
	public void add_plant(Plant p, int i, int j) {
		garden_matrix[j][i] = p;
	}
	
	//test
	public void write_array() {
		for(int i = 0; i < a; i++) {
			for(int j = 0; j < b; j++) {
				if(garden_matrix[i][j] != null) System.out.print("[" + garden_matrix[i][j].get_growth() + "]");
				else  System.out.print("[" + "]");
			}
			System.out.println();
		}
	}
}
