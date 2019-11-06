package com.spel.blog.service;

import org.junit.Assert;
import org.junit.Test;

public class MarkdownServiceBeanTest {

    @Test
    public void testToHtml() {
        MarkdownServiceBean bean = new MarkdownServiceBean();
        Assert.assertNotNull(bean.toHtml("test"));
    }
}
