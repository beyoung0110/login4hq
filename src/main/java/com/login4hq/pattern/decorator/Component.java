package com.login4hq.pattern.decorator;

import com.sun.xml.internal.rngom.parse.host.Base;

abstract class Component {
	public abstract void Operation();
	
	public static void main(String[] args){
		ComcreteComponent c = new ComcreteComponent();
		ConcreteDecoratorA d1 = new ConcreteDecoratorA();
		ConcreteDecoratorB d2 = new ConcreteDecoratorB();
		d1.SetComponent(c);
		d2.SetComponent(d1);
		d1.Operation();
		System.out.println("/n--------------------/n");
		d2.Operation();
	}
}

class ComcreteComponent extends Component{
	public void Operation(){
		System.out.println("具体对象的操作");
	}
}

class Decorator extends Component{
	public Component component;
	public void SetComponent(Component component){
		this.component = component;
	}
	public void Operation(){
		if( component != null){
			component.Operation();
		}
	}
}

class ConcreteDecoratorA extends Decorator{
	private String addedState;
	public void Operation(){
		super.Operation();
		addedState = "New State";
		System.out.println("具体装饰对象A的操作");		
	}	
}

class ConcreteDecoratorB extends Decorator{
	public void Operation(){
		super.Operation();
		AddedBehavior();
		System.out.println("具体装饰对象B的操作");		
	}
	
	private void AddedBehavior(){
		System.out.println("对象B添加的操作");		
	}
}



