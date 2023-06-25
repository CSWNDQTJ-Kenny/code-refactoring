package stage_03;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

/**
 * author  : Kenny
 * time    :
 * description : Customer表示顾客，有数据和相应的访问函数
 */
public class Customer {
    private String name;
    private List rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }
    public String getName() {
        return name;
    }

    /**
     * 提供一个用于生成详单的函数
     */
    public String statement() {
        double totalAmount = 0; //总金额
        int frequentRenterPoints = 0; //常客计算积分时使用

        String result = "original.Rental Record for " + getName() + "\n";

        /*
            循环中的 thisAmount 变量，有点多余了，
            它接收getCharge方法的结果，之后就没有变化了，
            运用 Replace Temp with Query 方法，将 thisAmount 变量清除。
         */
        for (int i = 0; i < rentals.size(); i++) {
            //double thisAmount = 0; //总金额
            Rental each = (Rental) rentals.get(i);

            //------ 将 amountFor 方法，移动到 Rental 类，留下Rental类的getChange方法
            //thisAmount = each.getCharge();
            //------ 将 amountFor 方法，移动到 Rental 类，留下Rental类的getChange方法

            frequentRenterPoints++;
            //如果是新书，积分另算
            if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getDaysRented() >= 1) {
                frequentRenterPoints++;
            }
            /*
                将之前的 thisAmount 变量替换成 each.getCharge() 方法
             */
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
            totalAmount += each.getCharge();
        }
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }




}
