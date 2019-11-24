import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javafx.stage.Stage;

public class Player implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int diff;
	ArrayList<ArrayList<Plant>> garden_matrix; 
	private int a;
	private int b;
	
	public void set_data(String n, int d, int x, int y) {
		name = n;
		diff = d;
		a = y;
		b = x;
		garden_matrix = new ArrayList<ArrayList<Plant>>(); 
		
		for(int i = 0; i < a; i++) {
			garden_matrix.add(new ArrayList<Plant>() );
			for(int j = 0; j < b; j++) {
				garden_matrix.get(i).add(null);
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
		return garden_matrix.get(i).get(j);
	}
	
	public void remove_plant(int i, int j) {
		garden_matrix.get(i).set(j, null);
	}
	
	public void add_plant(Plant p, int i, int j) {
		garden_matrix.get(i).set(j, p);
	}
	
	public void grow_plants() {
		for(int i = 0; i < a; i++) {
			for(int j = 0; j < b; j++) {
				if(garden_matrix.get(i).get(j) != null) {
					if(this.get_plant(i, j).get_growth_level() < this.get_plant(i, j).get_maxgrowth()) {
						this.get_plant(i, j).grow();
						//for tests
						//this.write_array();
					}
				}
			}
		}
	}
	
	public void check_grow(Stage window, Enviroment e) {
		for(int i = 0; i < a; i++) {
			for(int j = 0; j < b; j++) {
				if(garden_matrix.get(i).get(j) != null) {
					if(this.get_plant(i, j).get_growth_level() < this.get_plant(i, j).get_maxgrowth()) {
						if(this.get_plant(i, j).get_growth() >= this.get_plant(i, j).get_grow_time()) {
							
							this.get_plant(i, j).erase_growth();
							this.get_plant(i, j).incr_growthlevel();
							
							int x = i + 14;
							int y = j + 8;
							String url = "";
							
							switch (this.get_plant(i, j).get_growth_level()){
								case 2:url = "paradicsom2"; break;
								case 3:url = "paradicsom3"; break;
								case 4:url = "paradicsom4"; break;
							}
							e.draw_plant(window, y, x, url);
						}
					}
				}
			}
		}
	}
	
	public void save() {
		try {
			FileOutputStream fos = new FileOutputStream("farm_save");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
            fos.close();
		}
		catch (IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	//for tests
	public void write_array() {
		for(int i = 0; i < a; i++) {
			for(int j = 0; j < b; j++) {
				if(garden_matrix.get(i).get(j) != null) System.out.print("[" + garden_matrix.get(i).get(j).get_growth() + "]");
				else  System.out.print("[" + "]");
			}
			System.out.println();
		}
		System.out.println();
	}
}
