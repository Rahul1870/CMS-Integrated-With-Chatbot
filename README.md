# CMS-Integrated-With-Chatbot
🔧 Technologies Used
Java (Core + Swing) – For application logic and GUI

MySQL – Backend relational database

JDBC – Java Database Connectivity for data operations

OpenAI ChatGPT API – Integrated chatbot for student and faculty assistance

Swing – Desktop-based GUI development

📌 Project Overview
The College Management System with ChatGPT Integration is a desktop-based Java application designed to streamline and automate various college administrative operations. It features a built-in AI-powered chatbot using the ChatGPT API to provide real-time assistance and answer common user queries.

✨ Key Features
📚 Student Module: Add, update, delete, and view student details.

🧑‍🏫 Faculty Module: Manage faculty information and course assignments.

🗂 Course Management: Handle course details and allocation.

📊 Admin Dashboard: Centralized control panel for all operations.

💬 Chatbot Assistant: ChatGPT-integrated assistant to answer student/faculty FAQs and guide navigation.

🔐 Authentication: Basic login system for authorized access.

📈 Responsive GUI: User-friendly interface built using Java Swing.

🧱 Project Structure
graphql
Copy
Edit
College-Management-System/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── ui/                 # Swing GUI files
│   │   │   ├── database/          # JDBC database connections
│   │   │   ├── chatbot/           # ChatGPT API integration logic
│   │   │   └── models/            # Student, Faculty, Course models
│
├── lib/                          # External dependencies (if any)
├── db/                           # SQL scripts and database schema
├── README.md
└── LICENSE
⚙️ Setup Instructions
Clone the repository

bash
Copy
Edit
git clone https://github.com/yourusername/college-management-chatbot.git
cd college-management-chatbot
Set up MySQL Database

Create a new MySQL database (e.g., college_db)

Run the SQL script provided in the /db folder to create tables

Configure DB Credentials in Code

Update your JDBC connection string, username, and password in the relevant file:

java
Copy
Edit
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college_db", "root", "yourpassword");
Add Your ChatGPT API Key

Store your OpenAI API key in a .env or directly in the code (not recommended for production)

java
Copy
Edit
String apiKey = "sk-xxxxxxx"; // Your OpenAI API key
Run the Application

Open the project in your IDE (e.g., IntelliJ, Eclipse)

Compile and run the Main.java file

💡 Chatbot Capabilities
FAQs related to admissions, results, fee structure, attendance, etc.

Interactive command handling for user guidance

GPT-based conversational support for real-time answers
