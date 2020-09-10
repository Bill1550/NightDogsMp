package com.loneoaktech.tests.nightdogsmp.domain.api.types

import com.soywiz.klock.Time
import com.soywiz.klock.TimeFormat
import com.soywiz.klock.format
import com.soywiz.klock.parseTime
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder


data class ApiTime(
    val value: Time
) {

    @Serializer( forClass = ApiTime::class )
    companion object : KSerializer<ApiTime> {

        private val timeFormat = TimeFormat("hh:mm:ss a")

        override val descriptor: SerialDescriptor
            get() = PrimitiveSerialDescriptor("Time", PrimitiveKind.STRING)

        override fun deserialize(decoder: Decoder): ApiTime {
            return ApiTime( timeFormat.parseTime(decoder.decodeString()) )
        }

        override fun serialize(encoder: Encoder, value: ApiTime) {
            encoder.encodeString( timeFormat.format( value.value ) )
        }

    }
}
