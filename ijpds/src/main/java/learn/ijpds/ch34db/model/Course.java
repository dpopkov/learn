package learn.ijpds.ch34db.model;

import java.util.Objects;

public class Course {
    private String courseId;
    private String subjectId;
    private String courseNumber;
    private String title;
    private String numOfCredits;

    public Course() {
    }

    public Course(String courseId, String subjectId, String courseNumber, String title, String numOfCredits) {
        this.courseId = courseId;
        this.subjectId = subjectId;
        this.courseNumber = courseNumber;
        this.title = title;
        this.numOfCredits = numOfCredits;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNumOfCredits() {
        return numOfCredits;
    }

    public void setNumOfCredits(String numOfCredits) {
        this.numOfCredits = numOfCredits;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", subjectId='" + subjectId + '\'' +
                ", courseNumber='" + courseNumber + '\'' +
                ", title='" + title + '\'' +
                ", numOfCredits='" + numOfCredits + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseId, course.courseId) &&
                Objects.equals(subjectId, course.subjectId) &&
                Objects.equals(courseNumber, course.courseNumber) &&
                Objects.equals(title, course.title) &&
                Objects.equals(numOfCredits, course.numOfCredits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, subjectId, courseNumber, title, numOfCredits);
    }
}
