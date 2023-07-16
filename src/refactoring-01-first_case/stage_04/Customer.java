package stage_04;

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
        double totalAmount = 0; //总金额
        int frequentRenterPoints = 0; //常客计算积分时使用

        String result = "original.Rental Record for " + getName() + "\n";

        /*
            是时候提炼循环中有关 “常客积分计算” 这部分代码了
            也是先使用 Extract Method 方法，提炼出逻辑，
            之后使用 Move Method 方法，将方法迁移到 Rental 类中，
            因为显然 “常客积分计算” 也没有使用Customer的任何信息，使用的均为Rental类的信息
         */
        for (int i = 0; i < rentals.size(); i++) {
            Rental each = (Rental) rentals.get(i);

            /*
                提炼出常客积分计算逻辑代码，
                因为变量frequentRenterPoints的值并没有参与积分计算，
                所以可以不必将变量frequentRenterPoints传入新抽取的方法，
                只需将方法的返回值累加到变量frequentRenterPoints中即可
             */
//            frequentRenterPoints++;
            //如果是新书，积分另算
//            if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getDaysRented() >= 1) {
//                frequentRenterPoints++;
//            }
            frequentRenterPoints += each.getFrequentRenterPoints();

            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
            totalAmount += each.getCharge();
        }
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }

    /**
     * 使用 Extract Method 方法，提炼出计算逻辑，
     * 提炼出的计算”常客积分“的方法，
     * 之后使用 Move Method 方法，将 getFrequentRenterPoints 方法迁移到 Rental 类中，
     * 之后此方法可以删除
     * @param aRental
     * @return
     */
    /*public int getFrequentRenterPoints(Rental aRental) {
        //如果是新书，积分另算
        if (aRental.getMovie().getPriceCode() == Movie.NEW_RELEASE && aRental.getDaysRented() >= 1) {
            return 2;
        } else {
            return 1;
        }
    }*/


}
