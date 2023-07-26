package S01_duplicated_code.M01_extract_method.stage_final;

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
     * 基于 Case4，在重构的路上再走一步
     * 整理一下变量 初始化 的方式
     */
    public void printOwing(double previousAmount) {
        printBanner();
        double outStanding = getOutStanding(previousAmount * 1.2); // todo Extract Method
        printDetails(outStanding);
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
