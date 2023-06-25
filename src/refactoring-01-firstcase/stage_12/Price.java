package stage_12;

public abstract class Price {

    public abstract int getPriceCode();

    /**
     * 现在就可以对 Price类中的 getCharge方法使用
     * Replace Conditional with Polymorphism（以多态取代表达式）
     * 一次取出 switch 的一个 case 分支，在对应的类建立覆盖函数
     * 最后将Price类中的 getCharge 方法声明为abstract类型
     */
    /**
     * 获取租赁当前影片所需要的费用
     *
     * @param daysRented
     * @return
     */
    public abstract double getCharge(int daysRented);

    /**
     * 运用 Move Method 手法
     * 将 Movie类中的 getFrequentRenterPoints方法搬迁Price类中
     * 并将新影片的积分计算逻辑抽出来，下沉到 NewReleasePrice类的覆写方法中
     */
    /**
     * 获得租赁当前影片而获得的积分
     *
     * @param daysRented
     * @return
     */
    public int getFrequentRenterPoints(int daysRented) {
       /*//如果是新书，另算积分呢
        if (getPriceCode() == Movie.NEW_RELEASE && daysRented >= 1) {
            return 2;
        } else {
            return 1;
        }*/
        return 1;
    }

}
