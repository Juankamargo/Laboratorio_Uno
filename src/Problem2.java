/*
 * This program allows an airline to manage the sales of their seats.
 */


/**
 * @author Juan Carlos Camargo Lizarazo
 */
public class Problem2 {

    /**
     * @param args 
     */
    public static void main(String[] args) {
        int x;
        int cheapSeat[][] = new int[7][6];
        String names_a[][] = new String[7][6];
        int ids_a[][]=new int [7][6];
        int ejecutiveSeat[][]=new int [2][4];
        String names_b[][]=new String [2][4];
        int ids_b[][] = new int[2][4];
        for (int i = 0; i < 7; i++) {
           for(int j=0;j<6;j++){
               cheapSeat[i][j]=0;
           }
        }
        for(int i=0;i<2;i++){
            for(int j=0;j<4;j++){
                ejecutiveSeat[i][j]=0;
            }
        }
        do {
            int option;
            String name;
            int id;
            System.out.println("What do you want to do?");
            System.out.println("1. Asign seat	 ");
            System.out.println("2. Cancel reservation");
            System.out.println("3. Generate reports");
            java.util.Scanner read = new java.util.Scanner(System.in);
            option = read.nextInt();
            switch (option) {
                case 1: {
                    int see=0;
                    int option2;
                    System.out.println("Name:");
                    name = read.next();
                    System.out.println("Id:");
                    id = read.nextInt();
                    System.out.println("Wants: ");
                    System.out.println("1.Ejecutive class Seat\n2.Economic Class");
                    option2 = read.nextInt();
                    if (option2 == 1) {//clase ejecutiveSeat
                        int location;
                        System.out.println("1.Window \n2.Hall?");
                        System.out.println("Window|1|2||Hall||3|4|Window");
                        location = read.nextInt();
                        if (location == 1) {//location=Window
                            for(int i=0;i<2;i++){
                                for(int j=0;j<4;j++){
                                    if(j==0||j==3){
                                        if(ejecutiveSeat[i][j]==0){
                                            ejecutiveSeat[i][j]=1;
                                            names_b[i][j]=name;
                                            ids_b[i][j]=id;
                                            j=4;
                                            i=2;
                                            see=1;
                                            System.out.println("Your purchase was sucessful!!");
                                        }
                                    }
                                }
                            }
                            if(see==0){
                                System.out.println("There are no seats avalible in the window");
                            }
                        } else if (location == 2) {//location Hall
                            for(int i=0;i<2;i++){
                                for(int j=0;j<4;j++){
                                    if(j==1||j==2){
                                        if(ejecutiveSeat[i][j]==0){
                                            ejecutiveSeat[i][j]=1;
                                            names_b[i][j]=name;
                                            ids_b[i][j]=id;
                                            j=4;
                                            i=2;
                                            see=1;
                                            System.out.println("Your purchase was sucessful!!");                                        }
                                    }
                                }
                            }
                            if(see==0){
                                System.out.println("There are no seats avalible in the Hall");
                            }
                        }
                    } else if (option2 == 2) {//clase cheapSeat
                        int option3;
                        System.out.println("1.Hall\n2.middle\n3.Window");
                        option3=read.nextInt();
                        switch(option3){
                            case 1:{
                                for(int i=0;i<7;i++){
                                    for(int j=0;j<6;j++){
                                        if(j==2||j==3){
                                            if(cheapSeat[i][j]==0){
                                                cheapSeat[i][j]=1;
                                                names_a[i][j]=name;
                                                ids_a[i][j]=id;
                                                j=6;
                                                i=7;
                                                see=1;
                                                System.out.println("Your purchase was sucessful!!");
                                            }
                                        }
                                    }
                                }
                                if(see==0){
                                    System.out.println("There are no seats avalible in the hall");
                                }
                                break;
                            }
                            case 2:{
                                for(int i=0;i<7;i++){
                                    for(int j=0;j<6;j++){
                                        if(j==1||j==4){
                                            if(cheapSeat[i][j]==0){
                                                cheapSeat[i][j]=1;
                                                names_a[i][j]=name;
                                                ids_a[i][j]=id;
                                                j=6;
                                                i=7;
                                                see=1;
                                                System.out.println("Your purchase was sucessful!!");
                                            }
                                        }
                                    }
                                }
                                if(see==0){
                                    System.out.println("There are no seats avalible in the middle");
                                }
                                break;
                            }
                            case 3:{
                                for(int i=0;i<7;i++){
                                    for(int j=0;j<6;j++){
                                        if(j==0||j==5){
                                            if(cheapSeat[i][j]==0){
                                                cheapSeat[i][j]=1;
                                                names_a[i][j]=name;
                                                ids_a[i][j]=id;
                                                j=6;
                                                i=7;
                                                see=1;
                                                System.out.println("Your purchase was sucessful!!");
                                            }
                                        }
                                    }
                                }
                                if(see==0){
                                    System.out.println("There are no seats avalible in the Window");
                                }
                                break;
                            }
                        }
                    }
                break;                    
                }
                case 2: {
                    int cancel;
                    System.out.println("Id:");
                    cancel=read.nextInt();
                    for(int i=0;i<7;i++){
                        for(int j=0;j<6;j++){
                            if(ids_a[i][j]==cancel){
                                cheapSeat[i][j]=0;
                                ids_a[i][j]=0;
                                names_a[i][j]=null;
                                System.out.println("Cancelled");
                            }
                        }
                    }
                    for(int i=0;i<2;i++){
                        for(int j=0;j<4;j++){
                            if(ids_b[i][j]==cancel){
                                ejecutiveSeat[i][j]=0;
                                ids_b[i][j]=0;
                                names_b[i][j]=null;
                                System.out.println("Cancelled");
                            }
                        }
                    }
                    break;
                }
                case 3: {
                    int occupied=0;
                    for(int i=0;i<2;i++){
                        for(int j=0;j<4;j++){
                            if(ejecutiveSeat[i][j]==1){
                                occupied++;
                            }
                        }
                    }
                    int lost;
                    int seatNumber;
                    System.out.println("EjecutiveSeats occupied:"+occupied);
                    System.out.println("Enter the id you want to look for :");
                    lost=read.nextInt();
                    for(int i=0;i<2;i++){
                        for(int j=0;j<4;j++){
                            if(ids_b[i][j]==lost){
                                if(i==0){
                                    seatNumber=j+1;
                                    System.out.println("The id is located in the seat "+seatNumber);
                                }
                                else{
                                    seatNumber=4+j+1;
                                    System.out.println("The id is located in the seat"+seatNumber);
                                }
                            }
                        }
                    }
                    for(int i=0;i<7;i++){
                        for(int j=0;j<6;j++){
                            if(ids_a[i][j]==lost){
                                seatNumber=i+i+i+i+i+i+j+9;
                                System.out.println("The id is located in the seat "+seatNumber);
                            }
                        }
                    }
                    for(int i=0;i<7;i++){
                        for(int j=0;j<6;j++){
                            if(cheapSeat[i][j]==0){
                                seatNumber=i+i+i+i+i+i+j+9;
                                System.out.println("Is located in the cheapSeat "+seatNumber);
                                j=6;
                                i=7;
                            }
                        }
                    }
                    int ncheapSeat=0;
                    for(int i=0;i<7;i++){
                        for(int j=0;j<6;j++){
                            if(cheapSeat[i][j]==0){
                                if(j==0||j==5){
                                    ncheapSeat++;
                                }
                            }
                        }
                    }
                    System.out.println("The number os seats avalible in the window in the cheap class:"+ncheapSeat);
                    //function of names
                    for(int i =0;i<7;i++){
                        for(int j=0;j<6;j++){
                            for(int k=j+1;k<6;k++){
                                if(names_a[i][k].equalsIgnoreCase(names_a[i][k])){                                    
                                        System.out.println("There are 2 : "+names_a[i][j]);                                    
                                }else{}
                            }   
                        }
                    }
                    break;
                }
            }
            System.out.println("Dou you want to make something else?");
            System.out.println("1. yes\n2. no");
            x = read.nextInt();
        } while (x == 1);
    }
}
