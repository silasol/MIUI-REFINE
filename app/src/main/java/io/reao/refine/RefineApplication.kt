package io.reao.refine

import android.app.Application
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import com.topjohnwu.superuser.Shell
import timber.log.Timber

class RefineApplication : Application() {

    init {
        Shell.enableVerboseLogging = true
        Shell.setDefaultBuilder(
            Shell.Builder.create().setFlags(Shell.FLAG_REDIRECT_STDERR)
                .setFlags(Shell.FLAG_MOUNT_MASTER)
        )
    }

    override fun onCreate() {
        super.onCreate()
        Timber.d("RefineApplication is initialized.")

        if (BuildConfig.DEBUG) {
            AppCenter.start(
                this, "9bc3de5f-bb8b-478b-b047-77fbd485d864",
                Analytics::class.java, Crashes::class.java
            )
        }
    }
}