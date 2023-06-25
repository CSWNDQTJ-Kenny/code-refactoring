package stage_08;

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
    private int priceCode;

    /**
     * Movie 类中只有构造函数需要改动了
     * 使用 Self Encapsulate Field（自封装字段）
     * @param title
     * @param priceCode
     */
    public Movie(String title, int priceCode) {
        this.title = title;
//        this.priceCode = priceCode;
        setPriceCode(priceCode);
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }


    /**
     * 这里为了更好的控制因为电影种类变动而带来的代码改动上的成本
     * 我们可以使用以下方法：
     * Replace type code with state/strategy（以state/strategy取代类型码）
     * 即，运用 State设计模式 在Movie类下面，创建一个Price抽象类，并创建Price类的三个子类分别代表儿童影片价格、新片间隔、普通影片价格
     * 这样我们就可以在Price类的对象内进行子类化的动作getCharge了,
     * 这时候即便未来新增加了更多类型的影片，也可以通过增加新的Price子类，并且改变Movie类中的Price属性来解决
     *
     *
     * 但在此之前，我们需要使用 Self Encapsulate Field（自封装字段）方法，
     * 确保所有对 Movie类的 priceCode属性的访问都通过 get/set 方法。
     */
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
