package com.spel.blog.service;

public interface MarkdownService {
    String NAME = "blog_MarkdownService";

    public String toHtml(String markDown);
}