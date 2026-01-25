package errors

class CommentNotFoundException(override val message: String) : RuntimeException(message)