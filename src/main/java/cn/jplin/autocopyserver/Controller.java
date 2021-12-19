package cn.jplin.autocopyserver;

import cn.jplin.autocopyserver.pojo.Body;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@Slf4j
@RequestMapping(path = "/", produces = "application/json; charset=utf-8")
public class Controller {
    private LocalDateTime time = LocalDateTime.now();
    private String board = "null...";
    @GetMapping("/time")
    public String changeTime(){
        return time.toString();
    }

    @PostMapping("/board")
    public String setBoard(@RequestBody Body body){
        time = LocalDateTime.now();
        this.board = body.getString();
        log.info("Board content: " + board);
        return changeTime();
    }

    @GetMapping("/board")
    public String getBoard(){
        return board;
    }
}
