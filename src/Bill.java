import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Bill extends POS {
    String customer_name;
    String branch = "Chicago";
    String cashierName = "Jack";
    ArrayList<GroceryItem> billList = new ArrayList<>();
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();

    public void printBill(String customer_name) {
        try {
            writeBillToFile(customer_name, "Item.ser");
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void pre_printBill(String customer_name) {
        try {
            writeBillToFile(customer_name, "bill_one.ser");
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private void writeBillToFile(String customer_name, String fileName) throws IOException, ClassNotFoundException {
        try (FileWriter fileWriter = new FileWriter(customer_name + ".txt");
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream oi = new ObjectInputStream(fileInputStream)) {

            bufferedWriter.write("--------------------------------------------------------\n");
            bufferedWriter.write("💎💎💎💎💎💎💎💎Supermarket💎💎💎💎💎💎💎💎💎💎💎💎\n");
            bufferedWriter.write("--------------------------------------------------------\n");
            bufferedWriter.write(String.format("| Customer:       |" + customer_name + "\n"));
            bufferedWriter.write(String.format("| Branch:         |" + branch + "\n"));
            bufferedWriter.write(String.format("| Date:           |" + dateFormat.format(date) + "\n"));
            bufferedWriter.write(String.format("| Cashier:        |" + cashierName + "\n"));
            bufferedWriter.write("--------------------------------------------------------\n");
            bufferedWriter.write("\n");

            bufferedWriter.write("🌟 Item name    🌟 Item Price\n");
            double total = 0;
            double total_discount = 0;

            while (true) {
                try {
                    GroceryItem item = (GroceryItem) oi.readObject();
                    bufferedWriter.write("  " + item.name + "           " + item.price + "\n");
                    total += item.price;
                    total_discount += item.discount;
                } catch (EOFException ex) {
                    break;
                }
            }

            bufferedWriter.write("--------------------------------------------------------\n");
            bufferedWriter.write("\n");
            bufferedWriter.write(" The total of the bill is :                 " + total + "\n");
            bufferedWriter.write(" The total discount of the bill is :        " + total_discount + "\n");

            bufferedWriter.write("********************************************************\n");
            bufferedWriter.write("               THANK YOU !   COME AGAIN !\n");
            bufferedWriter.write("********************************************************\n");

        }
    }
}