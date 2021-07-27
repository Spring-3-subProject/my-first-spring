package hello.hellospring.domain;

public class Todo {
        private String title;
        private Boolean done;
        private long id;

        public String getTitle() {
        return title;
    }

        public void setTitle(String title) {
        this.title = title;
    }

        public Boolean getDone() {
        return done;
    }

        public void setDone(Boolean done) {
            this.done = done;
        }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
