package Service;

import Data.Student;
import Data.StudyGroup;
import Data.Teacher;

import java.util.List;

public class StudyGroupService {
    private StudyGroup studyGroup;

    public StudyGroup createStudyGroup(Teacher teacher, List<Student> students) {
        this.studyGroup = new StudyGroup(teacher, students);
        return studyGroup;
    }

}
