package com.learn.githubvisitor.config

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

object CheckNetworkStatus {


    fun isOnline(context: Context?, statusCallBack: Status) {

        var networkStatus = false

        val cm = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val n = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            cm.activeNetwork
        } else {
            TODO("VERSION.SDK_INT < M")
        }
        if (n != null) {
            val nc = cm.getNetworkCapabilities(n)
            //It will check for both wifi and cellular network

            networkStatus =
                nc!!.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) || nc.hasTransport(
                    NetworkCapabilities.TRANSPORT_WIFI
                )
        }

        if (networkStatus) {
            statusCallBack.online()
        } else {
            statusCallBack.offline()

        }


    }

    interface Status {
        fun online()
        fun offline()
    }

}