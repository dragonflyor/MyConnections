package com.yuzhi.fine.xiaozheutils;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by ZNE on 2016/4/13.
 */
public class NetUtils <T>{

        public ArrayList<T> list = new ArrayList<T>();
        /**
         * 获取查询的数据信息，以Json格式封装
         * @param url
         * @return
         */

        public  ArrayList<T> getInfo(String url){


            HttpUtils http = new HttpUtils();
            http.send(HttpMethod.GET,
                    url,
                    new RequestCallBack<String>(){

                        @Override
                        public void onLoading(long total, long current, boolean isUploading) {
                            // testTextView.setText(current + "/" + total);
                        }

                        @Override
                        public void onSuccess(ResponseInfo<String> responseInfo) {
                            System.out.print("从服务器收到的数据："+responseInfo.result);
                            parseInfoData(responseInfo.result);
                        }



                        @Override
                        public void onStart() {
                        }

                        @Override
                        public void onFailure(
                                com.lidroid.xutils.exception.HttpException error,
                                String msg) {
                            System.out.println("获取json字符串失败");

                        }
                    });

            return list;
        }

        private  void parseInfoData(String json) {
            System.out.println("----------------解析出的数据集合……");
            Log.i("NetService", "解析的json字符：" + json);
            Gson gson = new Gson();

            list =gson.fromJson(json, new TypeToken<List<T>>(){}.getType());
            System.out.println("----------------解析出的数据集合："+list.toString());
        }


        public  void insertNewInfo(String url , T infobean){
            RequestParams params = new RequestParams();
            //params.addHeader("name", "valueHeader");

            Gson gson = new Gson();
            //String json = gson.toJson(locationInfo);
            String json1 = gson.toJson(infobean);
            String json = null;
            try {
                json = new String(json1.getBytes("utf-8"));
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("上传数据到服务器："+json);
            params.addQueryStringParameter("data", json);

            // 只包含字符串参数时默认使用BodyParamsEntity，
            // 类似于UrlEncodedFormEntity（"application/x-www-form-urlencoded"）。
            //params.addBodyParameter("data", "valueBody");

            // 加入文件参数后默认使用MultipartEntity（"multipart/form-data"），
            // 如需"multipart/related"，xUtils中提供的MultipartEntity支持设置subType为"related"。
            // 使用params.setBodyEntity(httpEntity)可设置更多类型的HttpEntity（如：
            // MultipartEntity,BodyParamsEntity,FileUploadEntity,InputStreamUploadEntity,StringEntity）。
            // 例如发送json参数：params.setBodyEntity(new StringEntity(jsonStr,charset));
            //params.addBodyParameter("file", new File("path"));

            System.out.println("插入数据的json："+json);
            HttpUtils http = new HttpUtils();
            http.send(HttpRequest.HttpMethod.POST,
                    url,
                    params,
                    new RequestCallBack<String>() {

                        @Override
                        public void onStart() {
                            //testTextView.setText("conn.../");
                        }

                        @Override
                        public void onLoading(long total, long current, boolean isUploading) {
                            if (isUploading) {
                                //testTextView.setText("upload: " + current + "/" + total);
                            } else {
                                //testTextView.setText("reply: " + current + "/" + total);
                            }
                        }

                        @Override
                        public void onSuccess(ResponseInfo<String> responseInfo) {
                            //testTextView.setText("reply: " + responseInfo.result);
                            System.out.println("恭喜，提交位置到服务器成功！");
                        }

                        @Override
                        public void onFailure(HttpException error, String msg) {
                            //testTextView.setText(error.getExceptionCode() + ":" + msg);
                            System.out.println("提交位置到服务器失败！");
                        }
                    });
        }


}
