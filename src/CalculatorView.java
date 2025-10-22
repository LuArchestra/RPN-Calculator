package calc.view;

import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

interface CalculatorViewInterface {
    void setAccu(String text);
    void setStack(List<Double> stack);
    void setOnDigit(java.util.function.DoubleConsumer handler);
    void setOnOp(java.util.function.Consumer<String> handler);
    void setOnCmd(java.util.function.Consumer<String> handler);
}

public class CalculatorView extends BorderPane implements CalculatorViewInterface {
    private final TextField accu = new TextField();
    private final ListView<Double> stackView = new ListView<>();

    private DoubleConsumer onDigit = d -> {};
    private Consumer<String> onOp = s -> {};
    private Consumer<String> onCmd = s -> {};

    public CalculatorView() {
        setPadding(new Insets(12));

        accu.setEditable(false);
        accu.setPromptText("accu");
        setTop(accu);

        setLeft(stackView);
        BorderPane.setMargin(stackView, new Insets(0, 12, 0, 0));

        GridPane keypad = new GridPane();
        keypad.setHgap(8);
        keypad.setVgap(8);

        String[] digits = { "7","8","9","4","5","6","1","2","3","0",".","ENTER" };
        int row = 0, col = 0;
        for (String d : digits) {
            Button b = new Button(d);
            b.setMaxWidth(Double.MAX_VALUE);
            b.setOnAction(e -> {
                if ("ENTER".equals(d)) onCmd.accept("enter");
                else if (".".equals(d)) onCmd.accept("dot");
                else onDigit.accept(Double.parseDouble(d));
            });
            keypad.add(b, col, row);
            col++; if (col == 3) { col = 0; row++; }
        }

        VBox ops = new VBox(8);
        for (String op : new String[]{"+","-","*","/","±","drop","swap","clear"}) {
            Button b = new Button(op);
            b.setMaxWidth(Double.MAX_VALUE);
            b.setOnAction(e -> {
                if ("±".equals(op)) onOp.accept("opposite");
                else if ("drop".equals(op) || "swap".equals(op) || "clear".equals(op)) onCmd.accept(op);
                else onOp.accept(op);
            });
            ops.getChildren().add(b);
        }

        setCenter(keypad);
        setRight(ops);
    }

    @Override public void setAccu(String text) { accu.setText(text); }
    @Override public void setStack(List<Double> stack) { stackView.getItems().setAll(stack); }

    @Override public void setOnDigit(DoubleConsumer handler) { this.onDigit = handler != null ? handler : d -> {}; }
    @Override public void setOnOp(Consumer<String> handler) { this.onOp = handler != null ? handler : s -> {}; }
    @Override public void setOnCmd(Consumer<String> handler) { this.onCmd = handler != null ? handler : s -> {}; }
}