package com.changer.www.mvp.demo.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.changer.www.mvp.R;
import com.changer.www.mvp.entity.MJsonRequest;
import com.changer.www.mvp.net.retrofit.request.TestRetrofit;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Demo_Retrofit_Activity extends AppCompatActivity implements View.OnClickListener{

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.0.12:8080/MServer/")
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo__retrofit);
        initView();
        initListener();
    }

    private void initView() {
    }

    private void initListener() {
        findViewById(R.id.rtf_btn_1).setOnClickListener(this);
        findViewById(R.id.rtf_btn_2).setOnClickListener(this);
        findViewById(R.id.rtf_btn_3).setOnClickListener(this);
        findViewById(R.id.rtf_btn_4).setOnClickListener(this);
        findViewById(R.id.rtf_btn_5).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rtf_btn_1:{
                testRequest();
                break;
            }
            case R.id.rtf_btn_2:{
                testFileUpload();
                break;
            }
            case R.id.rtf_btn_3:{
                testFilesUpload();
                break;
            }
            case R.id.rtf_btn_4:{
                testFileUploadArgs();
                break;
            }
            case R.id.rtf_btn_5:{
                testFilesUploadArgs();
                break;
            }
        }
    }

    /**
     * 上传多文件带参
     */
    private void testFilesUploadArgs() {
        TestRetrofit testRequest=retrofit.create(TestRetrofit.class);
        Call<ResponseBody> call= null;
        RequestBody file = RequestBody.create(MediaType.parse("application/octet-stream"), "多文件上传带参");
        List<MultipartBody.Part> files=new ArrayList<>();
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", "test.txt", file);
        files.add(filePart);
        files.add(filePart);
        Map<String, RequestBody> args = new HashMap<>();
        MediaType textType = MediaType.parse("text/plain");
        RequestBody params = RequestBody.create(textType, new Gson().toJson(new MJsonRequest().addParam("name","jwding").getParams()));
        args.put("params",params);
        call=testRequest.testFilesUploadArgs("testController","testUpLoadFile.do",args,files);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Toast.makeText(Demo_Retrofit_Activity.this,response.body().string(),Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                call.request();
            }
        });
    }

    /**
     * 上传单文件带参
     */
    private void testFileUploadArgs() {
        TestRetrofit testRequest=retrofit.create(TestRetrofit.class);
        Call<ResponseBody> call= null;
        //call = testRequest.testRequest_Form("testRequest.do","jwding");
        RequestBody file = RequestBody.create(MediaType.parse("application/octet-stream"), "单文件上传带参");
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", "test.txt", file);
        Map<String, RequestBody> args = new HashMap<>();
        MediaType textType = MediaType.parse("text/plain");
        RequestBody params = RequestBody.create(textType, new Gson().toJson(new MJsonRequest().addParam("name","jwding").getParams()));
        args.put("params",params);
        call=testRequest.testFileUploadArgs("testController","testUpLoadFile.do",args,filePart);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Toast.makeText(Demo_Retrofit_Activity.this,response.body().string(),Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                call.request();
            }
        });
    }

    /**
     * 上传多文件
     */
    private void testFilesUpload() {
        TestRetrofit testRequest=retrofit.create(TestRetrofit.class);
        Call<ResponseBody> call= null;
        RequestBody file = RequestBody.create(MediaType.parse("application/octet-stream"), "多文件上传");
        List<MultipartBody.Part> files=new ArrayList<>();
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", "test.txt", file);
        files.add(filePart);
        files.add(filePart);
        call=testRequest.testFilesUpload("testController","testUpLoadFile.do",files);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Toast.makeText(Demo_Retrofit_Activity.this,response.body().string(),Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                call.request();
            }
        });
    }

    /**
     * 上传单文件
     */
    private void testFileUpload() {
        TestRetrofit testRequest=retrofit.create(TestRetrofit.class);
        Call<ResponseBody> call= null;
        //call = testRequest.testRequest_Form("testRequest.do","jwding");
        RequestBody file = RequestBody.create(MediaType.parse("application/octet-stream"), "单文件上传");
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", "test.txt", file);
        call=testRequest.testFileUpload("testController","testUpLoadFile.do",filePart);
        call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    try {
                        Toast.makeText(Demo_Retrofit_Activity.this,response.body().string(),Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    call.request();
                }
            });
    }

    /**
     * 发送请求
     */
    private void testRequest() {
        TestRetrofit testRequest=retrofit.create(TestRetrofit.class);
        Call<ResponseBody> call= null;
        //call = testRequest.testRequest_Form("testRequest.do","jwding");
        call=testRequest.testRequest_Json("testController","testRequest.do",new MJsonRequest().addParam("name","jwding").getRequestBody());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Toast.makeText(Demo_Retrofit_Activity.this,response.body().string(),Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                call.request();
            }
        });
    }

}
