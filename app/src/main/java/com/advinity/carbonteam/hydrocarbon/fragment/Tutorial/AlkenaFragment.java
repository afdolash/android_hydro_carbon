package com.advinity.carbonteam.hydrocarbon.fragment.Tutorial;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.advinity.carbonteam.hydrocarbon.R;
import com.advinity.carbonteam.hydrocarbon.activity.DescriptionActivity;
import com.advinity.carbonteam.hydrocarbon.adapter.AlkenaAdapter;
import com.advinity.carbonteam.hydrocarbon.modal.Alkena;
import com.advinity.carbonteam.hydrocarbon.other.ClickListener;
import com.advinity.carbonteam.hydrocarbon.other.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlkenaFragment extends Fragment {

    private List<Alkena> alkenaList = new ArrayList<>();
    private RecyclerView recyclerView;
    private AlkenaAdapter mAdapter;

    public AlkenaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_alkena, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.alkena_recycleview);

        mAdapter = new AlkenaAdapter(alkenaList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareAlkenaData();
        
        return view;
    }

    private void prepareAlkenaData() {
        Alkena alkena = new Alkena("Etena", "etena", "more");
        alkenaList.add(alkena);

        alkena = new Alkena("Propena", "propena", "more");
        alkenaList.add(alkena);

        alkena = new Alkena("Butena", "butena", "more");
        alkenaList.add(alkena);

        alkena = new Alkena("Pentena", "pentena", "more");
        alkenaList.add(alkena);

        alkena = new Alkena("Heksena", "heksena", "more");
        alkenaList.add(alkena);

        alkena = new Alkena("Heptena", "heptena", "more");
        alkenaList.add(alkena);

        alkena = new Alkena("Oktena", "oktena", "more");
        alkenaList.add(alkena);

        alkena = new Alkena("Nonena", "nonena", "more");
        alkenaList.add(alkena);

        alkena = new Alkena("Dekena", "dekena", "more");
        alkenaList.add(alkena);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Alkena alkana = alkenaList.get(position);

                Toast.makeText(getContext(), alkana.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getActivity(), DescriptionActivity.class);
                intent.putExtra("title", alkana.getTitle());
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }
}
