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

import com.bibek.twitter.api.UsersAPI;
import com.bibek.twitter.model.Users;
import com.bibek.twitter.response.SignUpResponse;
import com.bibek.twitter.url.URL;

import java.io.File;
import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfilePicture extends AppCompatActivity {
    Button btnDescribeActivity;
    ImageView uploadImage;
    private String name, Email, Password;
    String imagePath;
    String imageName = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_picture);
        btnDescribeActivity = findViewById(R.id.btnDescribeActivity);
        uploadImage = findViewById(R.id.uploadImage);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            name =bundle.getString("Name");
            Email = bundle.getString("email");
            Password = bundle.getString("password");
        }
        btnDescribeActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDescribeActivity.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                         signUp();
                        Intent intent = new Intent(ProfilePicture.this, ConnectActivity.class);
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

    private void signUp(){
        String fullName = name;
        String email = Email;
        String password = Password;

        Users users = new Users(fullName,email,password);
        UsersAPI usersAPI = URL.getInstance().create(UsersAPI.class);
        Call<SignUpResponse> usersCall = usersAPI.registerUser(users);

        usersCall.enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(ProfilePicture.this, "Code" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(ProfilePicture.this, "Sucessfully added", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) {
                Toast.makeText(ProfilePicture.this, "Error" + t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
            }
        });



    }

    }

