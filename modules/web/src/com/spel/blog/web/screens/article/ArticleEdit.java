package com.spel.blog.web.screens.article;

import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.security.global.UserSession;
import com.spel.blog.entity.Article;

import javax.inject.Inject;

@UiController("blog_Article.edit")
@UiDescriptor("article-edit.xml")
@EditedEntityContainer("articleDc")
@LoadDataBeforeShow
public class ArticleEdit extends StandardEditor<Article> {
    @Inject
    private InstanceContainer<Article> articleDc;

    @Inject
    private UserSession userSession;

    @Subscribe(target = Target.DATA_CONTEXT)
    public void onPreCommit(DataContext.PreCommitEvent event) {
        articleDc.getItem().setAuthor(userSession.getUser());
    }
}