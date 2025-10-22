package ui;

import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import controller.CalculatorController;

public class CalculatorViewController {

    @FXML private TextField display;
    @FXML private ListView<Double> stackList;

    private CalculatorController presenter;

    public void setPresenter(CalculatorController presenter) {
        this.presenter = presenter;
    }

    // Méthodes appelées depuis CalculatorView
    public void setDisplayText(String value) {
        display.setText(value);
    }

    public void setStack(List<Double> values) {
        stackList.getItems().setAll(values);
    }

    public void refreshAll() {
        // (optionnel : rafraîchit display + pile en une fois)
    }

    // Handlers liés au FXML
    @FXML
    private void onDigit0() { presenter.onDigit("0"); }

    @FXML
    private void onAdd() { presenter.onAdd(); }

    // etc.
}
