package stage_10;

public abstract class Price {

    public abstract   int getPriceCode();

    /**
     * 获取租赁当前影片所需要的费用
     * @param daysRented
     * @return
     */
    public double getCharge(int daysRented) {
        double result = 0;
        switch (getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (daysRented > 2) { //优惠力度
                    result += (daysRented - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += daysRented * 3; //果然还是新书最贵
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (daysRented > 3) {
                    result += (daysRented - 3) * 1.5;
                }
                break;
        }
        return result;
    }

}
