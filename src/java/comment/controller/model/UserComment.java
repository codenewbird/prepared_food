package controller.model;

/*
 * 用户评论JavaBeans
 */
public class UserComment {
    private String userId;
    private String userComment;
    private int score;

    /*
     * state
     * 1表示积极
     * -1表示消极
     */
    private int state;

    public UserComment(String userId,String userComment,int score) {
        this.userId = userId;
        this.userComment = userComment;
        this.score = score;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getUserComment() {
        return userComment;
    }
}