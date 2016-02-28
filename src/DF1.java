/*
 * This program asks for 3 numbers then,compares them and show the bigger one.
 */
/**
 *
 * @author Juan Carlos Camargo Lizarazo
 */
public class DF1 {
    
    /**
     * @param args guarda los valores de entrada
     */
    public static void main(String[] args) 
    {
    /**
     * @param mayor Es la variable a la que se le asigna el mayor entre a,b y c.
     */
        java.util.Scanner read = new java.util.Scanner(System.in);
        double a, b, c, mayor = 0;
        System.out.println("Ingrese A   ");
        a = read.nextDouble();
        System.out.println("Ingrese B   ");
        b = read.nextDouble();
        System.out.println("Ingrese C   ");
        c = read.nextDouble();
        
        if(a>b)
            if(a>c)
                mayor = a;
            else
                mayor = c;
        else

            if(b>c)
                mayor = b;
            else
                mayor =c;
     
    System.out.print("El mayor es   "+ mayor);  
                       
    }
    
}

    
    
    

