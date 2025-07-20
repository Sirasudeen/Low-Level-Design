package AbstractFactory;


public class App {
        private Button button;
        private CheckBox checkbox;

        public App(UIFactory uif)
        {
            this.button = uif.createButton();
            this.checkbox = uif.createCheckBox();
        }
        public void render()
        {
            button.render();
            checkbox.render();
        }
}
