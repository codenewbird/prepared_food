package com.zjx.entity.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * @author 周锦兴
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CommentEntity implements Serializable {
    private String identificationCode;
    private String userId;
    private String nickname;
    private String userComment;
    private int score;
    private Timestamp time;
}
