package com.example.ehayes.fioschannels;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by ehayes on 9/24/2014.
 */
public class Message {

    public static void message(Context context, String message){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }
}
