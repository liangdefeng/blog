package com.spel.blog.service;

public interface MarkdownToHtmlService {
    String NAME = "blog_MarkdownToHtmlService";


    public String convert(String markDown);
}