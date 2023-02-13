package com.example.kkneed.domin.entities

data class User(
    var userId: String? = null,
    var email: String? = null,
    var password: String? = null,
    var fullName: String? = null,
    var bio: String? = null,
    var imageUrl: String? = null,
    var following:List<String> = emptyList(),
    var followers:List<String> = emptyList(),
)