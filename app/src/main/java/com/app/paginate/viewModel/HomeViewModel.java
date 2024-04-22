package com.app.paginate.viewModel;

import android.app.Application;


import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.app.paginate.repository.RetrofitRepository;

/**
 * Created by ( Eng Ali Al Fayed)
 * Class do :
 * Date 12/29/2020 - 4:51 PM
 */
public class HomeViewModel extends AndroidViewModel {

    private RetrofitRepository retrofitRepository;
    private MutableLiveData<Object>topMoviesFirstPageResponse = new MutableLiveData<>();

    public HomeViewModel(@NonNull Application application) {
        super(application);
        retrofitRepository = RetrofitRepository.getInstance(application);
    }

    public void requestPosts(){
        retrofitRepository.loadPage(topMoviesFirstPageResponse);
    }

    public LiveData<Object> getFirstPage(){
        return topMoviesFirstPageResponse;
    }

}
