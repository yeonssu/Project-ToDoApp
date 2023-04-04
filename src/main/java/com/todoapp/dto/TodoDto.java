package com.todoapp.dto;

import lombok.*;

public class TodoDto {
    @Getter
    @Setter
    public static class Post {
        private String title;
        private int todoOrder;
        private boolean completed;
    }

    @Getter
    @Setter
    public static class Patch {
        private long id;
        private String title;
        private int todoOrder;
        private boolean completed;
    }

    @Getter
    @Setter
    public static class Response {
        private long id;
        private String title;
        private int todoOrder;
        private boolean completed;
    }
}
