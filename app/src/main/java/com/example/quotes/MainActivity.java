package com.example.quotes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private String[] quote= {
            "The only way to do great work is to love what you do. \n - Steve Jobs",
            "Success is not final, failure is not fatal: It is the courage to continue that counts. \n - Winston Churchill",
            "The greatest glory in living lies not in never falling, but in rising every time we fall. \n - Nelson Mandela",
            "Life is what happens when you're busy making other plans. \n - John Lennon",
            "In the end, it's not the years in your life that count. It's the life in your years. \n - Abraham Lincoln",
            "You miss 100% of the shots you don't take. \n - Wayne Gretzky",
            "The purpose of our lives is to be happy. \n - Dalai Lama",
            "Be yourself; everyone else is already taken.\n - Oscar Wilde"

    };
    private TextView quotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            quotes = findViewById(R.id.quotes);
            Button button = findViewById(R.id.button);
            ImageView imageView = findViewById(R.id.share);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(Intent. ACTION_SEND);
                    myIntent.setType("text/plain");
                    String shareBody = "Quote of the day - \n ";
                    String shareSub = quotes.getText().toString();
                    myIntent.putExtra(Intent.EXTRA_SUBJECT, shareBody);
                    myIntent.putExtra(Intent.EXTRA_TEXT, shareSub);
                    startActivity(Intent.createChooser(myIntent, "Share using"));
                }
            });
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   generateRandomQuote();
                }
            });
            return insets;
        });

        }
    private void generateRandomQuote() {
        Random random = new Random();
        int index = random.nextInt(quote.length);
        String randomQuote = quote[index];
        quotes.setText(randomQuote);
    }
// Intent error will be passed
    //
    }
