import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;
        System.out.print("Enter number of subjects: ");
        n = sc.nextInt();

        int total = 0;
        int validCount = 0;

        for (int i = 1; i <= n; i++) {
            int marks;
            System.out.print("Enter marks for subject " + i + ": ");
            marks = sc.nextInt();

            if (marks >= 0 && marks <= 100) {
                total += marks;
                validCount++;
            } else {
                System.out.println("Invalid marks for subject " + i);
            }
        }

        if (validCount == 0) {
            System.out.println("No valid subjects. Grade cannot be calculated.");
            return;
        }

        double average = (double) total / validCount;
        char grade;

        if (average >= 90)
            grade = 'A';
        else if (average >= 80)
            grade = 'B';
        else if (average >= 70)
            grade = 'C';
        else if (average >= 60)
            grade = 'D';
        else if (average >= 40)
            grade = 'E';
        else
            grade = 'F';

        System.out.println("\nTotal Marks (valid subjects): " + total);
        System.out.println("Average Percentage: " + average);
        System.out.println("Grade: " + grade);

        sc.close();
    }
}
