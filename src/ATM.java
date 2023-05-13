import java.util.Scanner;

public class ATM {

    public static final int RON_500 = 500;
    public static final int RON_200 = 200;
    public static final int RON_100 = 100;
    public static final int RON_50 = 50;
    public static final int RON_20 = 20;
    public static final int RON_10 = 10;
    public static final int RON_5 = 5;
    public static int balance = (10 * RON_500) + (10 * RON_200) + (10 * RON_100) + (10 * RON_50) + (10 * RON_20) + (10 * RON_10) + (10 * RON_5);

    public static final int PIN_CARD = 1234;

    public static void main(String[] args) {
        //type of user card
//        User user = new User.UserBuilder().basicCard(Card.BASIC).build();
        User user = new User.UserBuilder().goldCard(Card.GOLD).build();
        Scanner scanner = new Scanner(System.in);
        System.out.println("ATM");
        System.out.print("Enter the pin number: ");
        int count = 0;
        while (count < 3) {
            count++;
            int pin = scanner.nextInt();
            if (pin != PIN_CARD) {
                if (count == 3) {
                    System.out.println("Maximum number of retries reached!");
                    System.exit(0);
                }
                System.out.print("Invalid pin number, try again: ");
            } else {
                break;
            }
        }

        while (true) {
            System.out.println("Press 1 to Display the balance");
            System.out.println("Press 2 to Start a withdrawal");
            System.out.println("Press 3 to Eject the card");
            System.out.print("Choose any operation you want to perform: ");
            //take a choice from user
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    //displaying balance of the user
                    if (user.getBasic() == Card.BASIC) {
                        System.out.println("Balance: " + user.getBasic().getValue());
                        System.out.println("");
                    } else {
                        System.out.println("Balance: " + user.getGold().getValue());
                        System.out.println("");
                    }
                    break;
                case 2:
                    System.out.print("Enter the amount you want to withdrawn: ");
                    int withdraw = scanner.nextInt();
                    if (user.getBasic() == Card.BASIC) {
                        //get the withdrawl amount from user
                        if (withdraw > user.getBasic().getValue()) {
                            System.out.println("Insufficient Funds");
                        } else if (withdraw > balance) {
                            System.out.println("The machine does not have enough funds, please enter a smaller amount: " + balance);
                            System.out.println("The machine balance is : " + balance);
                        } else {
                            System.out.println("Please collect your money: " + withdraw);
                            balance = balance - withdraw;
                            int card_amount = user.getBasic().getValue();
                            int remaining_amount = card_amount - withdraw;
                            user.setBasic(Card.BASIC.EXIT_CODE1(remaining_amount));
                            System.out.println("Remaining amount: " + user.getBasic().getValue());
                        }
                    } else {
                        if (withdraw > user.getGold().getValue()) {
                            System.out.println("Insufficient Funds");
                        } else if (withdraw > balance) {
                            System.out.println("The machine does not have enough funds, please enter a smaller amount: " + balance);
                            System.out.println("The machine balance is : " + balance);
                        } else {
                            System.out.println("Please collect your money: " + withdraw);
                            balance = balance - withdraw;
                            int card_amount = user.getGold().getValue();
                            int remaining_amount = card_amount - withdraw;
                            user.setGold(Card.GOLD.EXIT_CODE2(remaining_amount));
                            System.out.println("Remaining amount: " + user.getGold().getValue());
                        }
                    }
                    System.out.println("");
                    break;
                case 3:

                    //exit from the menu
                    System.out.println("Card ejected, please take your card.");
                    System.exit(0);

            }
        }
    }
}
