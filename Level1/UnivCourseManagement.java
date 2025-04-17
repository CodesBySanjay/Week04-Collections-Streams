import java.util.List;
import java.util.ArrayList;

abstract class CourseType {
    private String name;

    public CourseType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class ExamCourse extends CourseType {
    public ExamCourse(String name) {
        super(name);
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String name) {
        super(name);
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String name) {
        super(name);
    }
}

class Course<T extends CourseType> {
    private String courseId;
    private T type;

    public Course(String courseId, T type) {
        this.courseId = courseId;
        this.type = type;
    }

    public String getCourseId() {
        return courseId;
    }

    public T getType() {
        return type;
    }
}

class CourseUtils {
    public static void printCourseTypes(List<? extends CourseType> types) {
        for (CourseType type : types) {
            System.out.println(type.getName());
        }
    }
}

public class UnivCourseManagement {
    public static void main(String[] args) {
        Course<ExamCourse> examCourse = new Course<>("CSE101", new ExamCourse("Midterm Exam"));
        Course<AssignmentCourse> assignmentCourse = new Course<>("ENG201", new AssignmentCourse("Essay Assignment"));
        Course<ResearchCourse> researchCourse = new Course<>("SCI301", new ResearchCourse("AI Research"));

        List<CourseType> allCourses = new ArrayList<>();
        allCourses.add(examCourse.getType());
        allCourses.add(assignmentCourse.getType());
        allCourses.add(researchCourse.getType());

        CourseUtils.printCourseTypes(allCourses);
    }
}