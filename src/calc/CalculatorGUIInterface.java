package calc;

import java.util.List;   // <— indispensable

// Cette interface impose la présence de méthodes pour toute interface graphique :
// - change  : modifie une valeur affichée sur la vue
// - affiche : affiche la valeur modifiée

public interface CalculatorGUIInterface {
    void affiche();
    void change(String accu);
    void change(List<Double> memory);
}
