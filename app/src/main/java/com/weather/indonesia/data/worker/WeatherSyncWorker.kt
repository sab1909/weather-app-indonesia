package com.weather.indonesia.data.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class WeatherSyncWorker(
    context: Context,
    params: WorkerParameters
) : Worker(context, params) {

    override fun doWork(): Result {
        return try {
            // Sync weather data
            Result.success()
        } catch (e: Exception) {
            Result.retry()
        }
    }
}