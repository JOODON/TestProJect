package service.impl;

import dao.LogDao;
import dao.GuestBookDao;
import dto.GuestBook;
import dto.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.GuestBookService;

import java.util.Date;
import java.util.List;

@Service
public class GuestbookServiceimpl implements GuestBookService {
    @Autowired
    GuestBookDao guestBookDao;

    @Autowired
    LogDao logDao;

    @Override
    @Transactional
    public List<GuestBook> getGuestbooks(Integer start){
        List<GuestBook> list = guestBookDao.selectAll(start,GuestBookService.LIMIT);
        return list;
    }

    @Override
    @Transactional(readOnly = false)
    public int deleteGuestbook(Long id, String ip) {
        int deleteCount=guestBookDao.deleteById(id);
        Log log=new Log();
        log.setIp(ip);
        log.setMethod("delete");
        log.setRegdate(new Date());
        logDao.insert(log);
        return deleteCount;
    }

    @Override
    @Transactional
    public GuestBook addGuestbook(GuestBook guestBook,String ip){
        guestBook.setRegdate(new Date());
        Long id=guestBookDao.insert(guestBook);
        guestBook.setId(id);

        Log log = new Log();
        log.setIp(ip);
        log.setMethod("insert");
        log.setRegdate(new Date());
        logDao.insert(log);
        return guestBook;

    }
    @Override
    public int getCount(){
        return guestBookDao.selectCount();
    }
}
