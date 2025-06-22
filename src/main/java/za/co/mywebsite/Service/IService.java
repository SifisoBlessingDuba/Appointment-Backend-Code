package za.co.mywebsite.Service;

public interface IService <T, ID>{
    T findById(ID id);
    T save(T t);
    void deleteById(ID id);

}
