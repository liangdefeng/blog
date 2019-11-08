package com.spel.blog.web.article;

import com.haulmont.cuba.core.app.NumberIdService;
import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.TextArea;
import com.haulmont.cuba.gui.components.TextInputField;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.OpenMode;
import com.haulmont.cuba.gui.screen.UiControllerUtils;
import com.haulmont.cuba.web.app.main.MainScreen;
import com.haulmont.cuba.web.testsupport.TestEntityFactory;
import com.haulmont.cuba.web.testsupport.TestEntityState;
import com.haulmont.cuba.web.testsupport.TestUiEnvironment;
import com.haulmont.cuba.web.testsupport.proxy.TestServiceProxy;
import com.spel.blog.entity.Article;
import com.spel.blog.web.BlogWebTestContainer;
import com.spel.blog.web.screens.article.ArticleEdit;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ArticleEditTest {

    @Rule
    public TestUiEnvironment environment =
            new TestUiEnvironment(BlogWebTestContainer.Common.INSTANCE).withUserLogin("admin");

    private Article article;

    @Before
    public void setUp() throws Exception {

        TestServiceProxy.mock(NumberIdService.class, new NumberIdService() {
            @Override
            public Long createLongId(String entityName, String sequenceName) {
                return new Long(1);
            }

            @Override
            public Long createCachedLongId(String entityName, String sequenceName) {
                return new Long(1);
            }
        });

        TestEntityFactory<Article> articleFactory =
                environment.getContainer().getEntityFactory(Article.class, TestEntityState.NEW);
        article = articleFactory.create(Collections.emptyMap());
    }

    @Test
    public void testClickPopupMessage() {
        Screens screens = environment.getScreens();
        screens.create(MainScreen.class, OpenMode.ROOT);
        ArticleEdit articleEdit = screens.create(ArticleEdit.class);
        articleEdit.setEntityToEdit(article);
        articleEdit.show();
        assertNull(articleEdit.getEditedEntity().getTitle());
        TextArea content = (TextArea) articleEdit.getWindow().getComponent("contentField");
        articleEdit.onContentFieldTextChange(new TextInputField.TextChangeEvent(content, "Test", 0));

        Button btn = (Button) articleEdit.getWindow().getComponent("popupMessageButton");
        articleEdit.popupMessage(new Button.ClickEvent(btn));
        articleEdit.getEditedEntity().setTitle("Title1");
        articleEdit.getEditedEntity().setContent("Hellow");
        articleEdit.closeWithCommit();

        InstanceContainer articleDc = UiControllerUtils.getScreenData(articleEdit).getContainer("articleDc");
        assertEquals(article, articleDc.getItem());
        assertEquals(article, articleDc.getItem());
    }
}

