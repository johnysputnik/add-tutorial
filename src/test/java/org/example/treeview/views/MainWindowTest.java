package org.example.treeview.views;

import javafx.stage.Stage;
import org.example.treeview.services.ViewFactory;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.io.IOException;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.api.FxToolkit.registerPrimaryStage;
import static org.testfx.matcher.base.NodeMatchers.isVisible;

public class MainWindowTest extends ApplicationTest {

    private final ViewFactory viewFactory = new ViewFactory();

    public static void setupSpec() throws Exception {
        System.setProperty("testfx.robot", "glass");
        System.setProperty("testfx.headless", "true");
        System.setProperty("prism.order", "sw");
        System.setProperty("prism.text", "t2k");
        System.setProperty("java.awt.headless", "true");
        registerPrimaryStage();
    }

    @Override
    public void start(Stage stage) {
        try {
            viewFactory.buildAndShowStage(stage, "/org/example/treeview/views/MainWindow.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTreeViewIsVisible() {
        verifyThat("#treeView", isVisible());
    }

    @Test
    public void testInfoViewIsVisible() {
        verifyThat("#infoView", isVisible());
    }

}
