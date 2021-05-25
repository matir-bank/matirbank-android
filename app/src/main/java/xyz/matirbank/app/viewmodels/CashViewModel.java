package xyz.matirbank.app.viewmodels;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.List;
import xyz.matirbank.app.api.entities.base.ResponseContainer;
import xyz.matirbank.app.api.entities.cash.requests.AddFundRequest;
import xyz.matirbank.app.api.entities.cash.requests.TopUpRequest;
import xyz.matirbank.app.api.entities.cash.requests.TransactionRequest;
import xyz.matirbank.app.api.entities.cash.responses.AddFundResponse;
import xyz.matirbank.app.api.entities.cash.responses.TransactionResponse;
import xyz.matirbank.app.repositories.CashRepository;

public class CashViewModel extends AndroidViewModel {

    private final CashRepository cashRepository = new CashRepository();
    private final LiveData<ResponseContainer<List<TransactionResponse>>> transactionList = new MutableLiveData<>();
    private final LiveData<ResponseContainer<TransactionResponse>> transactionCreate = new MutableLiveData<>();
    private final LiveData<ResponseContainer<TransactionResponse>> transactionDetails = new MutableLiveData<>();
    private final LiveData<ResponseContainer<AddFundResponse>> addFund = new MutableLiveData<>();
    private final LiveData<ResponseContainer<TransactionResponse>> topUp = new MutableLiveData<>();

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

    public LiveData<ResponseContainer<List<TransactionResponse>>> getTransactionList() {
        return transactionList;
    }

    public LiveData<ResponseContainer<TransactionResponse>> getTransactionCreate() {
        return transactionCreate;
    }

    public LiveData<ResponseContainer<TransactionResponse>> getTransactionDetails() {
        return transactionDetails;
    }

    public LiveData<ResponseContainer<AddFundResponse>> getAddFund() {
        return addFund;
    }

    public LiveData<ResponseContainer<TransactionResponse>> getTopUp() {
        return topUp;
    }

}
