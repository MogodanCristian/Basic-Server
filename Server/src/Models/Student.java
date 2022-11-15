package Models;

public class Student extends Human{
    private Integer m_year;

    public Integer getM_year() {
        return m_year;
    }

    public void setM_year(Integer m_year) {
        this.m_year = m_year;
    }

    @Override
    public String toString() {
        return "Student{" +
                "year=" + m_year +
                "first name= " + m_firstName + '\'' +
                "last name=" + m_lastName + '\'' +
                "college= " + m_college + '\'' +
                "age= " + m_age +
                '}';
    }

    public Student(String m_firstName, String m_lastName, String m_college, Integer m_age, Integer year) {
        this.m_firstName = m_firstName;
        this.m_lastName = m_lastName;
        this.m_college = m_college;
        this.m_age = m_age;
        this.m_year = year;
    }

    @Override
    void greeting() {
        System.out.println("Hello, I am a student!");
    }

    @Override
    void doWork() {
        System.out.println("I am currently doing homework!");
    }
}
