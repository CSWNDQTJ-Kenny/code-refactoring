package S01_duplicated_code.M01_extract_method.stage_01;

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
     * Case1，无临时变量的情况
     * 这种情况最简单，可以直接抽取
     */
    public void printOwing() {
        double outStanding = 0.0;

        printBanner(); // todo Extract Method

        // Calculate OutStanding
        for (Order order : _orders) {
            outStanding += order.getAmount();
        }

        // Print Details
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
