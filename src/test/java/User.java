import java.io.Serializable;

/**
 * @Auther: ruwenbo
 * @Date: 2020/8/12 22:34
 * @Description:
 */
public class User implements Serializable{


    private static final long serialVersionUID = -1007983712037718006L;
    private String name;

    private int age;

    private String sex;

    public User(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
