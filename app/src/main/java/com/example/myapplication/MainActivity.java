package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CourseAdapter.OnItemClickListener {

    private RecyclerView rvCourses;
    private CourseAdapter courseAdapter;
    private ArrayList<Course> courses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCourses = findViewById(R.id.rvCourses);

        courses = new ArrayList<>();
        courses.add(new Course("SE101", "Introduction to Software Engineering", "Dr. Ali Khan", "ali.khan@uol.edu.pk", "Fundamentals of software engineering principles, lifecycle models, and basic software processes.", 3));
        courses.add(new Course("SE201", "Software Requirement Engineering", "Dr. Sara Ahmed", "sara.ahmed@uol.edu.pk", "Elicitation, analysis, specification, and validation of software requirements for complex systems.", 3));
        courses.add(new Course("SE302", "Software Architecture and Design", "Prof. Usman Tariq", "usman.tariq@uol.edu.pk", "Design patterns, architectural styles, modularity, and high-level software system structuring.", 3));
        courses.add(new Course("CS101", "Programming Fundamentals", "Engr. Hamza Malik", "hamza.malik@uol.edu.pk", "Introduction to programming logic, variables, control structures, and basic algorithms.", 4));
        courses.add(new Course("CS202", "Object Oriented Programming", "Ms. Ayesha Raza", "ayesha.raza@uol.edu.pk", "Core OOP concepts including inheritance, polymorphism, encapsulation, and abstraction.", 4));
        courses.add(new Course("CS301", "Data Structures & Algorithms", "Dr. Bilal Hassan", "bilal.hassan@uol.edu.pk", "Linear and non-linear data structures, searching, sorting, and algorithmic efficiency analysis.", 3));
        courses.add(new Course("SE305", "Software Quality Engineering", "Dr. Zainab Bibi", "zainab.bibi@uol.edu.pk", "Software testing techniques, quality assurance frameworks, verification, and validation.", 3));
        courses.add(new Course("SE401", "Software Project Management", "Prof. Hassan Mahmood", "hassan.mahmood@uol.edu.pk", "Project planning, estimation, risk management, agile methodologies, and team leadership.", 3));
        courses.add(new Course("SE402", "Mobile Application Development", "Engr. Omer Farooq", "omer.farooq@uol.edu.pk", "Android app development using Java/Kotlin, UI design, layout managers, and system integration.", 3));

        rvCourses.setLayoutManager(new LinearLayoutManager(this));
        courseAdapter = new CourseAdapter(courses, this);
        rvCourses.setAdapter(courseAdapter);
    }

    @Override
    public void onItemClick(int position) {
        if (position >= 0 && position < courses.size()) {
            Course selectedCourse = courses.get(position);
            Intent intent = new Intent(MainActivity.this, CourseDetailActivity.class);
            intent.putExtra(CourseDetailActivity.EXTRA_CODE, selectedCourse.getCode());
            intent.putExtra(CourseDetailActivity.EXTRA_TITLE, selectedCourse.getTitle());
            intent.putExtra(CourseDetailActivity.EXTRA_INSTRUCTOR, selectedCourse.getInstructor());
            intent.putExtra(CourseDetailActivity.EXTRA_EMAIL, selectedCourse.getEmail());
            intent.putExtra(CourseDetailActivity.EXTRA_CREDIT_HOURS, selectedCourse.getCreditHours());
            intent.putExtra(CourseDetailActivity.EXTRA_DESCRIPTION, selectedCourse.getDescription());
            startActivity(intent);
        }
    }
}
