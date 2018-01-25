package org.example.treeview.acceptance.steps;

import cucumber.api.java8.En;
import javafx.scene.Node;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeView;
import org.example.treeview.TreeviewExampleApplication;
import org.example.treeview.model.ObservablePerson;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.hasText;
import static org.testfx.matcher.base.NodeMatchers.isVisible;


public class TestApplicationSteps implements En {


    static {
        System.setProperty("testfx.robot", "glass");
        System.setProperty("testfx.headless", "true");
        System.setProperty("prism.order", "sw");
        System.setProperty("prism.text", "t2k");
        System.setProperty("java.awt.headless", "true");
    }

    public TestApplicationSteps() {

        Given("^I have the application open$", () -> {
            // nothing to do here
        });

        When("^I select item (\\d+) in (.*)$", (Integer index, String id) -> {

            FxRobot robot = new FxRobot();
            Node node = robot.lookup("#" + id).query();
            TreeView<ObservablePerson> treeView = (TreeView<ObservablePerson>) node;

            TreeCell<ObservablePerson> cellNode = robot.from(treeView).lookup(".tree-cell").nth(index - 1).query();
            treeView.getSelectionModel().select(cellNode.getTreeItem());

            // This doesn't propogate the selection from the click ?
            // Node cellNode = robot.from(treeView).lookup(".tree-cell").nth(index-1).query();
            //robot.clickOn(cellNode);

        });

        Then("^(.*) is visible$", (id) -> {
            verifyThat("#" + id, isVisible());
        });

        Then("^nameField value is equal to the name of item (\\d+) in (.*)", (Integer index, String sourceId) -> {

            FxRobot robot = new FxRobot();
            Node node = robot.lookup("#" + sourceId).query();
            TreeView<ObservablePerson> treeView = (TreeView<ObservablePerson>) node;

            TreeCell<ObservablePerson> cellNode = robot.from(treeView).lookup(".tree-cell").nth(index - 1).query();
            String name = cellNode.getTreeItem().getValue().getName().getValue();
            verifyThat("#nameField", hasText(name));
        });

        // set up the view

        try {
            // before test class:
            FxToolkit.registerPrimaryStage();
            FxToolkit.showStage(); // show primary Stage, if was previously hidden.

            // before each test method:
            FxToolkit.setupStage(stage -> {
                TreeviewExampleApplication app = new TreeviewExampleApplication();
                app.start(stage);
            });
            FxToolkit.showStage();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
