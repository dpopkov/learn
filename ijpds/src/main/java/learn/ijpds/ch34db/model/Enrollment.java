package learn.ijpds.ch34db.model;

import java.util.Objects;

public class Enrollment {
    private String ssn;
    private String courseId;
    private String dateRegistered;
    private String grade;

    public Enrollment() {
    }

    public Enrollment(String ssn, String courseId, String dateRegistered, String grade) {
        this.ssn = ssn;
        this.courseId = courseId;
        this.dateRegistered = dateRegistered;
        this.grade = grade;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(String dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "ssn='" + ssn + '\'' +
                ", courseId='" + courseId + '\'' +
                ", dateRegistered='" + dateRegistered + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enrollment that = (Enrollment) o;
        return Objects.equals(ssn, that.ssn) &&
                Objects.equals(courseId, that.courseId) &&
                Objects.equals(dateRegistered, that.dateRegistered) &&
                Objects.equals(grade, that.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ssn, courseId, dateRegistered, grade);
    }
}
