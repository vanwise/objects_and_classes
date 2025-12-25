data class Post(
    val id: Int,
    val ownerId: Int?,
    val fromId: Int?,
    val createdBy: Int,
    val date: Int,
    val text: String = "",
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Boolean?,
    val likes: Likes,
    val isFavourite: Boolean = false
)
