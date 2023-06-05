public class MemoList {
    private List<Memo> memoList;

    public MemoList() {
        memoList = new ArrayList<>();
    }

    public void modifyMemo(int index, String password, String newContent) {
        for (Memo memo : memoList) {
            if (memo.getIndex() == index) {
                if (memo.getPassword().equals(password)) {
                    memo.setContent(newContent);
                    memo.setTimestamp(LocalDateTime.now());
                    System.out.println("메모가 수정되었습니다.");
                    return;
                } else {
                    System.out.println("비밀번호가 일치하지 않습니다.");
                    return;
                }
            }
        }
        System.out.println("해당 번호의 메모가 존재하지 않습니다.");
    }
}

