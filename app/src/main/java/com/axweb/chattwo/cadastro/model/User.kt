package com.axweb.chattwo.cadastro.model

data class User(
    var first_name: String? = null,
    var last_name: String? = null,
    var firebase_id: String? = null,
    var email: String? = null,
    var gender: String? = null,
    var birthdate: String? = null,
    var username: String? = null,
    var photo_path: String? = null,
    var completeRegister: Boolean = false,
)
