package com.demo.listeners;

import com.demo.model.DataModel;

import retrofit2.Call;
import retrofit2.http.GET;

import static com.demo.utils.AppConstants.URL;

/**
 * Created by vijayaraj_s on 18/07/18.
 */

public interface ApiInterface {

    /**
     * @return requested api url data
     */
    @GET(URL)
    Call<DataModel> getData();

}
