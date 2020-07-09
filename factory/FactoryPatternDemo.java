package design.patterns.factory;

public class FactoryPatternDemo {
	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();
		
		//��ȡCircle�Ķ��󣬲���������draw����
		Shape shape1 = shapeFactory.getShape("circle");
		
		//����Circle��draw����
		shape1.draw();
		
		//��ȡRectangle�Ķ��󣬲���������draw����
		Shape shape2=shapeFactory.getShape("rectangle");
		
		//����Rectangle��draw����
		shape2.draw();
		
		//��ȡSquare�Ķ��󣬲���������draw����
		Shape shape3=shapeFactory.getShape("square");
		
		//����square��draw����
		shape3.draw();
	}

}
