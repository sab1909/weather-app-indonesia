package com.weather.indonesia.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "locations")
data class LocationEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    
    @ColumnInfo(name = "provinsi")
    val provinsi: String,
    
    @ColumnInfo(name = "kabupaten")
    val kabupaten: String,
    
    @ColumnInfo(name = "kecamatan")
    val kecamatan: String,
    
    @ColumnInfo(name = "desa")
    val desa: String,
    
    @ColumnInfo(name = "latitude")
    val latitude: Double,
    
    @ColumnInfo(name = "longitude")
    val longitude: Double
)