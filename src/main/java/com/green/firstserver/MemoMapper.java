package com.green.firstserver;

import com.green.firstserver.model.MemoGetOneRes;
import com.green.firstserver.model.MemoGetRes;
import com.green.firstserver.model.MemoPostReq;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
// interface가 implements한 클래스가 생성, 그 클래스를 객체화(주소값).
// 주소값을 스프링 컨테이너가 들고 있는다.
// 스프링 컨테이너가 객체 주소값을 들고 있을 수 있는 건 빈 등록이 되었기 때문

@Mapper
public interface MemoMapper {
    // insert, update, delete 작업은 메소드 생성 시 리턴 타입 int (select 제외)
    int insMemo(MemoPostReq req);
    List<MemoGetRes> selMemoList();
    MemoGetOneRes selMemo(int id);
}
