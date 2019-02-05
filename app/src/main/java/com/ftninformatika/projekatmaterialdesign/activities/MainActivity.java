package com.ftninformatika.projekatmaterialdesign.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.ftninformatika.projekatmaterialdesign.R;
import com.ftninformatika.projekatmaterialdesign.adapters.RecyclerViewAdapter;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.OnClickListener {

    RecyclerView rvItems;
    String podaci[] = new String[]{"Jedan","Dva","Tri","Cetiri","Pet"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvItems = findViewById(R.id.rv_items);

        //zbog efikasnosti aplikacije
        rvItems.setHasFixedSize(true);

        //Podesimo na koji nacin ce se podaci prikazivati(Linearno / Grid / staggered grid).
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvItems.setLayoutManager(manager);

        // Napravimo i dodelimo adapter Recycler Viewu.
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(podaci,this);
        rvItems.setAdapter(adapter);

    }


    @Override
    public void onClick(String text) {
        Toast.makeText(this,"Kliknuli ste na: " +  text,Toast.LENGTH_SHORT).show();
    }
}
