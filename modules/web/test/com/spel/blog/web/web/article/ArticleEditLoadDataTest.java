package com.spel.blog.web.web.article;

import com.haulmont.cuba.core.app.DataService;
import com.haulmont.cuba.core.app.NumberIdService;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.gui.Screens;
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
import mockit.Delegate;
import mockit.Expectations;
import mockit.Mocked;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.*;

public class ArticleEditLoadDataTest {
    @Rule
    public TestUiEnvironment environment =
            new TestUiEnvironment(BlogWebTestContainer.Common.INSTANCE).withUserLogin("admin");

    @Mocked
    private DataService dataService;

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

        new Expectations() {{
            dataService.load((LoadContext<? extends Entity>) any);

            result = new Delegate() {
                Entity load(LoadContext lc) {

                    if ("blog_Article".equals(lc.getEntityMetaClass())) {
                        return article;
                    } else
                        return article;
                }
            };
        }};

        TestServiceProxy.mock(DataService.class, dataService);

        TestEntityFactory<Article> articleFactory =
                environment.getContainer().getEntityFactory(Article.class, TestEntityState.DETACHED);

        article = articleFactory.create(
                "title", "title",
                "content", "content value"
        );
    }

    @After
    public void tearDown() throws Exception {
        TestServiceProxy.clear();
    }

    @Test
    public void testGenerateName() {
        Screens screens = environment.getScreens();

        screens.create(MainScreen.class, OpenMode.ROOT).show();

        ArticleEdit articleEdit = screens.create(ArticleEdit.class);
        articleEdit.setEntityToEdit(article);
        articleEdit.show();

        assertNotNull(articleEdit.getEditedEntity().getTitle());

        InstanceContainer articleDc = UiControllerUtils.getScreenData(articleEdit).getContainer("articleDc");
        assertEquals(article, articleDc.getItem());
    }
}
