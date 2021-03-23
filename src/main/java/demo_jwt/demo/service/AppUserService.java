package demo_jwt.demo.service;

import demo_jwt.demo.model.AppUser;
import demo_jwt.demo.repository.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserService implements IAppUserService, UserDetailsService {
    @Autowired
    private AppUserRepo appUserRepo;
    @Override
    public AppUser findByName(String name) {
        return appUserRepo.findAppUserByUsername(name);
    }

//    @Override
//    public AppUser getUserCurrent() {
//        AppUser appUser;
//        String name;
//        Object ob = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        if (ob instanceof UserDetails){
//            name = ((UserDetails)ob).getUsername();
//        }
//        else {
//            name = ob.toString();
//        }
//        appUser = this.findByName(name);
//
//        return appUser;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser=findByName(username);
        List<GrantedAuthority> authorities=new ArrayList<>();
        authorities.add(appUser.getRole());
        UserDetails userDetails=new User(appUser.getUsername(),appUser.getPassword(),authorities);
        return userDetails;
    }
}

