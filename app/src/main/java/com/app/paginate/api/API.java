package com.app.paginate.api;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import static com.app.paginate.utils.Constants.POST_API;

import android.database.Observable;

import com.app.paginate.model.PostData;
import com.app.paginate.model.RecyclerData;

import java.util.List;

/**
 * Created by ( Eng Ali Al Fayed)
 * Class do : API Interface of Retrofit Client
 * Date 12/29/2020 - 4:53 PM
 */
public interface API {

    @GET(POST_API)
   Call<List<RecyclerData.RecyclerDatum>> getPosts();


}
