package src.stu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1.录入学生成绩");
            System.out.println("2.修改学生成绩");
            System.out.println("3.查看学生成绩");
            System.out.println("4.平均分排序");
            System.out.println("5.查询学生成绩");
            System.out.println("6.不及格学生");
            System.out.println("7.输出成绩单");
            System.out.println("8.结束程序");
            System.out.print("请选择操作: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    inputStudents();
                    break;
//                case 2:
//                    modifyScores(stu, numStudents);
//                    break;
//                case 3:
//                    viewScores(stu, numStudents);
//                    break;
//                case 4:
//                    sortByAverage(stu, numStudents);
//                    break;
//                case 5:
//                    findStudent(stu, numStudents);
//                    break;
//                case 6:
//                    findFailingStudents(stu, numStudents);
//                    break;
//                case 7:
//                    printScoreSheet(stu, numStudents);
//                    break;
                case 8:
                    System.out.println("程序结束");
                    break;
                default:
                    System.out.println("选择错误，请重新输入。");
                    break;
            }

            scanner.nextLine(); // Consume the newline character
            System.out.println("按回车键继续...");
            scanner.nextLine();
//            clearScreen();
        } while (choice != 8);
    }

    private static void inputStudents() {
        List<Student> studentList = new ArrayList<>();
        String filePath = "D:/MyProject/IdeaProjects/file/sample.txt";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine())  != null) {
                // 处理每一行数据 .....
                String[] lineArr = line.split("\\s+");
                Student student = new Student(lineArr[0], lineArr[1], lineArr[2]);
                studentList.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        getAnswer(studentList);
    }

    private static void getAnswer(List<Student> studentList) {
        int maxAnsLen = studentList.get(0).getAnswer().length();
        int maxStuNum = studentList.size();

        int[][] ansResCnt = new int[maxAnsLen][26]; // 统计每个答案出现的频次
        int index = -1;

        for (int ansNum = 0; ansNum < maxAnsLen; ansNum++) {
            for (Student student : studentList) {
                index = student.getAnswer().charAt(ansNum) - 'A';
                ansResCnt[ansNum][index]++;
            }
        }

        Character[] cnt = new Character[maxAnsLen];

        for (int i = 0; i < maxAnsLen; i++) {
            int max = -1;
            int loc = -1;
            for (int j = 0; j < 26; j++) {
                if (ansResCnt[i][j] > max) {
                    max = ansResCnt[i][j];
                    loc = j;
                }
            }
            if (loc >= 0) {
//                cnt[i] = (char)('A' + loc);
//                System.out.println((char) ('A' + loc));
                cnt[i] = ((char) ('A' + loc));
            }
        }
        System.out.println("题号\t\t答案\t\t频次");
        for (int i = 0; i < maxAnsLen; i++) {
            System.out.println(i + 1 + "\t\t" + cnt[i] + "\t\t" + ansResCnt[i][cnt[i] - 'A']);
//            System.out.println(cnt[i]);
//            System.out.println(cnt[i] - 'A');
//            System.out.println(ansResCnt[i][cnt[i] - 'A']);
//            System.out.println(i + 1 + "\t\t" + cnt[i] + "\t\t" + ansResCnt[i][cnt[i] - 'A']);
        }
    }

    private static void clearScreen() {
        System.out.print("");
        System.out.flush();// // 刷新输出缓冲区，确保内容被立即输出到控制台
    }

}
