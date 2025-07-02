package org.example;
import java.text.DecimalFormat;
import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        int numOfStudents = 0;

        System.out.print("Enter number of students: ");
        numOfStudents = sc.nextInt();
        sc.nextLine();

        int[] numericScores = new int[numOfStudents];
        String[] studentNames = new String[numOfStudents];
        char[] studentGrades = new char[numOfStudents];

        double totalScore = 0;
        int countA=0, countB=0, countC=0, countD=0, countF=0;
        int maxScore = -1;
        ArrayList<String> topStudentList = new ArrayList<>();

        for (int i=0; i<numOfStudents;i++){
            System.out.printf("Enter name of student " + (i+1) + ": ");
            studentNames[i] = sc.nextLine();
            int score;
            while(true){
                System.out.print("Enter score for " + studentNames[i] + ": ");
                score = sc.nextInt();
                sc.nextLine();
                if (score >= 0 && score <= 100){
                    numericScores[i]=score;
                    break;
                } else{
                    System.out.println("Invalid score input");
                }
            }
            char grade = gradeCalculator(numericScores[i]);
            studentGrades[i] = grade;
            System.out.print(studentNames[i] + " got grade: " + grade);
            System.out.println();

            totalScore += numericScores[i];
            switch(grade){
                case'A': countA++; break;
                case'B': countB++; break;
                case'C': countC++; break;
                case'D': countD++; break;
                case'F': countF++; break;
            }

            if (numericScores[i] > maxScore) {
                maxScore = numericScores[i];
                topStudentList.clear(); // Clear previous top student(s) if a new max is found
                topStudentList.add(studentNames[i] + " (" + numericScores[i] + ")");
            } else if (numericScores[i] == maxScore) {
                // If the current student's score ties the max score, just add them to the list
                topStudentList.add(studentNames[i] + " (" + numericScores[i] + ")");
            }
        }
        System.out.println("---- Class Summary -----");
        //avg score = sum of grades / total students
        double averageScore = totalScore / numOfStudents;
        System.out.println("Average Score: " + df.format(averageScore));
        System.out.println("Grade Counts: A:" + countA +
                " B:" + countB +
                " C:" + countC +
                " D:" + countD +
                " F:" + countF);
        if(numOfStudents > 0){
            System.out.println("Top Student(s): " + String.join(", ", topStudentList));
        } else System.out.println("No students");
        sc.close();
    }
    public static char gradeCalculator(int score){
        if (score >= 90){
            return 'A';
        } else if (score >= 80){
            return 'B';
        } else if (score >= 70){
            return 'C';
        } else if (score >= 60){
            return 'D';
        } else return 'F';
    }
}
