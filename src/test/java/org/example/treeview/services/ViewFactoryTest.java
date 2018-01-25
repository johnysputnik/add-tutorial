package org.example.treeview.services;

import javafx.scene.Parent;
import javafx.util.Pair;
import org.example.treeview.views.MainWindow;
import org.example.treeview.views.MainWindowTest;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.io.IOException;


public class ViewFactoryTest extends ApplicationTest {

    private final ViewFactory viewFactory = new ViewFactory();

    @BeforeClass
    public static void setupSpec() throws Exception {
        MainWindowTest.setupSpec();
    }


    @Test
    public void testCreateView() throws IOException {
        Pair<Parent, Object> view = viewFactory.createView("/org/example/treeview/views/MainWindow.fxml");
        Assert.assertNotNull(view.getKey());
        Assert.assertNotNull(view.getValue());

        Assert.assertTrue(view.getValue() instanceof MainWindow);
    }

    @Test
    public void testCreateViewNoFile() throws IOException {
        Pair<Parent, Object> view = viewFactory.createView("/org/example/treeview/views/NoWindow.fxml");
        Assert.assertNull(view.getKey());
        Assert.assertNull(view.getValue());
    }

}
