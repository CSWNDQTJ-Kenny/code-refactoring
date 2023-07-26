package S01_duplicated_code.M01_extract_method.stage_03;

import java.util.List;

/**
 * author  :
 * time    :
 * description :
 */
public class ExtractMethod {

    private String _name;
    private List<Order> _orders;

    public ExtractMethod(String _name, List<Order> _orders) {
        this._name = _name;
        this._orders = _orders;
    }

    /**
     * Extract Method
     * Case3，有临时变量，且临时变量参与操作，但只在被提炼的代码段中使用
     * 这时该临时变量可以被一并提取到新方法中
     */
    public void printOwing() {
//        double outStanding = 0.0; // todo 临时变量被一同提取到新方法 getOutStanding
        printBanner();
        double outStanding = getOutStanding(); // todo  Extract Method
        printDetails(outStanding);
    }

    /**
     * Calculate OutStanding
     *
     * @return
     */
    private double getOutStanding() {
        double result = 0.0;  // todo 原方法中的临时变量 outStanding 被提取进来了
        for (Order order : _orders) {
            result += order.getAmount();
        }
        return result;
    }

    /**
     * Print Details
     *
     * @param outStanding
     */
    private void printDetails(double outStanding) {
        System.out.println("name" + _name);
        System.out.println("amount" + outStanding);
    }

    /**
     * Print Banner
     */
    private static void printBanner() {
        System.out.println("*************************");
        System.out.println("**** Customer Owes ******");
        System.out.println("*************************");
    }

}
