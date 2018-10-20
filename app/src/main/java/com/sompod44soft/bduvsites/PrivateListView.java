package com.sompod44soft.bduvsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class PrivateListView extends AppCompatActivity {
    public String[] PrivateUniversitys;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private_list_view);

        listView = findViewById(R.id.listviewid);
        PrivateUniversitys = getResources().getStringArray(R.array.Private_University);

        CustomAdaptor customAdaptor = new CustomAdaptor(this,PrivateUniversitys); // This is Custom Adaptor
        listView.setAdapter(customAdaptor);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) { // int i here position of listview item
                Intent intent =  new Intent(PrivateListView.this,PrivateWebView.class);
                intent.putExtra("key_value",i);
                startActivity(intent);

            }
        });

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
                Intent intent = new Intent(PrivateListView.this,FeedBack.class);
                startActivity(intent);
            }catch (Exception e){
                Toast.makeText(this, ""+e, Toast.LENGTH_SHORT).show();
            }

        }
        return super.onOptionsItemSelected(item);
    }
}
