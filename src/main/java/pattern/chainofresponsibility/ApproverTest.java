package pattern.chainofresponsibility;

/**
 * @Auther: Administrator
 * @Date: 2020/6/2 14:43
 * @Description:
 */
public class ApproverTest {
    public static void main(String[] args) {
        Course course = new Course("java设计模式精讲", "", "精讲视频");
        Approver articleApprover = new ArticleApprover();
        Approver videlApprover = new VideoApprover();

        articleApprover.setNextApprover(videlApprover);

        articleApprover.deploy(course);
    }
}
