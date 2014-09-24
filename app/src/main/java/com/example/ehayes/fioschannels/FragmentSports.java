package com.example.ehayes.fioschannels;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ehayes on 9/24/2014.
 */
public class FragmentSports extends Fragment implements AdapterView.OnItemClickListener {

    ArrayList<String> sportsChannels;

    ListView list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sports,container,false);

        list = (ListView) v.findViewById(R.id.listView);
        sportsChannels = new ArrayList<String>();
        addChannel("ESPN"); // 0 index
        addChannel("ESPN 2"); // 1 index
        addChannel("Fox Sports 1"); // 2 index
        addChannel("NFL Network"); // 3 index
        addChannel("SEC Network"); // 4 index
        addChannel("NBA TV");
        addChannel("ESPN Classic");
        addChannel("Nascar TV");
        addChannel("ESPN Outdoors");
        addChannel("ESPN Deportes");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,sportsChannels);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);

        return v;
    }

    public void addChannel(String s){
        sportsChannels.add(s);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //TextView temp = (TextView) view;

        switch (i){
            case 0: Intent intent0 = new Intent(Intent.ACTION_VIEW);
                    intent0.setData(Uri.parse("http://www.espn.com"));
                    startActivity(intent0);
                    break;
            case 4: Intent intent4 = new Intent(Intent.ACTION_VIEW);
                    intent4.setData(Uri.parse("http://secsports.go.com/watch"));
                    startActivity(intent4);
                    break;

        }



    }
}
