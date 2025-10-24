public class Main {
    public static void main(String[] args) throws Exception {
        CalculatorModel calc = new CalculatorModel();

        calc.setAccu(2.0);
        System.out.println("Initial accu: " + calc.getAccu());
        System.out.println("[Pushing accu to memory]");
        
        calc.push();
        System.out.println("Memory after push: " + calc.memory);


        System.out.println("\n-----------------[Test Addition] -------------------");
        calc.setAccu(3.0);
        System.out.println("New accu: " + calc.getAccu());

        calc.add(); // On appuie sur le bouton "+"
        System.out.println("Accu after addition: " + calc.getAccu());
        System.out.println("Memory after addition: " + calc.memory);


        System.out.println("\n-----------------[Test Multiplication] -------------------");
        calc.setAccu(8);
        System.out.println("New accu: " + calc.getAccu());

        calc.multiply();
        System.out.println("Accu after multiplication "+ calc.getAccu());
        System.out.println("Memory after multiplication: " + calc.memory);


        System.out.println("\n----------[Test push plusieurs valeurs en memoire] ------------");
        calc.setAccu(2);
        System.out.println("New accu: " + calc.getAccu());
        calc.push();
        System.out.println("[Accu pushed]");
        System.out.println("Memory after push: " + calc.memory +"<-- Last value (displayed on the screen)");


        System.out.println("\n-----------------[Test Soustraction] -------------------");
        calc.setAccu(5);
        System.out.println("New accu: " + calc.getAccu());
        calc.subtract();
        System.out.println("Accu after subtraction: " + calc.getAccu());
        System.out.println("Memory after subtraction: " + calc.memory);


        System.out.println("\n----------[Test 2 soustractions consecutives] ------------");
        calc.clear();
        System.out.println("Memory after clear: " + calc.memory);

        // Essaye avec une vraie calculatrice RPN : 
        calc.setAccu(4);
        System.out.println("New accu: " + calc.getAccu());
        calc.push();
        System.out.println("Memory after push: " + calc.memory);
        calc.subtract();
        System.out.println("Accu after subtraction: " + calc.getAccu());


        System.out.println("\n----------[Test Soustraction puis multiplication] ------------");
        calc.clear();
        System.out.println("Memory after clear: " + calc.memory);

        calc.setAccu(6);
        System.out.println("New accu: " + calc.getAccu());
        calc.push();
        System.out.println("Memory after push: " + calc.memory);

        calc.setAccu(8);
        System.out.println("New accu: " + calc.getAccu());
        calc.push();
        System.out.println("Memory after push: " + calc.memory);

        calc.setAccu(3);
        System.out.println("New accu: " + calc.getAccu());
        calc.push();
        System.out.println("New accu: " + calc.getAccu());
        System.out.println("Memory after push: " + calc.memory);

        calc.add();
        System.out.println("New accu after addition: " + calc.getAccu());
        System.out.println("Memory after addition: " + calc.memory);

        calc.multiply();
        System.out.println("New accu after multiplication: " + calc.getAccu());
        System.out.println("Memory after multiplication: " + calc.memory);

        calc.subtract();
        System.out.println("New accu after subtraction: " + calc.getAccu());
        System.out.println("Memory after subtraction: " + calc.memory);

        calc.subtract();
        System.out.println("New accu after subtraction: " + calc.getAccu());
        System.out.println("Memory after subtraction: " + calc.memory);

        calc.subtract();
        System.out.println("New accu after subtraction: " + calc.getAccu());
        System.out.println("Memory after subtraction: " + calc.memory);

        calc.subtract();
        System.out.println("New accu after subtraction: " + calc.getAccu());
        System.out.println("Memory after subtraction: " + calc.memory);

        calc.subtract();
        System.out.println("New accu after subtraction: " + calc.getAccu());
        System.out.println("Memory after subtraction: " + calc.memory);

System.out.println("\n----------[Test Division par 0] ------------");
        calc.clear();
        System.out.println("Memory after clear: " + calc.memory);
        calc.setAccu(5);
        System.out.println("New accu: " + calc.getAccu());
        calc.push();
        System.out.println("Memory after push: " + calc.memory);
        calc.setAccu(0);
        System.out.println("New accu: " + calc.getAccu());
        calc.divide();
        System.out.println("Accu after division: " + calc.getAccu());
        System.out.println("Memory after division: " + calc.memory);

System.out.println("\n----------[Test Polynome] ------------");
        
        double[] coeffs = {2.0, -3.0, 0.0, 5.0, 0.0}; // Représente le polynôme 5X^3 - 3X + 2        
        Polynome p = new Polynome(coeffs);
        System.out.print("Polynome:") ;
        System.out.print(p.toString());
        
        double[] coeffs2 = {0.0, 0.0, 0.0}; // Représente le polynôme 0
        Polynome p2 = new Polynome(coeffs2);
        System.out.print("\nPolynome:") ;
        System.out.print(p2.toString());
        
        double[] coeffs3 = {-1.2, 0.0, -4.0, -3.0}; // Représente le polynôme -3X^3 - 4X^2 - 1.2
        Polynome p3 = new Polynome(coeffs3);
        System.out.print("Polynome:") ;
        System.out.print(p3.toString());
        
        double[] coeffs4 = {-10.0, 42.0, 0.0 ,0.0, 8.0,-3.0,0.0,-2.5,-7.2,0.0}; // Représente le polynôme -7.2X^8 - 2.5X^7 - 3X^5 + 8X^4 + 42X -10        
        Polynome p4 = new Polynome(coeffs4);
        System.out.print("\nPolynome:") ;
        System.out.print(p4.toString());
        
        double[] coeffs5 = {0.0,2.0}; // Représente le polynôme 2.0X
        Polynome p5 = new Polynome(coeffs5);
        System.out.print("\nPolynome:") ;
        System.out.print(p5.toString());

        }
}
