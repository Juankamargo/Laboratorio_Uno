/*
 * This program allows to manage the voting to mayor in the towns of Topaiti
 * Max 20 towns and 20 candidates
 */



/**
 *
 * @author Juan Carlos Camargo Lizarazo
 * @version 1.0
 *
 */
public class Problem1 {

    /**
     * @param args 
     */
    public static void main(String[] args) {
        /**
         * @param a Option to decide if to run the program again.
         */
        int a = 1;
        do {
            java.util.Scanner read = new java.util.Scanner(System.in);
            int amountTowns = 21, amountCandidates = 21;
            while (amountTowns > 20) {
                System.out.println("How many towns  have candidates to mayor ?");
                amountTowns = read.nextInt();
                if (amountTowns > 20) {
                    System.out.println("The towns can’t be more than 20");
                }
            }
            while (amountCandidates > 20) {
                System.out.println("How many candidates for each town?");
                amountCandidates = read.nextInt();
                if (amountCandidates > 20) {
                    System.out.println("The candidates can´t be more than 20");
                }
            }
            String voting[][] = new String[amountTowns][amountCandidates + 1];
            for (int i = 0; i < amountTowns; i++) {
                System.out.println("Enter the name of the town" + (i + 1));
                voting[i][0] = read.next();
            }
            for (int i = 0; i < amountTowns; i++) {
                for (int j = 1; j < (amountCandidates + 1); j++) {
                    System.out.println("Enter the cadidate’s name " + (j) + " of the town " + (i + 1));
                    voting[i][j] = read.next();
                }
            }
            int votes[][] = new int[amountTowns][amountCandidates];
            for (int i = 0; i < amountTowns; i++) {
                for (int j = 0; j < amountCandidates; j++) {
                    System.out.println("Enter the votes of " + voting[i][j + 1]);
                    votes[i][j] = read.nextInt();
                }
            }
            System.out.print("\t   |");
            for (int i = 0; i < amountCandidates; i++) {
                System.out.print("Candidate " + (i + 1) + " | ");
            }
            System.out.println(" ");
            for (int i = 0; i < amountTowns; i++) {
                System.out.print("Town " + (i + 1) + "| ");
                for (int j = 0; j < amountCandidates; j++) {
                    System.out.print("  ");
                    System.out.print(votes[i][j] + "       |");
                }
                System.out.println();
            }
            for (int i = 0; i < amountTowns; i++) {
                System.out.println("Town " + (i + 1) + " = " + voting[i][0]);
                for (int j = 0; j < amountCandidates; j++) {
                    System.out.println("\tcandidate " + (j + 1) + " = " + voting[i][j + 1]);
                }
            }
            int totalVotes[] = new int[amountTowns];
            for (int i = 0; i < amountTowns; i++) {
                totalVotes[i] = 0;
                for (int j = 0; j < amountCandidates; j++) {
                    totalVotes[i] = totalVotes[i] + votes[i][j];
                }
            }
            for (int i = 0; i < amountTowns; i++) {
                for (int j = 0; j < amountCandidates; j++) {
                    System.out.println(voting[i][j + 1] + ": " + votes[i][j] + " = " + (((double) votes[i][j] / (double) totalVotes[i]) * 100) + "% of the votes");
                }
            }
            /**
             * @param m Change the votes of the bigger for the scnller
             * @param cn Change a name if there is candidate with more votes
             */
            int m;
            String cn;
            for (int i = 0; i < amountTowns; i++) {
                for (int j = 0; j < amountCandidates; j++) {
                    for (int k = j + 1; k < amountCandidates; k++) {
                        if (votes[i][j] < votes[i][k]) {
                            m = votes[i][j];
                            votes[i][j] = votes[i][k];
                            votes[i][k] = m;
                            cn = voting[i][j+1];
                            voting[i][j+1] = voting[i][k+1];
                            voting[i][k + 1] = cn;
                        }
                    }
                }
                System.out.println("The one with more votes in " + voting[i][0] + " was " + voting[i][1] + " with " + votes[i][0] + " votes");
                if (votes[0][0] < votes[i][0]) {
                    m = votes[i][0];
                }else  {m= votes[0][0];}
                if(i==amountTowns-1){
                    System.out.println("The more voted of all the towns got "+m+" votes");
                }
            }
            int n;
            /**
             * @param n detemines if someone got more than 50% of the voting.
             */
            for (int i = 0; i < amountTowns; i++) {
                n=1;
                for (int j = 0; j < amountCandidates; j++) {
                    if ((((double) votes[i][j] / (double) totalVotes[i]) * 100) > 50) {
                        System.out.println("The winner with more than 50% of the voting in " + voting[i][0] + " is " + voting[i][j + 1]);   
                        n=0;
                    } 
                }
                if(n==1){
                    System.out.println("Th eones who go to next round in  "+voting[i][0]+" are "+voting[i][1]+" y "+voting[i][2]);
                }
            }
            System.out.println("The order of the candidates is :");
            for (int i = 0; i < amountTowns; i++) {
                for (int j = 0; j < amountCandidates+1; j++) {
                    System.out.print(voting[i][j]+"  ; ");
                }
                System.out.println();
            }
            System.out.println("If you wish to run the program again press 1");
            System.out.println("If you want to go out press 2");
            a = read.nextInt();
            
        } while (a == 1);
    }
}
