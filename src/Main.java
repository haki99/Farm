import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
	
	Player player = new Player();
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage PrimaryStage) 
    {
    	Displayer displayer = new Displayer();
    	
    	displayer.initialize(PrimaryStage);
    	
    	displayer.Main_Menu(player);
    }
}