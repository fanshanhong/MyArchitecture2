package com.exam.myarchitecture.net.retrofit.service;

import com.exam.myarchitecture.net.retrofit.ResponseBaseBody;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by SuperFan on 2016/8/30.
 */
public interface RxBaseService {

    /**
     * @GET @POST 等方法的申明
     * 例如：
     *      @GET("/NewIndex2013/AjaxGetList.ashx?partID=394")
            Observable<List<News>> getNcuNews(@Query("pagesize") int howmany, @Query("pageindex") int fromwhere);

     * 该子类的实例由RxServiceFactory生成
     *
     */

    //普通get请求
    @GET("{url}")
    Observable<ResponseBaseBody> executeGet(
            @Path("url") String url,
            @QueryMap Map<String, String> maps);


    //普通post请求
    @POST("{url}")
    Observable<ResponseBaseBody> executePost(
            @Path("url") String url,
            @QueryMap Map<String, String> maps);

    //上传单个文件
    @Multipart
    @POST("{url}")
    Observable<ResponseBaseBody> upLoadFile(
            @Path("url") String url,
            @Part("image\\\"; filename=\\\"image.jpg") RequestBody avatar);


    //上传多个文件
    @POST("{url}")
    Observable<ResponseBaseBody> uploadFiles(
            @Path("url") String url,
            @Path("headers") Map<String, String> headers,
            @Part("filename") String description,
            @PartMap() Map<String, RequestBody> maps);

    //下载文件
    @Streaming
    @GET
    Observable<ResponseBaseBody> downloadFile(@Url String fileUrl);


}
