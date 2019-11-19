import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Displayer {

	public Scene Main_Menu(Stage window) {
		Button Bplay = new Button("Play");
    	Button Bexit = new Button("Exit");
    	
    	Bexit.setOnAction((event) -> {
    		closeProgram(window);
    		});
    	
    	VBox vbox = new VBox(5);
    	vbox.getChildren().addAll(Bplay, Bexit);
    	
    	StackPane main = new StackPane ();
    	main.setPrefSize(1200, 800);
    	
    	BackgroundSize bsize = new BackgroundSize(1504, 1000, false, false, false, false);
    	
        BackgroundImage myBI= new BackgroundImage(new Image("Data/Pics/main_background.jpg"),
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bsize);
        main.setBackground(new Background(myBI));
    	
        main.getChildren().add(vbox);
        vbox.setAlignment(Pos.CENTER);
        
        Scene main_menu = new Scene(main, 1200, 800);
        
        return main_menu;
	}
	
	private void closeProgram(Stage window) {
    	Boolean answer = ConfirmBox.display("Vigyázat!","Biztos ki akarsz lépni?");
    	if(answer) window.close();
    }
}
