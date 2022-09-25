package service;

import dto.GuestBook;

import java.util.List;

public interface GuestBookService {
    public static final Integer LIMIT=5;
    public List<GuestBook> getGuestbooks(Integer start);
    public int deleteGuestbook(Long id,String ip);
    public GuestBook addGuestbook(GuestBook guestBook,String ip);
    public int getCount();
}
