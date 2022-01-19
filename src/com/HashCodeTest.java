package com;

public class HashCodeTest {

	
	public static void main(String args[]) {
		
		HashCode obj1 = new HashCode(1, "abc");
		HashCode obj2 = new HashCode(1, "abc2");
		
		System.out.println(obj1 == obj2);
		
	}
	
	static class HashCode {
		public int id;
		public String name;

		public HashCode(int id, String name) {
			this.id = id;
			this.name = name;
		}

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
		public int hashCode() {
			return 1;
		}
	}
}
