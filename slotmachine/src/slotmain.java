import java.util.Random;
import java.util.Scanner;
public class slotmain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Random random = new Random();

        System.out.println("Welcome to the CASINO ROYALE!");
        System.out.println("Slot machine gives you the number value of reels times your bet when you catch all of them same. Good LUCK!");

        System.out.println("Enter your account balance: $");

        int AccountBalance;
        try {
            AccountBalance = Integer.parseInt(scanner.nextLine());

        }
        catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid amount of $");
            scanner.close();
            return;
        }
        Scanner bet = new Scanner(System.in);

        System.out.println("Please choose your bet per every spin you play: $");

        int userBet = bet.nextInt();

        boolean outOfFunds = false;
        while (!outOfFunds) {


            System.out.println("Press Enter to spin. (type 'exit' to leave..)");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")){

                System.out.println("Thanks for playing. Goodbye!");
                break;
            }
            if (userBet > AccountBalance){
                System.out.println("Insufficient funds. Please enter 'exit'.");
                continue;
            }

            AccountBalance -= userBet;

            int reel1 = random.nextInt(9) + 1 ;
            int reel2 = random.nextInt(9) + 1 ;
            int reel3 = random.nextInt(9) + 1 ;

            System.out.println("SPINS// =|||-" + reel1 + "-|-" + reel2 + "-|-" + reel3 + "-|||=\n" );
            int multiplier = 1;
            if (reel1==reel2 && reel2 == reel3  ) {
                multiplier = reel1*3;
            }

            if (multiplier > 1 ) {
                System.out.println("!!YOU WON!!");
                System.out.println("!!YOU WON!!");
                System.out.println("!!YOU WON!!\n");
                int winnings = userBet*multiplier;
                AccountBalance += winnings;
                System.out.println("You won " + winnings + "$$$\n");

            }
            else {
                System.out.println("LOSE!! Try Again.\n");
            }

            System.out.println("Current Account Balance: $" + AccountBalance + "\n");

            if (AccountBalance <= 0 ) {

                outOfFunds = true;
            }

        }
        if (outOfFunds) {

            System.out.println("You are out of funds. Come back later!");
        }
        scanner.close();
    }
}
