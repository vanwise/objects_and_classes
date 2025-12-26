package attachment

data class Sticker(
    val productId: Int,
    val stickerId: Int,
    val animationUrl: String,
    val isAllowed: Boolean,
)

class StickerAttachment(val sticker: Sticker) : Attachment("sticker")
