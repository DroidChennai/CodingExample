package com.demo.restapicall;

import android.util.Log;

import com.demo.listeners.ApiCallback;
import com.demo.listeners.ApiInterface;
import com.demo.model.DataModel;
import com.demo.model.Row;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.demo.utils.AppConstants.URL;

/**
 * Created by vijayaraj_s on 18/07/18.
 */

public class ApiClient {

    private static final String TAG = ApiClient.class.getSimpleName();

    // Member variable declararion
    private static Retrofit mRetrofit = null;

    /**
     * @param baseUrl pass base url
     * @return Retrofit instance
     */
    public static Retrofit getClient(String baseUrl) {

        // Null Checking
        if (mRetrofit == null) {

            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(100, TimeUnit.SECONDS)
                    .readTimeout(100, TimeUnit.SECONDS).build();

            mRetrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl).client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return mRetrofit;
    }

    /**
     * @param apiCallback Trigger the interface, once data received
     */
    public static void getData(final ApiCallback apiCallback) {

        ApiInterface apiService = ApiClient.getClient(URL).create(ApiInterface.class);

        Call<DataModel> call = apiService.getData();

        call.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {

                List<Row> mData = response.body().getRows();

                if (null != apiCallback && !mData.isEmpty()) {
                    apiCallback.notifySuccess(mData);
                } else {
                    apiCallback.notifyError();
                }
            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
                apiCallback.notifyError();
            }
        });
    }
}
