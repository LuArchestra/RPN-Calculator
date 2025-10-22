package app.controller;

import java.util.List;
import app.contracts.CalculatorModelInterface;
import app.contracts.CalculatorViewInterface;

/**
 * Contrôleur MVC (Presenter) — indépendant de JavaFX/FXML.
 * Orchestration : reçoit des intentions, appelle le modèle,
 * puis met à jour la vue via CalculatorViewInterface.
 */
public class CalculatorController {

    private final CalculatorModelInterface model;
    private final CalculatorViewInterface view;

    // Etat d’édition côté UI (pas de métier ici)
    private boolean editingNumber = false;     // on saisit un nombre (concaténation)
    private boolean stackLiftEnabled = false;  // si tu émules le "stack lift" HP (optionnel)

    public CalculatorController(CalculatorModelInterface model, CalculatorViewInterface view) {
        this.model = model;
        this.view  = view;
        // First paint
        pushStateToView();
    }

    /* =========================
       Intentions utilisateur
       ========================= */

    /** L'utilisateur tape un chiffre (ou "."). */
    public void onDigit(String token) {
        // Validation légère
        if (token == null || token.isEmpty()) return;

        // Edition d’un nouveau nombre
        if (!editingNumber) {
            // (optionnel) stackLiftEnabled : lève la pile au 1er chiffre après un résultat
            // if (stackLiftEnabled) { model.push(); stackLiftEnabled = false; } // si tu veux émuler HP
            replaceAccuFromToken(token);
            editingNumber = true;
        } else {
            appendTokenToAccu(token);
        }
        view.changeAccu(format(model.getAccu()));
    }

    /** ENTER / PUSH */
    public void onPush() {
        model.push();
        editingNumber = false;
        // stackLiftEnabled = false; // comportement HP : ENTER désactive la levée
        pushStateToView();
    }

    public void onPop() {
        safeRun(() -> model.pop());
    }

    public void onDrop() {
        safeRun(() -> model.drop());
    }

    public void onSwap() {
        safeRun(() -> model.swap());
    }

    public void onClear() {
        model.clear();
        editingNumber = false;
        pushStateToView();
    }

    public void onOpposite() {
        model.opposite();
        editingNumber = true; // on continue d’éditer ce X négatif
        pushStateToView();
    }

    /* ===== Opérations binaires ===== */

    public void onAdd()       { binaryOp(() -> model.add()); }
    public void onSubtract()  { binaryOp(() -> model.subtract()); }
    public void onMultiply()  { binaryOp(() -> model.multiply()); }
    public void onDivide()    { binaryOp(() -> model.divide()); } // gérer /0 côté modèle

    /* =========================
       Helpers d’orchestration
       ========================= */

    private void binaryOp(Runnable op) {
        safeRun(op);
        editingNumber = false;      // résultat figé
        // stackLiftEnabled = true; // prochain premier chiffre lèvera la pile (si tu émules HP)
        pushStateToView();
    }

    private void safeRun(Runnable op) {
        try {
            op.run();
            pushStateToView();
        } catch (RuntimeException ex) {
            // Gestion d’erreurs "métier" : pile vide, division par zéro, etc.
            // Stratégie simple : ne change pas l’état visuel, ou affiche un message via la vue
            // (tu peux étendre l'interface Vue avec showError(String) si besoin)
        }
    }

    /** Envoie l’état courant à la vue. */
    private void pushStateToView() {
        view.changeAccu(format(model.getAccu()));
        List<Double> stack = model.snapshotStack();
        view.changeStack(stack);
        // view.affiche(); // si tu veux un refresh global en plus
    }

    /* =========================
       Edition d’accu (UI only)
       ========================= */

    /** Remplace l'accu par le "premier token" (ex: "1" ou ".") selon ta politique. */
    private void replaceAccuFromToken(String token) {
        if (",".equals(token)) token = "."; // si tu veux tolérer la virgule
        if (".".equals(token)) {
            // démarrer à "0." si on tape d'abord le point
            setAccuFromString("0.");
        } else {
            setAccuFromString(token);
        }
    }

    /** Concatène le token au texte courant de l’accu. */
    private void appendTokenToAccu(String token) {
        String current = format(model.getAccu());
        if (",".equals(token)) token = ".";
        // Empêcher deux points décimaux
        if (".".equals(token) && current.contains(".")) return;

        String next = current.equals("0") && !token.equals(".") ? token : current + token;
        setAccuFromString(next);
    }

    /** Parse sécurisé : met à jour l’accu du modèle à partir d’un String. */
    private void setAccuFromString(String s) {
        try {
            double v = Double.parseDouble(s);
            model.setAccu(v);
        } catch (NumberFormatException ignored) {
            // on ignore le token invalide sans casser l'édition
        }
    }

    /** Formatage d’affichage (nombre de décimales, trim, locale...). */
    private String format(double v) {
        // Pour commencer : représentation brute
        // Tu peux remplacer par DecimalFormat si tu veux 4/6 décimales fixes, etc.
        return Double.toString(v);
    }
}
