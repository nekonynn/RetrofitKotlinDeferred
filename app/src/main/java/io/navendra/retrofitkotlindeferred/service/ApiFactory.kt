package io.navendra.retrofitkotlindeferred.service

import io.navendra.retrofitkotlindeferred.AppConstants

object ApiFactory{

    val placeholderApi : PlaceholderApi = RetrofitFactory.retrofit(AppConstants.JSON_PLACEHOLDER_BASE_URL)
                                                .create(PlaceholderApi::class.java)
}