package Controler;

import Data.*;
import Service.DataService;
import Service.StudyGroupService;
import View.StudentView;
import View.StudyGroupView;
import View.TeacherView;

import java.util.List;

public class Controler {
    private final DataService service = new DataService();
    private final StudentView studentView = new StudentView();
    private final TeacherView teacherView = new TeacherView();
    private final StudyGroupService groupService = new StudyGroupService();
    private final StudyGroupView groupView = new StudyGroupView();

    public void createStudent(String firstName, String secondName, String lastName, String dateB){
        service.create(firstName,secondName,lastName,dateB, Type.STUDENT);
    }

    public void getAllStudent(){
        List<Student> students = service.getAllStudent();
        for (Student student: students){
            studentView.printOnConsole(student);
        }
    }

    public void createTeacher(String firstName, String secondName, String lastName, String dateB){
        service.create(firstName,secondName,lastName,dateB, Type.TEACHER);
    }

    public void getAllTeacher(){
        List<User> userList = service.getAllTeacher();
        for (User user: userList){
            teacherView.printOnConsole((Teacher) user);
        }
    }

    public Teacher getTeacherById(int id) {
        return (Teacher) service.getUserById(Type.TEACHER, id);
    }
    public void createStudyGroup(Teacher teacher, List<Student> students){
        groupService.createStudyGroup(teacher, students);
    }

    public void createGroupByTeacherId(int id){
        List<Student> userList = service.getAllStudent();
        groupView.printOnConsole(groupService.createStudyGroup(getTeacherById(id), userList));
    }

}
