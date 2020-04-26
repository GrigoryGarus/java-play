import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Contact {
    private String fullName;
    private Date dob;
    private Integer countOfProjects;
    private Float rating;
    private String comments;



    public Contact(String fullName, Date dob, Integer countOfProjects, Float rating, String comments) {
        this.fullName = fullName;
        this.dob = dob;
        this.countOfProjects = countOfProjects;
        this.rating = rating;
        this.comments = comments;
    }

    //TODO: тут вы должны создать конструктор который конвертирует строковые значения полученые в ходе разбора входных данных.
//Иванов Иван Иванович; 18.06.1983; 34; 6.45; \"Работал над проектами: \"\"АБС\"\"; \"\"КВД\"\"\"
//Необходимо распарсить String в соотвествующие типы

    @Override
    public String toString() {
        return "Contact{" +
                "fullName='" + fullName + '\'' +
                ", dob=" + dob +
                ", countOfProjects=" + countOfProjects +
                ", rating=" + rating +
                ", comments='" + comments + '\'' +
                '}';
    }
}
