package com.yzak.spring_mongo.domain;

import java.io.Serializable;
import java.time.Instant;

public class Post implements Serializable {

    private String id;
    private Instant date;
    private String title;
    private String body;

    private User user;
}
