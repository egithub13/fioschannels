package com.example.ehayes.fioschannels;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by ehayes on 9/24/2014.
 */
public class FragmentChoice extends Fragment {

    Button sportsButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_choice,container,false);

        sportsButton = (Button) v.findViewById(R.id.sportsButton);
        sportsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new FragmentSports();
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.container,fragment);
                transaction.addToBackStack("FragmentChoice");
                transaction.commit();

            }
        });

        return v;
    }
}
