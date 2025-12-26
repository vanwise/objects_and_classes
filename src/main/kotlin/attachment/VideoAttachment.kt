package attachment

import Likes

data class AudioImage(
    override val width: Int,
    override val height: Int,
    override val url: String,
    val withPadding: Boolean,
) : Image(width, height, url)

data class VideoFrameImage(
    override val width: Int,
    override val height: Int,
    override val url: String,
) : Image(width, height, url)

data class VideoLikes(
    override val count: Int,
    override val userLikes: Boolean
) : Likes(count, userLikes)

data class Reposts(
    val countval: Int,
    val wallCount: Int,
    val mailCount: Int,
    val userReposted: Boolean,
)

data class Video(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val description: String,
    val duration: Int,
    val image: Array<AudioImage>,
    val firstFrame: Array<VideoFrameImage>,
    val date: Int,
    val addingDate: Int,
    val views: Int,
    val localViews: Int,
    val comments: Int?,
    val player: String,
    val platform: String,
    val canAdd: Boolean,
    val isPrivate: Boolean,
    val accessKey: String,
    val processing: Boolean,
    val isFavorite: Boolean,
    val canComment: Boolean,
    val canEdit: Boolean,
    val canLike: Boolean,
    val canRepost: Boolean,
    val canSubscribe: Boolean,
    val canAddToFaves: Boolean,
    val canAttachLink: Boolean,
    val width: Int,
    val height: Int,
    val userId: Int,
    val converting: Boolean,
    val added: Boolean,
    val isSubscribed: Boolean,
    val repeat: Boolean,
    val type: String,
    val balance: Int,
    val live: Boolean,
    val liveStartTime: Int,
    val liveStatus: String,
    val upcoming: Boolean,
    val spectators: Int,
    val likes: VideoLikes,
    val reposts: Reposts,
)

class VideoAttachment(val video: Video) : Attachment("video")
