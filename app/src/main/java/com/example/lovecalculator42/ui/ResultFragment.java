package com.example.lovecalculator42.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.lovecalculator42.databinding.FragmentResultBinding;

public class ResultFragment extends Fragment {
    FragmentResultBinding binding;
    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentResultBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = NavHostFragment.findNavController(this);
        getArgumentsAndSet();
        initClick();
    }

    private void initClick() {

        binding.tryAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigateUp();
            }
        });
    }

    private void getArgumentsAndSet() {
        String firstName = getArguments().getString("firstName");
        String secondName = getArguments().getString("secondName");
        String percent = getArguments().getString("percent");
        String result = getArguments().getString("result");

        binding.firstName.setText(firstName);
        binding.secondName.setText(secondName);
        binding.percent.setText(percent + "%");
        binding.result.setText(result);
    }
}