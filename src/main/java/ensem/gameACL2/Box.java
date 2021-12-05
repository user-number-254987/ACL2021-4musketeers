package ensem.gameACL2;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Box extends Rectangle {
	
	BoxType type;
	
    public Box(boolean light, int x, int y) {
        setWidth(App.BOX_SIZE);
        setHeight(App.BOX_SIZE);

        relocate(x * App.BOX_SIZE, y * App.BOX_SIZE);
        
        //Image img = new Image(BOX_IMAGE, App.BOX_SIZE, App.BOX_SIZE, false, false);
        //setFill(new ImagePattern(img));

        setFill(light ? Color.valueOf("#feb") : Color.valueOf("#582"));
    }
    
    public BoxType getType() {
		return type;
	}

	public void setType(BoxType type) {
		this.type = type;
	}

	public Box(Image img, int x, int y) {
    	setWidth(App.BOX_SIZE);
        setHeight(App.BOX_SIZE);

        relocate(x * App.BOX_SIZE, y * App.BOX_SIZE);
        
        //Image img = new Image(BOX_IMAGE, App.BOX_SIZE, App.BOX_SIZE, false, false);
        setFill(new ImagePattern(img));
    }
}