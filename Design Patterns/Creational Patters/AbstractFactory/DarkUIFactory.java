package AbstractFactory;

public class DarkUIFactory implements UIFactory {
    @Override
    public Button createButton()
    {
        return new DarkButton();
    }
    public CheckBox createCheckBox()
    {
        return new DarkCheckBox();
    }
}
