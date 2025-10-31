package calc;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorGUI implements CalculatorGUIInterface {
	
	@FXML
	private TextField txtAccu;
	
	@FXML
	private TextField txtStack1;
	
	@FXML
	private TextField txtStack2;
	
	@FXML
	private TextField txtStack3;
	
	// Definition du Controller MVC (définit lui même le modèle pour faire le lien)
    private CalculatorController mvcController;
    // Setter du MVC, a utiliser dans main.
    public void setMvc(CalculatorController mvcController) {
        this.mvcController = mvcController;
    }
    
    @FXML	// Actions réalisées en temps réel sur l'interface
    public void change(ActionEvent e) {
        String value = ((Button)e.getSource()).getText();  // "1", "2", ".", etc.
        mvcController.change(value); // On appelle la methode change du controlleur
    }
    
    @Override
    public void affiche() {
    	System.out.println("aww");
    }
    
	@Override
	public void change(String accu) {
		txtAccu.setText("");
		txtAccu.setText(accu);
	}
	
	@Override
	public void change(List<Double> stackData) {				// Liste en entrée, renvoie ses différentes couches sur l'écran.
		if (stackData.size() > 0) {
			txtStack1.setText(Double.toString(stackData.get(0)));
		} else {
			txtStack1.setText("0.0");
		}
		if (stackData.size() > 1) {
			txtStack2.setText(Double.toString(stackData.get(1)));
		} else {
			txtStack2.setText("0.0");
		}
		if (stackData.size() > 2) {
			txtStack3.setText(Double.toString(stackData.get(2)));
		} else
			txtStack3.setText("0.0");
	}
	// Le List Double en entée est important, pour pouvoir en tirer les différentes valeurs
	
}
    
