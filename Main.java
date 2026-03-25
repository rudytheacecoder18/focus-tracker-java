import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long startTime = 0;
        long endTime = 0;
        long totalTime = 0;

        boolean isRunning = false;
        int sessionCount = 0;
        long studyGoal = 0; // in seconds

        while(true) {
            System.out.println("\n----------------------------------");
            System.out.println("===== STUDY TRACKER =====");
            System.out.println("1. Start Study Session");
            System.out.println("2. End Study Session");
            System.out.println("3. View Progress");
            System.out.println("4. Set Study Goal (minutes)");
            System.out.println("5. Reset Progress");
            System.out.println("6. Exit");
            System.out.println("----------------------------------");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if(choice == 1) {
                if(!isRunning) {
                    startTime = System.currentTimeMillis();
                    isRunning = true;
                    System.out.println("Study session started!");
                } else {
                    System.out.println("Session already running!");
                }
            }

            else if(choice == 2) {
                if(isRunning) {
                    endTime = System.currentTimeMillis();
                    long sessionTime = (endTime - startTime) / 1000;
                    totalTime += sessionTime;
                    sessionCount++;

                    isRunning = false;

                    long minutes = sessionTime / 60;
                    long seconds = sessionTime % 60;

                    System.out.println("Session ended!");
                    System.out.println("You studied for " + minutes + " min " + seconds + " sec");
                    System.out.println("Good job! Keep it up!");
                } else {
                    System.out.println("No session running!");
                }
            }

            else if(choice == 3) {
                System.out.println("\n===== PROGRESS =====");

                // If session running → show live time
                if(isRunning) {
                    long currentTime = (System.currentTimeMillis() - startTime) / 1000;
                    long currMin = currentTime / 60;
                    long currSec = currentTime % 60;
                    System.out.println("Session running: " + currMin + " min " + currSec + " sec");
                }

                long totalMinutes = totalTime / 60;
                long totalSeconds = totalTime % 60;

                System.out.println("Total study time: " + totalMinutes + " min " + totalSeconds + " sec");
                System.out.println("Total sessions: " + sessionCount);

                // Average session
                if(sessionCount > 0) {
                    long avg = totalTime / sessionCount;
                    long avgMin = avg / 60;
                    long avgSec = avg % 60;
                    System.out.println("Average session: " + avgMin + " min " + avgSec + " sec");
                }

                // Goal
                if(studyGoal > 0) {
                    long goalMinutes = studyGoal / 60;
                    System.out.println("Study goal: " + goalMinutes + " minutes");

                    if(totalTime >= studyGoal) {
                        System.out.println("Goal achieved!");
                    } else {
                        long remaining = studyGoal - totalTime;
                        long remMin = remaining / 60;
                        long remSec = remaining % 60;
                        System.out.println("Keep going! Remaining: " + remMin + " min " + remSec + " sec");
                    }
                } else {
                    System.out.println("No goal set yet.");
                }
            }

            else if(choice == 4) {
                System.out.print("Enter study goal (in minutes): ");
                long minutes = sc.nextLong();

                if(minutes <= 0) {
                    System.out.println("Please enter a valid goal!");
                } else {
                    studyGoal = minutes * 60;
                    System.out.println("Goal set successfully!");
                }
            }

            else if(choice == 5) {
                System.out.print("Are you sure you want to reset? (yes/no): ");
                sc.nextLine(); // clear buffer
                String confirm = sc.nextLine();

                if(confirm.equalsIgnoreCase("yes")) {
                    totalTime = 0;
                    sessionCount = 0;
                    studyGoal = 0;
                    isRunning = false;
                    System.out.println("All progress reset!");
                } else {
                    System.out.println("Reset cancelled.");
                }
            }

            else if(choice == 6) {
                if(isRunning) {
                    System.out.println("You have an active session! End it first.");
                } else {
                    System.out.println("Exiting...");
                    sc.close();
                    break;
                }
            }

            else {
                System.out.println("Invalid choice!");
            }
        }
    }
}