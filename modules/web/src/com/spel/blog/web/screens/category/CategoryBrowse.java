package com.spel.blog.web.screens.category;

import com.haulmont.cuba.gui.screen.*;
import com.spel.blog.entity.Category;

@UiController("blog_Category.browse")
@UiDescriptor("category-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class CategoryBrowse extends MasterDetailScreen<Category> {
}