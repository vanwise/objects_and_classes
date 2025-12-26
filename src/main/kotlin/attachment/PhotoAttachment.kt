package attachment

data class PhotoImage(
    override val url: String,
    override val width: Int,
    override val height: Int,
    val type: String,
) : Image(width, height, url)

data class Photo(
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    val userId: Int,
    val text: String,
    val date: Int,
    val thumbHash: String,
    val hasTags: Boolean,
    val sizes: Array<PhotoImage>,
    val width: Int,
    val height: Int,
)

class PhotoAttachment(val photo: Photo) : Attachment("photo")
