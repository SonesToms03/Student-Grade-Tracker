import java.util.Scanner;

public class GRADE_TRACKER {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of students: ");
        int noOfStudents = scanner.nextInt();
        
        // Validate input
        while (noOfStudents <= 0) {
            System.out.println("Enter a valid number: ");
            noOfStudents = scanner.nextInt();
        }
        
        double[] grades = new double[noOfStudents];
        double total = 0;
        
        for (int i = 0; i < noOfStudents; i++) {
            System.out.print("Enter mark for student " + (i + 1) + ": ");
            grades[i] = scanner.nextDouble();
            
            // Validate grade input
            while (grades[i] < 0 || grades[i] > 100) {
                System.out.print("Invalid . Enter marks for student " + (i + 1) + " (0-100): ");
                grades[i] = scanner.nextDouble();
            }
            
            total += grades[i];
        }
        
        double average = total / noOfStudents;
        double highest = findHighest(grades);
        double lowest = findLowest(grades);
        
        System.out.println("Average grade: " + average);
        System.out.println("Highest grade: " + highest);
        System.out.println("Lowest grade: " + lowest);
        
        for (int i = 0; i < noOfStudents; i++) {
            System.out.println("Grade for student " + (i + 1) + ": " + computeGrade(grades[i]));
        }
        
        scanner.close();
    }
    
    public static double findHighest(double[] grades) {
        double highest = grades[0];
        for (double grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }
    
    public static double findLowest(double[] grades) {
        double lowest = grades[0];
        for (double grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }
    
    public static String computeGrade(double grade) {
        if (grade > 85) {
            return "A";
        } else if (grade > 75) {
            return "B";
        } else if (grade > 65) {
            return "C";
        } else if (grade > 55) {
            return "D";
        } else if (grade > 45) {
            return "E";
        } else {
            return "Fail";
        }
    }
}
