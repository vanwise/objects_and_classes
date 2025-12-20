object WallService {
    private var nextPostId = 0
    private var posts = emptyArray<Post>()

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
        nextPostId = 0
    }
}