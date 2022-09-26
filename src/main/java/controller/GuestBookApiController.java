package controller;

import dto.GuestBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.GuestBookService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/guestbooks")
public class GuestBookApiController {
    @Autowired
    GuestBookService guestBookService;

    @GetMapping
    public Map<String,Object> list(@RequestParam(name = "start",required = false,defaultValue = "0") int start){
        List<GuestBook> list=guestBookService.getGuestbooks(start);

    }

}
