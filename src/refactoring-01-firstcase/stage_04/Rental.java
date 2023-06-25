package stage_04;

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
     * 将 amountFor 方法，移动到 Rental 类，并改名 getCharge
     * @return
     */
    public double getCharge() {
        //注意double、int类型之间的转换。
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
        return result;
    }

    /**
     * 使用 Move Method 方法，将 "常客积分计算" 的逻辑迁移到 Rental 类中
     * @return
     */
    public int getFrequentRenterPoints() {
        //如果是新书，积分另算
        if (getMovie().getPriceCode() == Movie.NEW_RELEASE && getDaysRented() >= 1) {
            return 2;
        } else {
            return 1;
        }
    }

}
