# AI Chatbot with Smart Email Automation using Gemini API

## Overview

This project is a Java-based AI chatbot powered by the Google Gemini API. It enables users to interact with an AI assistant through natural language and includes an intelligent email automation feature. Users can describe the purpose of an email in plain English, and the chatbot generates a professional subject and email body. After user confirmation, the email is securely sent using Gmail SMTP.

---

## Features

* AI-powered conversational chatbot
* Natural language understanding using Gemini API
* Intelligent email generation
* Email preview before sending
* Secure email delivery using Gmail SMTP
* JSON response parsing using Gson
* Modular Java implementation without frameworks

---

## Technologies Used

* Java
* Google Gemini API
* Jakarta Mail API
* Gson
* HTTPURLConnection
* Gmail SMTP

---

## Project Structure

```
src/
│── Main.java
│── GeminiClient.java
│── ResponseParser.java
│── EmailService.java
│── Config.java

lib/
│── gson-2.10.1.jar
│── jakarta.mail-2.0.2.jar
│── jakarta.activation-2.0.1.jar
```

---

## How It Works

1. User enters a prompt.
2. The chatbot identifies whether it is a normal conversation or an email request.
3. For email requests:

   * Gemini generates a professional subject and body.
   * A preview is displayed.
   * The user enters the recipient email address.
   * After confirmation, the email is sent securely through Gmail SMTP.
4. For other prompts, the chatbot responds using the Gemini API.

---

## Screenshots

Add screenshots of:

* Chat interface
* Email generation preview
* Successful email sent

---

## Setup Instructions

1. Clone the repository.

2. Add the required JAR files inside the `lib` folder.

3. Create a local environment file for your Gemini API key.

4. Compile:

```bash
javac -cp ".;lib/*" src/*.java
```

5. Run:

```bash
java -cp ".;src;lib/*" Main
```

---

## Future Enhancements

* Voice interaction
* Desktop application automation
* File management
* Calendar integration
* Multi-step AI task execution

---

## Author

**Gopika GS**

B.Tech Computer Science and Engineering
