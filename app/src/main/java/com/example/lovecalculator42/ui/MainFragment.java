package com.example.lovecalculator42.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lovecalculator42.App;
import com.example.lovecalculator42.R;
import com.example.lovecalculator42.databinding.FragmentMainBinding;
import com.example.lovecalculator42.network.LoveModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainFragment extends Fragment {
    NavController navController;
    FragmentMainBinding binding;
    private final String Host = "love-calculator.p.rapidapi.com";
    private static final String KEY = "45b28df03fmsh8eeb628c6f29d40p1d202bjsn47081ca0dc87";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initClickers();
        navController = NavHostFragment.findNavController(this);
    }

    private void initClickers() {
        binding.tryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDataFromLoveApi();
            }
        });
    }

    private void getDataFromLoveApi() {
        String firstName = binding.firstNameEd.getText().toString();
        String secondName = binding.secondNameEd.getText().toString();
        App.api.loveCalculate(firstName,secondName,Host,KEY).enqueue(new Callback<LoveModel>() {
            @Override
            public void onResponse(Call<LoveModel> call, Response<LoveModel> response) {
                if (response.isSuccessful()) {
                    Bundle bundle = new Bundle();

                    bundle.putString("firstName",response.body().firstName);
                    bundle.putString("secondName",response.body().secondName);
                    bundle.putString("percent",response.body().percentage);
                    bundle.putString("result",response.body().result);

                    navController.navigate(R.id.resultFragment,bundle);
                }

            }

            @Override
            public void onFailure(Call<LoveModel> call, Throwable t) {
                Log.e("ololo", "onFailure: " +t.getLocalizedMessage() );
            }
        });
    }
}