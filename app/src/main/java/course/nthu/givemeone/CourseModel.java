package course.nthu.givemeone;

/**
 * Created by rex5207 on 16/2/14.
 */
public class CourseModel {
    private String CourseNum;//課程編號
    private String CourseName;//課程名稱
    private String CourseTeacher;//授課老師
    private String CourseTime;//授課時間
    private String CourseQuota;//剩餘名額

    public String getCourseNum(){
        return CourseNum;
    }
    public String getCourseName(){
        return CourseName;
    }
    public String getCourseTeacher(){
        return CourseTeacher;
    }
    public String getCourseTime(){
        return CourseTime;
    }
    public String getCourseQuota(){
        return CourseQuota;
    }

    public void setCourseNum(String CourseNum){
        this.CourseNum = CourseNum;
    }
    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }
    public void setCourseTeacher(String CourseTeacher){
        this.CourseTeacher = CourseTeacher;
    }
    public void setCourseTime(String CourseTime){
        this.CourseTime = CourseTime;
    }
    public void setCourseQuota(String CourseQuota){
        this.CourseQuota = CourseQuota;
    }
}
