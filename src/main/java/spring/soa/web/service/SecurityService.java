package spring.soa.web.service;

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String userName, String password);
}
