package original;

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

}
