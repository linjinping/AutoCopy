package cn.jplin.autocopyserver;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "/", produces = "application/json; charset=utf-8")
public class Controller {
    private LocalDateTime time = LocalDateTime.now();
    private String board = "null...";

    @GetMapping("/time")
    public String changeTime(){
        return time.toString().replaceAll("T", " ");
    }

    @PostMapping("/board")
    public String setBoard(@RequestBody String string){
        time = LocalDateTime.now();
        this.board = string;
        return changeTime();
    }

    @GetMapping("/board")
    public String getBoard(){
        return board;
    }
}
