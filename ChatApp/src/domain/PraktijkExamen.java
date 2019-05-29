package domain;

public class PraktijkExamen {

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    private String date;
    private String title;
    private String year;


    public PraktijkExamen(String date, String title, String year){
        setDate(date);
        setTitle(title);
        setYear(year);
    }
}
