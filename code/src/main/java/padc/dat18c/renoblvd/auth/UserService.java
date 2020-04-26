package padc.dat18c.renoblvd.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final AuthGroupRepository authGroupRepository;

    public UserService(UserRepository userRepository, AuthGroupRepository authGroupRepository){
        super();
        this.userRepository = userRepository;
        this.authGroupRepository= authGroupRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);
        if(null== user){
            throw new UsernameNotFoundException("cannot find username: " + username);
        }
        List<AuthGroup> authGroups = this.authGroupRepository.findByUsername(username);
        return new UserPrincipal(user, authGroups);
    }


    public List<User> getAll(){
        return (List<User>) this.userRepository.findAll();
    }

    public void create(User user){
        userRepository.save(user);
    }

    public void delete(int id){
        userRepository.deleteById(id);
    }
    public User findById(int id){
        return userRepository.findById(id).get();
    }
    public void update(User user){
        userRepository.save(user);
    }
    public List<AuthGroup> getUserGroup(){
        return (List<AuthGroup>) this.authGroupRepository.findAll();
    }

    public void saveRole(AuthGroup authGroup){
        authGroupRepository.save(authGroup);
    }
    public AuthGroup getRole(int id){
        long longId = id;
        return authGroupRepository.findById(longId).get();
    }
    public void deleteRole(int id){
        long longId = id;
        authGroupRepository.deleteById(longId);
    }
}