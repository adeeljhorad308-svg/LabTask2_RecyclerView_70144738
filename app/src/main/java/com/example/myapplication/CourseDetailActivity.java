package com.example.myapplication;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CourseDetailActivity extends AppCompatActivity {

    public static final String EXTRA_CODE = "extra_code";
    public static final String EXTRA_TITLE = "extra_title";
    public static final String EXTRA_INSTRUCTOR = "extra_instructor";
    public static final String EXTRA_EMAIL = "extra_email";
    public static final String EXTRA_CREDIT_HOURS = "extra_credit_hours";
    public static final String EXTRA_DESCRIPTION = "extra_description";

    private String instructorEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        TextView tvDetailCode = findViewById(R.id.tvDetailCode);
        TextView tvDetailTitle = findViewById(R.id.tvDetailTitle);
        TextView tvDetailInstructor = findViewById(R.id.tvDetailInstructor);
        TextView tvDetailCreditHours = findViewById(R.id.tvDetailCreditHours);
        TextView tvDetailDescription = findViewById(R.id.tvDetailDescription);
        Button btnEmailInstructor = findViewById(R.id.btnEmailInstructor);

        Intent intent = getIntent();
        if (intent != null) {
            String code = intent.getStringExtra(EXTRA_CODE);
            String title = intent.getStringExtra(EXTRA_TITLE);
            String instructor = intent.getStringExtra(EXTRA_INSTRUCTOR);
            instructorEmail = intent.getStringExtra(EXTRA_EMAIL);
            int creditHours = intent.getIntExtra(EXTRA_CREDIT_HOURS, 0);
            String description = intent.getStringExtra(EXTRA_DESCRIPTION);

            if (code != null) {
                setTitle(code);
            }

            tvDetailCode.setText(code);
            tvDetailTitle.setText(title);
            tvDetailInstructor.setText(instructor);
            tvDetailCreditHours.setText("Credit Hours: " + creditHours);
            tvDetailDescription.setText(description);
        }

        btnEmailInstructor.setOnClickListener(v -> sendEmailToInstructor());
    }

    private void sendEmailToInstructor() {
        if (instructorEmail == null || instructorEmail.isEmpty()) {
            Toast.makeText(this, "No email address found for instructor", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:" + instructorEmail));

        try {
            startActivity(emailIntent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "No email application available", Toast.LENGTH_SHORT).show();
        }
    }
}
