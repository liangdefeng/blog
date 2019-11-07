package com.spel.blog;

import com.haulmont.cuba.core.global.*;
import com.spel.blog.entity.Article;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ArticleTest {

    @ClassRule
    public static BlogTestContainer cont = BlogTestContainer.Common.INSTANCE;

    private Metadata metadata;

    @Before
    public void setUp() throws Exception {
        metadata = cont.metadata();
    }

    @Test
    public void testCreateArticle() throws Exception {
        // Get a managed bean (or service) from container
        DataManager dataManager = AppBeans.get(DataManager.class);

        // Create new Customer
        Article article = metadata.create(Article.class);
        article.setTitle("title");
        article.setSeoUrl("seo url 1");
        article.setContent("content");
        article.setTags("tags");
        article.setToTop(true);
        article.setAbstractText("abstract text");

        // Save the customer to the database
        dataManager.commit(article);

        // Load the customer by ID
        Article loaded = dataManager.load(
                LoadContext.create(Article.class).setId(article.getId()).setView(View.LOCAL));

        assertNotNull(loaded);
        assertEquals(article.getTitle(), loaded.getTitle());

        // Remove the customer
        dataManager.remove(loaded);
    }

    @Test
    public void testUpdateArticle() throws Exception {
        // Get a managed bean (or service) from container
        DataManager dataManager = AppBeans.get(DataManager.class);

        // Create new Customer
        Article article = metadata.create(Article.class);
        article.setTitle("title");
        article.setContent("content");
        article.setSeoUrl("seo url 2");
        article.setTags("tags");
        article.setToTop(true);
        article.setAbstractText("abstract text");

        // Save the customer to the database
        dataManager.commit(article);

        // Load the customer by ID
        Article loaded = dataManager.load(
                LoadContext.create(Article.class).setId(article.getId()).setView(View.LOCAL));

        article.setContent("Content 2");
        dataManager.commit(loaded);

        assertNotNull(loaded);
        assertEquals(article.getTitle(), loaded.getTitle());

        // Remove the customer
        dataManager.remove(loaded);
    }
}
