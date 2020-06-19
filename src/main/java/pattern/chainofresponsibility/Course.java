package pattern.chainofresponsibility;

import lombok.Data;

/**
 * @Auther: Administrator
 * @Date: 2020/6/2 11:13
 * @Description:
 */
@Data
public class Course {
    private String name;
    private String article;
    private String video;

    public Course(String name, String article, String video) {
        this.name = name;
        this.article = article;
        this.video = video;
    }
}
