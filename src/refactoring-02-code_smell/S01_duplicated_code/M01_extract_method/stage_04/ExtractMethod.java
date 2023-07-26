package S01_duplicated_code.M01_extract_method.stage_04;

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
     * Case4，有临时变量，且临时变量参与操作，还在原先方法的其他地方使用
     * 这里临时变量在原先的方法中，在被提炼的新方法的 前后 都用到了该临时变量
     * 这时，需要将该临时变量作为 参数 传递给被提炼的代码段；
     * 同时，将该临时变量作为新方法的 返回值，返回给原先的函数
     */
    public void printOwing(double previousAmount) {
        double outStanding = previousAmount * 1.2; // todo outStanding 在被提炼的方法 getOutStanding 前面 用到了
        printBanner();
        outStanding = getOutStanding(outStanding); // todo Extract Method
        printDetails(outStanding); // todo outStanding 在被提炼的方法 getOutStanding 后面 也用到了
    }

    /**
     * Calculate OutStanding
     *
     * @return
     */
    private double getOutStanding(double initialValue) {
        double result = initialValue;
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
