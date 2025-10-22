import java.util.Stack;


interface CalculatorModelInterface {
    void add();
    void subtract();
    void multiply();
    void divide();
    void opposite();
    void push();
    Double pop();
    void drop();
    void swap();
    void clear();
}


public class CalculatorModel implements CalculatorModelInterface {

    private double accu;    // Accumulateur : Valeur en cours de traitement (affichée par la calculatrice)

    Stack<Double> memory = new Stack<>(); // Mémoire pile


    public CalculatorModel(){
        this.accu = 0.0;
        this.memory = new Stack<>();
    }

    public double getAccu(){
        return this.accu;
    } 

    public void setAccu(double value){  
        //memory.push(accu);       // Sauvegarde de l'ancienne valeur de l'accumulateur dans la pile
        // le push pollue la pile (0 s'ajoute au premier push...), on el remplacera avec la partie controleur
        this.accu = value;
    }


// Méthode pour dépiler la dernière valeur de la pile et la retourner si elle existe sinon affiche une erreur
    public Double pop(){
        try {
            if (memory.isEmpty()) {
                throw new Exception("Erreur : La pile est vide.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0.0;
        }
        return memory.pop();
    }


    // Definition des opérations de la calculatrice RPN à implémenter
    @Override
    public void add() {
        accu = this.pop() + this.accu;         // Additionne accu avec la dernière valeur en mémoire
    }

    @Override
    public void subtract(){
        accu = this.pop() - accu;
    }

    @Override
    public void multiply(){
        accu = this.pop() * accu;
    }

    @Override
    public void divide(){
        try {
            if (accu == 0.0) {
                throw new Exception("Erreur : Division par zero.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        accu = this.pop() / accu;
    }

    @Override
    public void opposite(){ // Change le signe de la dernière valeur de la pile
        double A = this.pop();
        memory.push(-A);                   // Remet le résultat dans la pile
    }

    @Override
    public void push(){
        memory.push(accu);


    }
    
    @Override
    public void drop(){         // supprime la dernière valeur de la pile
        memory.pop();
    }

    @Override
    public void swap(){         // echange les deux dernières valeurs de la pile
        double last = memory.pop();
        double second = memory.pop();
        memory.push(last);      // second position
        memory.push(second);    // last position

    }

    @Override
    public void clear(){        // vide la pile
        if (this.accu == 0.0) then : {
        memory.clear();
        }
        else {
            this.setAccu(0.0);
        }
    }

}
