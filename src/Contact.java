import java.util.Date;

public class Contact {
    private final String fullName;
    private final Date dob;
    private final Integer countOfProjects;
    private final Float rating;
    private final String comments;


    public Contact(String fullName, Date dob, Integer countOfProjects, Float rating, String comments) {
        this.fullName = fullName;
        this.dob = dob;
        this.countOfProjects = countOfProjects;
        this.rating = rating;
        this.comments = comments;
    }

    public String getFullName() {
        return fullName;
    }

    public String getComments() {
        return comments;
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
