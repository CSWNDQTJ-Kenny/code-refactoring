package stage_07;

/**
 * author  : Kenny
 * time    :
 * description : Rental表示某位顾客租了一部影片,表示行为。
 */
public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }


    /**
     * 如果用户准备修改影片分类规则。
     * 费用计算和常客积分计算也会因此而发生改变。
     * 首当其冲的就是Rental类getCharge中的switch...case...语句。
     *
     * 所以在做修改影片分类规则之前，
     * 回过头来，我们要重构这个 getCharge 发方法啦
     * 对于方法中的 switch 语句，
     * 最好不要在另一个对象的属性基础上运用switch，如果要使用switch，也应当作用于自己的数据上。
     *
     * 所以对于下面的代码，是时候考虑将 getCharge 方法 迁移到 Movie类中了。
     *
     * 这里注意，计算费用涉及到2方面的输入，一个是影片类型（Movie类），一个是租赁时间（Rental类），
     * 就意味着，在计算费用时，无论如何这两个类会有耦合，
     * 要么把 租赁时间（Rental类）传递给 Movie类，要么把 影片类型（Movie类）传递给Rental类，
     * 对于当前case，Movie类的 影片类型 是更容易变换的，因为用户可能更频繁的修改影片分类规则，
     * 这是就要频繁修改 Rental类中的 getCharge 方法，以及其中的 switch case 语句，
     * 所以，这里要考虑将 getCharge 方法 迁移到 Movie类中，并将 租赁时间（Rental类）传递给 Movie类的新方法
     */
    /**
     * 将 amountFor 方法，移动到 Rental 类，并改名 getCharge
     * @return
     */
    public double getCharge() {
        /*//注意double、int类型之间的转换。
        double result = 0;

        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                //优惠力度
                if (getDaysRented() > 2) {
                    result += (getDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                //果然还是新书最贵啊
                result += getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (getDaysRented() > 3) {
                    result += (getDaysRented() - 3) * 1.5;
                }
                break;
        }
        return result;*/

        return movie.getCharge(daysRented);
    }

    /**
     * 搬迁完 getCharge 方法后，同样的 搬迁 getFrequentRenterPoints方法
     */
    /**
     * 使用 Move Method 方法，将 "常客积分计算" 的逻辑迁移到 Rental 类中
     * @return
     */
    public int getFrequentRenterPoints() {
        /*//如果是新书，积分另算
        if (getMovie().getPriceCode() == Movie.NEW_RELEASE && getDaysRented() >= 1) {
            return 2;
        } else {
            return 1;
        }*/

        return movie.getFrequentRenterPoints(daysRented);
    }

}
