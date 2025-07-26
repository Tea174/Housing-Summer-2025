package belgium.antwerp.housing.service;

import belgium.antwerp.housing.domain.AppUser;
import belgium.antwerp.housing.domain.Role;

import java.util.List;

public interface AppUserService {
    List<AppUser> getAppUsers();
    AppUser addAppUser(String email, String name, String password, Role role);
    AppUser patchAppUser(final int id, final String name);
    void removeAppUser(final int id);

}
