import errors.PostNotFoundException

object WallService {
    private var nextPostId = 0
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()

    fun createComment(postId: Int, comment: Comment): Comment {
        for (post in posts) {
            if (post.id == postId) {
                comments += comment
                return comments.last()
            }
        }
        throw PostNotFoundException("Пост с id $postId не найден")
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
        nextPostId = 0
    }
}