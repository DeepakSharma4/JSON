package com.example.hp.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class next extends AppCompatActivity {
    private ListView lst;
    private ArrayList<model> arrylist;
    //  private ArrayAdapter dd;
    private Myadpter dd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        lst = (ListView) findViewById(R.id.listview);
        arrylist = new ArrayList<model>();
        arrylist = getIntent().getParcelableArrayListExtra("key");
        dd = new Myadpter(next.this, arrylist);
        lst.setAdapter(dd);

        // int n=arrylist.get(0);
        //   dd = new ArrayAdapter(next.this, R.layout.support_simple_spinner_dropdown_item, arrylist);
        //  lst.setAdapter(dd);
    }
}
