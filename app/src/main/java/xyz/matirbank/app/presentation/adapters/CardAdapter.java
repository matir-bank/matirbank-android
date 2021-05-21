package xyz.matirbank.app.presentation.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;
import java.util.List;

import xyz.matirbank.app.R;
import xyz.matirbank.app.api.entities.cards.responses.CardResponse;
import xyz.matirbank.app.databinding.ItemCreditCardBinding;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.MyViewHolder> {

    Context context;
    List<CardResponse> cardResponseList;

    public CardAdapter(Context context, List<CardResponse> cardResponseList) {
        this.context = context;
        this.cardResponseList = cardResponseList;
    }

    protected class MyViewHolder extends RecyclerView.ViewHolder {
        ItemCreditCardBinding binding;
        public MyViewHolder(ItemCreditCardBinding b){
            super(b.getRoot());
            binding = b;
        }
    }

    @NonNull
    @NotNull
    @Override
    public CardAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CardAdapter.MyViewHolder(ItemCreditCardBinding.inflate(LayoutInflater.from(context), parent, false));
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onBindViewHolder(@NonNull @NotNull CardAdapter.MyViewHolder holder, int position) {
        holder.binding.txtName.setText(processName(cardResponseList.get(position).getName()));
        holder.binding.txtNumber.setText(processNumber(cardResponseList.get(position).getCardNo()));
        holder.binding.txtExpireDate.setText(processValidity(cardResponseList.get(position).getValidity()));

        if(position % 4 == 0) {
            holder.binding.layoutContainer.setBackground(context.getDrawable(R.drawable.background_dark_abstract_04));
        } else if(position % 3 == 0) {
            holder.binding.layoutContainer.setBackground(context.getDrawable(R.drawable.background_dark_abstract_03));
        } else if(position % 2 == 0) {
            holder.binding.layoutContainer.setBackground(context.getDrawable(R.drawable.background_dark_abstract_02));
        } else {
            holder.binding.layoutContainer.setBackground(context.getDrawable(R.drawable.background_dark_abstract_01));
        }
    }

    // TODO: Add Functionality
    String processName(String input) {
        return input.toUpperCase();
    }

    // TODO: Add Functionality
    String processNumber(String input) {
        return input.toUpperCase();
    }

    // TODO: Add Functionality
    String processValidity(String input) {
        return input.toUpperCase();
    }

    @Override
    public int getItemCount() {
        return cardResponseList.size();
    }
}
