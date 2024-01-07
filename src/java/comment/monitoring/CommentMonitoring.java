package monitoring;

import java.math.BigDecimal;

public class CommentMonitoring {

    private String prefoodId;
    public CommentMonitoring(String prefoodId) {
        this.prefoodId = prefoodId;
    }

    /*
     * 请求获取差评占比与阈值
     * 如果达到阈值，上传异常
     */
    public void commentCheck(String id) {
        /*
         * 获取24h内差评占比、好评占比、该预制菜阈值
         */

        int positiveInt = getPositiveCnt(prefoodId);
        int negativeInt = getNegativeCnt(prefoodId);
        double thresholdDouble = getThreshould(prefoodId);

        BigDecimal positive = new BigDecimal(positiveInt);
        BigDecimal negative = new BigDecimal(negativeInt);
        BigDecimal threshould = new BigDecimal(thresholdDouble);

        BigDecimal rate = negative.divide(
            negative.add(positive)
        );

        if(rate.compareTo(threshould) > -1) {
            commentAlert(prefoodId);
        }
    }

    /*
     * 推送异常
     */
    void commentAlert(String prefoodId) {
        System.out.println(prefoodId+"异常~");
    }

    /*
     * 三个获取方法
     * 全部调用数据库接口
     */
    int getPositiveCnt(String id) {
        return 1;
    }

    int getNegativeCnt(String id) {
        return 1;
    }

    double getThreshould(String id) {
        return 0.5;
    }
}
