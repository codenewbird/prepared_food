package com.zjx.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Comment {
    private String identificationCode;
    private String userId;
    private String userComment;
    private int score;
    private Timestamp time;

    /*
     * state
     * 1表示积极
     * -1表示消极
     */
    private int state;
}
