import java.util.*;

class Main {

    static Scanner sc = new Scanner(System.in);

    static long startTime = 0;
    static long totalTime = 0;
    static int sessionCount = 0;
    static long studyGoal = 0;
    static boolean isRunning = false;

    public static void main(String[] args) {

        while (true) {
            showMenu();
            int choice = getChoice();

            switch (choice) {
                case 1 -> startSession();
                case 2 -> endSession();
                case 3 -> viewProgress();
                case 4 -> setGoal();
                case 5 -> resetProgress();
                case 6 -> exitProgram();
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void showMenu() {
        System.out.println("\n----------------------------------");
        System.out.println("===== STUDY TRACKER =====");
        System.out.println("1. Start Study Session");
        System.out.println("2. End Study Session");
        System.out.println("3. View Progress");
        System.out.println("4. Set Study Goal (minutes)");
        System.out.println("5. Reset Progress");
        System.out.println("6. Exit");
        System.out.println("----------------------------------");
    }

    static int getChoice() {
        System.out.print("Enter choice: ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid input! Please enter a number.");
            sc.next();
            return -1;
        }
        return sc.nextInt();
    }

    static void startSession() {
        if (!isRunning) {
            startTime = System.currentTimeMillis();
            isRunning = true;
            System.out.println("Study session started!");
        } else {
            System.out.println("Session already running!");
        }
    }

    static void endSession() {
        if (isRunning) {
            long endTime = System.currentTimeMillis();
            long sessionTime = (endTime - startTime) / 1000;

            totalTime += sessionTime;
            sessionCount++;
            isRunning = false;

            System.out.println("Session ended!");
            printTime(sessionTime);
        } else {
            System.out.println("No session running!");
        }
    }

    static void viewProgress() {
        System.out.println("\n===== PROGRESS =====");

        if (isRunning) {
            long currentTime = (System.currentTimeMillis() - startTime) / 1000;
            System.out.print("Session running: ");
            printTime(currentTime);
        }

        System.out.print("Total study time: ");
        printTime(totalTime);

        System.out.println("Total sessions: " + sessionCount);

        if (sessionCount > 0) {
            System.out.print("Average session: ");
            printTime(totalTime / sessionCount);
        }

        if (studyGoal > 0) {
            System.out.println("Study goal: " + (studyGoal / 60) + " minutes");

            if (totalTime >= studyGoal) {
                System.out.println("Goal achieved!");
            } else {
                System.out.print("Remaining: ");
                printTime(studyGoal - totalTime);
            }
        } else {
            System.out.println("No goal set yet.");
        }
    }

    static void setGoal() {
        System.out.print("Enter study goal (minutes): ");

        if (!sc.hasNextLong()) {
            System.out.println("Invalid input!");
            sc.next();
            return;
        }

        long minutes = sc.nextLong();

        if (minutes <= 0) {
            System.out.println("Enter a valid number!");
        } else {
            studyGoal = minutes * 60;
            System.out.println("Goal set successfully!");
        }
    }

    static void resetProgress() {
        System.out.print("Are you sure? (yes/no): ");
        sc.nextLine(); // clear buffer
        String confirm = sc.nextLine();

        if (confirm.equalsIgnoreCase("yes")) {
            totalTime = 0;
            sessionCount = 0;
            studyGoal = 0;
            isRunning = false;
            System.out.println("Progress reset!");
        } else {
            System.out.println("Cancelled.");
        }
    }

    static void exitProgram() {
        if (isRunning) {
            System.out.println("End session first!");
        } else {
            System.out.println("Exiting...");
            sc.close();
            System.exit(0);
        }
    }

    static void printTime(long seconds) {
        long min = seconds / 60;
        long sec = seconds % 60;
        System.out.println(min + " min " + sec + " sec");
    }
}