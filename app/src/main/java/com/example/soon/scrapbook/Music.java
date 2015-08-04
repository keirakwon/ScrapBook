package com.example.soon.scrapbook;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by soon on 2015-08-05.
 */
public class Music extends Fragment{
    public static final String ARG_MENU = "menu_num";
    private RecyclerView sRecyclerView;
    public Music(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View rootView = inflater.inflate(R.layout.music, container, false);

        sRecyclerView = (RecyclerView)rootView.findViewById(R.id.recyclerView);

        String drawerMenu = getResources().getStringArray(R.array.favoriteMenuArray)[0];
        getActivity().setTitle(drawerMenu);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        sRecyclerView.setLayoutManager(layoutManager);

        String[] dataset = new String[1];
        dataset[0] = "Singer : IU";

        RecyclerAdapter sAdapter = new RecyclerAdapter(dataset,getActivity());
        sRecyclerView.setAdapter(sAdapter);
        super.onViewCreated(view, savedInstanceState);
    }

}
