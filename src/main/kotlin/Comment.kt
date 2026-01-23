data class Comment(
    val id: Int,
    val postId: Int,
    val date: Int,
    val text: String,
    val replyToUser: Int,
    val replyToComment: Int,
)
