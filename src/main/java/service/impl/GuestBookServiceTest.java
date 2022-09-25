package service.impl;

import config.ApplicationConfig;
import dto.GuestBook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.GuestBookService;

import java.util.Date;

public class GuestBookServiceTest {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        GuestBookService guestbookService = ac.getBean(GuestBookService.class);

        GuestBook guestbook = new GuestBook();
        guestbook.setName("주동호");
        guestbook.setContent("데이터 베이스 테스트입니다.. 왜 안되는지 모르겠습니다");
        guestbook.setRegdate(new Date());
        GuestBook result = guestbookService.addGuestbook(guestbook, "127.0.0.1");
        System.out.println(result);
    }
}
