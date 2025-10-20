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
        System.out.println("Memory after push: " + calc.memory);

        calc.add();
        System.out.println("Memory after addition: " + calc.memory);

        calc.multiply();
        System.out.println("Memory after multiplication: " + calc.memory);

        calc.subtract();
        System.out.println("Memory after subtraction: " + calc.memory);
        // La calculatrice ne gère pas correctement la pile
    }
}
