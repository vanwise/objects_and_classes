import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class WallServiceTest {
    private val post = Post(
        id = 5,
        ownerId = 1,
        fromId = 2,
        createdBy = 3,
        date = 1766251110,
        text = "Самый лучший пост!",
        replyOwnerId = 3,
        replyPostId = 2,
        friendsOnly = true,
        likes = Likes(
            count = 1,
            userLikes = false,
            canLike = true,
            canPublish = true
        ),
    )

    @BeforeEach
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun addShouldReturnCorrectId() {
        val addedPost = WallService.add(post)
        assertEquals(1, addedPost.id)
    }

    @Test
    fun updateShouldReturnTrueForExistPost() {
        val addedPost = WallService.add(post)
        val editedPost = addedPost.copy(text = "Еще лучше пост!!")
        val isUpdateSuccess = WallService.update(editedPost)
        assertTrue(isUpdateSuccess)
    }

    @Test
    fun updateShouldReturnFalseForMissingPost() {
        WallService.add(post)
        val nonExistPost = post.copy(id = 999)
        val isUpdateSuccess = WallService.update(nonExistPost)
        assertFalse(isUpdateSuccess)
    }
}