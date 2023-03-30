package views.registry;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import views.InputPanel;
import views.PassPanel;
import views.TitlePanel;

public class RegistryView extends VBox {
    Label registryLabel;
    TitlePanel titlePanel;
    InputPanel nameInput;
    InputPanel emailInput;
    PassPanel passInput;
    PassPanel passAgainInput;
    
    public RegistryView() {

        this.initComponent();
        this.setComponent();
        this.addComponent();
        this.setPanel();
        this.addButton();

    }

    private void initComponent() {
        this.titlePanel = new TitlePanel();
        this.nameInput = new InputPanel();
        this.emailInput = new InputPanel();
        this.passInput = new PassPanel();
        this.passAgainInput = new PassPanel();
    }

    private void setComponent() {
        this.titlePanel.setText(" Regisztáció ");
        this.nameInput.setText("Név :");
        this.emailInput.setText("Email :");
        this.passInput.setText("Jelszó :");
        this.passAgainInput.setText("Jelszó megerősítése :");
    }

    private void addComponent() {
        this.getChildren().add(this.titlePanel);
        this.getChildren().add(this.nameInput);
        this.getChildren().add(this.emailInput);
        this.getChildren().add(this.passInput);
        this.getChildren().add(this.passAgainInput);
    }
    
    private void setPanel() {
        this.setAlignment(Pos.CENTER);
    }
    
    private void addButton() {
    
        Button registryButton = new Button();
        registryButton.setText("Regisztráció");
        this.getChildren().add(registryButton);
    }
}