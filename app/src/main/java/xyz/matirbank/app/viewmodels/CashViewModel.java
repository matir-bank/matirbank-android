package xyz.matirbank.app.viewmodels;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import xyz.matirbank.app.api.entities.Types;
import xyz.matirbank.app.api.entities.cash.requests.AddFundRequest;
import xyz.matirbank.app.api.entities.cash.requests.TopUpRequest;
import xyz.matirbank.app.api.entities.cash.requests.TransactionRequest;
import xyz.matirbank.app.repositories.CashRepository;

public class CashViewModel extends AndroidViewModel {

    private final CashRepository cashRepository = new CashRepository();
    private final LiveData<Types.TransactionListResponse> transactionList = new MutableLiveData<>();
    private final LiveData<Types.TransactionResponse> transactionCreate = new MutableLiveData<>();
    private final LiveData<Types.TransactionResponse> transactionDetails = new MutableLiveData<>();
    private final LiveData<Types.AddFundResponse> addFund = new MutableLiveData<>();
    private final LiveData<Types.TransactionResponse> topUp = new MutableLiveData<>();

    public CashViewModel(@NonNull Application application) {
        super(application);
    }

    /* Request */

    public void transactionList(){
        cashRepository.transactionList();
    }

    public void transactionCreate(TransactionRequest request){
        cashRepository.transactionCreate(request);
    }
    public void transactionDetails(int request){
        cashRepository.transactionDetails(request);
    }

    public void addFund(AddFundRequest request){
        cashRepository.addFund(request);
    }

    public void topUp(TopUpRequest request){
        cashRepository.topUp(request);
    }

    public CashRepository getCashRepository() {
        return cashRepository;
    }

    /* Get */

    public LiveData<Types.TransactionListResponse> getTransactionList() {
        return transactionList;
    }

    public LiveData<Types.TransactionResponse> getTransactionCreate() {
        return transactionCreate;
    }

    public LiveData<Types.TransactionResponse> getTransactionDetails() {
        return transactionDetails;
    }

    public LiveData<Types.AddFundResponse> getAddFund() {
        return addFund;
    }

    public LiveData<Types.TransactionResponse> getTopUp() {
        return topUp;
    }

}
