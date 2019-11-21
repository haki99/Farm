import javafx.geometry.Insets;
import javafx.scene.Scene;
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
	public boolean draw_enviroment(Stage window) {
		boolean siker = false;
		
		Image image = new Image("Data/Pics/Enviroment/Sand/left.png");
		
		ImageView lake = new ImageView();
		lake.setImage(image);
		
		Rectangle tenger = new Rectangle(0, 0, 32, 32);
		tenger.setFill(Color.rgb(21, 108, 153));
		
		/*HBox box = new HBox();
        box.getChildren().addAll(lake, tenger);
        box.setBackground(new Background(new BackgroundFill(Color.rgb(47, 129, 54), CornerRadii.EMPTY, Insets.EMPTY)));*/
		
		GridPane gamelayout = new GridPane();
		
		for(int i = 0; i < 32; i++) {
			gamelayout.add(tenger, i, 0);
		}
		
		//gamelayout.add(lake, 1, 0);
        
        Scene sgame = new Scene(gamelayout, 1200, 800);
        
        window.setScene(sgame);
		
		return siker;
	}
}
