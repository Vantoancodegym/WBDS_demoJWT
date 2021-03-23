package demo_jwt.demo.service;

import demo_jwt.demo.model.AppUser;

public interface IAppUserService {
    AppUser findByName(String name);
//    AppUser getUserCurrent();
}
