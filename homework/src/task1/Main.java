package task1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		Class commodity = Commodity.class;

		System.out.println("Имя класса: " + commodity.getName());
		System.out.println("Простое имя класса: " + commodity.getSimpleName());
		System.out.println("Модификатор доступа класса: " + Modifier.toString(commodity.getModifiers()));
		System.out.println("Пакет текущего класса: " + commodity.getPackage());
		System.out.println("Родительский класс: " + commodity.getSuperclass());
		System.out.println();

		System.out.println("Класс " + commodity.getSimpleName() + " обладает следующим набором полей: ");
		Field[] commodityFields = commodity.getDeclaredFields();
		for (Field field : commodityFields) {
			System.out.println("Поле " + field);
		}
		System.out
				.println("Общее число всех полей класса " + commodity.getSimpleName() + " - " + commodityFields.length);
		System.out.println();

		System.out.println("Класс " + commodity.getSimpleName() + " обладает следующим набором public полей: ");
		Field[] commodityPublicFields = commodity.getFields();
		for (Field field : commodityPublicFields) {
			System.out.println("Поле " + field);
		}
		System.out.println("Общее число public полей класса " + commodity.getSimpleName() + " - " + commodityPublicFields.length);
		System.out.println();

		System.out.println("Класс " + commodity.getSimpleName() + " обладает следующим набором конструкторов: ");
		Constructor[] commodityConstructors = commodity.getConstructors();
		for (Constructor constructor : commodityConstructors) {
			System.out.println("Конструктор " + constructor);
		}
		System.out.println("Общее число конструкторов класса " + commodity.getSimpleName() + " - " + commodityConstructors.length);
		System.out.println();

		System.out.println("Класс " + commodity.getSimpleName() + " обладает следующим набором методов: ");
		Method[] commodityMethods = commodity.getMethods();
		for (Method method : commodityMethods) {
			System.out.println("Метод " + method);
		}
		System.out.println("Общее число методов класса " + commodity.getSimpleName() + " - " + commodityMethods.length);
		System.out.println();

		System.out.println("Добавим новый товар, используя рефлексию:");
		Constructor<Commodity> constructor = commodity.getConstructor(String.class, int.class, int.class);
		Commodity newInstance = constructor.newInstance("Коробка", 25, 50);
		System.out.println(newInstance);
		System.out.println();

		System.out.println("Изменим название товара, используя рефлексию:");
		Field fieldName = commodity.getField("name");
		fieldName.set(newInstance, "Большая коробка");
		System.out.println(newInstance);
		System.out.println();

		System.out.println("Добавим вес товару, используя рефлексию:");
		Method commodityMethod = commodity.getMethod("setWeight", int.class);
		commodityMethod.invoke(newInstance, 49);
		System.out.println(newInstance);
		System.out.println();

		System.out.println("Выведем название товара на консоль, используя рефлексию:");
		commodityMethod = commodity.getMethod("getName", null);
		System.out.println("Название выбранного товара - " + commodityMethod.invoke(newInstance, null));
		System.out.println();

		System.out.println("Поместим товар на указанную полку, используя рефлексию:");
		commodityMethod = commodity.getMethod("putOnShelf", int.class);
		commodityMethod.invoke(newInstance, 23);
		System.out.println();

		System.out.println("Передадим товар указанному лицу на ответхранение, используя рефлексию:");
		commodityMethod = commodity.getMethod("giveForSafekeeping", String.class);
		commodityMethod.invoke(newInstance, "Ленин В.И.");
	}

}

