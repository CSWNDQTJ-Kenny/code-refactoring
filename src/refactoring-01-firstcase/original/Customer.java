package original;

import java.lang.reflect.Array;
import java.util.*;

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
        //总金额
        double totalAmount = 0;
        //常客计算积分时使用
        int frequentRenterPoints = 0;

        String result = "original.Rental Record for " + getName() + "\n";

        for (int i = 0; i < rentals.size(); i++) {
            //每个租赁金额
            double thisAmount = 0;
            Rental each = (Rental) rentals.get(i);

            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    //优惠力度
                    if (each.getDaysRented() > 2) {
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    //果然还是新书最贵啊
                    thisAmount += each.getDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3) {
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    }
                    break;
            }

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
        现在需要添加一个新功能：
        打印 HTML 格式的详单
     */

}
