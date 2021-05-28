package xyz.matirbank.app.presentation.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.view.Window;

import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import xyz.matirbank.app.api.entities.cards.responses.CardResponse;
import xyz.matirbank.app.databinding.DialogCardActionBinding;
import xyz.matirbank.app.presentation.adapters.CardAdapter;

public class CardActionDialog {

    public void showDialog(Activity activity, CardResponse cardResponse) {

        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.setCancelable(false);

        DialogCardActionBinding dialogBinding = DialogCardActionBinding.inflate(activity.getLayoutInflater());
        dialog.setContentView(dialogBinding.getRoot());

        List<CardResponse> cardResponseList = new ArrayList<>();
        cardResponseList.add(cardResponse);

        CardAdapter cardAdapter = new CardAdapter(activity, response.getData().getCards());
        activity.binding.cardRecycler.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false));
        activity.binding.cardRecycler.setAdapter(cardAdapter);

    }

}
