package pattern.state;

/**
 * @Auther: Administrator
 * @Date: 2020/6/2 15:23
 * @Description:
 */
public abstract class CourseVideoState {
    protected CourseVideoContext courseVideoContext;

    public void setCourseVideoContext(CourseVideoContext courseVideoContext) {
        this.courseVideoContext = courseVideoContext;
    }
    // 播放
    public abstract void play();
    // 快进
    public abstract void speed();
    // 暂停
    public abstract void pause();
    // 结束
    public abstract void stop();

}
