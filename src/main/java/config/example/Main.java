package config.example;

import config.ApplicationConfig;
import dao.GuestBookDao;
import dto.GuestBook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		GuestBookDao guestbookDao = ac.getBean(GuestBookDao.class);

		GuestBook guestbook = new GuestBook();
		guestbook.setName("주동호");
		guestbook.setContent("게스트북 2");
		guestbook.setRegdate(new Date());
		Long id = guestbookDao.insert(guestbook);
		System.out.println("id : " + id);
    }
}