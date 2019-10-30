package com.spel.blog.web.screens.article;

import com.haulmont.cuba.gui.screen.*;
import com.spel.blog.entity.Article;

@UiController("blog_Article.edit")
@UiDescriptor("article-edit.xml")
@EditedEntityContainer("articleDc")
@LoadDataBeforeShow
public class ArticleEdit extends StandardEditor<Article> {
}