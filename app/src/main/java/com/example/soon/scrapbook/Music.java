package com.example.soon.scrapbook;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by soon on 2015-08-05.
 */
public class Music extends Fragment{
    public static final String ARG_MENU = "menu_num";
    public Music(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.music, container, false);

        String drawerMenu = getResources().getStringArray(R.array.favoriteMenuArray)[0];

        getActivity().setTitle(drawerMenu);
        return rootView;
    }

}
