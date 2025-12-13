# University Management System (Java Swing)

[![Java](https://img.shields.io/badge/Java-11%2B-blue)](https://www.oracle.com/java/)
[![Swing](https://img.shields.io/badge/UI-Swing-orange)](https://docs.oracle.com/javase/tutorial/uiswing/)
[![MySQL](https://img.shields.io/badge/Database-MySQL-brightgreen)](https://www.mysql.com/)

A desktop application built with Java Swing for managing university faculty and student records. It features a graphical interface for data entry, retrieval, and basic administration tasks, backed by a MySQL database.

## Features

- **Splash Screen**: Animated startup screen with university logo and auto-redirect to login after 5 seconds.
- **User Authentication**: Simple username/password login against a MySQL `login` table.
- **Main Dashboard**: Menu bar with options for:
  - **New Entries**: Add Faculty/Student or Apply Leave (placeholder).
  - **View Records**: Display faculty/students in tables with search by ID/Roll No.
  - **Updates**: Placeholder for updating records.
  - **Examinations**: Add/View/Update Results (placeholders).
  - **Fees**: Student fee forms and structures (placeholders).
  - **Utilities**: Launch Calculator/Notepad (Windows-only).
  - **Exit**: Graceful application close.
- **Add Faculty/Student**: Forms with auto-generated IDs, date picker (JDateChooser), combo boxes for courses/departments, and input validation (e.g., 10-digit phone).
- **View Faculty/Student**: JTable-based display using DbUtils, with search, print, add, update (placeholder), and cancel buttons.
- **Database Operations**: CRUD via JDBC; supports random ID generation for uniqueness.

## Technologies Used

- **Core**: Java 8+ (Swing for UI, AWT for events).
- **Database**: MySQL Connector/J (JDBC), JdbcTemplate not used (direct Statement).
- **Libraries**:
  - `com.toedter.calendar.JDateChooser`: For date selection.
  - `net.proteanit.sql.DbUtils`: For ResultSet to JTable conversion.
- **Build**: Plain Java (no Maven/Gradle; compile/run via javac/java).
- **OS Dependencies**: Windows for utilities (calc.exe, notepad.exe).

## Prerequisites

- Java Development Kit (JDK) 8 or higher installed.
- MySQL Server 5.7+ running locally.
- MySQL Connector/J JAR in classpath (for JDBC).
- Additional JARs: `jcalendar-1.4.jar` (for JDateChooser) and `rs2xml.jar` (for DbUtils).

## Installation

1. **Clone/Download**: Download the source files (e.g., `ConnectDb.java`, `Home.java`, etc.) into a project folder (e.g., `UniversityManagement`).

2. **Database Setup**:
   - Create a MySQL database named `universitymanagement`.
   - Run the following SQL to create tables (adjust as needed):
     ```sql
     CREATE DATABASE universitymanagement;
     USE universitymanagement;

     -- Login table
     CREATE TABLE login (
         id INT AUTO_INCREMENT PRIMARY KEY,
         username VARCHAR(50) NOT NULL,
         password VARCHAR(50) NOT NULL
     );
     INSERT INTO login (username, password) VALUES ('admin', 'password'); -- Default credentials

     -- Teacher (Faculty) table
     CREATE TABLE teacher (
         id INT AUTO_INCREMENT PRIMARY KEY,
         name VARCHAR(100) NOT NULL,
         parent VARCHAR(100) NOT NULL,
         email VARCHAR(100),
         address TEXT,
         phone VARCHAR(15),
         fId VARCHAR(20) UNIQUE NOT NULL,
         dob DATE,
         course VARCHAR(50),
         dept VARCHAR(50)
     );

     -- Student table
     CREATE TABLE student (
         id INT AUTO_INCREMENT PRIMARY KEY,
         name VARCHAR(100) NOT NULL,
         parent VARCHAR(100) NOT NULL,
         email VARCHAR(100),
         address TEXT,
         phone VARCHAR(15),
         sId VARCHAR(20) UNIQUE NOT NULL,
         dob DATE,
         course VARCHAR(50),
         dept VARCHAR(50)
     );
