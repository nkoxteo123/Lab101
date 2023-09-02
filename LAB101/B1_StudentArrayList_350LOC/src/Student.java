public class Student {
    String id;
    String studentName ;
    String courseName;
    String semester;
    public Student(String id, String studentName, String courseName, String semester) {
        this.id = id;
        this.studentName = studentName;
        this.courseName = courseName;
        this.semester = semester;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getSemester() {
        return semester;
    }
    public void setSemester(String semester) {
        this.semester = semester;
    }
    
    public String toString() {
        return (getStudentName() + " | " + getCourseName() + " | " + getSemester());
    }
    
    public String toStringCount() {
        return (getStudentName()+" | "+getCourseName());
    }
}
