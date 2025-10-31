package calc;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
    	launch(args); // Appelle la methode "Application.start"
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("ControllerFXML.fxml"));
    		Parent root = loader.load();
    		CalculatorGUI gui = loader.getController();
    		CalculatorModel model = new CalculatorModel();
    		CalculatorController controller = new CalculatorController(model);
    		
    		
    		Scene scene = new Scene(root);
    		
            // 5️⃣ Lie la vue et le contrôleur
            gui.setMvc(controller);
            controller.setView(gui);
    		
    		// Definition du Stage et affichage
    		primaryStage.setScene(scene);
    		primaryStage.show();
    		
    		
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}
