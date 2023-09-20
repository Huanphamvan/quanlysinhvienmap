package manager;

import model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StudentManager implements IManager<Student>{
    private Map<Integer,Student>list= new HashMap<>();
    @Override
    public void add(Student student) {
        list.put(student.getId(),student);
    }

    @Override
    public void edit(int id, Student student) {
        list.put(id,student);

    }

    @Override
    public void delete(int id) {
        list.remove(id);
    }

//    @Override
//    public int findIndexArrayIdByKeySet(int id) {
//        ArrayList<Integer> ArrayKey = list.keySet();
//        return ;
//    }


    @Override
    public Map<Integer, Student> findAll() {
        return list;
    }
}
