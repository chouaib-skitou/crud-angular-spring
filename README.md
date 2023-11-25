
# Angular 17 and Spring Boot Project

This README provides instructions for setting up and running the Angular 17 and Spring Boot project. The project is divided into two main parts: the frontend, built with Angular 17, and the backend, developed using Spring Boot.

## Prerequisites

Before starting, ensure you have the following installed:

- **Java**: Required for running the Spring Boot backend.
- **Node.js**: Needed for the Angular frontend.
- **Maven**: For managing and building the Spring Boot project.

## Backend Setup (Spring Boot)

1. **Navigate to the backend directory**:
   ```bash
   cd ./backend
   ```

2. **Build the project using Maven**:
   ```bash
   mvn clean install
   ```

3. **Run the Spring Boot application**:
   ```bash
   mvn spring-boot:run
   ```

This will start the backend server, usually on `http://localhost:8080`.

## Frontend Setup (Angular 17)

1. **Navigate to the frontend directory**:
   ```bash
   cd ./frontend
   ```

2. **Install dependencies**:
   ```bash
   npm install
   ```

3. **Serve the Angular application**:
   ```bash
   ng serve
   ```

This will start the Angular application, typically available at `http://localhost:4200`.

## Usage

After starting both the backend and frontend, you can access the Angular application through your browser at `http://localhost:4200`. The application will communicate with the Spring Boot backend running on `http://localhost:8080`.

## Additional Notes

- Ensure that both the backend and frontend ports are available and not being used by other applications.
- For more detailed instructions or project-specific commands, refer to the documentation available in each project's directory (`frontend` and `backend`).
