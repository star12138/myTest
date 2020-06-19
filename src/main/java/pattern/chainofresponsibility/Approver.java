package pattern.chainofresponsibility;

/**
 * @Auther: Administrator
 * @Date: 2020/6/2 11:15
 * @Description:
 */
public abstract class Approver {
    protected Approver approver;

    public void setNextApprover(Approver approver) {
        this.approver = approver;
    }

    public abstract void deploy(Course course);
}
