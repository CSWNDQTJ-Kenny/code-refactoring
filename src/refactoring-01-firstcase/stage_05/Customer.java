package stage_05;

import java.util.ArrayList;
import java.util.List;

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
        //double totalAmount = 0; //总金额
        //int frequentRenterPoints = 0; //常客计算积分时使用

        String result = "original.Rental Record for " + getName() + "\n";

        for (int i = 0; i < rentals.size(); i++) {
            Rental each = (Rental) rentals.get(i);

            //frequentRenterPoints += each.getFrequentRenterPoints();

            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
            //totalAmount += each.getCharge();
        }

        /*
            临时变量不是我们喜欢的，如果可以的话，
            我们应该将 totalAmount 和 frequentRenterPoints 这两个 statement() 方法的临时变量替换掉，
            使用 Replace Temp with Query 技巧来替换
         */
//        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
//        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    /**
     * 查询方法，获取总金额
     * @return
     */
    private double getTotalCharge() {
        double result = 0;
        for (int i = 0; i < rentals.size(); i++) {
            Rental each = (Rental) rentals.get(i);
            result +=  each.getCharge();
        }
        return result;
    }

    /**
     * 查询方法，获取总积分
     * @return
     */
    private double getTotalFrequentRenterPoints() {
        int result = 0;
        for (int i = 0; i < rentals.size(); i++) {
            Rental each = (Rental) rentals.get(i);
            result += each.getFrequentRenterPoints();
        }
        return result;
    }


}
