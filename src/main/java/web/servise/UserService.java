package web.servise;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public User findById(long id);
    public void save(User user);
    public void update(long id, User updUser);
    public void delete(long id);
    public void gen5Users();
}
