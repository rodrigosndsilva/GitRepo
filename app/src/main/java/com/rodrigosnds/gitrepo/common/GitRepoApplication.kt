package com.rodrigosnds.gitrepo.common

import android.app.Application
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.rodrigosnds.gitrepo.BuildConfig
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GitRepoApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        configCrashAndAnalyticsReport()
    }

    private fun configCrashAndAnalyticsReport() {
        if (BuildConfig.DEBUG) {
            FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(false)
            FirebaseAnalytics.getInstance(this).setAnalyticsCollectionEnabled(false)
        }
    }
}