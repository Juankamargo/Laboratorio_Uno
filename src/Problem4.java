/*
 * This program runs the system of sales of a store.
 */


/**
 *
 * @author Juan Carlos Camargo Lizarazo
 */
public class Problem4 {

    public static void main(String[] args) {
        //Products
        boolean products[] = new boolean[10];
        int code[] = new int[10];
        String description[] = new String[10];
        int price[] = new int[10];
        //Sales
        boolean sales[] = new boolean[10];
        int date[] = new int[10];
        int seller[] = new int[10];
        int product[] = new int[10];
        int quantity[] = new int[10];
        int payment[] = new int[10];
        //Seller
        boolean sellers[] = new boolean[10];
        int id[] = new int[10];
        String name[] = new String[10];
        String lastName[] = new String[10];
        //Date
        int dates[] = new int[10];
        int day[] = new int[10];
        int month[] = new int[10];
        int year[] = new int[10];
        int hour[] = new int[10];

        java.util.Scanner read= new java.util.Scanner(System.in);

        initialize(products, code, description, price, sales, date, seller, product, quantity, payment, sellers, id, name,  lastName);
boolean l=true;
while(l){
    System.out.print("System of sales of a store\n\n");
    System.out.print("1.Register a product\n");
    System.out.print("2.Register a sale\n");
    System.out.print("3.Register a seller\n");
    System.out.print("4.Seller with bigger sales\n");
    System.out.print("5.List of sales by debit\n");
    System.out.print("6.Exit");
int o=read.nextInt();
switch(o){
    case 1:
EnterProducts(products, code, description, price);
    break;
    case 2:
NuevaSale( sales, date, seller, product, quantity, payment, code, id, day, month, year, hour, name, lastName, price);
    break;
    case 3:
EnterSellers(sellers, id, name, lastName);
    break;
    case 4:
BiggerSale( seller, quantity,  product, id, name, lastName, sellers);
    break;
    case 5:
Saledebit( payment, seller, product, quantity);
    break;
    case 6:
l=false;
    break;
    default:
System.out.print("\nInvalid option");
    break;
}
}
    }

    public static void initialize(boolean[] products, int code[], String description[], int price[], boolean sales[], int date[], int seller[], int product[], int quantity[], int payment[], boolean sellers[], int id[], String name[], String lastName[]) {
        for (int n = 0; n < 10; n++) {
            code[n] = 0;
            description[n] = "";
            price[n] = 0;
            date[n] = 0;
            seller[n] = 0;
            product[n] = 0;
            quantity[n] = 0;
            payment[n] = 0;
            id[n] = 0;
            name[n] = "";
            lastName[n] = "";
        }
    }

    public static void EnterProducts(boolean[] products, int[] code, String[] description, int[] price) {
        java.util.Scanner read = new java.util.Scanner(System.in);
        boolean goOn = true;
        int o;
        while (goOn) {

            System.out.print("1.Enter a new product.\n2. Go back\n");
            o = read.nextInt();
            switch (o) {
                case 1:
                    int n = LookForSpace(products);
                    if (n == -1) {
                        System.out.print("Its not posible to enter more products.");
                        break;
                    }
                    System.out.print("\nNew Product\n");
                    System.out.print("\nEnter the code of the product: ");
                    code[n] = read.nextInt();
                    System.out.print("\nEnter a brief description: ");
                    description[n] = read.nextLine();
                    System.out.print("\nEnter the price: ");
                    price[n] = read.nextInt();
                    products[n] = true;
                    System.out.print("\n\nPRODUCT ADDED\n\n");
                    break;
                case 2:
                    goOn = false;
                    break;
                default:
                    System.out.print("\nInvalid option\n");
                    break;
            }
        }
    }

    public static int LookForSpace(boolean[] array) {
        for (int n = 0; n < 10; n++) {
            if (array[n] == false) {
                return n;
            }
        }
        return -1;
    }

    public static void EnterSellers(boolean[] sellers, int[] id, String[] name, String[] lastName) {
        java.util.Scanner read = new java.util.Scanner(System.in);
        boolean goOn = true;
        int o;
        while (goOn) {

            System.out.print("1.Enter a New seller.\n2. Go back\n");
            o = read.nextInt();
            switch (o) {
                case 1:
                    int n = LookForSpace(sellers);
                    if (n == -1) {
                        System.out.print("You can’t enter more sellers.");
                        break;
                    }
                    System.out.print("\nNew Seller\n");
                    System.out.print("\nEnter the id: ");
                    id[n] = read.nextInt();
                    System.out.print("\nEnter the name: ");
                    name[n] = read.nextLine();
                    System.out.print("\nEnter the lastName: ");
                    lastName[n] = read.nextLine();
                    sellers[n] = true;
                    System.out.print("\n\nPRODUCT ADDED\n\n");
                    break;
                case 2:
                    goOn = false;
                    break;
                default:
                    System.out.print("\nInvalid option\n");
                    break;
            }
        }
    }

