package AbstractFactory;


public class LightUIFactory implements UIFactory {
    public Button createButton()
    {
        return new LightButton();
    }
    public CheckBox createCheckBox()
    {
        return new LightCheckBox();
    }
}
