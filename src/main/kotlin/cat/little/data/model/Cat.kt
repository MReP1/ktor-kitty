package cat.little.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Cat(
    val name: String,
    val description: String,
    val imageUrl: String
)