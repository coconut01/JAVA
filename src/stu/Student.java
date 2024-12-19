package src.stu;

public class Student {
    private String id; // 学号
    private String name; // 姓名
    private String answer; // 答案

    private int score;
    private float aver;;

    public Student() {

    }

    public Student(String id, String name, String answer) {
        this.id = id;
        this.name = name;
        this.answer = answer;
    }

    // 获取学号
    public String getId() {
        return id;
    }

    // 设置学号
    public void setId(String id) {
        this.id = id;
    }

    // 获取姓名
    public String getName() {
        return name;
    }

    // 设置姓名
    public void setName(String name) {
        this.name = name;
    }

    // 获取答案
    public String getAnswer() {
        return answer;
    }

    // 设置答案
    public void setAnswer(String name) {
        this.answer = answer;
    }

}
