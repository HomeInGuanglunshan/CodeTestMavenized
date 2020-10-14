package reflectTest.reflectTest07;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by huyanxia on 2017/10/12.
 * <p>
 * https://www.cnblogs.com/zhima-hu/p/7655836.html
 */
public class Test {
	public static void main(String[] args) {
		Human human = new Human();
		//调用测试
		human.getClasses();
	}
}

//泛型类Person
class Person<E> {
	String entityClassName;//类名称
	public Class<E> entityClass;//类原型

	public void getClasses() {
		Class<? extends Person> clazz = this.getClass();//this是human的对象，clazz的值是class com.Human
		Type type = clazz.getGenericSuperclass();//获得clazz的父类，type的值com.Person<com.Hobby>
		Type type1 = ((ParameterizedType) type).getActualTypeArguments()[0];//获得父类的泛型参数的类型，0表示第一个参数，type1的值是class com.Hobby
		this.entityClass = (Class<E>) type1;//class com.Hobby
		this.entityClassName = this.entityClass.getSimpleName();//Hobby
	}
}

class Human extends Person<Hobby> {
	String hobby;
}

class Hobby {

}