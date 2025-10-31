    // =============================================
    //	Controller Documentation :
    // 		- All the entries have a String type
    
    
    // - Accepted entries for change() :
    
    // [value from GUI] : [Translation in model]
    //		- "\\d+" 	: integers
    //		- "x" 		: multiplication
    //		- "/"		: division
    //		- "+"		: addition
    //		- "-"		: soustraction
    //		- "."		: virgule
    //		- "C"		: clear
    //		- "C/CE"	: cLear
    //			- Pressed one time 	: clear
    //			- Pressed two times : clear all (accu & stack memory)
    //		- "CE"		: clear all (accu & stack memory)
    //		- "swap"	: swap
    //		- "pop"		: pop
	//		- "enter"	: push
    // =============================================


// flagUp : est ce qu'il faut push avant de commencer la nouvelle saisie ?
// isTyping : est ce qu'il faut ecraser la saisie actuelle ? (sans push)
//	- utile pour le push, permets d'afficher la derniere sortie sur l'accu, puis de l'ecraser sans push de nouveau, avec isTyping
// 	- utile meme si dans beaucoup de cas, isTyping et flagUp ont le même resultat (operations...)

package calc;

import java.util.List;

import javafx.event.ActionEvent;

public class CalculatorController implements CalculatorControllerInterface  {
	
	private CalculatorModel model;			// Définis le modèle
	private CalculatorGUIInterface view;	// Définis la vue
	
	// - Variables gestion de l'accu
    private String currentInput = "";		// Saisie actuelle
    private String displayedInput = "";		// Saisie a afficher (permets un bon affichage
    
    // Variables gestion de la Stack
    private double stackData;
    
    // isTyping define if we should override the curent accu, or add the inputs.
    private boolean isTyping; // Gestion 
    private boolean setTyping(boolean bool){
    	return isTyping = bool;
    }
    
	// Setter du controlleur
	// - Permets ...
    public CalculatorController(CalculatorModel model) {
        this.model = model;
    }
	
    // Setter pour la vue
    public void setView(CalculatorGUIInterface view) {
        this.view = view;
    }
    
    
    @Override
	public void change(String accu) {
    	
    	if (accu.matches("\\d+")) {	// renvoie true si 1 ou plusieurs chiffres (integers)
    		if (!model.getFlag()) {
    			model.push();
    			currentInput = accu;
    			model.setFlag(true);
    		} else if (!isTyping){
    			currentInput =  accu;
    			setTyping(true);
    		} else {
    			currentInput += accu;
    		}
    		
    		model.setFlag(true);
    	} else if ("x".equals(accu)) {
    		model.multiply();
    		currentInput = Double.toString(model.getAccu());
    		model.setFlag(false);
    	} else if ("/".equals(accu)) {
    		model.divide();
    		currentInput = Double.toString(model.getAccu());
    		model.setFlag(false);
    	} else if ("+".equals(accu)) {
    		model.add();
    		currentInput = Double.toString(model.getAccu());
    		model.setFlag(false);
    	} else if ("-".equals(accu)) {
    		model.subtract();
    		currentInput = Double.toString(model.getAccu());
    		model.setFlag(false);
    	} else if (".".equals(accu)) {
    		if (".".equals(currentInput)) {
    			currentInput += ""; 			// Si déja ".", ne rien changer
    		} else if (currentInput.isEmpty()) {
    			currentInput = "0."; 			// Si aucune saisie : ajouter "0."
    		} else {
    			currentInput += ".";				// Sinon, ajouter "."
    		} 
			// Pas de soucis si on execute une addition après le ".", c'est simplement le marqueur du double.
    	} else if ("C".equals(accu)) {
			model.clear();
			currentInput = "";
    	} else if ("C/CE".equals(accu)) {
    		if (accu.equals(currentInput)) {
    			model.clear(); // !!!!!!!!!!!!!!!!!!!!!! ajouter clearAll au modele
    		} else {
    			model.clear();
    		}
    		currentInput = Double.toString(model.getAccu());
    	} else if ("CE".equals(accu)) {
    		model.clear();
    		currentInput = Double.toString(model.getAccu());
    	} else if ("enter".equals(accu)) {
    		model.push();
    		currentInput = Double.toString(model.getAccu());
    		setTyping(false);
    	}
		model.setAccu(Double.parseDouble(currentInput)); // Double.parseDouble permets de changer un String en double.
		view.change(currentInput); // Renvoie la saisie a l'interface graphique

		// Rafraichissement de la stack
		List<Double> stackData;
		stackData = model.getStack();
		view.change(stackData);
	}
	
	@Override
	public void change(List<Double> stackData) {
		stackData = model.getStack();
		view.change(stackData);
	}
}
