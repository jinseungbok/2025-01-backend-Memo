package com.green.firstserver;

import com.green.firstserver.model.MemoGetOneRes;
import com.green.firstserver.model.MemoGetRes;
import com.green.firstserver.model.MemoPostReq;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController //빈(Bean)등록, 스프링 컨테이너 객체 생성을 대리로 맡긴다., 요청/응답 담당자
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;

//    public MemoController(MemoService memoService) {
//        this.memoService = memoService;
//    }

    // DI 받는 방법 3가지
    // 1. field 주입
    // 2. setter 주입 (메소드 주입)
    // 3. 생성자 주입

    @GetMapping("/memo")
    public List<MemoGetRes> getMemo() {
        return memoService.selMemoList();
    }

    @GetMapping("/memo/{id}")
    public MemoGetOneRes getMemo(@PathVariable int id) {
        System.out.println("getMemo: " + id);
        return memoService.selMemo(id);
    }

//    @GetMapping("/memo/{board_id}")
//    public String getMemo(@PathVariable("board_id") int boardId) {
//        System.out.println("boardId: "  + boardId);
//        return "Hello Board! - boardId: " + boardId ;
//    }

    @PostMapping("/memo")
    public String postMemo(@RequestBody MemoPostReq req) { //@RequestBody는 JSON 데이터를 받을꺼야.
        System.out.println("postMemo: " + req);
        int result = memoService.insMemo(req);
        return result == 1 ? "성공" : "실패";
    }
}
