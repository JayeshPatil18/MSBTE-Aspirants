package com.msbteapp.msbtewallah.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.msbteapp.msbtewallah.Branch;
import com.msbteapp.msbtewallah.R;
import com.msbteapp.msbtewallah.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Button btn_co = (Button) view.findViewById(R.id.branch_co);
        Button btn_mech = (Button) view.findViewById(R.id.branch_mech);
        Button btn_elec = (Button) view.findViewById(R.id.branch_elec);
        Button btn_civil = (Button) view.findViewById(R.id.branch_civil);

        btn_co.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Branch.class);
                intent.putExtra("branch_selected", "co");
                startActivity(intent);
            }
        });

        btn_mech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Branch.class);
                intent.putExtra("branch_selected", "mech");
                startActivity(intent);
            }
        });

        btn_elec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Branch.class);
                intent.putExtra("branch_selected", "elec");
                startActivity(intent);
            }
        });

        btn_civil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Branch.class);
                intent.putExtra("branch_selected", "civil");
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}