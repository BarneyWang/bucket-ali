package me.heng.model;

/**
 * AUTHOR: heyong.wd(和庸)
 * DATE: 2017/3/29
 * TIME: 下午5:59
 */
public class Model {



    private String name;
    private int age;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Model{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
