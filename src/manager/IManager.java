package manager;

import java.util.Map;

public interface IManager <E>{
    void add (E e);
    void edit(int id, E e);
    void delete (int id);
//    int findIndexArrayIdByKeySet(int id);

    Map<Integer,E > findAll();
}
