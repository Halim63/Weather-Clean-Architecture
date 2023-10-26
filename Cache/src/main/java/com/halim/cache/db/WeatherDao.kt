package com.halim.cache.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.halim.cache.models.weather.WeatherCacheModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

@Dao
interface WeatherDao {
    @Query("SELECT * FROM weathercachemodel")

    fun getAllWeather(): Observable<List<WeatherCacheModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(weatherCacheEntity: WeatherCacheModel): Completable


    @Delete
    fun delete(weatherCacheModel: WeatherCacheModel): Completable
}