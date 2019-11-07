package com.spel.blog.web.web.article;

import com.haulmont.cuba.core.app.NumberIdService;
import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.web.testsupport.proxy.TestServiceProxy;
import com.spel.blog.web.BlogWebTestContainer;
import com.haulmont.cuba.gui.screen.OpenMode;
import com.haulmont.cuba.web.app.main.MainScreen;
import com.haulmont.cuba.web.testsupport.TestEntityFactory;
import com.haulmont.cuba.web.testsupport.TestEntityState;
import com.haulmont.cuba.web.testsupport.TestUiEnvironment;
import com.spel.blog.entity.Article;
import com.spel.blog.web.screens.article.ArticleEdit;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ArticleEditInteractionTest {

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
    public void testGenerateName() {
        Screens screens = environment.getScreens();

        screens.create(MainScreen.class, OpenMode.ROOT).show();

        ArticleEdit articleEdit = screens.create(ArticleEdit.class);
        articleEdit.setEntityToEdit(article);
        articleEdit.show();

        assertNull(articleEdit.getEditedEntity().getTitle());

        // Button generateBtn = (Button) articleEdit.getWindow().getComponent("generateBtn");
        // articleEdit.onContentFieldTextChange();onGenerateBtnClick(new Button.ClickEvent(generateBtn));
        // assertEquals("Generated name", articleEdit.getEditedEntity().getTitle());
    }
}

