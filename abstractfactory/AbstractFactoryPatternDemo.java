package design.patterns.abstractfactory;

public class AbstractFactoryPatternDemo {
	public static void main(String[] args) {
		 
		//��ȡ��״����
		AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");
		
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
		
		
		//��ȡ��ɫ����
		AbstractFactory colorFactory=FactoryProducer.getFactory("color");
		
		//��ȡ��ɫΪRed�Ķ���
		Color color1 = colorFactory.fillColor("Red");
		
		//����Red��fill����
		color1.fill();
		
		//��ȡ��ɫΪBlue�Ķ���
		Color color2=colorFactory.fillColor("Blue");
		
		//����Blue��fill����
		color2.fill();
		
		//��ȡ��ɫΪGreen�Ķ���
		Color color3=colorFactory.fillColor("Green");
		
		//����Green��fill����
		color3.fill();
	}

}
