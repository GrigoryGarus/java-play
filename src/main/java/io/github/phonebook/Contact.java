package io.github.phonebook;

import java.util.Date;
import java.util.Objects;

public class Contact implements Comparable {
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

    public Contact(String fullName) {
        this.fullName = fullName;

        this.dob = null;
        this.countOfProjects = 0;
        this.rating = (float) 0;
        this.comments = null;
    }

    public String getFullName() {
        return fullName;
    }

    public String getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return "io.github.phonebook.Contact{" +
                "fullName='" + fullName + '\'' +
                ", dob=" + dob +
                ", countOfProjects=" + countOfProjects +
                ", rating=" + rating +
                ", comments='" + comments + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Contact secondContact = (Contact) o;
        if (this.fullName.contains(secondContact.getFullName())) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.hashCode() == o.hashCode()) return true;

        return false;
    }

    @Override
    public int hashCode() {
        int result = getFullName() != null ? getFullName().hashCode() : 0;
        result = 31 * result + (dob != null ? dob.hashCode() : 0);
        result = 31 * result + (countOfProjects != null ? countOfProjects.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (getComments() != null ? getComments().hashCode() : 0);
        return result;
    }
}
