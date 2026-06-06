CREATE DATABASE IF NOT EXISTS plotease;
USE plotease;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    student_id VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE schedules (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,

    subject_code VARCHAR(20) NOT NULL,
    subject_name VARCHAR(100) NOT NULL,
    course VARCHAR(50) NOT NULL,

    year_level INT NOT NULL,
    section VARCHAR(10) NOT NULL,
    semester INT NOT NULL,

    day1 VARCHAR(20) NOT NULL,
    day2 VARCHAR(20),

    time_slot VARCHAR(50) NOT NULL,
    room VARCHAR(50),

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (user_id) REFERENCES users(id)
);


INSERT INTO users (full_name, student_id, email, password)
VALUES ('Juan Dela Cruz', '2026-001', 'juan@email.com', '12345');

INSERT INTO schedules (
    user_id,
    subject_code,
    subject_name,
    course,
    year_level,
    section,
    semester,
    day1,
    day2,
    time_slot,
    room
)
VALUES (
    1,
    'IT101',
    'Introduction to Computing',
    'BSIT',
    1,
    'A',
    1,
    'Monday',
    'Wednesday',
    '7:00 AM - 8:30 AM',
    'Room 101'
);