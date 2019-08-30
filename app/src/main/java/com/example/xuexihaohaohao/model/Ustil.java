package com.example.xuexihaohaohao.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.xuexihaohaohao.App;

public class Ustil {
    private  static Ustil ustil=null;
    private Ustil(){}
    public  static  Ustil getInstance(){
        if (ustil==null){
            synchronized (Ustil.class){
                if (ustil==null){
                    ustil=new Ustil();
                }
            }
        }
        return ustil;
    }
    public  interface  ICallBack{
        void onChenggong(Object obj);
         void onShibai(String meg);
    }
    public  boolean wan(){
        ConnectivityManager cm= (ConnectivityManager) App.sContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info != null) {
            return info.isAvailable();
        }
        return false;
    }
    public  void  doGet(String pach, final ICallBack iCallBack){
        RequestQueue requestQueue = Volley.newRequestQueue(App.sContext);
        StringRequest request=new StringRequest(Request.Method.GET, pach, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (iCallBack != null) {
                    iCallBack.onChenggong(response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (iCallBack != null) {
                    iCallBack.onShibai(error.getMessage());
                }
            }
        });
        requestQueue.add(request);
    }
}
