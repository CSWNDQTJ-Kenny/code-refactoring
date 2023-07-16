package stage_02;

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
            此时发现，amountFor 方法使用了来自Rental类的信息，
            但是并没没有使用来自Customer类的任何信息，
            所以要考虑将amountFor方法移动到Rental类中，
            运用 Move Method 手段，先将代码copy到Rental类，然后调整代码使之适应新家（去掉一些参数，变更函数名称）
         */
        for (int i = 0; i < rentals.size(); i++) {
            double thisAmount = 0; //总金额
            Rental each = (Rental) rentals.get(i);

            //------ 将 amountFor 方法，移动到 Rental 类，留下Rental类的getChange方法
            thisAmount = each.getCharge();
            //------ 将 amountFor 方法，移动到 Rental 类，留下Rental类的getChange方法

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
     * 如果这个旧函数被很多其他类使用，而目前又不想修改其他类的接口，则可以保留这个旧函数
     * @param aRental
     * @return
     */
    private double amountFor(Rental aRental) {
        return aRental.getCharge();
    }


}
