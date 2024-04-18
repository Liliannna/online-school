package net.online.school.ttschool;

import java.io.Serializable;


public class Trainee implements Serializable {
    private String firstName;
    private String lastName;
    private int rating;

    public Trainee(String firstName, String lastName, int rating) throws TrainingException {
        setFirstName(firstName);
        setLastName(lastName);
        setRating(rating);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws TrainingException {
        this.firstName = firstName;
        if (firstName == null || firstName == "") {
            throw new TrainingException(TrainingErrorCode.TRAINEE_WRONG_FIRSTNAME);
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws TrainingException {
        this.lastName = lastName;
        if (lastName == null || lastName == "") {
            throw new TrainingException(TrainingErrorCode.TRAINEE_WRONG_LASTNAME);
        }
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) throws TrainingException {
        this.rating = rating;
        if (rating > 5 || rating == 0) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_WRONG_RATING);
        }
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trainee trainee = (Trainee) o;

        if (rating != trainee.rating) return false;
        if (firstName != null ? !firstName.equals(trainee.firstName) : trainee.firstName != null) return false;
        return lastName != null ? lastName.equals(trainee.lastName) : trainee.lastName == null;

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + rating;
        return result;
    }
}
