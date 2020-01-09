package com.bibek.twitter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ProfilePicture extends AppCompatActivity {
    Button btnDescribeActivity;
    ImageView uploadImage;
    String imagePath;
    String imageName = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_picture);
        btnDescribeActivity = findViewById(R.id.btnDescribeActivity);
        uploadImage = findViewById(R.id.uploadImage);
        btnDescribeActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDescribeActivity.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ProfilePicture.this, DescribeActivity.class);
                        startActivity(intent);
                    }
                });

            }
        });
//
        uploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             loadImage();
            }
        });
    }
    private  void loadImage(){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            if (data == null){
                Toast.makeText(this, "select image", Toast.LENGTH_SHORT).show();
            }
        }
        Uri uri = data.getData();

        imagePath = getRealPathFromURI(uri);
        uploadImage.setImageURI(uri);
        //previewImage(imagePath);
        Toast.makeText(this,"load" +uri,Toast.LENGTH_SHORT);
    }
    private  String getRealPathFromURI(Uri uri){
        String[] projection ={MediaStore.Images.Media.DATA};
        CursorLoader loader = new CursorLoader(getApplicationContext(), uri, projection, null,null,null);
        Cursor cursor = loader.loadInBackground();
        int colIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String result = cursor.getString(colIndex);
        cursor.close();
        return  result;
    }
//    private void saveImageOnly(){
//        File file = new File(imagePath);
//        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"),file);
//        MultipartBody.Part body = MultipartBody.Part.createFormData("imageFile",file.getName(),requestBody);
//
//        UsersAPI usersAPI  = URL.getInstance().create(UsersAPI.class);
//        Call<ImageResponse> responseBodyCall = usersAPI.uploadImage(body);
//
//        StrictModeClass.StrictMode();
//        try {
//
//            Response<ImageResponse> imageResponseResponse = responseBodyCall.execute();
//            imageName = imageResponseResponse.body().getFilename();
//        } catch (IOException e){
//            Toast.makeText(this,"Error " + e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
//        }
//    }

    }

