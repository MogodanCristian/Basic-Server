package Models;

public class Teacher extends Human {

    private String m_subject;
    public Teacher(String m_firstName, String m_lastName, String m_college, Integer m_age,String subject) {
        this.m_firstName = m_firstName;
        this.m_lastName = m_lastName;
        this.m_college = m_college;
        this.m_age = m_age;
        this.m_subject = subject;
    }

    public String getM_subject() {
        return m_subject;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "subject='" + m_subject + '\'' +
                "first name='" + m_firstName + '\'' +
                ", last name='" + m_lastName + '\'' +
                ",college='" + m_college + '\'' +
                ",age=" + m_age +
                '}';
    }

    public void setM_subject(String m_subject) {
        this.m_subject = m_subject;
    }

    @Override
    public void greeting() {
        System.out.println("Hello,I am a teacher!");
    }

    @Override
    public void doWork() {
        System.out.println("I am currently grading student homework!");
    }}