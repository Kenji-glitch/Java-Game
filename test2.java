import java.util.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//import java.util.Scanner;
//import java.util.Collections;

public class test2 {
    public static void main(String[] args) throws InterruptedException {
        boolean gameRunning = true;

        System.out.println("\n\n          Group 2 Presents     \n\n");
        Thread.sleep(2000);
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("              -Trivia Game-                ");
        System.out.println("              Version 1.1.2                 ");
        System.out.println("                   Beta                     ");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------\n\n");
        Thread.sleep(2000);

        System.out.println("\n\n          Group 2 Presents     \n\n");
        Thread.sleep(2000);
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");
        System.out.println("              -Trivia Game-                ");
        System.out.println("              Version 1.1.2                 ");
        System.out.println("                   Beta                     ");
        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------\n\n");
        Thread.sleep(2000);



        List<String[]> questions = new ArrayList<>();
        questions.add(new String[]{"What is the third planet from the Sun?:\n \nA. Earth\nB. Jupiter\nC. Mars\nD. Yekok\n ", "A"});
        questions.add(new String[]{"What is the name of Cinderella's fairy godmother in Disney's 'Cinderella'?\n\nA. Flora\nB. Fauna\nC. Merryweather\nD. The Blue Fairy\n", "C"});
        questions.add(new String[]{"What is the name of the character voiced by Robin Williams in Disney's 'Aladdin'?\n\nA. Jafar\nB. Abu\nC. Genie\nD. Iago\n", "C"});
        // These questions are not final, these are just examples.
        Collections.shuffle(questions);
        // Add more questions and answers as needed

        List<String> names = new ArrayList<>();
        List<Integer> totalTimer = new ArrayList<>();
        List<Integer> score = new ArrayList<>();
        List<String> remarks = new ArrayList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();

            while (gameRunning) {
                randomizeQuestions(questions, random);
                int playerScore = 0;
                int scoreLimit = 100;
                int failLimit = -200;

                System.out.println("        Trivia Game v1.1.2 beta\n");
                System.out.println("Main Menu\n");
                System.out.println("1. Start Game");
                System.out.println("2. Instructions");
                System.out.println("3. Leaderboard");
                System.out.println("4. Exit\n");
                System.out.print("Please Select an Option (1, 2, 3, 4): ");
                int playerOption = scanner.nextInt();
                System.out.println();

                if (playerOption == 1) {
                    System.out.print("\nEnter Your Name: ");
                    String playerName = scanner.next();
                    names.add(playerName);

                    System.out.println("\n--------------------------------------------");
                    System.out.println("               LOADING GAME                 ");
                    System.out.println("                PLEASE WAIT                 ");
                    System.out.println("--------------------------------------------\n");
                    Thread.sleep(2000);
                    System.out.println("--------------------------------------------");
                    System.out.println("                  START!                    ");
                    System.out.println("--------------------------------------------\n");
                    Thread.sleep(1000);

                    long startTimer = System.currentTimeMillis();

                    for (String[] question : questions) {
                        String questionText = question[0];
                        System.out.println(questionText);
                        System.out.print("\nEnter (A, B, C, D): ");
                        String userAnswer = scanner.next().toUpperCase();
                        System.out.println();

                        String correctAnswer = question[1];

                        if (!userAnswer.equals("A") && !userAnswer.equals("B") && !userAnswer.equals("C") && !userAnswer.equals("D")) {
                            System.out.println("Invalid input. Please enter A, B, C, or D.\n");
                        } else {
                            if (userAnswer.equals(correctAnswer)) {
                                System.out.println("Your answer is correct!");
                                playerScore += 25;
                                System.out.println(playerName + ", your Score is: " + playerScore + "\n");
                            } else {
                                System.out.println(userAnswer + " is Incorrect!");
                                System.out.println("The correct answer is, " + correctAnswer);
                                playerScore -= 50;
                                System.out.println(playerName + ", your Score is: " + playerScore + "\n");
                            }
                            Thread.sleep(1000);
                        }

                        totalTimer.add((int) (System.currentTimeMillis() - startTimer) / 1000);

                        if (playerScore <= failLimit) {
                            System.out.println("--------------------------------------------------------------------------------------------------");
                            System.out.println("--------------------------------------------------------------------------------------------------");
                            System.out.println("                                        YOU FAILED!                                               ");
                            System.out.println("                                         GAME OVER                                                ");
                            System.out.println("                                    BETTER LUCK NEXT TIME!                                        ");
                            System.out.println("                                     Your score is, " + playerScore);
                            System.out.println("--------------------------------------------------------------------------------------------------");
                            System.out.println("--------------------------------------------------------------------------------------------------\n");
                            remarks.add("| FAILED");
                            score.add(playerScore);
                            break;
                        } else if (playerScore >= scoreLimit) {
                            System.out.println("--------------------------------------------------------------------------------------------------");
                            System.out.println("--------------------------------------------------------------------------------------------------");
                            System.out.println("                                         GREAT!                                                   ");
                            System.out.println("                                        YOU WIN!                                                  ");
                            System.out.println("                        You have reached 100 points in " + totalTimer.get(totalTimer.size() - 1) + " seconds");
                            System.out.println("                                    TOTAL: SCORE: " + playerScore);
                            System.out.println("--------------------------------------------------------------------------------------------------");
                            System.out.println("--------------------------------------------------------------------------------------------------\n");
                            remarks.add("| PASSED");
                            score.add(playerScore);
                            System.out.println("                  Congratulations, " + playerName + ". You are a certified Trivia Master\n");
                            Thread.sleep(1000);
                            break;
                        }
                    }
                } else if (playerOption == 2) {
                    displayInstructions();
                } else if (playerOption == 3) {
                    displayLeaderboard(names, totalTimer, score, remarks);
                } else {
                    break;
                }

                System.out.print("Go Back to Main Menu? (Y/N): ");
                String repeatLoop = scanner.next().toUpperCase();
                System.out.println("\n\n");
                if (repeatLoop.equals("N")) {
                    gameRunning = false;
                }
            }
        }
    }

    private static void randomizeQuestions(List<String[]> questions, Random random) {
        // Shuffle your questions here
    }

    private static void displayInstructions() throws InterruptedException {
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println("                                    GAME INSTRUCTIONS                                             ");
        System.out.println("--------------------------------------------------------------------------------------------------\n");
        Thread.sleep(1000);
        System.out.println("The quizz consists of questions carefully designed to help you self-assess your general knowledge.");
        Thread.sleep(1000);
        System.out.println("Each question in the quiz is of multiple-choice format. Read each question carefully.");
        Thread.sleep(1000);
        System.out.println("Answer each question by typing the LETTER of your chosen answer.");
        Thread.sleep(1000);
        System.out.println("Each CORRECT ANSWER will INCREASE your score by 25 POINTS.");
        Thread.sleep(1000);
        System.out.println("If you reach 100 POINTS the quiz will END!");
        Thread.sleep(1000);
        System.out.println("But for every WRONG ANSWER, your score will be DEDUCTED by 50 POINTS.");
        Thread.sleep(1000);
        System.out.println("It is GAME OVER if your score reaches -200 points.");
        Thread.sleep(1000);
        System.out.println("The quiz tracks your TIME to reach 100 POINTS");
        Thread.sleep(1000);
        System.out.println("The Player who will reach 100 POINTS the FASTEST is the GRAND MASTER!");
        Thread.sleep(1000);
        System.out.println("Good Luck and Enjoy!\n");
        Thread.sleep(1000);
        System.out.println("-DEVS\n");
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println("                                 TRIVIA MASTERS v1.1.2 beta                                          ");
        System.out.println("--------------------------------------------------------------------------------------------------\n");
        System.out.println();
    }

    private static void displayLeaderboard(List<String> names, List<Integer> totalTimer, List<Integer> score, List<String> remarks) {
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println("                                      LEADERBOARD                                                 ");
        System.out.println("--------------------------------------------------------------------------------------------------\n");
        if (names.isEmpty() && totalTimer.isEmpty() && score.isEmpty() && remarks.isEmpty()) {
            System.out.println("                      PLEASE PLAY THE GAME TO POPULATE THE LEADERBOARD                            \n");
        } else {
            for (int i = 0; i < names.size(); i++) {
                System.out.println(names.get(i) + " | Finished in " + totalTimer.get(i) + " seconds | Score: " + score.get(i) + remarks.get(i));
            }
            System.out.println("--------------------------------------------------------------------------------------------------\n");
        }
        System.out.println("                                TRIVA MASTERS v1.1.2 beta                                           ");
        System.out.println("--------------------------------------------------------------------------------------------------\n");
        System.out.println();
    }
}
