import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.util.Duration;


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
        MenuItem aratas = new MenuItem("Aratás");
        menu.getItems().addAll(par_ultetes_menu, aratas);
		
		for (int i = 8 ; i < x ; i++) {
            for (int j = 14; j < y; j++) {
            	int a = i;
            	int b = j;
            	Pane cell = new Pane();
                cell.setOnMouseClicked(e -> {
                	e.consume();
                	
            		int u = a - 8;
            		int z = b - 14;
            		
            		if(player.get_plant(z, u) == null) {

            			par_ultetes_menu.setOnAction(evt -> {
               		
                			String type = "paradicsom1";
                		
                			enviroment.draw_plant(window, a, b, type);
                		
                			Plant p = new Plant("paradicsom", 5, 4);
                		
                			player.add_plant(p, u, z);
                		});
            		}
            		else {
            			aratas.setOnAction(evt -> {
            				evt.consume();
            				
            				player.remove_plant(z, u);
            				
            				int l = 0;
            				int k = 0;
            				
            				switch(player.getdiff()) {
            					case 1: l = 5; k = 5; break;
            					case 2: l = 10; k = 8; break;
            					case 3: l = 20; k = 8; break;
            				}
            				
            				enviroment.draw_soil(window, player, l, k);
            				enviroment.draw_garden(window, player);
            			});
            		}
            		
                    menu.show(cell, e.getScreenX(), e.getScreenY());
                });
                kert.add(cell, a, b);
            }
        }

		return kert;
	}
	
	public void growcycle(Player player, Stage window, Enviroment e) {
		
		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
			
			player.grow_plants();
			player.check_grow(window, e);
			
		}));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}
}
