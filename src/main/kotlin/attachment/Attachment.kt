package attachment

sealed class Attachment(val type: String) {
    data class AudioAttachment(val audio: Audio) : Attachment("audio")
    data class VideoAttachment(val video: Video) : Attachment("video")
    data class PhotoAttachment(val photo: Photo) : Attachment("photo")
    data class FileAttachment(val file: File) : Attachment("file")
    data class StickerAttachment(val sticker: Sticker) : Attachment("sticker")
}
