package com.infodesk.InfoDesk_and_Online_Consultancy.user;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
 
public class UserDetailsServiceImpl implements UserDetailsService {
 
    // @Autowired
    // private UserRepository userRepository;
     
    // @Override
    // public UserDetails loadUserByUsername(String username)
    //         throws UsernameNotFoundException {
    //     User user = userRepository.getUserByUsername(username);
         
    //     if (user == null) {
    //         throw new UsernameNotFoundException("Could not find user");
    //     }
         
    //     return new MyUserDetails(user);
    // }
    public static Long currentUser;

    @Autowired
    private UserRepository userRepo;
     
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email);
        // currentUser = userRepo.findByEmail(username).getUserId();
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new MyUserDetails(user);
    }
    
    
 
}