package pattern.state;

/**
 * @Auther: Administrator
 * @Date: 2020/6/2 15:32
 * @Description:
 */
public class PlayState extends CourseVideoState {
    @Override
    public void play() {
        System.out.println("视频正常播放");
    }

    @Override
    public void speed() {
        super.courseVideoContext.setCourseVideoState(CourseVideoContext.SPEED_STATE);
    }

    @Override
    public void pause() {
        super.courseVideoContext.setCourseVideoState(CourseVideoContext.PAUSE_STATE);
    }

    @Override
    public void stop() {
        super.courseVideoContext.setCourseVideoState(CourseVideoContext.STOP_STATE);
    }
}
