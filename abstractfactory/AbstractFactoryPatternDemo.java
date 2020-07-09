package design.patterns.abstractfactory;

public class AbstractFactoryPatternDemo {
	public static void main(String[] args) {
		 
		//获取形状工厂
		AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");
		
		//获取Circle的对象，并调用它的draw方法
		Shape shape1 = shapeFactory.getShape("circle");
		
		//调用Circle的draw方法
		shape1.draw();
		
		//获取Rectangle的对象，并调用它的draw方法
		Shape shape2=shapeFactory.getShape("rectangle");
		
		//调用Rectangle的draw方法
		shape2.draw();
		
		//获取Square的对象，并调用它的draw方法
		Shape shape3=shapeFactory.getShape("square");
		
		//调用square的draw方法
		shape3.draw();
		
		
		//获取颜色工厂
		AbstractFactory colorFactory=FactoryProducer.getFactory("color");
		
		//获取颜色为Red的对象
		Color color1 = colorFactory.fillColor("Red");
		
		//调用Red的fill方法
		color1.fill();
		
		//获取颜色为Blue的对象
		Color color2=colorFactory.fillColor("Blue");
		
		//调用Blue的fill方法
		color2.fill();
		
		//获取颜色为Green的对象
		Color color3=colorFactory.fillColor("Green");
		
		//调用Green的fill方法
		color3.fill();
	}

}
