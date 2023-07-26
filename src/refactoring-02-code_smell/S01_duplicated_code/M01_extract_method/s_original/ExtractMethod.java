package S01_duplicated_code.M01_extract_method.s_original;

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
     * 这几乎是最常用的重构手法，
     * 当一个方法过长或者方法中的代码需要一些注释才能让人理解用途的时候，
     * 我们就可以将这段代码放到一个独立的方法中，
     * 同时给这个方法起一个良好的名字（良好是指方法名称与方法本体之间的语义距离尽量小）
     * 原因：
     * 1、每个方法的粒度会很小，进而被复用的概率会增大
     * 2、这会使顶层方法读起来仿佛一系列注释
     * 3、如果方法粒度细，那么方法的覆写和修改也会容易一些
     *
     * 原始范例
     * Case1，无临时变量的情况
     * Case2，含有临时变量的情况
     * Case3，有临时变量，且临时变量参与操作，但只在被提炼的代码段中使用
     * Case4，有临时变量，且临时变量参与操作，还在原先方法的其他地方使用
     */
    public void printOwing() {
        double outStanding = 0.0;

        // Print Banner
        System.out.println("*************************");
        System.out.println("**** Customer Owes ******");
        System.out.println("*************************");

        // Calculate OutStanding
        for (Order order : _orders) {
            outStanding += order.getAmount();
        }

        // Print Details
        System.out.println("name" + _name);
        System.out.println("amount" + outStanding);
    }

}
