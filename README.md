# 🧠 Focus Tracker (Java)

A simple **console-based study tracker** built in Java that helps users track study sessions, measure productivity, and stay consistent with their goals.

---

## 🚀 Features

* ⏱️ Start and end study sessions
* 📊 Track total study time
* 🔢 Count number of sessions
* 📈 View average session duration
* 🎯 Set a study goal (in minutes)
* 🔄 Reset progress anytime
* ⚡ Live session tracking while running

---

## 🛠️ Tech Stack

* **Language:** Java
* **Concepts Used:**

  * Object-Oriented Programming (OOP)
  * Loops & Conditional Logic
  * User Input Handling (`Scanner`)
  * Time Tracking (`System.currentTimeMillis()`)

---

## 📂 Project Structure

```
focus-tracker-java/
│── Main.java       # Main application logic
│── README.md
```

---

## ⚙️ How It Works

The program runs in a loop and provides a menu:

```
1. Start Study Session
2. End Study Session
3. View Progress
4. Set Study Goal
5. Reset Progress
6. Exit
```

### 💡 Key Logic

* Uses system time to calculate session duration
* Converts milliseconds → seconds → minutes
* Stores:

  * Total study time
  * Number of sessions
  * Study goal

---

## ▶️ How to Run

### 1. Clone the repo

```bash
git clone https://github.com/rudytheacecoder18/focus-tracker-java.git
cd focus-tracker-java
```

### 2. Compile

```bash
javac Main.java
```

### 3. Run

```bash
java Main
```

---

## 🎯 Example Output

```
===== STUDY TRACKER =====
1. Start Study Session
2. End Study Session
3. View Progress
4. Set Study Goal (minutes)
5. Reset Progress
6. Exit
```

---

## 📌 Use Cases

* Students tracking study time
* Developers tracking coding sessions
* Anyone building focus habits

---

## 🧩 Future Improvements

* Add GUI (JavaFX or Swing)
* Save progress to file/database
* Add Pomodoro timer mode
* Add daily/weekly analytics
* Export reports

---

## 🤝 Contributing

Contributions are welcome!
Feel free to fork this repo and submit a pull request.

---

## 👤 Author

* GitHub: https://github.com/rudytheacecoder18

---

## ⭐ If you like this project

Give it a star ⭐ and share it!
