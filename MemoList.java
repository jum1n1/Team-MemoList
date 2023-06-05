import java.util.*;
import java.time.LocalDateTime;

public class MemoList {
    private List<Memo> memoList;
    private int count; // 메모 개수를 관리하는 변수

    public MemoList() {
        memoList = new ArrayList<>();
        count = 0;
    }

    public void addMemo(Memo memo) {
        memo.setIndex(count);
        memoList.add(memo);
        count++;
    }

    public List<Memo> getMemos() {
        return memoList;
    }

    public void modifyMemo(int index, String newPassword, String newContent) {
        boolean isModified = false;
        for (Memo memo : memoList) {
            if (memo.getIndex() == index) {
                if (memo.getPassword().equals(newPassword)) {
                    memo.setContent(newContent);
                    memo.setTimestamp(LocalDateTime.now());
                    System.out.println("작성자 " + memo.getName() + "님의 메모가 수정 되었습니다.");
                    isModified = true;
                    break;
                } else {
                    System.out.println("비밀번호가 일치하지 않습니다.");
                    isModified = true;
                    break;
                }
            }
        }
        if (!isModified) {
            System.out.println("해당 인덱스는 존재하지 않습니다.");
        }
    }
}
