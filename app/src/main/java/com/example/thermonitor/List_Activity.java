package com.example.thermonitor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class List_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_);

        String[] OS = {"Android", "iPhone", "Windows", "Blackberry", "Linux"};
        ArrayAdapter adapter= new ArrayAdapter<String>(List_Activity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.OS));
        final ListView theListView= (ListView) findViewById(R.id.theListView);
        theListView.setAdapter(adapter);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(List_Activity.this, DeviceDetailActivity.class);
                intent.putExtra("OSversion", theListView.getItemAtPosition(position).toString());
                startActivity(intent);
            }
        });
    }
}
