package Models;

 public abstract class Human implements Comparable<Human>{
    protected String m_firstName;
    protected String m_lastName;
    protected String m_college;
    protected Integer m_age;
    abstract  void greeting();

    public String getM_firstName() {
        return m_firstName;
    }

    public void setM_firstName(String m_firstName) {
        this.m_firstName = m_firstName;
    }

    public String getM_lastName() {
        return m_lastName;
    }

    public void setM_lastName(String m_lastName) {
        this.m_lastName = m_lastName;
    }

    public String getM_college() {
        return m_college;
    }

    public void setM_college(String m_college) {
        this.m_college = m_college;
    }

    public Integer getM_age() {
        return m_age;
    }
    public void setM_age(Integer m_age) {
        this.m_age = m_age;
    }
    abstract void  doWork();

     @Override
     public int compareTo(Human o) {
         return Integer.compare(this.m_age, o.m_age);
     }
 }

