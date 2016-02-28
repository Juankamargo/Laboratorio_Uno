/*
 * This programs allows the user to know whem passing from a function to another and when the main is over.
 */

/**
 *
 * @author Juan Carlos Camargo Lizarazo
 */
public class DF3 {
    /**
     * @param args permite leer variables
     */
    public static void main(String[] args) {
        System.out.println("Primera funcion en main");
        func1();
        func2();
        System.out.println("se termina el main");
    }
    public static void func1(){
        System.out.println("Segunda funcion");
    }
    public static void func2(){
        System.out.println("Tercera funcion");
    }    
}


