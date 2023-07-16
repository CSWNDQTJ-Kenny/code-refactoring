package stage_11;

public abstract class Price {

    public abstract   int getPriceCode();

    /**
     * 现在就可以对 Price类中的 getCharge方法使用
     * Replace Conditional with Polymorphism（以多态取代表达式）
     * 一次取出 switch 的一个 case 分支，在对应的类建立覆盖函数
     * 最后将Price类中的 getCharge 方法声明为abstract类型
     */
    /**
     * 获取租赁当前影片所需要的费用
     * @param daysRented
     * @return
     */
    public abstract double getCharge(int daysRented);
//    public abstract double getCharge(int daysRented) {
//        double result = 0;
//        switch (getPriceCode()) {
//            case Movie.REGULAR:
//                result += 2;
//                if (daysRented > 2) { //优惠力度
//                    result += (daysRented - 2) * 1.5;
//                }
//                break;
//            case Movie.NEW_RELEASE:
//                result += daysRented * 3; //果然还是新书最贵
//                break;
//            case Movie.CHILDRENS:
//                result += 1.5;
//                if (daysRented > 3) {
//                    result += (daysRented - 3) * 1.5;
//                }
//                break;
//        }
//        return result;
//    }

}
