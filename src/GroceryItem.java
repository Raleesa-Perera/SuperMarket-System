// grocery items create in here
import java.io.Serializable;

public class GroceryItem implements Serializable {
    int itemCode;
    String name;
    double price;
    double discount;
    double weight;
    String date_manu;
    String date_exp;
    String manu_name;
    public GroceryItem(){

    }

    public GroceryItem(int itemCode)throws ItemCodeNotFound{
        switch(itemCode){
            case 1:
                this.itemCode=itemCode;
                this.name="Flour";
                this.price=250.0;
                this.discount=this.price*0.1;
                this.weight=1;
                this.date_exp="2022.10.11";
                this.date_manu="2022.10.02";
                this.manu_name="Dadly";
                break;
            case 2:
                this.itemCode=itemCode;
                this.name="Potatoes";
                this.price=300.0;
                this.discount=this.price*0.15;
                this.weight=1;
                this.date_exp="2022.10.11";
                this.date_manu="2022.10.02";
                this.manu_name="Mr.Potato";
                break;
            case 3:
                this.itemCode=itemCode;
                this.name="Tomatoes";
                this.price=350.0;
                this.discount=this.price*0.05;
                this.weight=1;
                this.date_exp="2022.10.11";
                this.date_manu="2022.10.02";
                this.manu_name="Nuwara";
                break;
            case 4:
                this.itemCode=itemCode;
                this.name="Bread";
                this.price=150.0;
                this.discount=this.price*0.15;
                this.weight=1;
                this.date_exp="2022.10.11";
                this.date_manu="2022.10.02";
                this.manu_name="Wasana";
                break;
            case 5:
                this.itemCode=itemCode;
                this.name="Apples";
                this.price=500.0;
                this.discount=this.price*0.05;
                this.weight=1;
                this.date_exp="2022.10.11";
                this.date_manu="2022.10.02";
                this.manu_name="Chinese";
                break;
            case 6:
                this.itemCode=itemCode;
                this.name="Chocolates";
                this.price=275.0;
                this.discount=this.price*0.1;
                this.weight=1;
                this.date_exp="2022.10.11";
                this.date_manu="2022.10.02";
                this.manu_name="Mars";
                break;
            case 7:
                this.itemCode=itemCode;
                this.name="Broccoli";
                this.price=600.0;
                this.discount=this.price*0.25;
                this.weight=1;
                this.date_exp="2022.10.11";
                this.date_manu="2022.10.02";
                this.manu_name="Broccoli Sons";
                break;
            case 8:
                this.itemCode=itemCode;
                this.name="Cheese";
                this.price=1000.0;
                this.discount=this.price*0.05;
                this.weight=1;
                this.date_exp="2022.10.11";
                this.date_manu="2022.10.02";
                this.manu_name="HappyCow";
                break;
            case 9:
                this.itemCode=itemCode;
                this.name="Eggs";
                this.price=670.0;
                this.discount=this.price*0.15;
                this.weight=1;
                this.date_exp="2022.10.11";
                this.date_manu="2022.10.02";
                this.manu_name="EggsEggs";
                break;
            case 10:
                this.itemCode=itemCode;
                this.name="Cookies";
                this.price=550.0;
                this.discount=this.price*0.2;
                this.weight=1;
                this.date_exp="2022.10.11";
                this.date_manu="2022.10.02";
                this.manu_name="LittleLion";
                break;
            default:
                throw new ItemCodeNotFound("It is not found in here");
        }
    }
}
