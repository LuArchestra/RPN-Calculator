import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        CalculatorView view = new CalculatorView();
        Scene scene = new Scene(view.createUI(), 300, 400);

        stage.setTitle("RPN Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
