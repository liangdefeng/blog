package com.spel.blog.web.screens.category;

import com.haulmont.cuba.gui.screen.*;
import com.spel.blog.entity.Category;

@UiController("blog_Category.edit")
@UiDescriptor("category-edit.xml")
@EditedEntityContainer("categoryDc")
@LoadDataBeforeShow
public class CategoryEdit extends StandardEditor<Category> {
}