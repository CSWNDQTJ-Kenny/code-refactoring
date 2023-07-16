package S01_duplicated_code.M03_form_template_method.stage_01.price;

/**
 * 总结：引入 State设计模式 话费了我们不少力气，值得吗？
 * 这么做的收益是：如果我们想要修改任何与价格有关的行为，或者添加新的定价标准，或是加入其它取决于价格的行为
 * 程序的修改会变得容易很多，
 * 对于目前这个量级的程序，任何功能或特性上的修改可能都不合适，
 * 但如果在一个更复杂的系统中，有十多个关于价格的函数，程序修改的难易程度就会有很大差别。
 */
public abstract class Price {

    public abstract int getPriceCode();


    /**
     * 获取租赁当前影片所需要的费用
     *
     * @param daysRented
     * @return
     */
    public abstract double getCharge(int daysRented);


    /**
     * 获得租赁当前影片而获得的积分
     *
     * @param daysRented
     * @return
     */
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }

}
