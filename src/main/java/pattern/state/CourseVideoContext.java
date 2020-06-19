package pattern.state;


/**
 * @Auther: Administrator
 * @Date: 2020/6/2 15:23
 * @Description:
 */
public class CourseVideoContext {
    private CourseVideoState courseVideoState;

    public static final PlayState PLAY_STATE = new PlayState();
    public static final SpeedState SPEED_STATE = new SpeedState();
    public static final StopState STOP_STATE = new StopState();
    public static final PauseState PAUSE_STATE = new PauseState();

    public CourseVideoState getCourseVideoState() {
        return courseVideoState;
    }

    public void setCourseVideoState(CourseVideoState courseVideoState) {
        this.courseVideoState = courseVideoState;
        this.courseVideoState.setCourseVideoContext(this);
    }

    public void play() {
        courseVideoState.play();
    }

    public void speed(){
        courseVideoState.speed();
    }

    public void stop(){
        courseVideoState.stop();
    }

    public void pause(){
        courseVideoState.pause();
    }
}
