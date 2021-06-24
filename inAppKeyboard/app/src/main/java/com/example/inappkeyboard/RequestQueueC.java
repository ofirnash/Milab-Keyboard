package com.example.inappkeyboard;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class RequestQueueC {
    private static com.example.inappkeyboard.RequestQueueC reqQInstance;
    private RequestQueue reqQ;

    public RequestQueueC(Context context){
        reqQ = Volley.newRequestQueue(context.getApplicationContext());
    }

    public static synchronized com.example.inappkeyboard.RequestQueueC getInstance(Context context){
        if(reqQInstance == null){
            reqQInstance = new com.example.inappkeyboard.RequestQueueC(context);
        }

        return reqQInstance;
    }

    public RequestQueue getQueue(){
        return reqQ;
    }
}
