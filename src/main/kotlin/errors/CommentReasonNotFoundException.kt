package errors

class CommentReasonNotFoundException(override val message: String) : RuntimeException(message)