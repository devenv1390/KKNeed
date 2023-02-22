package com.example.kkneed.data

import androidx.room.TypeConverter
import com.example.kkneed.model.Ingredient
import com.example.kkneed.model.NutrientLevels
import com.example.kkneed.model.Nutriments
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ProductConverters {
    @TypeConverter
    fun stringToNutrientLevels(value: String): NutrientLevels {
        val type = object : TypeToken<NutrientLevels>() {
        }.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun nutrientLevelsToString(nutrientLevels: NutrientLevels): String {
        val gson = Gson()
        return gson.toJson(nutrientLevels)
    }

    @TypeConverter
    fun stringToNutriments(value: String): Nutriments {
        val type = object : TypeToken<Nutriments>() {
        }.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun nutrimentsToString(nutriments: Nutriments): String {
        val gson = Gson()
        return gson.toJson(nutriments)
    }

    @TypeConverter
    fun stringToObject(value: String): List<String> {
        val listType = object : TypeToken<List<String>>() {
        }.type
        return Gson().fromJson(value, listType)
    }
    @TypeConverter
    fun ingredientToObject(value: String): List<Ingredient> {
        val listType = object : TypeToken<List<Ingredient>>() {
        }.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun objectToString(list: List<Any>): String {
        val gson = Gson()
        return gson.toJson(list)
    }


}