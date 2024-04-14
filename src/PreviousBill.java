import java.io.*;
import java.util.Scanner;

public class PreviousBill {
    //POS pre_bill;
    //Bill pre_bill2;
    public PreviousBill(){}
    public void show_pre_bill(){
        System.out.println("  Bill no.    Customer Name");
        System.out.println("    1             Jack     ");
        System.out.println("    2             Anne     ");
    }
    public void select_bill(int bill_num) throws Exception {
        if(bill_num==1){
            bill_one();
        }
        if(bill_num==2){
            bill_two();
        }
    }
    public void showDetails(){

    }
    public static void bill_one() throws Exception{
        try{
            FileOutputStream file_bill_one = new FileOutputStream("bill_one.ser");
            ObjectOutputStream os_bill_one = new ObjectOutputStream(file_bill_one);

            GroceryItem groceryItem_one_one = new GroceryItem(7);
            os_bill_one.writeObject(groceryItem_one_one);
            GroceryItem groceryItem_one_two = new GroceryItem(8);
            os_bill_one.writeObject(groceryItem_one_two);
            GroceryItem groceryItem_one_three = new GroceryItem(9);
            os_bill_one.writeObject(groceryItem_one_three);

            //----------------------------------------------------------------------------------------

            System.out.println("⭐⭐⭐This is the grocery item list⭐⭐⭐");
            System.out.println();
            POS.showItems();
            System.out.println();
            System.out.println("♦️ Please add items to your previous bill");

            System.out.println("♦️ If you want to stop buying items please enter -1");
            System.out.println();
            boolean stop= true;
            while(stop){
                System.out.println("🌟️Please enter the item code : ");
                Scanner scanner = new Scanner(System.in);
                int value = scanner.nextInt();
                if(value>10){
                    System.out.println("You entered a wrong number ❌");
                }
                else if(value==-1){
                    stop=false;
                }
                else{
                    GroceryItem groceryItem = new GroceryItem(value);
                    os_bill_one.writeObject(groceryItem);
                    System.out.println("Added "+groceryItem.name+" to the list successfully ✔️");

                    System.out.println();
                }
            }
            os_bill_one.close();
        }
        catch(ItemCodeNotFound ex){
            ex.printStackTrace();
        }
        //----------------------------------------------------------------------------------------
    }
    public static void bill_two()throws Exception{
        try{
            FileOutputStream file_bill_two = new FileOutputStream("bill_two.ser");
            ObjectOutputStream os_bill_two = new ObjectOutputStream(file_bill_two);
            GroceryItem groceryItem_two_one = new GroceryItem(4);
            os_bill_two.writeObject(groceryItem_two_one);
            GroceryItem groceryItem_two_two = new GroceryItem(5);
            os_bill_two.writeObject(groceryItem_two_two);


            System.out.println("⭐⭐⭐This is the grocery item list⭐⭐⭐");
            System.out.println();
            POS.showItems();
            System.out.println();

            System.out.println("♦️ If you want to stop buying items please enter -1");
            System.out.println();
            boolean stop= true;
            while(stop){
                System.out.println("🌟️Please enter the item code : ");
                Scanner scanner = new Scanner(System.in);
                int value = scanner.nextInt();
                if(value>3){
                    System.out.println("You entered a wrong number ❌");
                }
                else if(value==-1){
                    stop=false;
                }
                else{
                    GroceryItem groceryItem = new GroceryItem(value);
                    os_bill_two.writeObject(groceryItem);
                    System.out.println("Added "+groceryItem.name+" to the list successfully ✔️");

                    System.out.println();
                }
            }
            os_bill_two.close();
        }
        catch(ItemCodeNotFound ex){
            ex.printStackTrace();
        }
    }

}

