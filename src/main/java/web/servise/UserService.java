package web.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;
import web.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserService {

    private final UsersRepository usersRepository;

    @Autowired
    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<User> findAll(){
        return usersRepository.findAll();
    }

    public User findById(long id) {
        Optional<User> user = usersRepository.findById(id);
        return user.orElse(null);
    }

    @Transactional
    public void save(User user){
        usersRepository.save(user);
    }

    @Transactional
    public void update(long id, User updUser) {
        updUser.setId(id);
        usersRepository.save(updUser);
    }

    @Transactional
    public void delete(long id) {
        usersRepository.deleteById(id);
    }

    @Transactional
    public void gen5Users(){
        for (int i =1; i<6; i++) {
            User user = new User(2220+i, "lastName_"+i, "name_"+i);
            update((long) i, user);
        }
    }

}
