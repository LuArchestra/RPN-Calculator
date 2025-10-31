package calc;

import java.util.List;

// Cette interface impose la présence de ces methodes pour tout Controleur (MVC) :
// - change : appelle a la modification d'une valeur dans le modèle (coeur de la calculatrice)

public interface CalculatorControllerInterface {
    void change(String accu);
    void change(List<Double> memory);
}

