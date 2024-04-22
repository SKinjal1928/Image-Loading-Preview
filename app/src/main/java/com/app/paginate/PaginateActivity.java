package com.app.paginate;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;

import com.app.paginate.adapter.PaginateAdapter;
import com.app.paginate.databinding.PaginateActivityBinding;
import com.app.paginate.model.RecyclerData;
import com.app.paginate.utils.CheckValidation;
import com.app.paginate.viewModel.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

public class PaginateActivity extends AppCompatActivity {

    PaginateActivityBinding binding;
    private HomeViewModel homeViewModel;
    PaginateAdapter paginateAdapter;
   public ArrayList<RecyclerData.RecyclerDatum> thumbnailsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = PaginateActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (android.os.Build.VERSION.SDK_INT >= 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        homeViewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(HomeViewModel.class);

        initMyOrderRecyclerView();
        observerDataRequest();
    }
    private void initMyOrderRecyclerView() {
        if (CheckValidation.isConnected(this)) {
            homeViewModel.requestPosts();


        }else{
            Toast.makeText(this,"Please check connection..",Toast.LENGTH_LONG).show();
//            showErrorView(null);
        }

        //attach adapter to  recycler
       /* paginateAdapter = new PaginateAdapter(this);
        binding.setAdapterTopMovies(mAdapter);
        binding.recyclerMyOrders.setHasFixedSize(true);
        binding.recyclerMyOrders.setItemAnimator(new DefaultItemAnimator());

        loadFirstPage();

        binding.recyclerMyOrders
                .addOnScrollListener(new  PaginationScrollListener((LinearLayoutManager) binding.recyclerMyOrders.getLayoutManager()) {

                    @Override
                    protected void loadMoreItems() {
                        isLoading = true ;
                        currentPage += 1 ;

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                loadNextPage();
                            }
                        } , 1000);
                    }

                    @Override
                    protected int getTotalPageCount() {
                        return totalPages;
                    }

                    @Override
                    protected boolean isLastPage() {
                        return isLastPage;
                    }

                    @Override
                    protected boolean isLoading() {
                        return isLoading;
                    }
                });*/
    }

    private void observerDataRequest(){
        homeViewModel.getFirstPage().observe(this, it -> {
//            if (it instanceof RecyclerData.RecyclerDatum) {
//                hideErrorView();
//            thumbnailsList = ((RecyclerData) it).getList();
//            thumbnailsList.addAll((RecyclerData.RecyclerDatum) it);
            thumbnailsList =(ArrayList<RecyclerData.RecyclerDatum>) it;
            paginateAdapter = new PaginateAdapter(thumbnailsList, this);
            binding.rvImages.setAdapter(paginateAdapter);
            binding.rvImages.setHasFixedSize(true);
            binding.rvImages.setItemAnimator(new DefaultItemAnimator());
            binding.mainProgress.setVisibility(View.GONE);
        });



    }

    private ArrayList<RecyclerData.RecyclerDatum> fetchResults(RecyclerData moviesTopModel) {
        return moviesTopModel.getList();
    }


}
