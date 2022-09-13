package cat.little.data.model

import kotlinx.serialization.Serializable

@Serializable
data class SpecialCatRequest(
    val number: Int
)
