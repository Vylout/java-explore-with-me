package ru.practicum.comments.mapper;

import ru.practicum.comments.model.dto.CommentDto;
import ru.practicum.comments.model.dto.NewCommentDto;
import ru.practicum.comments.model.entity.Comment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CommentMapper {
    public static Comment toComment(NewCommentDto newCommentDto) {
        return Comment.builder()
                .commentText(newCommentDto.getCommentText())
                .createdDate(LocalDateTime.now())
                .build();
    }

    public static CommentDto toCommentDto(Comment comment) {
        return CommentDto.builder()
                .id(comment.getId())
                .authorName(comment.getAuthor().getName())
                .commentText(comment.getCommentText())
                .createdOn(comment.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
//                .likesCount(comment.getLikes() == null ? 0 : comment.getLikes().size())
//                .dislikesCount(comment.getDislikes() == null ? 0 : comment.getDislikes().size())
                .build();
    }

    public static List<CommentDto> toCommentDto(Iterable<Comment> comments) {
        List<CommentDto> result = new ArrayList<>();

        for (Comment comment : comments) {
            result.add(toCommentDto(comment));
        }

        return result;
    }
}
