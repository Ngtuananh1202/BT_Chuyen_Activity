package com.example.btchuyenactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etUsername, etPassword, etEmail;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etEmail = findViewById(R.id.etEmail);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            String username = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString();
            String email = etEmail.getText().toString().trim();

            if (username.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Nhập tên người dùng", Toast.LENGTH_SHORT).show();
                return;
            }
            if (password.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Nhập mật khẩu", Toast.LENGTH_SHORT).show();
                return;
            }

            // Nếu user không nhập email thì tạo email mặc định (ví dụ)
            if (email.isEmpty()) {
                email = username + "@example.com";
            }

            // Ở đây demo không gọi server, chỉ chuyển màn hình và truyền dữ liệu
            Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("email", email);
            startActivity(intent);
        });
    }
}