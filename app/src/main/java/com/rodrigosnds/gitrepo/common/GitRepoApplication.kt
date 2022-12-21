package com.rodrigosnds.gitrepo.common

import android.app.Application
import com.google.firebase.analytics.FirebaseAnalytics
import com.rodrigosnds.gitrepo.BuildConfig
import com.google.firebase.crashlytics.FirebaseCrashlytics
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GitRepoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        configCrashAndAnalyticsReportForDebug()
    }

    private fun configCrashAndAnalyticsReportForDebug() {
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(!BuildConfig.DEBUG)
        FirebaseAnalytics.getInstance(this).setAnalyticsCollectionEnabled(!BuildConfig.DEBUG)
    }
}