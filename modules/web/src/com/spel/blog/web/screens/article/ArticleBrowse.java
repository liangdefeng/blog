package com.spel.blog.web.screens.article;

import com.haulmont.cuba.gui.screen.*;
import com.spel.blog.entity.Article;

@UiController("blog_Article.browse")
@UiDescriptor("article-browse.xml")
@LookupComponent("articlesTable")
@LoadDataBeforeShow
public class ArticleBrowse extends StandardLookup<Article> {
}