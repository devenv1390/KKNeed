package com.example.kkneed.model


import androidx.room.ColumnInfo
import androidx.room.TypeConverters
import com.example.kkneed.data.ProductConverters
import com.google.gson.annotations.SerializedName

@TypeConverters(ProductConverters::class)
data class Nutriments(
//    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo(name = "nutriments_id")
//    var nutrimentsId: Int = 0,

    @SerializedName("alcohol")
    @ColumnInfo(name = "nutriments_alcohol") val alcohol: Double,

    @SerializedName("alcohol_100g")
    @ColumnInfo(name = "nutriments_alcohol100g") val alcohol100g: Double,

    @SerializedName("alcohol_serving")
    @ColumnInfo(name = "nutriments_alcoholServing") val alcoholServing: Double,

    @SerializedName("alcohol_unit")
    @ColumnInfo(name = "nutriments_alcoholUnit") val alcoholUnit: String,

    @SerializedName("alcohol_value")
    @ColumnInfo(name = "nutriments_alcoholValue") val alcoholValue: Double,

    @SerializedName("calcium")
    @ColumnInfo(name = "nutriments_calcium") val calcium: Double,

    @SerializedName("calcium_100g")
    @ColumnInfo(name = "nutriments_calcium100g") val calcium100g: Double,

    @SerializedName("calcium_serving")
    @ColumnInfo(name = "nutriments_calciumServing") val calciumServing: Double,

    @SerializedName("calcium_unit")
    @ColumnInfo(name = "nutriments_calciumUnit") val calciumUnit: String,

    @SerializedName("calcium_value")
    @ColumnInfo(name = "nutriments_calciumValue") val calciumValue: Double,

    @SerializedName("carbohydrates")
    @ColumnInfo(name = "nutriments_carbohydrates") val carbohydrates: Double,

    @SerializedName("carbohydrates_100g")
    @ColumnInfo(name = "nutriments_carbohydrates100g") val carbohydrates100g: Double,

    @SerializedName("carbohydrates_serving")
    @ColumnInfo(name = "nutriments_carbohydratesServing") val carbohydratesServing: Double,

    @SerializedName("carbohydrates_unit")
    @ColumnInfo(name = "nutriments_carbohydratesUnit") val carbohydratesUnit: String,

    @SerializedName("carbohydrates_value")
    @ColumnInfo(name = "nutriments_carbohydratesValue") val carbohydratesValue: Double,

    @SerializedName("energy")
    @ColumnInfo(name = "nutriments_energy") val energy: Double,

    @SerializedName("energy_100g")
    @ColumnInfo(name = "nutriments_energy100g") val energy100g: Double,

    @SerializedName("energy-kj")
    @ColumnInfo(name = "nutriments_energyKj") val energyKj: Double,

    @SerializedName("energy-kj_100g")
    @ColumnInfo(name = "nutriments_energyKj100g") val energyKj100g: Double,

    @SerializedName("energy-kj_serving")
    @ColumnInfo(name = "nutriments_energyKjServing") val energyKjServing: Double,

    @SerializedName("energy-kj_unit")
    @ColumnInfo(name = "nutriments_energyKjUnit") val energyKjUnit: String,

    @SerializedName("energy-kj_value")
    @ColumnInfo(name = "nutriments_energyKjValue") val energyKjValue: Double,

    @SerializedName("energy-kj_value_computed")
    @ColumnInfo(name = "nutriments_energyKjValueComputed") val energyKjValueComputed: Double,

    @SerializedName("energy_serving")
    @ColumnInfo(name = "nutriments_energyServing") val energyServing: Double,

    @SerializedName("energy_unit")
    @ColumnInfo(name = "nutriments_energyUnit") val energyUnit: String,

    @SerializedName("energy_value")
    @ColumnInfo(name = "nutriments_energyValue") val energyValue: Double,

    @SerializedName("fat")
    @ColumnInfo(name = "nutriments_fat") val fat: Double,

    @SerializedName("fat_100g")
    @ColumnInfo(name = "nutriments_fat100g") val fat100g: Double,

    @SerializedName("fat_serving")
    @ColumnInfo(name = "nutriments_fatServing") val fatServing: Double,

    @SerializedName("fat_unit")
    @ColumnInfo(name = "nutriments_fatUnit") val fatUnit: String,

    @SerializedName("fat_value")
    @ColumnInfo(name = "nutriments_fatValue") val fatValue: Double,

    @SerializedName("fiber")
    @ColumnInfo(name = "nutriments_fiber") val fiber: Double,

    @SerializedName("fiber_100g")
    @ColumnInfo(name = "nutriments_fiber100g") val fiber100g: Double,

    @SerializedName("fiber_serving")
    @ColumnInfo(name = "nutriments_fiberServing") val fiberServing: Double,

    @SerializedName("fiber_unit")
    @ColumnInfo(name = "nutriments_fiberUnit") val fiberUnit: String,

    @SerializedName("fiber_value")
    @ColumnInfo(name = "nutriments_fiberValue") val fiberValue: Double,

    @SerializedName("fruits-vegetables-nuts-estimate-from-ingredients_100g")
    @ColumnInfo(name = "nutriments_fruitsVegetablesNutsEstimateFromIngredients100g") val fruitsVegetablesNutsEstimateFromIngredients100g: Double,

    @SerializedName("fruits-vegetables-nuts-estimate-from-ingredients_serving")
    @ColumnInfo(name = "nutriments_fruitsVegetablesNutsEstimateFromIngredientsServing") val fruitsVegetablesNutsEstimateFromIngredientsServing: Double,

    @SerializedName("nutrition-score-fr")
    @ColumnInfo(name = "nutriments_nutritionScoreFr") val nutritionScoreFr: Double,

    @SerializedName("nutrition-score-fr_100g")
    @ColumnInfo(name = "nutriments_nutritionScoreFr100g") val nutritionScoreFr100g: Double,

    @SerializedName("proteins")
    @ColumnInfo(name = "nutriments_proteins") val proteins: Double,

    @SerializedName("proteins_100g")
    @ColumnInfo(name = "nutriments_proteins100g") val proteins100g: Double,

    @SerializedName("proteins_serving")
    @ColumnInfo(name = "nutriments_proteinsServing") val proteinsServing: Double,

    @SerializedName("proteins_unit")
    @ColumnInfo(name = "nutriments_proteinsUnit") val proteinsUnit: String,

    @SerializedName("proteins_value")
    @ColumnInfo(name = "nutriments_proteinsValue") val proteinsValue: Double,

    @SerializedName("salt")
    @ColumnInfo(name = "nutriments_salt") val salt: Double,

    @SerializedName("salt_100g")
    @ColumnInfo(name = "nutriments_salt100g") val salt100g: Double,

    @SerializedName("salt_serving")
    @ColumnInfo(name = "nutriments_saltServing") val saltServing: Double,

    @SerializedName("salt_unit")
    @ColumnInfo(name = "nutriments_saltUnit") val saltUnit: String,

    @SerializedName("salt_value")
    @ColumnInfo(name = "nutriments_saltValue") val saltValue: Double,

    @SerializedName("saturated-fat")
    @ColumnInfo(name = "nutriments_saturatedFat") val saturatedFat: Double,

    @SerializedName("saturated-fat_100g")
    @ColumnInfo(name = "nutriments_saturatedFat100g") val saturatedFat100g: Double,

    @SerializedName("saturated-fat_serving")
    @ColumnInfo(name = "nutriments_saturatedFatServing") val saturatedFatServing: Double,

    @SerializedName("saturated-fat_unit")
    @ColumnInfo(name = "nutriments_saturatedFatUnit") val saturatedFatUnit: String,

    @SerializedName("saturated-fat_value")
    @ColumnInfo(name = "nutriments_saturatedFatValue") val saturatedFatValue: Double,

    @SerializedName("sodium")
    @ColumnInfo(name = "nutriments_sodium") val sodium: Double,

    @SerializedName("sodium_100g")
    @ColumnInfo(name = "nutriments_sodium100g") val sodium100g: Double,

    @SerializedName("sodium_serving")
    @ColumnInfo(name = "nutriments_sodiumServing") val sodiumServing: Double,

    @SerializedName("sodium_unit")
    @ColumnInfo(name = "nutriments_sodiumUnit") val sodiumUnit: String,

    @SerializedName("sodium_value")
    @ColumnInfo(name = "nutriments_sodiumValue") val sodiumValue: Double,

    @SerializedName("sugars")
    @ColumnInfo(name = "nutriments_sugars") val sugars: Double,

    @SerializedName("sugars_100g")
    @ColumnInfo(name = "nutriments_sugars100g") val sugars100g: Double,

    @SerializedName("sugars_serving")
    @ColumnInfo(name = "nutriments_sugarsServing") val sugarsServing: Double,

    @SerializedName("sugars_unit")
    @ColumnInfo(name = "nutriments_sugarsUnit") val sugarsUnit: String,

    @SerializedName("sugars_value")
    @ColumnInfo(name = "nutriments_sugarsValue") val sugarsValue: Double
)