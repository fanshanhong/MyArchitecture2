package com.exam.myarchitecture.net.retrofit.service;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.exam.myarchitecture.contants.ServerConstant;
import com.exam.myarchitecture.net.retrofit.ResponseBaseBody;
import com.exam.myarchitecture.net.retrofit.factory.RxServiceFactory;
import com.exam.myarchitecture.net.retrofit.subscriber.HttpResultSubscriber;
import com.exam.myarchitecture.net.retrofit.transformer.TransformUtils;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;

import java.util.Map;

import rx.Subscription;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by SuperFan on 2016/8/30.
 */
public class RxBaseApi{
    /**
     * 调用RxService 的方法  返回相应的Observeble
     * 例如
     * 1.获取RxService实例
     *   RXServiceXX rXServiceXX =
            RxServiceFactory.createServiceFrom(RXServiceXX.class, host);
     * 2.获取Observeble
     *   public Observable<List<News>> getNcuNews(int howmany, int fromwhere){
            return rXServiceXX.getNcuNews(howmany, fromwhere)
                            .subscribeOn(Schedulers.io())//在io线程进行数据获取
                            .observeOn(AndroidSchedulers.mainThread());//在UI线程使用返回的数据
        }
     */

    private RxBaseService apiService;
    private static RxBaseApi rxBaseApi;


    private RxBaseApi(Context context,String prefixUrl,Map<String,String> headers) {
        apiService = RxServiceFactory.getInstance().createRxServiceFrom(context,RxBaseService.class,prefixUrl,headers);
    }

    public static RxBaseApi getDefault(@NonNull Context context,@NonNull String prefixUrl,Map<String,String> headers) {
        if(rxBaseApi == null){
            rxBaseApi = new RxBaseApi(context,prefixUrl,headers);
        }
        return rxBaseApi;
    }

    /**
     * 执行get请求
     * @param context
     * @param subscriber
     * @param url
     * @param request
     * @return
     */
    public <T> Subscription executeGet(Context context, final HttpResultSubscriber subscriber, final Class<T> resultType, String url, Map<String,String> request) {

//        RxBaseService apiService = RxServiceFactory.createRxServiceFrom(context, RxBaseService.class, "", null);

        return apiService.executeGet(url, request)
                .map(new Func1<ResponseBaseBody, T>() {
                    @Override
                    public T call(ResponseBaseBody responseBaseBody) {
                        T resultData = null;
                        //返回的服务器对象
                        if (responseBaseBody != null) {

                            //获取服务器给的message提示
                            subscriber.setResultMessage(responseBaseBody.getMessage());
                            // 获取服务器给的resultCode
                            subscriber.setResultCode(responseBaseBody.getStatusCode());
                            //获取服务的访问结果类型
                            subscriber.setResultType(responseBaseBody.getType());

                            //如果访问成功就解析数据
                            if (!TextUtils.isEmpty(responseBaseBody.getType()) && responseBaseBody.getType().equals(ServerConstant.SERVER_SUCCESS_RESULT_TYPE)) {
                                try {
                                    resultData = new Gson().fromJson(responseBaseBody.getMsg(), resultType);
                                } catch (Throwable t) {
                                    Logger.i(resultType.getName()+"解析出错 msg= "+responseBaseBody.getMsg());
                                }
                            }

                        }
                        return resultData;
                    }
                })
//                .subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
                .compose(TransformUtils.<T>defaultSchedulers())
                .subscribe(subscriber);
    }

    /**
     * 执行post请求
     * @param context
     * @param subscriber
     * @param url
     * @param request
     * @return
     */
    public <T> Subscription executePost(Context context, final HttpResultSubscriber subscriber, final Class<T> resultType, String url,Map<String,String> request) {

//        RxBaseService apiService = RxServiceFactory.createRxServiceFrom(context,RxBaseService.class,"",null);

        return apiService.executePost(url, request)
                .observeOn(Schedulers.io())
                .map(new Func1<ResponseBaseBody, T>() {
                    @Override
                    public T call(ResponseBaseBody responseBaseBody) {

                        T resultData = null;
                        //返回的服务器对象
                        if (responseBaseBody != null) {

                            //获取服务器给的message提示
                            subscriber.setResultMessage(responseBaseBody.getMessage());
                            // 获取服务器给的resultCode
                            subscriber.setResultCode(responseBaseBody.getStatusCode());
                            //获取服务的访问结果类型
                            subscriber.setResultType(responseBaseBody.getType());

                            //如果访问成功就解析数据
                            if (!TextUtils.isEmpty(responseBaseBody.getType()) && responseBaseBody.getType().equals(ServerConstant.SERVER_SUCCESS_RESULT_TYPE)) {
                                try {
                                    resultData = new Gson().fromJson(responseBaseBody.getMsg(), resultType);
                                } catch (Exception t) {
                                    Logger.i(resultType.getName() + "解析出错 msg= " + responseBaseBody.getMsg());
                                }
                            }

                        }
                        return resultData;
                    }
                })
//                .doOnSubscribe(new Action0() {
//                    @Override
//                    public void call() {
//                    }
//                })
//                .subscribeOn(AndroidSchedulers.mainThread()) // 指定主线程

//                .subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
                .compose(TransformUtils.<T>defaultSchedulers())
                .subscribe(subscriber);
    }
}
