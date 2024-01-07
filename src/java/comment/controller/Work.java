package controller;

import controller.model.UserComment;

public class Work {

    /*
     * 模拟一下传入评论
     */
    public static void main(String[] args) {
        UserComment userComment = new UserComment("yf","狗看了都摇头", 5);
        CommentController commentController = new CommentController("红烧茄子");

        commentController.dealComment(userComment);
    }
}