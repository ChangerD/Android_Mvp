package com.changer.www.mvp.net.retrofit.request;

import com.changer.www.mvp.entity.MJsonRequest;

import org.json.JSONObject;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by 25340 on 2017/6/5.
 */

public interface TestRetrofit {

    /**
     * 表单请求
     * @param fun
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("testController/{fun}")
    Call<ResponseBody> testRequest_Form(@Path("fun") String fun, @Field("params") String params);

    /**
     * Json格式请求数据
     * @param fun
     * @param params
     * @return
     */
    @POST("{ctrl}/{fun}")
    Call<ResponseBody> testRequest_Json(@Path("ctrl") String ctrl,@Path("fun") String fun, @Body RequestBody params);

    @POST("{ctrl}/{fun}")
    @Multipart
    Call<ResponseBody> testFileUpload(@Path("ctrl") String ctrl,@Path("fun") String fun,@Part MultipartBody.Part file);

    @POST("{ctrl}/{fun}")
    @Multipart
    Call<ResponseBody> testFileUploadArgs(@Path("ctrl") String ctrl,@Path("fun") String fun, @PartMap Map<String, RequestBody> args, @Part MultipartBody.Part file);

    @POST("{ctrl}/{fun}")
    @Multipart
    Call<ResponseBody> testFilesUpload(@Path("ctrl") String ctrl,@Path("fun") String fun,@Part List<MultipartBody.Part> files);

    @POST("{ctrl}/{fun}")
    @Multipart
    Call<ResponseBody> testFilesUploadArgs(@Path("ctrl") String ctrl,@Path("fun") String fun,@PartMap Map<String, RequestBody> args,@Part List<MultipartBody.Part> files);
}
