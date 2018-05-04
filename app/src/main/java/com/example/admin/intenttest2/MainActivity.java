package com.example.admin.intenttest2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button buttonYoutubeCall, buttonCapture;
    EditText editText;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //createIntent1();
        createIntent2();
        createIntent3();

    }

    public void createIntent1(){
        buttonYoutubeCall = findViewById(R.id.btnYoutube);
        editText = findViewById(R.id.editText1);

        //String message = editText.getText().toString();

        // day la implicit intent
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=3ztsB7Zx9xo"));
        startActivity(intent);

    }

    public void createIntent2(){
        buttonYoutubeCall = findViewById(R.id.btnYoutube);

        buttonYoutubeCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel: 987654321"));
                startActivity(intent);

            }
        });
    }

    public void createIntent3(){

        imageView = findViewById(R.id.imageView);
        buttonCapture = findViewById(R.id.btnCapture);


        // search google intent ACTION CALL
        buttonCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);
            }
        });


    }


    //goi ham tao intent capture
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
        imageView.setImageBitmap(bitmap);
    }

}

