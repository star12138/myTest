package pattern.state;

/**
 * @Auther: Administrator
 * @Date: 2020/6/2 15:48
 * @Description:
 */
public class CourseVideoStateTest {
    public static void main(String[] args) {
        CourseVideoContext videoContext = new CourseVideoContext();
        videoContext.setCourseVideoState(CourseVideoContext.PLAY_STATE);

        System.out.println("当前状态：" + videoContext.getCourseVideoState().getClass().getSimpleName());
//        videoContext.setCourseVideoState(CourseVideoContext.PAUSE_STATE);

        videoContext.pause();
        System.out.println("当前状态：" + videoContext.getCourseVideoState().getClass().getSimpleName());
//        videoContext.setCourseVideoState(CourseVideoContext.SPEED_STATE);
        videoContext.speed();
        System.out.println("当前状态：" + videoContext.getCourseVideoState().getClass().getSimpleName());
//        videoContext.setCourseVideoState(CourseVideoContext.STOP_STATE);
        videoContext.stop();
        System.out.println("当前状态：" + videoContext.getCourseVideoState().getClass().getSimpleName());
    }
}
