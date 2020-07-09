package design.patterns.abstractfactory;

public class ColorFactory extends AbstractFactory{

	@Override
	public Shape getShape(String shape) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color fillColor(String color) {
		// TODO Auto-generated method stub
		if(color == null) {
			return null;
		}
		if(color.equalsIgnoreCase("Red")) {
			return new Red();
		}else if(color.equalsIgnoreCase("Blue")) {
			return new Blue();
		}else if(color.equalsIgnoreCase("Green")) {
			return new Green();
		}
		
		return null;
	}

}
