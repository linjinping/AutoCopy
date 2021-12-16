package cn.jplin.autocopyserver;

import cn.jplin.autocopyserver.pojo.Board;
import cn.jplin.autocopyserver.utils.FixLinkedList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "/", produces = "application/json; charset=utf-8")
public class Controller {
    Logger logger = LoggerFactory.getLogger(Controller.class);
    private LocalDateTime time = LocalDateTime.now();
    private String board = "null...";
    @GetMapping("/time")
    public String changeTime(){
        return time.toString().replaceAll("T", " ");
    }

    @PostMapping("/board")
    public String setBoard(@RequestBody Board body){
        time = LocalDateTime.now();
        this.board = body.getString();
        logger.info("string: " + board);
        return changeTime();
    }

    @GetMapping("/board")
    public String getBoard(){
        return board;
    }
}
