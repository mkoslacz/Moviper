package com.mateuszkoslacz.moviper.rxsample.viper.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by jjodelka on 17/10/16.
 */

class User {

    @SerializedName("organizations_url")
    var organizationsUrl: String? = null
    @SerializedName("avatar_url")
    var avatarUrl: String? = null
    @SerializedName("gists_url")
    var gistsUrl: String? = null
    @SerializedName("html_url")
    var htmlUrl: String? = null
    var location: String? = null
    var company: String? = null
    var email: String? = null
    var name: String? = null
    var blog: String? = null
    var type: String? = null
    var url: String? = null
    var id: String? = null
    var login: String? = null
}
