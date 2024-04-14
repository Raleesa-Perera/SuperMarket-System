import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class POS{
    ArrayList<GroceryItem> newArraylist = new ArrayList<>();

    public static void showItems(){
        System.out.println(" Item code |     Name                |   Price");
        System.out.println("-----------------------------------------------");
        System.out.println("     1     |   Flour (1 kg)     🍚  |   250.0");
        System.out.println("     2     |   Potatoes (1 kg)  🥔  |   300.0");
        System.out.println("     3     |   Tomatoes (1 kg)  🍅  |   350.0");
        System.out.println("     4     |   Bread            🍞  |   150.0");
        System.out.println("     5     |   Apples           🍎  |   500.0");
        System.out.println("     6     |   Chocolates       🍫  |   275.0");
        System.out.println("     7     |   Broccoli         🥦  |   600.0");
        System.out.println("     8     |   Cheese           🧀  |   1000.0");
        System.out.println("     9     |   Eggs             🥚  |   670.0");
        System.out.println("     10    |   Cookies          🍪  |   550.0");



    }
    public void buyItems() throws ItemCodeNotFound {
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("Item.ser");
            ObjectOutputStream os = new ObjectOutputStream(fileOutputStream);
            System.out.println("♦️ If you want to stop buying items please enter -1");
            System.out.println();
            //int value = 0;
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
                    newArraylist.add(groceryItem);
                    os.writeObject(groceryItem);
                    System.out.println("Added "+groceryItem.name+" to the list successfully ✔️");

                    System.out.println();
                }
            }
            os.close();

        }
        catch(ItemCodeNotFound ex){
            throw new ItemCodeNotFound("It is not found");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void ShowListItems(){
        for(GroceryItem v: newArraylist){
            System.out.println(v+"  "+v.name);
        }
    }
}
