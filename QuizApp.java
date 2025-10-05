import java.io.*;
import java.util.*;

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== Welcome to the Java Quiz =====");
        System.out.print("Enter your name: ");
        String userName = sc.nextLine();
        System.out.println("Hi " + userName + "! Let's start the quiz.\n");

        // Step 1: Create Questions
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("1. What is the size of int in Java?",
                Arrays.asList("A. 4 bytes", "B. 2 bytes", "C. 8 bytes", "D. Depends on OS"), 1));
        questions.add(new Question("2. Which of these is not a Java loop?",
                Arrays.asList("A. for", "B. while", "C. foreach", "D. repeat"), 4));
        questions.add(new Question("3. What is the default value of a boolean variable in Java?",
                Arrays.asList("A. true", "B. false", "C. 0", "D. null"), 2));
        questions.add(new Question("4. Which collection allows key-value pairs?",
                Arrays.asList("A. List", "B. Set", "C. Map", "D. Queue"), 3));
        questions.add(new Question("5. Which loop is best suited when you know the number of iterations?",
                Arrays.asList("A. while", "B. do-while", "C. for", "D. enhanced-for"), 3));

        Collections.shuffle(questions);

        int score = 0;

        // Step 2: Run Quiz
        for (Question q : questions) {
            System.out.println(q.questionText);
            for (int i = 0; i < q.options.size(); i++) {
                System.out.println((i + 1) + ". " + q.options.get(i));
            }

            System.out.print("Enter your answer (1-4): ");
            int userAnswer;

            // Input validation
            while (true) {
                try {
                    userAnswer = Integer.parseInt(sc.nextLine());
                    if (userAnswer >= 1 && userAnswer <= 4)
                        break;
                    else
                        System.out.print("Enter a valid option (1-4): ");
                } catch (Exception e) {
                    System.out.print("Please enter a number (1-4): ");
                }
            }

            if (q.checkAnswer(userAnswer)) {
                System.out.println("✅ Correct!\n");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer: " + q.correctOption + "\n");
            }
        }

        // Step 3: Show Score
        System.out.println("-------------------------------------");
        System.out.println("🎯 Quiz Finished!");
        System.out.println("Player: " + userName);
        System.out.println("Your Score: " + score + " / " + questions.size());

        // Step 4: Feedback
        if (score == questions.size()) {
            System.out.println("🏆 Excellent! Perfect Score!");
        } else if (score >= 3) {
            System.out.println("👍 Good Job! Keep Learning!");
        } else {
            System.out.println("📘 Need more practice!");
        }

        // Step 5: Save and Rank
        saveResult(userName, score, questions.size());
        int rank = showLeaderboardAndReturnRank(userName, score, questions.size());

        System.out.println("🏅 Your Rank: " + rank + " / " + getTotalPlayers() + " players");
        System.out.println("=================================\n");

        sc.close();
    }

    // Save result in file
    public static void saveResult(String userName, int score, int total) {
        try {
            FileWriter fw = new FileWriter("quiz_results.txt", true);
            fw.write(userName + "," + score + "," + total + "," + new Date().getTime() + "\n");
            fw.close();
            System.out.println("\n🗂 Result saved successfully!\n");
        } catch (IOException e) {
            System.out.println("⚠ Error saving result: " + e.getMessage());
        }
    }

    // Leaderboard with rank + remarks + percentage
    public static int showLeaderboardAndReturnRank(String currentUser, int currentScore, int total) {
        System.out.println("===== 🏆 Leaderboard (Top 5) =====");

        File file = new File("quiz_results.txt");
        if (!file.exists()) {
            System.out.println("No records found yet!");
            return 1;
        }

        List<PlayerScore> scores = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    String name = parts[0];
                    int score = Integer.parseInt(parts[1]);
                    int tot = Integer.parseInt(parts[2]);
                    scores.add(new PlayerScore(name, score, tot));
                }
            }
        } catch (IOException e) {
            System.out.println("⚠ Error reading leaderboard: " + e.getMessage());
        }

        // Sort descending by score
        scores.sort((a, b) -> Integer.compare(b.score, a.score));

        // Display top 5
        int rank = 1;
        for (PlayerScore ps : scores) {
            if (rank > 5)
                break;
            double percentage = ((double) ps.score / ps.total) * 100;
            String remark = getRemark(percentage);
            System.out.printf("%d. %-10s - %d/%d (%.0f%%) - %s%n", rank, ps.name, ps.score, ps.total, percentage,
                    remark);
            rank++;
        }

        // Calculate current user's rank
        int userRank = 1;
        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i).name.equalsIgnoreCase(currentUser) &&
                    scores.get(i).score == currentScore) {
                userRank = i + 1;
                break;
            }
        }

        return userRank;
    }

    // Count total players
    public static int getTotalPlayers() {
        File file = new File("quiz_results.txt");
        if (!file.exists())
            return 0;
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (br.readLine() != null)
                count++;
        } catch (IOException e) {
            return 0;
        }
        return count;
    }

    // Remark generator
    public static String getRemark(double percentage) {
        if (percentage == 100)
            return "🌟 Perfect!";
        else if (percentage >= 80)
            return "🏅 Excellent";
        else if (percentage >= 60)
            return "👍 Good";
        else if (percentage >= 40)
            return "💡 Average";
        else
            return "📘 Try Again";
    }
}

// Player score model
