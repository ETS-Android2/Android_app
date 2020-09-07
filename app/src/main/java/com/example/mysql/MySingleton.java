package com.example.mysql;

import android.content.Context;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.Volley;

public class MySingleton {

    private static MySingleton nInstance;
    private RequestQueue nRequestQueu;
    private Context nCtx;

    public MySingleton(Context nCtx){
        this.nCtx = nCtx;
        nRequestQueu = getnRequestQueu();
    }
    public RequestQueue getnRequestQueu(){
        if (nRequestQueu == null){
            Cache cache = new DiskBasedCache(nCtx.getCacheDir(),1024*1024);
            Network network = new BasicNetwork(new HurlStack());
            nRequestQueu = new RequestQueue(cache,network);
            nRequestQueu = Volley.newRequestQueue(nCtx.getApplicationContext());
        }
        return nRequestQueu;
    }

    public static synchronized MySingleton getInstance(Context context){
        if (nInstance == null){
            nInstance = new MySingleton(context);
        }
        return nInstance;
    }
    public <T>void  addToRequestQueue(Request<T>request){
        nRequestQueu.add(request);
    }
}
