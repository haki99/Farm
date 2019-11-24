import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;


public class Controller {
	public GridPane garden(Player player, int x, int y, Enviroment enviroment, Stage window, GraphicsContext gc, Group root, Canvas canvas) {
		
		x += 8;
		y += 14;

		GridPane kert = new GridPane();
		kert.setGridLinesVisible(true);
		
		for (int i = 0; i < 37; i++) {
	         ColumnConstraints column = new ColumnConstraints(32);
	         kert.getColumnConstraints().add(column);
	     }
		
		for (int i = 0; i < 24; i++) {
	         RowConstraints row = new RowConstraints(32);
	         kert.getRowConstraints().add(row);
	     }
		
		ContextMenu menu = new ContextMenu();
        MenuItem par_ultetes_menu = new MenuItem("Ültetés");
        menu.getItems().addAll(par_ultetes_menu);
		
		for (int i = 8 ; i < x ; i++) {
            for (int j = 14; j < y; j++) {
            	int a = i;
            	int b = j;
            	Pane cell = new Pane();
                cell.setOnMouseClicked(e -> {
                	par_ultetes_menu.setOnAction(evt -> {
                		int u = a - 8;
                		int z = b - 14;
                		
                		System.out.println("Item 1 selected in cell [" + a + ", " + b + "]");
                		
                		String type = "paradicsom";
                		
                		enviroment.draw_plant(window, a, b, type);
                		
                		Plant p = new Plant("paradicsom", 10);
                		
                		player.add_plant(p, u, z);
                	});
                    menu.show(cell, e.getScreenX(), e.getScreenY());
                });
                kert.add(cell, a, b);
            }
        }

		return kert;
	}
	
	public void growcycle(Player player, int a, int b) {
		
        AnimationTimer loop = new AnimationTimer() {

            @Override
            public void handle(long now) {
            	//
        		//novekedes ciklus
        		for(int i = 0; i < a; i++) {
        			for(int j = 0; j < b; j++) {
        				if(player.get_plant(i, j) != null) {
        					player.get_plant(i, j).grow();;
        					player.write_array();
        				}
        			}	
        		}
        		//
            }
        };

        loop.start();
	}
}
