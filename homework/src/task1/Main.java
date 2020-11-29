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

		System.out.println("��� ������: " + commodity.getName());
		System.out.println("������� ��� ������: " + commodity.getSimpleName());
		System.out.println("����������� ������� ������: " + Modifier.toString(commodity.getModifiers()));
		System.out.println("����� �������� ������: " + commodity.getPackage());
		System.out.println("������������ �����: " + commodity.getSuperclass());
		System.out.println();

		System.out.println("����� " + commodity.getSimpleName() + " �������� ��������� ������� �����: ");
		Field[] commodityFields = commodity.getDeclaredFields();
		for (Field field : commodityFields) {
			System.out.println("���� " + field);
		}
		System.out
				.println("����� ����� ���� ����� ������ " + commodity.getSimpleName() + " - " + commodityFields.length);
		System.out.println();

		System.out.println("����� " + commodity.getSimpleName() + " �������� ��������� ������� public �����: ");
		Field[] commodityPublicFields = commodity.getFields();
		for (Field field : commodityPublicFields) {
			System.out.println("���� " + field);
		}
		System.out.println("����� ����� public ����� ������ " + commodity.getSimpleName() + " - " + commodityPublicFields.length);
		System.out.println();

		System.out.println("����� " + commodity.getSimpleName() + " �������� ��������� ������� �������������: ");
		Constructor[] commodityConstructors = commodity.getConstructors();
		for (Constructor constructor : commodityConstructors) {
			System.out.println("����������� " + constructor);
		}
		System.out.println("����� ����� ������������� ������ " + commodity.getSimpleName() + " - " + commodityConstructors.length);
		System.out.println();

		System.out.println("����� " + commodity.getSimpleName() + " �������� ��������� ������� �������: ");
		Method[] commodityMethods = commodity.getMethods();
		for (Method method : commodityMethods) {
			System.out.println("����� " + method);
		}
		System.out.println("����� ����� ������� ������ " + commodity.getSimpleName() + " - " + commodityMethods.length);
		System.out.println();

		System.out.println("������� ����� �����, ��������� ���������:");
		Constructor<Commodity> constructor = commodity.getConstructor(String.class, int.class, int.class);
		Commodity newInstance = constructor.newInstance("�������", 25, 50);
		System.out.println(newInstance);
		System.out.println();

		System.out.println("������� �������� ������, ��������� ���������:");
		Field fieldName = commodity.getField("name");
		fieldName.set(newInstance, "������� �������");
		System.out.println(newInstance);
		System.out.println();

		System.out.println("������� ��� ������, ��������� ���������:");
		Method commodityMethod = commodity.getMethod("setWeight", int.class);
		commodityMethod.invoke(newInstance, 49);
		System.out.println(newInstance);
		System.out.println();

		System.out.println("������� �������� ������ �� �������, ��������� ���������:");
		commodityMethod = commodity.getMethod("getName", null);
		System.out.println("�������� ���������� ������ - " + commodityMethod.invoke(newInstance, null));
		System.out.println();

		System.out.println("�������� ����� �� ��������� �����, ��������� ���������:");
		commodityMethod = commodity.getMethod("putOnShelf", int.class);
		commodityMethod.invoke(newInstance, 23);
		System.out.println();

		System.out.println("��������� ����� ���������� ���� �� �������������, ��������� ���������:");
		commodityMethod = commodity.getMethod("giveForSafekeeping", String.class);
		commodityMethod.invoke(newInstance, "����� �.�.");
	}

}

