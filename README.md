# University Database App - Lab Sheet 06

Spring Boot, MySQL, JPA and REST API submission for **COSC32133 / BECS32263 - Full-Stack Software Development**.

## Prerequisites

- JDK 17 or 21
- Maven 3.9+
- XAMPP MySQL/MariaDB or MySQL Server
- An IDE with Lombok annotation processing enabled

## Database setup

Start MySQL, then use phpMyAdmin's **SQL** tab or MySQL Workbench.

1. Run `sql/anomaly-demo.sql` and inspect `registration_flat` for Task 2.
2. Run the individual statements in `sql/anomaly-tests.sql` **one at a time** and take the Task 2 screenshots.
3. Before creating the normalized schema, run `USE university_db; DROP TABLE registration_flat;`.
4. Run `sql/schema.sql` on the empty database, then run `sql/data.sql`.
5. Run `sql/join-check.sql` to confirm that the five tables recreate the original seven registrations.
6. Run every statement in `sql/schema-violations.sql` **one at a time** for Task 5. The first eight statements must fail; the final `ALTER TABLE` statements demonstrate an intentional schema change and restore the database afterwards.

The scripts expect newly-created, empty normalized tables. If you need a completely fresh run, drop `university_db` manually in phpMyAdmin/Workbench and repeat the ordered setup above.

## Run the application

The database must already exist because `spring.jpa.hibernate.ddl-auto=validate` deliberately prevents Hibernate from creating or changing it.

```powershell
mvn spring-boot:run
```

When startup finishes, open [http://localhost:8080](http://localhost:8080) to use the dashboard frontend. It displays the same read-only repository queries required for Task 12. The JSON endpoints remain available under `/api`.

### Frontend preview without MySQL

If MySQL is not available yet, run the separate H2 in-memory preview profile. It loads the same sample data and is only for viewing/testing the dashboard; use the default MySQL profile for all lab screenshots and submission evidence.

```powershell
mvn spring-boot:run "-Dspring-boot.run.profiles=demo"
```

For XAMPP defaults the connection uses MySQL user `root` with an empty password. If your MySQL password is not empty, copy `src/main/resources/secrets.properties.example` to `secrets.properties` locally and replace the placeholder value. That file is ignored by Git.

## API endpoints

| URL | Expected result |
| --- | --- |
| `http://localhost:8080/api/students` | Four students sorted by name |
| `http://localhost:8080/api/students?name=sil` | Kamal Silva |
| `http://localhost:8080/api/students/S001` | Kamal Silva |
| `http://localhost:8080/api/students/S001/enrollments` | CS101 and CS102 enrollments |
| `http://localhost:8080/api/courses` | Four courses with lecturer and department |
| `http://localhost:8080/api/courses?minCredits=4` | CS201 only |
| `http://localhost:8080/api/courses?department=Computer%20Science` | CS101, CS102 and CS201 |
| `http://localhost:8080/api/courses/CS101/students` | Kamal Silva and Nimali Perera |
| `http://localhost:8080/api/departments/D01/lecturers` | Dr. Perera and Dr. Fernando |
| `http://localhost:8080/api/enrollments?grade=A` | S001/CS101 and S004/CS201 |
| `http://localhost:8080/api/reports/course-counts` | CS101: 2, CS102: 2, ST201: 2, CS201: 1 |

## Submission support

- `docs/lab-answers.md` contains the written answers for normalization Tasks 2 and 3, along with an ER diagram.
- `docs/screenshots.md` is the exact screenshot checklist for the final PDF.
