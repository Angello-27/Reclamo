package com.topicos.miguel.reclamo.Control.Server

import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import com.loopj.android.http.RequestParams

class ServerREST {

    companion object {

        val BASEURL : String = "http://localhost:80/Reclamo/public/"
        val client : AsyncHttpClient = AsyncHttpClient()

        fun GET(url: String, params : RequestParams, responseHandler: AsyncHttpResponseHandler){
            client.get(getAbsoluteURL(url), params, responseHandler)
        }

        fun POST(url: String, params : RequestParams, responseHandler: AsyncHttpResponseHandler){
            client.post(getAbsoluteURL(url), params, responseHandler)
        }

        fun PUT(url: String, params : RequestParams, responseHandler: AsyncHttpResponseHandler){
            client.put(getAbsoluteURL(url), params, responseHandler)
        }

        fun getAbsoluteURL(realtiveURL : String): String{
            return BASEURL + realtiveURL
        }
    }
}