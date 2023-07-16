package S01_duplicated_code.M03_form_template_method.original;

import java.util.ArrayList;
import java.util.List;

/**
 * author  : Kenny
 * time    :
 * description : Customer表示顾客，有数据和相应的访问方法
 */

/**
 *
 * 新需求：需要再添加一种报表打印的方式。。。
 * 这时候我们就要回头review下 “打印报表” 的方法啦
 *
 *
 * 我们使用 Form Template Method 手段
 * 对之前遗留的 statement 和 htmlStatement 方法重构
 * 它们两个方法的具体操作不完全相同，
 * 但是，它们的执行顺序是一样的
 * 所以，我们可以将执行操作的顺序提升到超类，并借助多态保证各操作仍得以保持差异性
 * 这样的方法 就是 Template Method（模板方法）
 *
 * 但是在使用模板方法之前，需要对两个方法做一些整理，使它们成为同一个超类下的子方法
 * 可以运用方法对象，针对“打印报表”创建一个独立的策略继承体系
 * 
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
