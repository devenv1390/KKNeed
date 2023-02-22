package com.example.kkneed.model


import com.google.gson.annotations.SerializedName

data class Nutriments(
    @SerializedName("alcohol")
    val alcohol: Double,
    @SerializedName("alcohol_100g")
    val alcohol100g: Double,
    @SerializedName("alcohol_serving")
    val alcoholServing: Double,
    @SerializedName("alcohol_unit")
    val alcoholUnit: String,
    @SerializedName("alcohol_value")
    val alcoholValue: Double,
    @SerializedName("calcium")
    val calcium: Double,
    @SerializedName("calcium_100g")
    val calcium100g: Double,
    @SerializedName("calcium_serving")
    val calciumServing: Double,
    @SerializedName("calcium_unit")
    val calciumUnit: String,
    @SerializedName("calcium_value")
    val calciumValue: Double,
    @SerializedName("carbohydrates")
    val carbohydrates: Double,
    @SerializedName("carbohydrates_100g")
    val carbohydrates100g: Double,
    @SerializedName("carbohydrates_serving")
    val carbohydratesServing: Double,
    @SerializedName("carbohydrates_unit")
    val carbohydratesUnit: String,
    @SerializedName("carbohydrates_value")
    val carbohydratesValue: Double,
    @SerializedName("energy")
    val energy: Double,
    @SerializedName("energy_100g")
    val energy100g: Double,
    @SerializedName("energy-kj")
    val energyKj: Double,
    @SerializedName("energy-kj_100g")
    val energyKj100g: Double,
    @SerializedName("energy-kj_serving")
    val energyKjServing: Double,
    @SerializedName("energy-kj_unit")
    val energyKjUnit: String,
    @SerializedName("energy-kj_value")
    val energyKjValue: Double,
    @SerializedName("energy-kj_value_computed")
    val energyKjValueComputed: Double,
    @SerializedName("energy_serving")
    val energyServing: Double,
    @SerializedName("energy_unit")
    val energyUnit: String,
    @SerializedName("energy_value")
    val energyValue: Double,
    @SerializedName("fat")
    val fat: Double,
    @SerializedName("fat_100g")
    val fat100g: Double,
    @SerializedName("fat_serving")
    val fatServing: Double,
    @SerializedName("fat_unit")
    val fatUnit: String,
    @SerializedName("fat_value")
    val fatValue: Double,
    @SerializedName("fiber")
    val fiber: Double,
    @SerializedName("fiber_100g")
    val fiber100g: Double,
    @SerializedName("fiber_serving")
    val fiberServing: Double,
    @SerializedName("fiber_unit")
    val fiberUnit: String,
    @SerializedName("fiber_value")
    val fiberValue: Double,
    @SerializedName("fruits-vegetables-nuts-estimate-from-ingredients_100g")
    val fruitsVegetablesNutsEstimateFromIngredients100g: Double,
    @SerializedName("fruits-vegetables-nuts-estimate-from-ingredients_serving")
    val fruitsVegetablesNutsEstimateFromIngredientsServing: Double,
    @SerializedName("nutrition-score-fr")
    val nutritionScoreFr: Double,
    @SerializedName("nutrition-score-fr_100g")
    val nutritionScoreFr100g: Double,
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
    val saltValue: Double,
    @SerializedName("saturated-fat")
    val saturatedFat: Double,
    @SerializedName("saturated-fat_100g")
    val saturatedFat100g: Double,
    @SerializedName("saturated-fat_serving")
    val saturatedFatServing: Double,
    @SerializedName("saturated-fat_unit")
    val saturatedFatUnit: String,
    @SerializedName("saturated-fat_value")
    val saturatedFatValue: Double,
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
    val sugars: Double,
    @SerializedName("sugars_100g")
    val sugars100g: Double,
    @SerializedName("sugars_serving")
    val sugarsServing: Double,
    @SerializedName("sugars_unit")
    val sugarsUnit: String,
    @SerializedName("sugars_value")
    val sugarsValue: Double
)