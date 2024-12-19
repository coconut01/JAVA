//package src.stu;
//
//import java.io.*;
//import java.util.Scanner;
//
//public class StudentManagementSystem2 {
//    private static final int MAX_STUDENTS = 80;
//    private static Student[] stu = new Student[MAX_STUDENTS];
//    private static int numStudents = 0;
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int choice;
//        do {
//            System.out.println("1.录入学生成绩");
//            System.out.println("2.修改学生成绩");
//            System.out.println("3.查看学生成绩");
//            System.out.println("4.平均分排序");
//            System.out.println("5.查询学生成绩");
//            System.out.println("6.不及格学生");
//            System.out.println("7.输出成绩单");
//            System.out.println("8.结束程序");
//            System.out.print("请选择操作: ");
//            choice = scanner.nextInt();
//
//            switch (choice) {
//                case 1:
//                    numStudents = inputStudents();
//                    break;
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
//                case 8:
//                    System.out.println("程序结束");
//                    break;
//                default:
//                    System.out.println("选择错误，请重新输入。");
//                    break;
//            }
//
//            scanner.nextLine(); // Consume the newline character
//            System.out.println("按回车键继续...");
//            scanner.nextLine();
//            clearScreen();
//        } while (choice != 8);
//    }
//
//    private void inputStudents() {
//        String filePath = "D:/MyProject/IdeaProjects/file/sample.txt";
//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
//            String line;
//            while ((line = bufferedReader.readLine())  != null) {
//                // 处理每一行数据 .....
//            }
//        } catch (Exception e) {
//        }
//
//    }
//
////    private static void modifyScores(Student[] st, int n) {
////        Scanner scanner = new Scanner(System.in);
////        System.out.print("请输入要修改成绩的学生学号: ");
////        String num = scanner.nextLine();
////
////        boolean found = false;
////        for (int i = 0; i < n; i++) {
////            if (st[i].num.equals(num)) {
////                System.out.println("找到学生记录:");
////                System.out.println("学号\t姓名\t班级\t科目1\t科目2\t科目3\t科目4\t平均分");
////                System.out.println(st[i].num + "\t" + st[i].name + "\t" + st[i].cla + "\t" + st[i].c1 + "\t" + st[i].c2 + "\t" + st[i].c3 + "\t" + st[i].c4 + "\t" + st[i].aver);
////                System.out.print("请输入要修改的科目(1-4): ");
////                int subject = scanner.nextInt();
////
////                if (subject < 1 || subject > 4) {
////                    System.out.println("选择错误，请重新输入科目范围。");
////                    return;
////                }
////
////                System.out.print("请输入新的成绩: ");
////                int score = scanner.nextInt();
////
////                while(score<0||score>100) {
////                    System.out.println("成绩无效，请输入0到100之间的成绩。");
////                    score= scanner.nextInt();
////                };
////
////                switch (subject) {
////                    case 1:
////                        st[i].c1 = score;
////                        break;
////                    case 2:
////                        st[i].c2 = score;
////                        break;
////                    case 3:
////                        st[i].c3 = score;
////                        break;
////                    case 4:
////                        st[i].c4 = score;
////                        break;
////                }
////                st[i].sum = st[i].c1 + st[i].c2 + st[i].c3 + st[i].c4;
////                st[i].aver = st[i].sum / 4.0f;
////
////                System.out.println("成绩修改成功。");
////                found = true;
////                break;
////            }
////        }
////
////        if (!found) {
////            System.out.println("未找到该学生记录。");
////        }
////    }
////
////    private static void viewScores(Student[] st, int n) {
////        System.out.println("学号\t姓名\t班级\t科目1\t科目2\t科目3\t科目4\t平均分");
////        for (int i = 0; i < n; i++) {
////            System.out.println(st[i].num + "\t" + st[i].name + "\t" + st[i].cla + "\t" + st[i].c1 + "\t" + st[i].c2 + "\t" + st[i].c3 + "\t" + st[i].c4 + "\t" + st[i].aver);
////        }
////    }
////
////    private static void sortByAverage(Student[] st, int n) {
////        // 使用冒泡排序算法对学生数组按平均分进行排序
////        for (int i = 0; i < n - 1; i++) {
////            for (int j = 0; j < n - i - 1; j++) {
////                if (st[j].aver < st[j + 1].aver) {
////                    // 交换学生对象位置
////                    Student temp = st[j];
////                    st[j] = st[j + 1];
////                    st[j + 1] = temp;
////                }
////            }
////        }
////        System.out.println("学号\t姓名\t班级\t科目1\t科目2\t科目3\t科目4\t平均分");
////        for (int i = 0; i < n; i++) {
////            System.out.println(st[i].num + "\t" + st[i].name + "\t" + st[i].cla + "\t" + st[i].c1 + "\t" + st[i].c2 + "\t" + st[i].c3 + "\t" + st[i].c4 + "\t" + st[i].aver);
////        }
////    }
////
////    private static void findStudent(Student[] st, int n) {
////        Scanner scanner = new Scanner(System.in);
////        System.out.print("请输入要查询的学生学号: ");
////        String num = scanner.nextLine();
////
////        boolean found = false;
////        for (int i = 0; i < n; i++) {
////            if (st[i].num.equals(num)) {
////                System.out.println("找到学生记录:");
////                System.out.println("学号\t姓名\t班级\t科目1\t科目2\t科目3\t科目4\t平均分");
////                System.out.println(st[i].num + "\t" + st[i].name + "\t" + st[i].cla + "\t" + st[i].c1 + "\t" + st[i].c2 + "\t" + st[i].c3 + "\t" + st[i].c4 + "\t" + st[i].aver);
////                found = true;
////                break;
////            }
////        }
////
////        if (!found) {
////            System.out.println("未找到该学生记录。");
////        }
////    }
////
////    private static void findFailingStudents(Student[] st, int n) {
////        System.out.println("不及格学生记录:");
////        System.out.println("学号\t姓名\t班级\t科目1\t科目2\t科目3\t科目4\t平均分");
////        for (int i = 0; i < n; i++) {
////            if (st[i].c1 < 60 || st[i].c2 < 60 || st[i].c3 < 60 || st[i].c4 < 60) {
////                System.out.println(st[i].num + "\t" + st[i].name + "\t" + st[i].cla + "\t" + st[i].c1 + "\t" + st[i].c2 + "\t" + st[i].c3 + "\t" + st[i].c4 + "\t" + st[i].aver);
////            }
////        }
////    }
////
////    private static void printScoreSheet(Student[] st, int n) {
////        System.out.println("学号\t姓名\t班级\t科目1\t科目2\t科目3\t科目4\t平均分");
////        for (int i = 0; i < n; i++) {
////            System.out.println(st[i].num + "\t" + st[i].name + "\t" + st[i].cla + "\t" + st[i].c1 + "\t" + st[i].c2 + "\t" + st[i].c3 + "\t" + st[i].c4 + "\t" + st[i].aver);
////        }
////    }
////
////    private static void clearScreen() {
////        System.out.print("");
////        System.out.flush();// // 刷新输出缓冲区，确保内容被立即输出到控制台
////    }
//}
