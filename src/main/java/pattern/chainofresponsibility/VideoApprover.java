package pattern.chainofresponsibility;

import org.apache.commons.lang3.StringUtils;

/**
 * @Auther: Administrator
 * @Date: 2020/6/2 14:41
 * @Description:
 */
public class VideoApprover extends Approver {
    @Override
    public void deploy(Course course) {
        if (StringUtils.isNotEmpty(course.getVideo())) {
            System.out.println(course.getName() + "含有视频，批准");

        } else {
            System.out.println(course.getName() + "不含有视频，不批准");
        }
    }
}
