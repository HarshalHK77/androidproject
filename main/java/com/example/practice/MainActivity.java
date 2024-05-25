package com.example.practice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity {
    Button explicit , implicit ,openWebpage,AsyncTask,Context,ChangeColor,register,RecyclerView ,notify,sharePreference,popup,registerButton;




    //writing a function for connecting menu file to the main file
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menulist,menu);
        return super.onCreateOptionsMenu(menu);
    }
    //writing a method for using menu item as buttons
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.AsyncTask)
        {
            Intent intent = new Intent(MainActivity.this, com.example.practice.AsyncTask.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
    //writing a method for display context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        getMenuInflater().inflate(R.menu.contextmenu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }
    //writing method for showing toast message on clicking item
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.like)
        {
            Toast.makeText(this, "Thanks for liking", Toast.LENGTH_SHORT).show();
        }
        
        return super.onContextItemSelected(item);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        explicit = findViewById(R.id.Explicit);
        implicit = findViewById(R.id.Implicit);
        openWebpage = findViewById(R.id.openWebPage);
        AsyncTask = findViewById(R.id.AsyncTask);
        Context = findViewById(R.id.Context);
        ChangeColor =findViewById(R.id.ChangeColor);
        notify = findViewById(R.id.notify);
        sharePreference = findViewById(R.id.sharePreference);
        popup = findViewById(R.id.popup);
        registerButton =findViewById(R.id.registerButton);
        register =findViewById(R.id.register);
        RecyclerView = findViewById(R.id.RecyclerView);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel channel = new NotificationChannel("My notification","notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        //using explicit intent for opening another activity
        explicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
        //using explicit intent for opening camera
        implicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });
        //using intent for opening an url link
        openWebpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.javatpoint.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);

            }
        });
        registerForContextMenu(Context);

        ChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWindow().getDecorView().setBackgroundColor(Color.GRAY);
            }
        });

        //writing method to give notification
        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,"My notification");
                builder.setContentTitle("Notification");
                builder.setContentText("Hello guys");
                builder.setSmallIcon(R.drawable.logo);
                builder.setAutoCancel(true);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
                managerCompat.notify(1,builder.build());
            }
        });
        sharePreference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,sharedPreferences.class);
                startActivity(intent);
            }
        });
        //writing method for popoup menu
        popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this,popup);
                popupMenu.getMenuInflater().inflate(R.menu.contextmenu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(MainActivity.this, "You Clicked "+item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,registrationForm.class);
                startActivity(intent);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,register.class);
                startActivity(intent);
            }
        });
        RecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RecyclerView.class);
                startActivity(intent);
            }
        });
    }

}