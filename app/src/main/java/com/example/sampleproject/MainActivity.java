package com.example.sampleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nameEdtTxt;
    private Button clickBtn;
    private ImageView imageV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEdtTxt = (EditText) findViewById(R.id.nameEdtTxt);
        clickBtn = (Button) findViewById(R.id.clickBtn);
        imageV = (ImageView) findViewById(R.id.imageView);
        clickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEdtTxt.getText().toString().trim();
                if(name.isEmpty()){
                    nameEdtTxt.setError("Please enter your name first");
                    nameEdtTxt.requestFocus();
                    return;
                }
                int n = (int) (10*(Math.random()));
                String num = String.valueOf(n);
                String image = "@drawable/a"+num;
                int imageResource = getResources().getIdentifier(image,null,getPackageName());
                Drawable res = getResources().getDrawable(imageResource);
                imageV.setImageDrawable(res);
                Toast.makeText(MainActivity.this,name+", an image is set for you!",Toast.LENGTH_SHORT).show();
            }
        });

    }
}