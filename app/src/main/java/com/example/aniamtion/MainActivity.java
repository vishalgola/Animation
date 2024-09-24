package com.example.aniamtion;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
TextView txtAmin;
Button button1,button2,button3,button4;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

         txtAmin=findViewById(R.id.text);
         button1=findViewById(R.id.btnTranslate);
         button2=findViewById(R.id.btnAlpha);
         button3=findViewById(R.id.btnRotate);
         button4=findViewById(R.id.btnScale);

         Animation move= AnimationUtils.loadAnimation(this,R.anim.move);
         button1.setOnClickListener(new View.OnClickListener(){
             @Override
             public void onClick(View v) {
                 txtAmin.startAnimation(move);
             }
         });

         Animation alpha= AnimationUtils.loadAnimation(this,R.anim.alpha);
         button2.setOnClickListener(new View.OnClickListener(){
             @Override
             public void onClick(View v) {
                 txtAmin.startAnimation(alpha);
             }
             });

         Animation rotate= AnimationUtils.loadAnimation(this,R.anim.rotate);
         button3.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            txtAmin.startAnimation(rotate);
                                        }
                                    });
         Animation scale= AnimationUtils.loadAnimation(this,R.anim.scale);
         button4.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            txtAmin.startAnimation(scale);
                                        }
                                    });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}