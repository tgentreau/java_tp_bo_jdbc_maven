package eu.unareil.dal;

import java.util.List;

public interface DAO<T> {
    public T selectById(int id) throws DALException;
    public List<T> selectAll() throws Exception;
    public void update(T data)throws DALException;
    public int insert(T data)throws DALException;
    public void delete(int id)throws DALException;
}
