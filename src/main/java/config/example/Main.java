package config.example;

import config.ApplicationConfig;
import dao.RoleDao;
import dto.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        //어느 클래스에서 읽어 올거냐? 라는걸 선언 해줌!
        RoleDao roleDao = ac.getBean(RoleDao.class);

        List<Role> list = roleDao.selectAll();

        for (Role role : list) {
            System.out.println(role);
        }
    }
}