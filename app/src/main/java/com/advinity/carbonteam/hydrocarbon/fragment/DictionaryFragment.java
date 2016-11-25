package com.advinity.carbonteam.hydrocarbon.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.advinity.carbonteam.hydrocarbon.R;
import com.advinity.carbonteam.hydrocarbon.adapter.DictionaryAdapter;
import com.advinity.carbonteam.hydrocarbon.modal.Dictionary;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DictionaryFragment extends Fragment {

    private List<Dictionary> dictionaryList = new ArrayList<>();
    private RecyclerView recyclerView;
    private DictionaryAdapter mAdapter;

    public DictionaryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dictionary, container, false);

        // Inisialisasi
        recyclerView = (RecyclerView) view.findViewById(R.id.dictionary_recycleview);

        // Setting layout untuk recylerview
        mAdapter = new DictionaryAdapter(dictionaryList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        // Mengisi data dictionary
        prepareDictionaryData();

        return view;
    }

    // Mengisi data dictionary
    private void prepareDictionaryData() {
        Dictionary dictionary = new Dictionary("Metana", "metana");
        dictionaryList.add(dictionary);
    }

}
