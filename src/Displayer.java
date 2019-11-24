import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class Displayer {
	private Stage window;
	
	public void initialize(Stage PrimaryStage) {
		Image traktor = new Image("Data/Pics/traktor.gif");
		
		window = PrimaryStage;
    	window.setTitle("Farm");
    	window.getIcons().add(traktor);
    	
    	window.centerOnScreen();
        window.setMaxHeight(800);
        window.setMaxWidth(1200);
        
        window.setOnCloseRequest((event) -> {
        	event.consume();
        	closeProgram();
        });
	}

	public void Main_Menu(Player player) {
    	
		Button Bplay = new Button("Play");
    	Button Bexit = new Button("Exit");
		
		Bplay.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t){
                window.setScene(Setup_Game(player));
          }
		});
		
    	Bexit.setOnAction((event) -> {
    		event.consume();
    		closeProgram();
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
        
        window.setScene(main_menu);
        window.show();
	}
	
	public void closeProgram() {
    	Boolean answer = ConfirmBox.display("Vigyázat!","Biztos ki akarsz lépni?");
    	if(answer) window.close();
    }
	
	public Scene Setup_Game(Player player) {
		ObservableList<String> difficulty = FXCollections.observableArrayList("Könnyû","Közepes","Nehéz");	
		ComboBox<String> diff_ch = new ComboBox<String>(difficulty);
		
		Label label1 = new Label("Name:");
		TextField textField = new TextField ();
		textField.setMaxWidth(200);
		
		Button Bback = new Button("Back");
		Button Bstart = new Button("Start");
		
		Bback.setOnAction((event) -> {
			Main_Menu(player);
    	});
		
		Bstart.setOnAction((event) -> {  	
			int x = 0;
			int a = 0;
			int b = 0;
			switch(diff_ch.getValue()) {
				case "Könnyû": x = 1; a = 5; b = 5; break;
				case "Közepes": x = 2; a = 10; b = 8;  break;
				case "Nehéz": x = 3; a = 20; b = 8;  break;
				default: break;
			}
			
        	player.set_data(textField.getText(), x, a, b);
    		Game_display(player);
    	});
		
		GridPane setup_game = new GridPane ();
		setup_game.setVgap(5);
		setup_game.setHgap(5);
		setup_game.setPadding(new Insets(10, 10, 10, 10));
		setup_game.setAlignment(Pos.CENTER);
		
		setup_game.add(label1, 0, 0);
		setup_game.add(textField, 1, 0);
		setup_game.add(diff_ch, 1, 1);
		setup_game.add(Bstart, 1, 2);
		setup_game.add(Bback, 1, 3);
		
		BackgroundSize bsize = new BackgroundSize(1504, 1000, false, false, false, false);
    	
        BackgroundImage myBI= new BackgroundImage(new Image("Data/Pics/main_background.jpg"),
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bsize);
        
        setup_game.setBackground(new Background(myBI));		
		Scene sgame = new Scene(setup_game, 1200, 800);
		
		return sgame;
	}
	
	public void Game_display(Player player) {
		int x = 0;
		int y = 0;
		
		switch(player.getdiff()) {
			case 1: x = 5; y = 5; break;
			case 2: x = 10; y = 8; break;
			case 3: x = 20; y = 8; break;
		}
		
	    Enviroment enviroment  = new Enviroment();
	    enviroment.initialize(window);
		enviroment.draw_enviroment(window);	
		enviroment.draw_soil(window, player, x, y);
		enviroment.smart_garden(player, x, y, enviroment, window);
	}
}
