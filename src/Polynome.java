import java.util.ArrayList;

public class Polynome {
    public int degree;
    public ArrayList<Double> coefficients;

/**
 * @param coefficients
 */
public Polynome(double[] coefficientsEntrée){
    this.coefficients = new ArrayList<>();
    for (double coeff : coefficientsEntrée) {
        this.coefficients.add(coeff);
    }
    this.degree = coefficients.size() - 1;
    while (coefficients.size() > 1 && coefficients.get(coefficients.size() - 1) == 0)
    {
        this.coefficients.remove(coefficients.size() - 1);
        this.degree--;
    }
        if (this.degree == 0 && this.coefficients.get(0).equals(0.0)) {
            this.degree = -1;
            
        }
    }
    public int getDegree() {
        return degree;
    }

    public ArrayList<Double> getCoefficients() {
        return coefficients;
    }

    @Override
    public String toString() {
        if (this.degree == -1) {
                System.out.println(" 0");
            }
        else {
        if (this.degree != 0 ) {
            System.out.print(" " + coefficients.get(this.degree));
            System.out.print("X");
            if (this.degree != 1) {
                System.out.print("^" + this.degree);
            }
            
        }
        for (int i = this.degree - 1; i >= 0; i--) {
            if (coefficients.get(i) > 0) {
                System.out.print(" + " + coefficients.get(i));
                if (i != 0 ) {
                    System.out.print("X");
                        if (i != 1) {
                    System.out.print("^" + i);
                    }
                }
            }
            else {
                if (coefficients.get(i) < 0) {
                    System.out.print(" - " + (-coefficients.get(i)));
                    if (i != 0 ) {
                        System.out.print("X");
                            if (i != 1) {
                        System.out.print("^" + i);
                        }
                    }
                }
            }
        }
        }
        System.out.println();
        return "";
    }
}
