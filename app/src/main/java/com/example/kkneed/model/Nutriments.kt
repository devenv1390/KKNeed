package com.example.kkneed.model


import com.google.gson.annotations.SerializedName

data class Nutriments(
    @SerializedName("alcohol")
    val alcohol: Int,
    @SerializedName("alcohol_100g")
    val alcohol100g: Int,
    @SerializedName("alcohol_serving")
    val alcoholServing: Int,
    @SerializedName("alcohol_unit")
    val alcoholUnit: String,
    @SerializedName("alcohol_value")
    val alcoholValue: Int,
    @SerializedName("calcium")
    val calcium: Double,
    @SerializedName("calcium_100g")
    val calcium100g: Double,
    @SerializedName("calcium_serving")
    val calciumServing: Double,
    @SerializedName("calcium_unit")
    val calciumUnit: String,
    @SerializedName("calcium_value")
    val calciumValue: Int,
    @SerializedName("carbohydrates")
    val carbohydrates: Int,
    @SerializedName("carbohydrates_100g")
    val carbohydrates100g: Int,
    @SerializedName("carbohydrates_serving")
    val carbohydratesServing: Int,
    @SerializedName("carbohydrates_unit")
    val carbohydratesUnit: String,
    @SerializedName("carbohydrates_value")
    val carbohydratesValue: Int,
    @SerializedName("energy")
    val energy: Int,
    @SerializedName("energy_100g")
    val energy100g: Int,
    @SerializedName("energy-kj")
    val energyKj: Int,
    @SerializedName("energy-kj_100g")
    val energyKj100g: Int,
    @SerializedName("energy-kj_serving")
    val energyKjServing: Int,
    @SerializedName("energy-kj_unit")
    val energyKjUnit: String,
    @SerializedName("energy-kj_value")
    val energyKjValue: Int,
    @SerializedName("energy-kj_value_computed")
    val energyKjValueComputed: Double,
    @SerializedName("energy_serving")
    val energyServing: Int,
    @SerializedName("energy_unit")
    val energyUnit: String,
    @SerializedName("energy_value")
    val energyValue: Int,
    @SerializedName("fat")
    val fat: Int,
    @SerializedName("fat_100g")
    val fat100g: Int,
    @SerializedName("fat_serving")
    val fatServing: Int,
    @SerializedName("fat_unit")
    val fatUnit: String,
    @SerializedName("fat_value")
    val fatValue: Int,
    @SerializedName("fiber")
    val fiber: Int,
    @SerializedName("fiber_100g")
    val fiber100g: Int,
    @SerializedName("fiber_serving")
    val fiberServing: Int,
    @SerializedName("fiber_unit")
    val fiberUnit: String,
    @SerializedName("fiber_value")
    val fiberValue: Int,
    @SerializedName("fruits-vegetables-nuts-estimate-from-ingredients_100g")
    val fruitsVegetablesNutsEstimateFromIngredients100g: Int,
    @SerializedName("fruits-vegetables-nuts-estimate-from-ingredients_serving")
    val fruitsVegetablesNutsEstimateFromIngredientsServing: Int,
    @SerializedName("nutrition-score-fr")
    val nutritionScoreFr: Int,
    @SerializedName("nutrition-score-fr_100g")
    val nutritionScoreFr100g: Int,
    @SerializedName("proteins")
    val proteins: Double,
    @SerializedName("proteins_100g")
    val proteins100g: Double,
    @SerializedName("proteins_serving")
    val proteinsServing: Double,
    @SerializedName("proteins_unit")
    val proteinsUnit: String,
    @SerializedName("proteins_value")
    val proteinsValue: Double,
    @SerializedName("salt")
    val salt: Double,
    @SerializedName("salt_100g")
    val salt100g: Double,
    @SerializedName("salt_serving")
    val saltServing: Double,
    @SerializedName("salt_unit")
    val saltUnit: String,
    @SerializedName("salt_value")
    val saltValue: Int,
    @SerializedName("saturated-fat")
    val saturatedFat: Int,
    @SerializedName("saturated-fat_100g")
    val saturatedFat100g: Int,
    @SerializedName("saturated-fat_serving")
    val saturatedFatServing: Int,
    @SerializedName("saturated-fat_unit")
    val saturatedFatUnit: String,
    @SerializedName("saturated-fat_value")
    val saturatedFatValue: Int,
    @SerializedName("sodium")
    val sodium: Double,
    @SerializedName("sodium_100g")
    val sodium100g: Double,
    @SerializedName("sodium_serving")
    val sodiumServing: Double,
    @SerializedName("sodium_unit")
    val sodiumUnit: String,
    @SerializedName("sodium_value")
    val sodiumValue: Double,
    @SerializedName("sugars")
    val sugars: Int,
    @SerializedName("sugars_100g")
    val sugars100g: Int,
    @SerializedName("sugars_serving")
    val sugarsServing: Int,
    @SerializedName("sugars_unit")
    val sugarsUnit: String,
    @SerializedName("sugars_value")
    val sugarsValue: Int
)