    public static void NuevaSale(boolean[] sales, int[] date, int[] seller, int[] product, int[] quantity, int[] payment, int[] code, int[] id, int[] day, int[] month, int[] year, int[] hour, String[] name, String[] lastName, int[] price) {
        java.util.Scanner read = new java.util.Scanner(System.in);
        boolean goOn = true;
        int o;
        while (goOn) {

            System.out.print("1.Enter a new sale.\n2. Go back\n");
            o = read.nextInt();
            switch (o) {
                case 1:
                    int n = LookForSpace(sales);
                    if (n == -1) {
                        System.out.print("You cannot enter more sales.");
                        break;
                    }
                    System.out.print("\nNew Sale\n");
                    System.out.print("\nEnter the date: ");
                    System.out.print("\nDay: ");
                    day[n] = read.nextInt();
                    System.out.print("\nMonth: ");
                    month[n] = read.nextInt();
                    System.out.print("\nYear: ");
                    year[n] = read.nextInt();
                    System.out.print("\nHour(hhmm): ");
                    hour[n] = read.nextInt();
                    System.out.print("\nEnter the id of the seller: ");
                    int see = read.nextInt();

                    while (Look_for(id, see) == -1) {
                        System.out.print("\nSeller not registered .\nEnter it again: ");
                        see = read.nextInt();
                    }
                    seller[n] = see;
                    System.out.print("\nEnter the code of the product sold : ");
                    int co = read.nextInt();

                    while (Look_for(code, co) == -1) {
                        System.out.print("\nProduct not registered.\nEnter it again: ");
                        co = read.nextInt();
                    }
                    product[n] = co;
                    System.out.print("\nEnter the quantity: ");
                    quantity[n] = read.nextInt();
                    System.out.print("\nEnter the form of payment:\n0->Cash\n1->Debit\n2->Card\n");
                    payment[n] = read.nextInt();
                    sales[n] = true;
                    System.out.print("\n\nSale Registered\n\n");
                    Ticket(n, sales, date, seller, product, quantity, payment, code, id, day, month, year, hour, name, lastName,  price);
                    break;
                case 2:
                    goOn = false;
                    break;
                default:
                    System.out.print("\nInvalid option\n");
                    break;
            }
        }
    }

    public static int Look_for(int array[], int num) {
        for (int n = 0; n < 10; n++) {
            if (array[n] == num) {
                return n;
            }
        }
        return -1;
    }

    public static void Ticket(int n, boolean[] sales, int[] date, int[] seller, int[] product, int[] quantity, int[] payment, int[] code, int[] id, int[] day, int[] month, int[] year, int[] hour, String[] name, String[] lastName, int[] price) {

        int sellerNum = Look_for(id, seller[n]);
        int productNum = Look_for(code, product[n]);

        System.out.print("\nImportant Store\n\n");
        System.out.print("Date: " + day[n] + "/" + month[n] + "/" + year + " " + (hour[n] / 10) + ":" + (hour[n] % 10) + "\n");
        System.out.print("Seller: " + name[sellerNum] + lastName[sellerNum] + "\n");
        System.out.print("Code\tCant.\tV.Unit.\tTotal");
        System.out.print(product[n] + "\t" + quantity[n] + "\t" + price[productNum] + "\t" + (price[productNum] * quantity[n]));
        System.out.print("Payment: ");
        switch (payment[n]) {
            case 0:
                System.out.print("Cash");
                break;
            case 1:
                System.out.print("Debit");
                break;
            case 2:
                System.out.print("Card");
                break;
        }
    }

public static void BiggerSale(int[] seller,int[] quantity, int[] product, int[] id, String[] name, String[] lastName, boolean[] sellers){
int seent[]=new int[10];
for (int n=0; n<10; n++) {
    if (sellers[n]) {
        seent[n]=quantity[Look_for(seller, id[n])]*product[Look_for(seller, id[n])];
    }else
    {
        seent[n]=0;
    }
}
int bigger=0;
for (int n=0;n<10 ; n++) {
    if(seent[n]>bigger){
        bigger=seent[n];
    }
}

int nbigger=Look_for(seent, bigger);

System.out.print("\n The seller with more sales was " + name[nbigger] + lastName[nbigger] + " with " + bigger +  " sales");

}

public static void Saledebit(int[] payment,int [] seller, int[] product, int[] quantity){
System.out.print("\nPayments with Debit.\n");
  for (int n=0;n<10 ; n++) {
    if(payment[n]==1){
        System.out.print("\nid\tTotal\n");
        System.out.print(seller[n] + "\t" + (product[n]*quantity[n]));
    }
}
}
}
