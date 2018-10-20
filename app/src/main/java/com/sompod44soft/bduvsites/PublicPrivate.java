package com.sompod44soft.bduvsites;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class PublicPrivate extends AppCompatActivity implements View.OnClickListener {
private ImageButton imageButton1,imageButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_private);

        imageButton1 = findViewById(R.id.DU_ID);
        imageButton2 = findViewById(R.id.NSU_ID);

        imageButton1.setOnClickListener(this);
        imageButton2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.DU_ID){
            Intent intent = new Intent(this,PublicListView.class);
            startActivity(intent);
        }
        else if(v.getId() == R.id.NSU_ID){
            Intent intent = new Intent(this,PrivateListView.class);
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_for_navigationbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.shareID){
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plane");
            String Subject = "Rent Giant";
            String body = "All Bangladeshi University sites are Here.. \n shahrearislam3@gmail.com";

            intent.putExtra(Intent.EXTRA_SUBJECT,Subject);
            intent.putExtra(Intent.EXTRA_TEXT,body);
            startActivity(Intent.createChooser(intent," Share With"));
        }
        else if(item.getItemId() == R.id.feedbackcID){
            try{
                Intent intent = new Intent(PublicPrivate.this,FeedBack.class);
                startActivity(intent);
            }catch (Exception e){
                Toast.makeText(this, ""+e, Toast.LENGTH_SHORT).show();
            }

        }
        return super.onOptionsItemSelected(item);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBackPressed() {
        this.finishAffinity();
        System.exit(0);
        super.onBackPressed();
    }
}
