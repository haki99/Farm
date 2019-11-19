import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class Main extends Application{
	
	Stage window;

    @Override
    public void start(Stage PrimaryStage) 
    {
    	window = PrimaryStage;
    	window.setTitle("Farm");
    	
    	Displayer displayer = new Displayer();
    	Scene scene;
    	
    	scene = displayer.Main_Menu(window);

        window.setOnCloseRequest((event) -> {
        	event.consume();
        	closeProgram();
        });
        
        window.setScene(scene);
        window.centerOnScreen();
        window.setResizable(false);
        window.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    private void closeProgram() {
    	Boolean answer = ConfirmBox.display("Vigyázat!","Biztos ki akarsz lépni?");
    	if(answer) window.close();
    }
}