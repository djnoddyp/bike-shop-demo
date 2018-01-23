package pnodder.dao;

import java.util.List;

public interface GenericDao {

    List findAll();

    Object findById(Integer id);

}
