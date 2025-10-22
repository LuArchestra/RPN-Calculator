import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Voir l'étape 2 pour l'emplacement du FXML
        Parent root = FXMLLoader.load(getClass().getResource("/calculator.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("RPN Calculator");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
