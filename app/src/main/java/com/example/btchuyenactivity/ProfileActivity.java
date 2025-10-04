package com.example.btchuyenactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    ImageView ivSettings;
    TextView tvProfileName, tvFriends, tvFollowers;
    TextView tvEmail, tvPhone, tvSkype, tvWeb;
    TextView tvBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        ivSettings = findViewById(R.id.ivSettings);
        tvProfileName = findViewById(R.id.tvProfileName);
        tvFriends = findViewById(R.id.tvFriends);
        tvFollowers = findViewById(R.id.tvFollowers);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);
        tvSkype = findViewById(R.id.tvSkype);
        tvWeb = findViewById(R.id.tvWeb);
        tvBack = findViewById(R.id.tvBack);

        // Lấy dữ liệu từ Intent
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String email = intent.getStringExtra("email");

        if (username != null) {
            tvProfileName.setText(username);
            tvSkype.setText("Skype : " + username);
        } else {
            tvProfileName.setText("Profile Name");
        }

        if (email != null) {
            tvEmail.setText("Email : " + email);
        }

        // Bạn có thể thay bằng giá trị thật nếu có
        tvFriends.setText("125\nFriends");
        tvFollowers.setText("250\nFollowers");
        tvPhone.setText("Phone : +84 123 456 789");
        tvWeb.setText("Web : yoursite.com");

        // Khi ấn Settings (bánh răng) thì về lại Login
        ivSettings.setOnClickListener(v -> {
            // Clear stack và về Login
            Intent backToLogin = new Intent(ProfileActivity.this, LoginActivity.class);
            backToLogin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(backToLogin);
            finish();
        });

        // Tùy chọn: nhấn Back text cũng finish
        tvBack.setOnClickListener(v -> finish());
    }
}
