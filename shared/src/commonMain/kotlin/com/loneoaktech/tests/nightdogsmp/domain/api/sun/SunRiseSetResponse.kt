 package com.loneoaktech.experimental.nightdogs.api.sun

import com.loneoaktech.tests.nightdogsmp.domain.api.types.ApiTime
import kotlinx.serialization.UseSerializers

import com.soywiz.klock.Time
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data as returned by the Sunset and Sunrise times api.
 *
 * Created by BillH on 3/3/2019
 */

@Serializable
data class SunRiseSetResponse(
    val results: SunRiseSetResults,
    val status: String
)

/**
 * The results object returned by the end point.
 * @field:Json attributes are use to decouple the API field name from Kotlin class property name.
 *
 * Values tha@SerialName( are nullable so we don't get an error if they are missing.
 *
 */
@Serializable
data class SunRiseSetResults(

    @SerialName("sunrise")
    val sunrise: ApiTime,

    @SerialName("sunset")
    val sunset: ApiTime,

    @SerialName("solar_noon")
    val solarNoon: ApiTime?,

    @SerialName("civil_twilight_begin")
    val civilTwilightBegin: ApiTime?,

    @SerialName("civil_twilight_end")
    val civilTwilightEnd: ApiTime?,

    @SerialName("nautical_twilight_begin")
    val nauticalTwilightBegin: ApiTime?,

    @SerialName("nautical_twilight_end")
    val NauticalTwilightEnd: ApiTime?,

    @SerialName("astronomical_twilight_begin")
    val astronomicalTwilightBegin: ApiTime?,

    @SerialName("astronomical_twilight_end")
    val astronomicalTwilightEnd: ApiTime?

)