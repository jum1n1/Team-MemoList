import java.time.LocalDateTime;

public class Memo {
    private int index; // 글 key(id) 값
    private String name; // 글 작성자 이름
    private String password; // 글 작성한 사람의 패스워드
    private String content;
    private LocalDateTime time;

    public Memo(int index, String name, String password, String content, LocalDateTime time) {
        this.index = index;
        this.name = name;
        this.password = password;
        this.content = content;
        this.time = time;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return time;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.time = timestamp;
    }
}