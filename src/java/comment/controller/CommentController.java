package controller;

import controller.classify.CommentClassifyInterface;
import controller.model.UserComment;

/*
    对于上传的单个评论进行处理
*/
class CommentController {

    //预制菜id
    private String prefoodId;

    public CommentController(String prefoodId) {
        this.prefoodId = prefoodId;
    }

    /*
     * 对传入的评论进行处理
     */
    void dealComment(UserComment userComment) {
        /*
         * 设置评论种类
         */
        int type = queryType(userComment);
        userComment.setState(type);

        /*
         * 申请数据库存储评论
         */
        sendComment(prefoodId,userComment);
    }

    /*
     *  获取评论的种类
     */
    int queryType(UserComment userComment) {
        CommentClassifyInterface commentClassifyInterface = new CommentClassifyInterface();
        String text = "{\"input\": \""+userComment.getUserComment()+"\"}";
        int result = commentClassifyInterface.postText(text,"https://api-inference.modelscope.cn/api-inference/v1/models/damo/nlp_structbert_sentiment-classification_chinese-ecommerce-base");
        return result;
    }

    /*
     * 调用数据库接口
     */
    void sendComment(String prefoodId,UserComment userComment) {

    }
    
}