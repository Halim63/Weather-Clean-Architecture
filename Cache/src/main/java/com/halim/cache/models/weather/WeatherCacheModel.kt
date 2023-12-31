package com.halim.cache.models.weather

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.halim.cache.models.CacheModel
import com.halim.data.models.weather.WeatherDetailsEntityModel
import java.io.ByteArrayOutputStream

@Entity
data class WeatherCacheModel(
    val temperature:Double?,
    val date:String?,
    @PrimaryKey(autoGenerate = true)
    val id: Int? =null
):CacheModel {

}
