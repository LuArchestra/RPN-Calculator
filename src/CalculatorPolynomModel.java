import java.util.Stack;
import java.lang.reflect.Array;


public class CalculatorPolynomModel implements Calculator {
    // Implementation spécifique pour les polynômes
    private Polynom accu;    // Accumulateur : Valeur en cours de traitement (affichée par la calculatrice)
    Stack<Polynom> memory = new Stack<Polynom>(); // Mémoire pile


    public CalculatorPolynomModel(){
        this.accu = new Polynom(new double[]{0.0});
        this.memory = new Stack<>();
    }
    /**
     * @return the accu
     */
    public Polynom getAccu(){
        return this.accu;
    }
    public void setAccu(Polynom value) {
        this.accu = value;
    }
    /**
     * Méthode pour dépiler la dernière valeur de la pile et la retourner si elle existe sinon affiche une erreur
     */
    
    public Polynom pop(){
        try {
            if (memory.isEmpty()) {
                throw new Exception("Erreur : La pile est vide.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Polynom(new double[]{0.0});
        }
        return memory.pop();
    }
    @Override
    public void add() {
        Polynom p2 = this.pop();
        Polynom p1 = this.accu;
        double[] resultCoeffs = new double[Math.max(p1.getDegree(), p2.getDegree()) + 1];
        for (int i = 0; i <= Math.max(p1.getDegree(), p2.getDegree()); i++) {
            double coeff1 = (i <= p1.getDegree()) ? p1.getCoefficients().get(i) : 0.0;
            double coeff2 = (i <= p2.getDegree()) ? p2.getCoefficients().get(i) : 0.0;
            resultCoeffs[i] = coeff1 + coeff2;
            this.accu = new Polynom(resultCoeffs);
        }
        Polynom result  = new Polynom(resultCoeffs);
        this.accu = result;
    }

    @Override
    public void subtract(){
        Polynom p2 = this.pop();
        Polynom p1 = this.accu;
        double[] resultCoeffs = new double[Math.max(p1.getDegree(), p2.getDegree()) + 1];
        for (int i = 0; i <= Math.max(p1.getDegree(), p2.getDegree()); i++) {
            double coeff1 = (i <= p1.getDegree()) ? p1.getCoefficients().get(i) : 0.0;
            double coeff2 = (i <= p2.getDegree()) ? p2.getCoefficients().get(i) : 0.0;
            resultCoeffs[i] = coeff1 - coeff2;
            this.accu = new Polynom(resultCoeffs);
        }
        Polynom result  = new Polynom(resultCoeffs);
        this.accu = result;
    }

    @Override
    public void multiply(){
        Polynom p2 = this.pop();
        Polynom p1 = this.accu;
        double[] resultCoeffs = new double[p1.getDegree() + p2.getDegree() + 1];
        for (int i = 0; i <= p1.getDegree(); i++) {
            for (int j = 0; j <= p2.getDegree(); j++) {
                resultCoeffs[i + j] += p1.getCoefficients().get(i) * p2.getCoefficients().get(j);
            }
        }

        Polynom result  = new Polynom(resultCoeffs);
        this.accu = result;
        
    }

    @Override
    public void divide(){
        System.out .println("Erreur : Division de polynômes non implémentée.");
    }

    @Override
    public void opposite(){
        Polynom p = this.accu;
        double[] resultCoeffs = new double[p.getDegree() + 1];
        for (int i = 0; i <= p.getDegree(); i++) {
            resultCoeffs[i] = -p.getCoefficients().get(i);
        }
        Polynom result  = new Polynom(resultCoeffs);
        this.accu = result;
    }

    @Override
    public void push(){
        memory.push(accu);
    }

    @Override
    public void drop(){
        this.pop();
    }

    @Override
    public void swap(){
        Polynom first = this.pop();
        Polynom second = this.pop();
        memory.push(first);
        memory.push(second);
    }

    @Override
    public void clear(){
        memory.clear();
        this.accu = new Polynom(new double[]{0.0});
    }
}