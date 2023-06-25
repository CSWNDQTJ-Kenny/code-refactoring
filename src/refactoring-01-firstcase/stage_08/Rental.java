package stage_08;

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
     * 获取租赁当前影片所需要的费用
     * @return
     */
    public double getCharge() {
        return movie.getCharge(daysRented);
    }


    /**
     * 获得租赁当前影片而获得的积分
     * @return
     */
    public int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(daysRented);
    }

}
