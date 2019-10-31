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

    String POOPUP_MESSAGE = "popupMessage";

    protected void initActions(@SuppressWarnings("unused") InitEvent event) {

        super.initActions(event);

        Window window = getWindow();
        Messages messages = getBeanLocator().get(Messages.NAME);
        Icons icons = getBeanLocator().get(Icons.NAME);

        Action popupMessageAction = new BaseAction(POOPUP_MESSAGE)
                .withIcon(icons.get(CubaIcon.EDITOR_CANCEL))
                .withCaption(messages.getMainMessage("actions.Cancel"))
                .withHandler(this::popupMessage);

        window.addAction(popupMessageAction);
    }

    protected void popupMessage(@SuppressWarnings("unused") Action.ActionPerformedEvent event) {
        this.getWindow().showMessageDialog("Debug", event.getSource().getCaption(), Frame.MessageType.WARNING);
    }

    private EntityStates getEntityStates() {
        return getBeanLocator().get(EntityStates.NAME);
    }

    @Subscribe("contentField")
    public void onContentFieldValueChange(HasValue.ValueChangeEvent<String> event) {

    }

    @Subscribe(target = Target.DATA_CONTEXT)
    public void onPreCommit(DataContext.PreCommitEvent event) {
        if (getEntityStates().isNew(getEditedEntity()) || doNotReloadEditedEntity()) {
            articleDc.getItem().setAuthor(userSession.getUser());
        }
    }
}