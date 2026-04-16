package com.quibbly.shared

import co.touchlab.crashkios.crashlytics.setCrashlyticsUnhandledExceptionHook
import co.touchlab.kermit.ExperimentalKermitApi
import co.touchlab.kermit.Logger
import co.touchlab.kermit.crashlytics.CrashlyticsLogWriter

@OptIn(ExperimentalKermitApi::class)
@Suppress("unused")
fun startKermit(){
    Logger.addLogWriter(CrashlyticsLogWriter())
    setCrashlyticsUnhandledExceptionHook()
}