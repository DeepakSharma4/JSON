package com.example.hp.json;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn1, btn2, btn3;
    private TextView txt1;
    private String strng;
    private StringBuffer buffer;
    String name;
    int id,salary;
private model mm;
    private ArrayList<model> arrylist;  //class pass  as genric
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
arrylist=new ArrayList<model>();
        buffer=new StringBuffer();
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        txt1 = (TextView) findViewById(R.id.txt1);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:

                try {
                    JSONObject obj1 = new JSONObject();
                    obj1.put("id", 101);
                    obj1.put("name", "vikas goyal");
                    obj1.put("salary", 5000);
                    //
                    JSONObject obj2 = new JSONObject();
                    obj2.put("id", 102);
                    obj2.put("name", "deepak");
                    obj2.put("salary", 5000);
                    //
                    JSONArray jsarry = new JSONArray();
                    jsarry.put(obj1);
                    jsarry.put(obj2);
                    //
                    JSONObject employe = new JSONObject();
                    employe.put("employe", jsarry);
                    //
                    strng = employe.toString(); //private string taken
                    txt1.setText(strng);
                    //
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                break;
            case R.id.btn2:

                try {
                    JSONObject obj1 = new JSONObject(strng);
                    //
                    JSONArray jsarry = obj1.getJSONArray("employe");
                    //
                    for (int i = 0; i < jsarry.length(); i++) {
                        JSONObject obj2 = (JSONObject) jsarry.get(i);//
                        //
                         name = obj2.getString("name");
                         id = obj2.getInt("id");
                         salary = obj2.getInt("salary");
                        buffer.append(id+name+salary);
                        mm=new model(id,name,salary);
                        arrylist.add(mm);
                    }
                    Toast.makeText(MainActivity.this,buffer.toString(), Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn3:
                Intent intent = new Intent(MainActivity.this,next.class);
                intent.putParcelableArrayListExtra("key",arrylist);
                startActivity(intent);
                break;
        }
    }
}