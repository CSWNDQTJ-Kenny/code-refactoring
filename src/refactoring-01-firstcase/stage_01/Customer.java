package stage_01;

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
        double totalAmount = 0;  //总金额
        int frequentRenterPoints = 0; //常客计算积分时使用

        String result = "original.Rental Record for " + getName() + "\n";

        /*
            找出方法中的逻辑泥团 switch 语句后，
            运用 Extract Method 方法，将逻辑泥团抽取成新方法
         */
        for (int i = 0; i < rentals.size(); i++) {
            double thisAmount = 0; //总金额
            Rental each = (Rental) rentals.get(i);

            //------ 抽取总金额计算方法
            thisAmount = amountFor(each);
            //------ 抽取总金额计算方法

            frequentRenterPoints++;
            //如果是新书，积分另算
            if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getDaysRented() >= 1) {
                frequentRenterPoints++;
            }
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }

    /**
     * 抽取总金额计算方法
     * 之前代表每个Rental类对象的each变量名称不好，将each换成aRental
     * @param aRental
     * @return
     */
    private double amountFor(Rental aRental) {
        //注意double、int类型之间的转换。
        double result = 0;
        switch (aRental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                //优惠力度
                if (aRental.getDaysRented() > 2) {
                    result += (aRental.getDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                //果然还是新书最贵啊
                result += aRental.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (aRental.getDaysRented() > 3) {
                    result += (aRental.getDaysRented() - 3) * 1.5;
                }
                break;
        }
        return result;
    }
}
