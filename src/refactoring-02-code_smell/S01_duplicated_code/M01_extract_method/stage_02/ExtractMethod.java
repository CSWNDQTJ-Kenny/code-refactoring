package S01_duplicated_code.M01_extract_method.stage_02;

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
     * Case2，含有临时变量的情况
     * 但被提炼的代码段只是读取临时变量的值，并不修改它们
     * 这时可以将这些临时变量作为 参数，传给被提炼的方法
     */
    public void printOwing() {
        double outStanding = 0.0;

        printBanner();

        // Calculate OutStanding
        for (Order order : _orders) {
            outStanding += order.getAmount();
        }


        printDetails(outStanding); // todo  Extract Method
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
