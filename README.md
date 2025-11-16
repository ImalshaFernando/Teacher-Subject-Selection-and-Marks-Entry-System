# Teacher Subject Selection and Marks Entry System

A web-based system designed to allow teachers to efficiently select subjects and enter student marks. The system is secure, user-friendly, and scalable for future enhancements such as analytics or grade reporting.

---

## Problem Approach

The system is designed to simplify the mark-entry process while ensuring data integrity and scalability. It is divided into three primary layers:

- **Frontend (User Interface)**: Web interface for teachers to interact with the system.  
- **Backend (Application Logic)**: Handles authentication, data validation, and business logic.  
- **Database (Data Storage)**: Stores information about teachers, subjects, students, enrollments, and marks.  

---

## Step-by-Step Approach

1. **Requirement Understanding**
   1. Teacher logs into the system.
   2. Teacher selects a class and subject.
   3. System displays the list of students enrolled in that subject.
   4. Teacher enters or updates marks for each student.
   5. Marks are safely stored in the database after verification.

2. **Goal**
   - Simplify the mark-entry process.
   - Prevent incorrect or duplicate data entry.
   - Ensure the system is expandable for future features like analytics or grade reports.

3. **Main Focus Areas**
   - **Usability**: Provide a clear and easy-to-use interface for teachers.  
   - **Data Integrity**: Validate data on both frontend and backend.  
   - **Scalability**: Efficient design to handle multiple subjects and classes.

---

## Solution Design

### System Architecture

- **Frontend**: Built using React or Angular.  
- **Backend**: Developed using Spring Boot or Node.js (Express).  
- **Database**: Managed with MySQL or PostgreSQL.  

### Workflow

1. **Authentication**
   - Teachers log in using JWT or session-based authentication.
   - System retrieves only subjects assigned to that teacher.

2. **Subject & Student Selection**
   - Teacher selects a subject from a dropdown.
   - System fetches enrolled students dynamically from the backend.

3. **Marks Entry Form**
   - Responsive table view lists students with editable fields for marks.
   - Client-side validation ensures marks are within a valid range (e.g., 0–100).

4. **Backend Processing**
   - Backend receives marks data via POST request.
   - Validates the data and updates the database.
   - Returns a confirmation message.

5. **Database Design**
   - **Teacher** (`teacher_id`, `name`, `email`)  
   - **Subject** (`subject_id`, `name`, `teacher_id`)  
   - **Student** (`student_id`, `name`, `class`)  
   - **Enrollment** (`student_id`, `subject_id`)  
   - **Marks** (`mark_id`, `student_id`, `subject_id`, `marks`, `updated_by`, `updated_at`)  

**Example Data Flow**  
Teacher selects “Mathematics” → System fetches students from Enrollment → Teacher enters marks → Backend validates and saves marks in the Marks table.

---

## Features
- Easy and intuitive marks entry for teachers.
- Dynamic fetching of enrolled students per subject.
- Validation to prevent invalid data entry.
- Secure authentication and role-based access.
- Scalable architecture to support multiple subjects, classes, and teachers.
