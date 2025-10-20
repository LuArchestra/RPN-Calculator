import java.util.Stack;

// A corriger : Certaines opérations ne donnent pas l'identique à une vraie calculatrice RPN
// Ex : 5 push 3 push multiply donne 15 OK
//      8 push 6 push substract, substract, substract donne autre résultat.

interface CalculatorModelInterface {
    void add();
    void subtract();
    void multiply();
    void divide();
    void opposite();
    void push();
    void pop();
    void drop();
    void swap();
    void clear();
}


public class CalculatorModel implements CalculatorModelInterface {

    private double accu;    // Accumulateur : Valeur en cours de traitement (affichée par la calculatrice)

    public double getAccu(){
        return this.accu;
    } 

    public void setAccu(double value){  
        memory.push(accu);       // Sauvegarde de l'ancienne valeur de l'accumulateur dans la pile
        this.accu = value;
    }

    Stack<Double> memory = new Stack<>(); // Mémoire pile


    // Definition des opérations de la calculatrice RPN à implémenter
    @Override
    public void add() {
        accu = memory.pop() + accu;         // Additionne accu avec la dernière valeur en mémoire
    }

    @Override
    public void subtract(){
        accu = memory.pop() - accu;
    }

    @Override
    public void multiply(){
        accu = memory.pop() * accu;
    }

    @Override
    public void divide(){
        accu += memory.pop() / accu;
    }

    @Override
    public void opposite(){ // Change le signe de la dernière valeur de la pile
        double A = memory.pop();
        memory.push(-A);                   // Remet le résultat dans la pile
    }

    @Override
    public void push(){
        memory.push(accu);

    }
    
    @Override
    public void pop(){
        accu = memory.pop();
        // fixer try catch : si accumulateur vide, erreur
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
        memory.clear();
    }

}
