package pattern.state;

/**
 *
 * @Auther: Administrator
 * @Date: 2020/6/2 15:33
 * @Description:
 */
public class StopState extends CourseVideoState {
    @Override
    public void play() {
        super.courseVideoContext.setCourseVideoState(CourseVideoContext.PLAY_STATE);
    }

    @Override
    public void speed() {
        System.out.println("停止状态，不允许快进播放");
    }

    @Override
    public void pause() {
        System.out.println("停止播放状态");
    }

    @Override
    public void stop() {
        System.out.println("停止状态");
    }
}
