package chapter6;

public class Student {

    private String name;
    private String major;
    private int id;
    private float GradePointAverage;

    public Student(String name, String major, int id, float gradePointAverage) {
        this.name = name;
        this.major = major;
        this.id = id;
        this.GradePointAverage = gradePointAverage;
    }

    public Student() {
        this("","",0,0.0F);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getGradePointAverage() {
        return GradePointAverage;
    }

    public void setGradePointAverage(float gradePointAverage) {
        GradePointAverage = gradePointAverage;
    }

    @Override
    public String toString() {
        return "이름 : "+name+"\n학과 : "+major+"\n학번 : "+id+"\n학점평균 : "+GradePointAverage;
    }
}
