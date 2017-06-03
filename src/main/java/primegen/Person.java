package primegen;

/**
 * Created with IntelliJ IDEA.
 * User: andy.lai
 * Date: 03/06/2017
 * Time: 3:01 PM
 */
public class Person {
    public int age;
    public String gender;
    public Person(int age,String gender){
        this.age=age;
        this.gender=gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public boolean isChild(){
        return age<=14;
    }
    public boolean isFemale(){
        return gender.equalsIgnoreCase("f");
    }
}
