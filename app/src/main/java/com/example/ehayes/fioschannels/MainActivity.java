package com.example.ehayes.fioschannels;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {

    EditText name,number;
    SQLiteAdapter helper;
    Button addDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.nameEditText);
        number = (EditText) findViewById(R.id.numberEditText);

        helper = new SQLiteAdapter(this);

    }

    public void addChannel(View view){
        String channelName = name.getText().toString();
        String channelNumber = number.getText().toString();

        long id = helper.insertData(channelName,channelNumber);
        if(id<0){
            Message.message(this,"Unsuccessful");

        }else{
            Message.message(this,"!!!!!YES!!!!!!!!");

        }

        name.setText("");
        number.setText("");
    }

    public void viewDetails(View view){
        String data = helper.getAllData();
        Message.message(this,data);

    }
}
