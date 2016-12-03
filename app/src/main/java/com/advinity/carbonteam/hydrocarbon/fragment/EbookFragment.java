package com.advinity.carbonteam.hydrocarbon.fragment;


import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.advinity.carbonteam.hydrocarbon.R;
import com.advinity.carbonteam.hydrocarbon.activity.DescriptionActivity;
import com.advinity.carbonteam.hydrocarbon.activity.EbookDetailsActivity;
import com.advinity.carbonteam.hydrocarbon.adapter.EbookAdapter;
import com.advinity.carbonteam.hydrocarbon.modal.Alkana;
import com.advinity.carbonteam.hydrocarbon.modal.Ebook;
import com.advinity.carbonteam.hydrocarbon.other.ClickListener;
import com.advinity.carbonteam.hydrocarbon.other.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EbookFragment extends Fragment {

    private ImageView thumbnail;
    private RecyclerView recyclerView;
    private EbookAdapter adapter;
    private List<Ebook> ebookList;

    public EbookFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ebook, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.ebook_recyclerview);

        ebookList = new ArrayList<>();
        adapter = new EbookAdapter(getActivity(), ebookList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(3, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareEbook();

        return view;
    }

    private int dpToPx(int dp) {
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics()));
    }

    private class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view);
            int column = position % spanCount;

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    private void prepareEbook() {
        int[] covers = new int[] {
                R.drawable.ic_alkena_24dp,
                R.drawable.ic_alkana_24dp,
                R.drawable.ic_alkuna_24dp,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher
        };

        Ebook ebook = new Ebook("True Romance", "13", covers[0]);
        ebookList.add(ebook);

        ebook = new Ebook("Xscpae", "8", covers[1]);
        ebookList.add(ebook);

        ebook = new Ebook("Maroon 5", "11", covers[2]);
        ebookList.add(ebook);

        ebook = new Ebook("Born to Die", "12", covers[3]);
        ebookList.add(ebook);

        ebook = new Ebook("Honeymoon", "14", covers[4]);
        ebookList.add(ebook);

        ebook = new Ebook("I Need a Doctor", "1", covers[5]);
        ebookList.add(ebook);

        ebook = new Ebook("Loud", "11", covers[6]);
        ebookList.add(ebook);

        ebook = new Ebook("Legend", "14", covers[7]);
        ebookList.add(ebook);

        ebook = new Ebook("Abcdefghijklmnopqrstuvwxyz", "11", covers[8]);
        ebookList.add(ebook);

        ebook = new Ebook("Greatest Hits", "17", covers[9]);
        ebookList.add(ebook);

        adapter.notifyDataSetChanged();
    }
}
