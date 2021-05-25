package xyz.matirbank.app.presentation.activities.common;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import xyz.matirbank.app.api.entities.base.MultipartRequest;
import xyz.matirbank.app.databinding.ActivityDashboardBinding;
import xyz.matirbank.app.presentation.viewmodels.DashboardViewModel;

public class DashboardActivity extends AppCompatActivity {

    DashboardViewModel dashboardViewModel;
    public ActivityDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dashboardViewModel = new DashboardViewModel(this);
        initViews();

        dashboardViewModel.getAccountsViewModel().accountSelf();

        // Try to Upload Photo
        BitmapDrawable drawable = (BitmapDrawable) binding.imgIcon.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        MultipartRequest multipartRequestFile = new MultipartRequest();
        multipartRequestFile.addBitmap("image", bitmap);
        dashboardViewModel.getAccountsViewModel().addPhoto(multipartRequestFile.getMultiPart());

        MultipartRequest multipartRequestType = new MultipartRequest();
        multipartRequestType.addValue("type", "NID");
        dashboardViewModel.getAccountsViewModel().addIdCard(multipartRequestType.getMultiPart(), multipartRequestFile.getMultiPart());

    }

    void initViews() {

    }
}