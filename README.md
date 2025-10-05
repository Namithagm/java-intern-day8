🧠 Online Quiz App (Java)

📋 Overview
This is a Java-based Online Quiz Application that allows users to attempt multiple-choice questions, get instant feedback, view their final score, and see a leaderboard with ranks, percentages, and remarks.
Each attempt is saved locally, and players are ranked based on their performance.


✨ Features
✅ Interactive quiz interface with MCQs
✅ Validates user input (only 1–4 options allowed)
✅ Displays score and performance feedback
✅ Saves player results to a local file (quiz_results.txt)
✅ Shows Top 5 players leaderboard
✅ Calculates percentage and remarks for each player
✅ Displays rank and total players count

🧩 Tech Stack
Language: Java
File Handling: For saving scores and leaderboard
Collections: Used ArrayList, List, and sorting
OOP Concepts: Encapsulation, Classes & Objects

⚙ How to Run
1️⃣ Install Java (JDK 17 or above)
Make sure Java is installed and added to your system path.
java -version
2️⃣ Create a new Java file
Save the below code as QuizApp.java in your preferred folder.
3️⃣ Compile and run
javac QuizApp.java
java QuizApp
4️⃣ Play the quiz! 🎯
Enter your name
Answer the questions (1–4)
View your final score, rank, and leaderboard

🗂 File Structure
📁 OnlineQuizApp
 ┣ 📄 QuizApp.java
 ┗ 📄 quiz_results.txt  ← Stores player scores automatically

🧠 Example Output
===== Welcome to the Java Quiz =====
Enter your name: Namitha
1. What is the size of int in Java?
1. A. 4 bytes
2. B. 2 bytes
3. C. 8 bytes
4. D. Depends on OS
Enter your answer (1-4): 1
✅ Correct!

🎯 Quiz Finished!
Player: Namitha
Your Score: 5 / 5
👍 Good Job! Keep Learning!

🗂 Result saved successfully!

===== 🏆 Leaderboard (Top 5) =====
1.Namitha       - 5/5 (100%) - 🌟 Perfect!
2.Asha          - 4/5 (80%)  - 🏅 Excellent
3. Rahul      - 3/5 (60%)  - 👍 Good
4. Meena      - 2/5 (40%)  - 💡 Average
5. Arjun      - 1/5 (20%)  - 📘 Try Again
=================================

🏅 Your Rank: 1 / 5 players

🧮 Ranking Logic
Players are ranked based on their total score (descending).
If two players have the same score, the one who played earlier appears higher.


🏆 Remarks System
Percentage	Remark
100%	🌟 Perfect!
80–99%	🏅 Excellent
60–79%	👍 Good
40–59%	💡 Average
Below 40%	📘 Try Again

💾 Data Storage
All quiz results are automatically stored in a file:
quiz_results.txt
Each entry format:
Name,Score,Total,Timestamp
Example:

Namitha,5,5,1728123456789
Asha,4,5,1728123456900


🚀 Future Enhancements
🔹 Add timer for each question
🔹 Load questions from external file (JSON / CSV)
🔹 GUI version using Swing / JavaFX
🔹 Online database integration (MySQL / PostgreSQL)

👩‍💻 Author

Namitha M
✨ A Java enthusiast passionate about coding, learning, and building smart applications.

📧 Feel free to fork this repo and enhance it!
