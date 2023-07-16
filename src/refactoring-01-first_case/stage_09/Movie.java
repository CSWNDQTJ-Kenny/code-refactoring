package stage_09;

/**
 * author  : Kenny
 * time    :
 * description : Movie记录类型、价格和标题等，单纯数据类。
 */
public class Movie {

    //三种片类型
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    /**
     * 现在需要用Price类替换int类型的属性priceCode
     * 之后与 priceCode 有关的 get、set 方法都需要修改
     */
    private String title;
//    private int priceCode;
    private Price price;

    /**
     * Movie类的构造函数
     * @param title
     * @param priceCode
     */
    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    /**
     * 与 priceCode 有关的 get 方法也需要修改
     */
    public int getPriceCode() {
//        return priceCode;
        return price.getPriceCode();
    }

    /**
     * 与 priceCode 有关的 set 方法也需要修改
     */
    public void setPriceCode(int arg) {
//        this.priceCode = priceCode;
        switch (arg) {
            case REGULAR:
                price = new RegularPrice();
                break;
            case CHILDRENS:
                price = new ChildrenPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code !");
        }
    }

    public String getTitle() {
        return title;
    }



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

    /**
     * 获得租赁当前影片而获得的积分
     * @param daysRented
     * @return
     */
    public int getFrequentRenterPoints(int daysRented) {
        //如果是新书，另算积分呢
        if (getPriceCode() == Movie.NEW_RELEASE && daysRented >= 1) {
            return 2;
        } else {
            return 1;
        }
    }


}
