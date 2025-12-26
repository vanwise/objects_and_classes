import attachment.Attachment

data class PostLikes(
    override val count: Int,
    override val userLikes: Boolean,
    val canLike: Boolean,
    val canPublish: Boolean
) : Likes(count, userLikes)

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
    val likes: PostLikes,
    val isFavourite: Boolean = false,
    val attachments: Array<Attachment>
)
