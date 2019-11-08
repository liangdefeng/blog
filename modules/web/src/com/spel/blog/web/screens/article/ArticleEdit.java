package com.spel.blog.web.screens.article;

import com.haulmont.cuba.core.global.EntityStates;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.actions.BaseAction;
import com.haulmont.cuba.gui.icons.CubaIcon;
import com.haulmont.cuba.gui.icons.Icons;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.security.global.UserSession;
import com.spel.blog.entity.Article;
import com.spel.blog.service.MarkdownService;

import javax.inject.Inject;

@UiController("blog_Article.edit")
@UiDescriptor("article-edit.xml")
@EditedEntityContainer("articleDc")
@LoadDataBeforeShow
public class ArticleEdit extends StandardEditor<Article> {

    public final static String POOPUP_MESSAGE = "popupMessage";

    @Inject
    private InstanceContainer<Article> articleDc;

    @Inject
    private UserSession userSession;

    @Inject
    private BrowserFrame browserFrame;

    @Inject
    private MarkdownService markdownService;

    @Inject
    private EntityStates entityStates;

    protected void initActions(@SuppressWarnings("unused") InitEvent event) {

        super.initActions(event);

        Window window = getWindow();
        Messages messages = getBeanLocator().get(Messages.NAME);
        Icons icons = getBeanLocator().get(Icons.NAME);

        Action popupMessageAction = new BaseAction(POOPUP_MESSAGE)
                .withIcon(icons.get(CubaIcon.EDITOR_CANCEL))
                .withCaption(messages.getMainMessage("actions.Cancel"));

        window.addAction(popupMessageAction);
    }

    @Subscribe("contentField")
    public void onContentFieldTextChange(TextInputField.TextChangeEvent event) {
        browserFrame.setSrcdoc(markdownService.toHtml(event.getText()));
    }

    @Subscribe("popupMessageButton")
    public void popupMessage(@SuppressWarnings("unused") Button.ClickEvent event) {
        this.getWindow().showMessageDialog("Debug", event.getSource().getCaption(), Frame.MessageType.WARNING);
    }

    @Subscribe(target = Target.DATA_CONTEXT)
    public void onPreCommit(DataContext.PreCommitEvent event) {
        if (entityStates.isNew(getEditedEntity()) || doNotReloadEditedEntity()) {
            articleDc.getItem().setAuthor(userSession.getUser());
        }
    }
}