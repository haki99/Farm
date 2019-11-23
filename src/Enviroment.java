import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Enviroment {
	public void draw_enviroment(Stage window, GraphicsContext gc) {    
        
        Image sand = new Image("Data/Pics/Enviroment/Sand/sand.png");
		Image sand_right = new Image("Data/Pics/Enviroment/Sand/right.png");
		Image sand_bottom = new Image("Data/Pics/Enviroment/Sand/bottom.png");
		Image sand_bottom_right = new Image("Data/Pics/Enviroment/Sand/bottom_right.png");
		Image sand_bottom_small_right = new Image("Data/Pics/Enviroment/Sand/bottom_small_right.png");
		Image boat = new Image("Data/Pics/Enviroment/Other/fishing_boat.png");
		Image sd_left = new Image("Data/Pics/Enviroment/Sand/sand_left.png");
		Image sd_top = new Image("Data/Pics/Enviroment/Sand/sand_top.png");
		Image sd_top_left = new Image("Data/Pics/Enviroment/Sand/sand_top_left.png");
		Image sd_top_left_small = new Image("Data/Pics/Enviroment/Sand/sand_top_left_small.png");
		Image grass_middle = new Image("Data/Pics/Enviroment/Grass/grass_middle.png");
		Image grass_left = new Image("Data/Pics/Enviroment/Grass/grass_left.png");
		Image grass_bottom = new Image("Data/Pics/Enviroment/Grass/grass_bottom.png");
		Image grass_bottom_left = new Image("Data/Pics/Enviroment/Grass/grass_bottom_left.png");
		Image grass_right_inside = new Image("Data/Pics/Enviroment/Grass/grass_right_inside.png");
		
		Rectangle background = new Rectangle(0, 0, 1200, 800);
		Rectangle tenger1 = new Rectangle(0, 0, 160, 256);
		Rectangle tenger2 = new Rectangle(0, 0, 512, 160);
	    
	    //zöld háttér
	    gc.setFill(Color.rgb(47, 129, 54));
        gc.fillRect(background.getLayoutX(),      
        		background.getLayoutY(), 
        		background.getWidth(), 
        		background.getHeight());
	    
        //tenger
	    gc.setFill(Color.rgb(21, 108, 153));
        gc.fillRect(tenger1.getLayoutX(),      
        		tenger1.getLayoutY(), 
        		tenger1.getWidth(), 
        		tenger1.getHeight());
        
        gc.fillRect(tenger2.getLayoutX(),      
        		tenger2.getLayoutY(), 
        		tenger2.getWidth(), 
        		tenger2.getHeight());
        
        //sarok homokok a tengernél
        gc.drawImage(sand_bottom_right, 160, 256);
        gc.drawImage(sand_bottom_right, 512, 160);
        gc.drawImage(sand_bottom_small_right, 160, 160);
        
        //jobb partszakasz
        for(int i = 0; i < 5; i++) {
        	gc.drawImage(sand_right, 512, 0 + i * 32);
        }
        
        //kicsi jobb partszakasz
        for(int i = 0; i < 2; i++) {
        	gc.drawImage(sand_right, 160, 192 + i * 32);
        }
        
        for(int i = 0; i < 10; i++) {
        	gc.drawImage(sand_bottom, 192 + i * 32, 160);
        }
        
        //kicsi alsó partszakasz
        for(int i = 0; i < 5; i++) {
        	gc.drawImage(sand_bottom, 0 + i * 32, 256);
        }
        
        //alsó partszakasz
        for(int i = 0; i < 11; i++) {
        	for(int j = 0; j < 3; j++) {
            	gc.drawImage(sand, 192 + i * 32, 192  + j * 32);
            }
        }
        
        //part belsõ szakaszok
        for(int i = 0; i < 9; i++) {
        	gc.drawImage(sand, 544, 0 + i * 32);
        }
        
        for(int i = 0; i < 8; i++) {
        	gc.drawImage(sand, 576, 0 + i * 32);
        }
        
        for(int i = 0; i < 7; i++) {
        	gc.drawImage(sand, 608, 0 + i * 32);
        }
        
        
        for(int i = 0; i < 12; i++) {
        	gc.drawImage(sand, 0 + i * 32, 288);
        }
        
        for(int i = 0; i < 8; i++) {
        	gc.drawImage(sand, 0 + i * 32, 320);
        }
        
        
        //hajó
        gc.drawImage(boat, 64, 64);
        
        //homok-fû határ
        for(int i = 0; i < 7; i++) {
        	gc.drawImage(sd_left, 640, 0 + i * 32);
        }
        
        for(int i = 0; i < 8; i++) {
        	gc.drawImage(sd_top, 0 + i * 32, 352);
        }
        
        for(int i = 0; i < 3; i++) {
        	gc.drawImage(sd_top, 288 + i * 32, 320);
        }
        
        for(int i = 0; i < 5; i++) {
        	gc.drawImage(sd_top, 416 + i * 32, 288);
        }
        
        gc.drawImage(sd_top_left, 384, 288);
        gc.drawImage(sd_top_left, 256, 320);
        gc.drawImage(sd_top_left_small, 256, 352);
        gc.drawImage(sd_top_left_small, 384, 320);
        gc.drawImage(sd_top_left_small, 576, 288);
        gc.drawImage(sd_top_left, 576, 256);
        gc.drawImage(sd_top_left_small, 608, 256);
        gc.drawImage(sd_top_left, 608, 224);
        gc.drawImage(sd_top_left_small, 640, 224);
        
        //Fû
        for(int i = 0; i < 8; i++) {
        	for(int j = 0; j < 10; j++) {
        		gc.drawImage(grass_middle, 960 + i * 32, 0 + j * 32);
        	}
        }
        
        for(int i = 0; i < 5; i++) {
        	for(int j = 0; j < 4; j++) {
        		gc.drawImage(grass_middle, 1056 + i * 32, 320 + j * 32);
        	}
        }
        
        for(int i = 0; i < 3; i++) {
        	for(int j = 0; j < 2; j++) {
        		gc.drawImage(grass_middle, 1120 + i * 32, 448 + j * 32);
        	}
        }
        
        for(int i = 0; i < 10; i++) {
        	gc.drawImage(grass_left, 928, 0 + i * 32);
        }
        
        gc.drawImage(grass_right_inside, 1088, 448);

        gc.drawImage(grass_left, 1088, 480);

        gc.drawImage(grass_right_inside, 1024, 320);
        
        for(int i = 0; i < 3; i++) {
        	gc.drawImage(grass_left, 1024, 352 + i * 32);
        }
        
        for(int i = 0; i < 10; i++) {
        	gc.drawImage(grass_bottom, 1120 + i * 32, 512);
        }
        
        gc.drawImage(grass_bottom, 1056, 448);
        
        for(int i = 0; i < 2; i++) {
        	gc.drawImage(grass_bottom, 960 + i * 32, 320);
        }
        
        gc.drawImage(grass_bottom_left, 928, 320);
        gc.drawImage(grass_bottom_left, 1024, 448);
        gc.drawImage(grass_bottom_left, 1088, 512);
        
	    window.show();
	}
	
	public void draw_garden(Stage window, Player player, GraphicsContext gc, int x, int y) {
		Image soil_top_left = new Image("Data/Pics/Enviroment/Garden/soil_top_left.png");
		Image soil_top_right = new Image("Data/Pics/Enviroment/Garden/soil_top_right.png");
		Image soil_bottom_left = new Image("Data/Pics/Enviroment/Garden/soil_bottom_left.png");
		Image soil_bottom_right = new Image("Data/Pics/Enviroment/Garden/soil_bottom_right.png");
		Image soil_top = new Image("Data/Pics/Enviroment/Garden/soil_top.png");
		Image soil_bottom = new Image("Data/Pics/Enviroment/Garden/soil_bottom.png");
		Image soil_left = new Image("Data/Pics/Enviroment/Garden/soil_left.png");
		Image soil_right = new Image("Data/Pics/Enviroment/Garden/soil_right.png");
		Image soil = new Image("Data/Pics/Enviroment/Garden/soil_line.png");
		Image hole = new Image("Data/Pics/Enviroment/Garden/hole.png");
		
		//Bal felsõ blokk
		gc.drawImage(soil_top_left, 224, 416);
		
		//Jobb felsõ blokk
		gc.drawImage(soil_top_right, 256 + x * 32, 416);
		
		//Bal alsó blokk
		gc.drawImage(soil_bottom_left, 224, 448 + y * 32);
		
		//Jobb alsó blokk
		gc.drawImage(soil_bottom_right, 256 + x * 32, 448 + y * 32);
		
		for(int i = 0; i < x; i++) {
			gc.drawImage(soil_top, 256 + i * 32, 416);
		}
		
		for(int i = 0; i < x; i++) {
			gc.drawImage(soil_bottom, 256 + i * 32, 448 + y * 32);
		}
		
		for(int j = 0; j < y; j++) {
			gc.drawImage(soil_left, 224, 448 + j * 32);
		}
		
		for(int j = 0; j < y; j++) {
			gc.drawImage(soil_right, 256 + x * 32, 448 + j * 32);
		}

		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				gc.drawImage(soil, 256 + i * 32, 448 + j * 32);
				gc.drawImage(hole, 257 + i * 32, 413 + j * 32);
			}
		}
	}
	
	public void draw_plant(Stage window, GraphicsContext gc, int a, int b, String type, Group root, Canvas canvas) {
		String url = "";
		switch(type) {
			case "paradicsom": url = "Data/Pics/Enviroment/Garden/Plants/paradicsom1.png"; break;
			//extend here
			default: break;
		}
		
		//0,0-ra alakítva a mátrix kezdése
		a -= 8;
		b -= 14;
		
		Image plant = new Image(url);
		
		//Elso palanta koordinatai: 258, 408
		gc.drawImage(plant, 258 + a * 32, 408 + b * 32);
		
        window.show();
	}
}
