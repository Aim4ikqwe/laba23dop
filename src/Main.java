interface Button{
    void information();
}
class StandardButton implements Button{
    public void information(){
        System.out.println("Это кнопка");
    }
}
abstract class Decorator implements Button{
    Button buttonDecorator;
    public Decorator(Button buttonDecorator) {
        this.buttonDecorator = buttonDecorator;
    }
    public void information(){ buttonDecorator.information();}
}
class Image extends Decorator {
    public Image(Button buttonDecorator){
        super(buttonDecorator);
    }
    public void information(){
        buttonDecorator.information();
        imageInfo();
    }
    public void imageInfo(){
        System.out.println("с рисунком");
    }
}

class Text extends Decorator {
    public Text(Button buttonDecorator){
        super(buttonDecorator);
    }
    public void information(){
        buttonDecorator.information();
        textInfo();
    }
    public void textInfo(){
        System.out.println("с надписью");
    }
}

class Circle extends Decorator {
    public Circle(Button buttonDecorator) {
        super(buttonDecorator);
    }

    public void information(){
        buttonDecorator.information();
        circleInfo();
    }
    public void circleInfo(){
        System.out.println("круглая");
    }

}
public class Main {
    public static void main(String[] args) {
        Button BasicButton = new StandardButton();
        BasicButton.information();
        Button ImageButton = new Image(BasicButton);
        ImageButton.information();
        Button TextButton = new Text(BasicButton);
        TextButton.information();
        Button CircleButton = new Circle(TextButton);
        CircleButton.information();
    }
}