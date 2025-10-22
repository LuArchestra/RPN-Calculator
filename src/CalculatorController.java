

interface CalculatorControlerInterface {
    change(String accu);
    change(List<Double> stackData);
}
public class CalculatorController {
    public void onDigit(String digit) {
        // Logique pour gérer l'entrée d'un chiffre
    }
    public void onAdd() {
        // Logique pour gérer l'addition
    }
    public void setView(CalculatorViewInterface view) {
        // Lier la vue au contrôleur
    }
    public void updateDisplay(String value) {
        // Met à jour l'affichage
    }
    public void updateStack(List<double> stackData) {
        // Met à jour les données de la pile
    }
    public void refreshAll() {
        // Rafraîchit l'affichage et la pile
    }
}
