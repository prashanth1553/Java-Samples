package com;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;

public class SerializationTest {

	public static void main(String args[]) throws IOException, ClassNotFoundException {

		String fileName = "Prashanth";
		SerializationObject obj = new SerializationObject();
		obj.setId(1553);
		obj.setName("Prashanth");
		obj.setParent("parent");
//		obj.setSchool("ZPHS");
		serialize(obj, fileName);

		SerializationObject dObject = (SerializationObject) deserialize(fileName);
		System.out.println(dObject);

	}

	public static Object deserialize(String fileName) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object obj = ois.readObject();
		ois.close();
		return obj;
	}

// serialize the given object and save it to file
	public static void serialize(Object obj, String fileName) throws IOException {
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj);

		fos.close();
	}

	static class SerializationObjectParent
			implements Serializable, Comparator<SerializationObjectParent>, Comparable<SerializationObjectParent> {

		public String parent;

		public String getParent() {
			return parent;
		}

		public void setParent(String parent) {
			this.parent = parent;
		}

		@Override
		public int compareTo(SerializationObjectParent o) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int compare(SerializationObjectParent o1, SerializationObjectParent o2) {
			// TODO Auto-generated method stub
			return 0;
		}

	}

	static class SerializationObject extends SerializationObjectParent implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public int id;
		public String name;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "SerializationObject{name=" + name + ",id=" + id + ",school=" + parent + "}";
		}
	}
}
