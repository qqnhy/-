package design.patterns.factory;

public class ShapeFactory {
	public Shape getShape(String shapeType) {
		if(shapeType == null) {
			return null;
		}
		if(shapeType.equalsIgnoreCase("CIRCLE")) {
			return new Circle();
		}
		if(shapeType.equalsIgnoreCase("SQUARE")) {
			return new Rectangle();
		}
		if(shapeType.equalsIgnoreCase("RECTANGLE")) {
			return new Rectangle();
		}
		return null;
	}

}
