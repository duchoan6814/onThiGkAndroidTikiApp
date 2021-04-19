package com.example.tikiapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CountQuatity#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CountQuatity extends Fragment {
    private ImageButton btnRemove, btnAdd;
    private TextView tvQuatity;
    private OnHandleCount onHandleCount;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private int mParam1;

    public CountQuatity() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment CountQuatity.
     */
    // TODO: Rename and change types and number of parameters
    public static CountQuatity newInstance(int param1) {
        CountQuatity fragment = new CountQuatity();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            onHandleCount = (OnHandleCount) context;
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_count_quatity, container, false);
        btnRemove = view.findViewById(R.id.btnRemove);
        btnAdd = view.findViewById(R.id.btnAdd);
        tvQuatity = view.findViewById(R.id.tvQuatity);

        tvQuatity.setText(""+this.mParam1);

        btnRemove.setOnClickListener(v -> handleButtonRemove());
        btnAdd.setOnClickListener(v -> handleButtonAdd());
        return view;
    }

    private void handleButtonAdd() {
        mParam1 += 1;
        onHandleCount.onClickButtonCount(mParam1);
        tvQuatity.setText(""+mParam1);
    }

    private void handleButtonRemove() {
        if (mParam1 > 0){
            mParam1 -= 1;
            onHandleCount.onClickButtonCount(mParam1);
            tvQuatity.setText(""+mParam1);
        }
    }

    public interface OnHandleCount {
        void onClickButtonCount(int quatity);
    }
}