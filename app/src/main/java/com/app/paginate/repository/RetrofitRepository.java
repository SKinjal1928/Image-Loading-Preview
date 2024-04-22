package com.app.paginate.repository;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.app.paginate.api.API;
import com.app.paginate.api.ApiClient;
import com.app.paginate.model.RecyclerData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ( Eng Ali Al Fayed)
 * Class do :
 * Date 12/29/2020 - 4:51 PM
 */
public class RetrofitRepository {

    private API instanceApi;
    private static RetrofitRepository retrofitRepository;
    private Application application;

    private RetrofitRepository(Application application) {
        this.application = application;
        instanceApi = ApiClient
                .getApiClientInstance(application.getApplicationContext())
                .getRetrofitClient()
                .create(API.class);
    }

    public static RetrofitRepository getInstance(Application app){
          if (retrofitRepository == null){
              retrofitRepository = new RetrofitRepository(app);
          }
          return  retrofitRepository;
    }

    public void loadPage(MutableLiveData<Object> topMoviesResponse){
        instanceApi.getPosts().enqueue(new Callback<List<RecyclerData.RecyclerDatum>>() {
            @Override
            public void onResponse(@NonNull Call< List<RecyclerData.RecyclerDatum>> call,@NonNull Response< List<RecyclerData.RecyclerDatum>> response) {

                if (response.isSuccessful()){
                    topMoviesResponse.setValue(response.body());
                    if( response.body() != null) {
//                        thumbnailsList.addAll(response.body());
                        Log.e("error", response.body().size()+"");
                    }
                }else{
                    topMoviesResponse.setValue("error");
                }
            }

            @Override
            public void onFailure(@NonNull Call< List<RecyclerData.RecyclerDatum>> call,@NonNull Throwable t) {
                topMoviesResponse.setValue(t);
                Log.e("failure", t.getMessage());
            }
        });
    }
}
