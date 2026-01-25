import errors.CommentNotFoundException
import errors.CommentReasonNotFoundException
import errors.PostNotFoundException

object WallService {
    private val REASONS = arrayOf(1, 2, 3, 4, 5, 6, 8)
    private var nextPostId = 0
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var reportedComments = emptyArray<ReportedComment>()

    fun createComment(postId: Int, comment: Comment): Comment {
        for (post in posts) {
            if (post.id == postId) {
                comments += comment
                return comments.last()
            }
        }
        throw PostNotFoundException("Пост с id $postId не найден")
    }

    fun reportComment(commentId: Int, reason: Int?): Boolean {
        if (reason != null && !REASONS.contains(reason)) {
            throw CommentReasonNotFoundException("Причина $reason не найдена")
        }

        for (comment in comments) {
            if (comment.id == commentId) {
                reportedComments += ReportedComment(commentId, reason)
                return true
            }
        }

        throw CommentNotFoundException("Коммент с id $commentId не найден")
    }

    fun add(post: Post): Post {
        posts += post.copy(id = ++nextPostId)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, currentPost) in posts.withIndex()) {
            if (currentPost.id == post.id) {
                posts[index] = post.copy()
                return true
            }
        }
        return false
    }

    fun clear() {
        posts = emptyArray()
        comments = emptyArray()
        reportedComments = emptyArray()
        nextPostId = 0
    }
}