package com.example.soon.scrapbook;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by soon on 2015-08-05.
 */
public class Psychology extends Fragment{
    public static final String ARG_MENU = "menu_num";
    public Psychology(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.psychology, container, false);

        String drawerMenu = getResources().getStringArray(R.array.favoriteMenuArray)[1];

        getActivity().setTitle(drawerMenu);
        return rootView;
    }
}
