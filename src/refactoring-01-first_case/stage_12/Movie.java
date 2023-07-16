package stage_12;

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


    private String title;
    private Price price;

    /**
     * Movie类的构造函数
     *
     * @param title
     * @param priceCode
     */
    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }


    public int getPriceCode() {
        return price.getPriceCode();
    }


    public void setPriceCode(int arg) {
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
     *
     * @param daysRented
     * @return
     */
    public double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }

    /**
     * 现在使用相同的手法对getFrequentRenterPoints进行重构
     * 运用 Replace Conditional with Polymorphism（以多态取代表达式）
     * 但这一次，我们不把迁移到Price类中的getFrequentRenterPoints方法声明为abstract
     * 我们只是在 NewReleasePrice类中覆写这个方法getFrequentRenterPoints
     * 并且将Price类中的方法getFrequentRenterPoints设定为一种默认行为
     */
    /**
     * 获得租赁当前影片而获得的积分
     *
     * @param daysRented
     * @return
     */
    public int getFrequentRenterPoints(int daysRented) {
       /* //如果是新书，另算积分呢
        if (getPriceCode() == Movie.NEW_RELEASE && daysRented >= 1) {
            return 2;
        } else {
            return 1;
        }*/
        return price.getFrequentRenterPoints(daysRented);
    }


}
