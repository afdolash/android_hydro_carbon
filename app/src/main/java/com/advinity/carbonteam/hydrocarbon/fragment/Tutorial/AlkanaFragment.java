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
import com.advinity.carbonteam.hydrocarbon.adapter.AlkanaAdapter;
import com.advinity.carbonteam.hydrocarbon.modal.Alkana;
import com.advinity.carbonteam.hydrocarbon.other.ClickListener;
import com.advinity.carbonteam.hydrocarbon.other.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlkanaFragment extends Fragment {

    private List<Alkana> alkanaList = new ArrayList<>();
    private RecyclerView recyclerView;
    private AlkanaAdapter mAdapter;

    public AlkanaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_alkana, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.alkana_recycleview);

        mAdapter = new AlkanaAdapter(alkanaList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareAlkanaData();

        return view;
    }

    private void prepareAlkanaData() {
        Alkana alkana = new Alkana("Metana", "metana", "more");
        alkanaList.add(alkana);

        alkana = new Alkana("Etana", "etana", "more");
        alkanaList.add(alkana);

        alkana = new Alkana("Propana", "propana", "more");
        alkanaList.add(alkana);

        alkana = new Alkana("Butana", "butana", "more");
        alkanaList.add(alkana);

        alkana = new Alkana("Pentana", "pentana", "more");
        alkanaList.add(alkana);

        alkana = new Alkana("Heksana", "heksana", "more");
        alkanaList.add(alkana);

        alkana = new Alkana("Heptana", "heptana", "more");
        alkanaList.add(alkana);

        alkana = new Alkana("Oktana", "oktana", "more");
        alkanaList.add(alkana);

        alkana = new Alkana("Nonana", "nonana", "more");
        alkanaList.add(alkana);

        alkana = new Alkana("Dekana", "dekana", "more");
        alkanaList.add(alkana);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Alkana alkana = alkanaList.get(position);

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
