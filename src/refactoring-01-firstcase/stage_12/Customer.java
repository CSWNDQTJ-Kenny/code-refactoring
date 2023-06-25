package stage_12;

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
        String result = "original.Rental Record for " + getName() + "\n";
        for (int i = 0; i < rentals.size(); i++) {
            Rental each = (Rental) rentals.get(i);
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    /**
     * 打印 HTML 格式的详单
     *
     * @return
     */
    public String htmlStatement() {
        //客户详单的 HTML 文件
        String result = "<H1>Rental Record<EM> for " + getName() + "\n";
        for (int i = 0; i < rentals.size(); i++) {
            Rental each = (Rental) rentals.get(i);
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }
        result += "<P> You owe <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
        result += "On this rental You earned <EM>" + String.valueOf(getTotalFrequentRenterPoints()) + "</EM> frequent renter points";
        return result;
    }


    /**
     * 查询方法，获取总金额
     *
     * @return
     */
    private double getTotalCharge() {
        double result = 0;
        for (int i = 0; i < rentals.size(); i++) {
            Rental each = (Rental) rentals.get(i);
            result += each.getCharge();
        }
        return result;
    }

    /**
     * 查询方法，获取总积分
     *
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
