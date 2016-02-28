/*
 * The program prints this figure : 
       *
      ***
     *****
    *******
   *********
 */

/**
 *
 * @author usuario
 */
public class DF2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * @param ast es un asterisco.
         * @param esp es un espacio.
         */
    {
        java.util.Scanner read = new java.util.Scanner(System.in);
        int cuenta_as = 1, contador = 1, blan = 1, num = 5;
        String esp = " ";
        String ast = "*";
        while(contador<=num)
        {
            blan = num - contador;
            while(blan>0)
            {
                System.out.print(esp);
                blan--;
            }
            cuenta_as=1;
            while(cuenta_as<(2*contador))
            {
                System.out.print(ast);
                cuenta_as++;
            }
            contador++;
            System.out.println("");
        }        
    }
        // TODO code application logic here
    }
    
}
