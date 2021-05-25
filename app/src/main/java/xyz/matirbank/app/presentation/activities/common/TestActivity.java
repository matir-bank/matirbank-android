package xyz.matirbank.app.presentation.activities.common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import xyz.matirbank.app.api.entities.cards.responses.CardResponse;
import xyz.matirbank.app.databinding.ActivityTestBinding;
import xyz.matirbank.app.presentation.adapters.CardAdapter;

public class TestActivity extends AppCompatActivity {

    public ActivityTestBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<CardResponse> cardResponseList = new ArrayList<>();

        CardResponse cardResponse = new CardResponse();
        cardResponse.setCardNo("1234123412341234");
        cardResponse.setName("Jhon Smith");
        cardResponse.setValidity("10/20");

        cardResponseList.add(cardResponse);
        cardResponseList.add(cardResponse);
        cardResponseList.add(cardResponse);
        cardResponseList.add(cardResponse);

        CardAdapter cardAdapter = new CardAdapter(this, cardResponseList);
        binding.recyclerTest.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.recyclerTest.setAdapter(cardAdapter);
    }
}