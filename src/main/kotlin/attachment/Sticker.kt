package attachment

data class Sticker(
    val productId: Int,
    val stickerId: Int,
    val animationUrl: String,
    val isAllowed: Boolean,
)
