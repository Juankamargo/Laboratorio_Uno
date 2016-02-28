/*
 * This program manages a parking lot.
 */


/**
 *
 * @author Juan Carlos Camargo Lizarazo
 */
public class Problem3 {
public static void main(String[] args) {
        java.util.Scanner read = new java.util.Scanner(System.in);
        boolean parkingLot[] = new boolean[87];
        int entry[] = new int[87];
        int earnings = 0;
        boolean l = true;
        initialize(parkingLot, entry, earnings);
        while (l) {
            System.out.print("Welcome to the parking system \n1.IEnter\n2.Retire\n3.Check parkingLot\n4.Free spaces\n5.Earnings\n6.Exit\n");
            int d;
            d = read.nextInt();
            switch (d) {
                case 1:
                    System.out.print("\n\n");
                    enter(parkingLot, entry);
                    System.out.print("\n\n");
                    break;
                case 2:
                    System.out.print("\n\n");
                    earnings += departure(parkingLot, entry);
                    System.out.print("\n\n");
                    break;
                case 3:
                    System.out.print("\n\n");
                    checkparkingLot(parkingLot);
                    System.out.print("\n\n");
                    break;
                case 4:
                    freeParkinglots(parkingLot);
                    System.out.print("\n\n");
                    break;
                case 5:
                    System.out.print("\n\n");
                    earning(earnings);
                    System.out.print("\n\n");
                    break;
                case 6:
                    l = false;
                    break;
                default:
                    System.out.print("Invalid option");
                    break;
            }

        }
    }

    public static void initialize(boolean parkingLot[], int entry[], int earnings) {
        earnings = 0;
        for (int n = 0; n < 87; n++) {
            parkingLot[n] = false;
            entry[n] = 0;
        }
    }

    public static boolean full(boolean parkingLot[]) {
        for (int n = 0; n < 87; n++) {
            if (!parkingLot[n]) {
                return false;
            }
        }
        return true;
    }

    public static void enter(boolean parkingLot[], int entry[]) {
        int position;
        int time = 0;
        java.util.Scanner read = new java.util.Scanner(System.in);
        System.out.println("Schedule of attention: from 6 to 20\nEnter the hour of the entry:");
        time = read.nextInt();
        while (time < 6 || time > 20) {
            System.out.print("There is no attetion at that hour, try again: ");
            time = read.nextInt();
        }

        boolean done = false;
        for (position = 0; position < 87; position++) {
            if (parkingLot[position] == false) {
                done = true;
                break;
            }
        }
        if (done) {
            parkingLot[position] = true;
            entry[position] = time;
            System.out.println("    Sucessful entry:    ParkingLot No. " + (position+1)  + "     hour of entry:" + time);
        } else {
            System.out.println("The entry was not sucessful.\n");
            if (full(parkingLot)) {
                System.out.println("The parking is full.");
            }
        }
    }

    public static int departure(boolean parkingLot[], int entry[]) {
        int number;
        int time;
        java.util.Scanner read = new java.util.Scanner(System.in);
        System.out.println("Enter the number of the parking lot where the car is");
        number = read.nextInt()-1;

        if (parkingLot[number] == true) {

            System.out.println("Enter the time of departure  ");
            time = read.nextInt();

            while (time < entry[number]) {
                System.out.println("Invalid hour, try again:");
                time = read.nextInt();
            }
            int total = time - entry[number];
            System.out.println("Time of entry: " + entry[number] + "\nHour of departure: " + time);
            System.out.println("\n Carge " + total + " Hours");
            entry[number]=0;
            parkingLot[number]=false;
            return total;
        } else {
            System.out.println("There is no car in that parking lot.");
            return 0;
        }

    }

    public static void earning(int earnings) {
        System.out.println("It’s been charged " + earnings + " Hours");
    }

    public static void freeParkinglots(boolean parkingLot[]) {
        int free = 0;
        for (int n = 0; n < 87; n++) {
            if (parkingLot[n] == false) {
                free++;
            }
        }
        System.out.println("There  " + free + " freeParkinglots");
    }

    public static void checkparkingLot(boolean parkingLot[]) {
        System.out.print("/--/--/--/--/--/--/--/--/--/--/--/--/--/--/--/--/--/--/--/--/");
        int number = 0;
        System.out.print("\n");
        for (int n = 0; n < 87; n++) {
            System.out.print("|");
            if (n + 1 < 10 && !parkingLot[n]) {
                System.out.print(" ");
            }
            if (parkingLot[n]) {
                System.out.print("**");
            } else {
                System.out.print(n + 1);
            }
            if ((n + 1) % 20 == 0 && n != 0) {
                System.out.print("|\n/--/--/--/--/--/--/--/--/--/--/--/--/--/--/--/--/--/--/--/--/\n");
            }
        }
        System.out.print("|\n");
        System.out.print("+--+--+--+--+--+--+--+");
    }
}
