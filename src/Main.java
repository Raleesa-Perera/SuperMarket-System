import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(" 🍁🍁🍁🍁 Welcome to the SuperMarket 🍁🍁🍁🍁");
        System.out.println();
        System.out.println("Please enter your name :");
        Scanner scanner =new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println();
        System.out.println("🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀");
        System.out.println("  Hi "+name+ " Welcome to the shop");
        System.out.println("🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀");
        System.out.println();
        System.out.println("Are you a New Customer or not?");
        System.out.print("Please Enter( yes or no ) : ");
        POS newPos = new POS();

        String input = scanner.nextLine();
        if(input.equals("yes")){
            Bill newBill = new Bill();
            System.out.println();
            System.out.println("⭐⭐⭐This is the grocery item list⭐⭐⭐");
            System.out.println();
            newPos.showItems();
            System.out.println();
            newPos.buyItems();
            newBill.printBill(name);
            System.out.println("Print the bill successfully");

        }
        if(input.equals("no")){
            System.out.println();
            PreviousBill previousBill = new PreviousBill();
            System.out.println("⭐⭐Please select your bill⭐⭐");
            previousBill.show_pre_bill();
            System.out.print("Enter the bill no: ");
            int pre_bill_num=scanner.nextInt();
            previousBill.select_bill(pre_bill_num);
            Bill newBill = new Bill();
            newBill.pre_printBill(name);
            System.out.println("Print the bill successfully");


        }

    }
}
