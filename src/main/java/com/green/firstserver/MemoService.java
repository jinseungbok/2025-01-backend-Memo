package com.green.firstserver;

import com.green.firstserver.model.MemoGetOneRes;
import com.green.firstserver.model.MemoGetRes;
import com.green.firstserver.model.MemoPostReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 빈등록
@RequiredArgsConstructor
public class MemoService {
    // Persistence DB 작업 처리 (로직 + DB 작업)

    // 생성자로 주입
    private final MemoMapper memoMapper;

    public int insMemo(MemoPostReq req) {
        return memoMapper.insMemo(req);
    } // insert

    public List<MemoGetRes> selMemoList() {
        return memoMapper.selMemoList();
    } // select
    public MemoGetOneRes selMemo(int id) {
        return memoMapper.selMemo(id);
    }
}