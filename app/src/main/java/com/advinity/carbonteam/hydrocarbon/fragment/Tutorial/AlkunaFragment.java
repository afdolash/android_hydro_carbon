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
import com.advinity.carbonteam.hydrocarbon.adapter.AlkunaAdapter;
import com.advinity.carbonteam.hydrocarbon.modal.Alkuna;
import com.advinity.carbonteam.hydrocarbon.other.ClickListener;
import com.advinity.carbonteam.hydrocarbon.other.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlkunaFragment extends Fragment {

    private List<Alkuna> alkunaList = new ArrayList<>();
    private RecyclerView recyclerView;
    private AlkunaAdapter mAdapter;

    public AlkunaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_alkuna, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.alkuna_recycleview);

        mAdapter = new AlkunaAdapter(alkunaList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareAlkunaData();
        
        return view;
    }

    private void prepareAlkunaData() {

        Alkuna alkuna = new Alkuna("Propuna", "propuna", "more");
        alkunaList.add(alkuna);

        alkuna = new Alkuna("Butuna", "butuna", "more");
        alkunaList.add(alkuna);

        alkuna = new Alkuna("Pentuna", "pentuna", "more");
        alkunaList.add(alkuna);

        alkuna = new Alkuna("Heksuna", "heksuna", "more");
        alkunaList.add(alkuna);

        alkuna = new Alkuna("Heptuna", "heptuna", "more");
        alkunaList.add(alkuna);

        alkuna = new Alkuna("Oktuna", "oktuna", "more");
        alkunaList.add(alkuna);

        alkuna = new Alkuna("Nonuna", "nonuna", "more");
        alkunaList.add(alkuna);

        alkuna = new Alkuna("Dekuna", "dekuna", "more");
        alkunaList.add(alkuna);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Alkuna alkena = alkunaList.get(position);

                Toast.makeText(getContext(), alkena.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();

                // Send the data to other activity here
                Intent intent = new Intent(getActivity(), DescriptionActivity.class);
                intent.putExtra("title", alkena.getTitle());

                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }
}
