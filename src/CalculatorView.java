import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

interface CalculatorViewInterface {
    public void affiche'();
    public void change(accu: String);
    public void change(stackData: List<double>)
}

public class button {
    String label;
    Runnable action;

    public button(String label, Runnable action) {
        this.label = label;
        this.action = action;
    }


}
public class CalculatorView {
    private TextField display = new TextField();

    public VBox createUI() {
        display.setEditable(false);
        display.setStyle("-fx-font-size: 20; -fx-alignment: center-right;");

        GridPane grid = new GridPane();
        grid.setHgap(8);
        grid.setVgap(8);
        grid.setPadding(new Insets(10));

        String[] buttons = {"7","8","9","+","4","5","6","-","1","2","3","*","0",".","=","/"};

        int col = 0, row = 0;
        for (String b : buttons) {
            Button btn = new Button(b);
            btn.setPrefSize(60, 60);
            grid.add(btn, col, row);
            col++;
            if (col == 4) { col = 0; row++; }
        }

        VBox root = new VBox(10, display, grid);
        root.setPadding(new Insets(10));
        return root;
    }

    public TextField getDisplay() { return display; }
}
