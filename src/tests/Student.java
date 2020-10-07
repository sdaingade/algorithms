package tests;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Student {
  public String name;
  public int section;

  public static Comparator<Student> BY_NAME = new ByName();
  public static Comparator<Student> BY_SECTION = new BySection();

  public Student(String name, int section) {
	  this.name = name;
	  this.section = section;
  }
  
  private static class ByName implements Comparator<Student> {
	@Override
	public int compare(Student v, Student w) {
		return v.name.compareTo(w.name);
	}
  }
	
  public static class BySection implements Comparator<Student> {
	@Override
	public int compare(Student v, Student w) {
		return v.section - w.section;
	}
  }

   public static void main(String[] args) {
	   Student s1 = new Student("abc",1);
	   Student s2 = new Student("abcd",2);
	   Student[] students = {s1, s2};
	   Arrays.sort(students, Student.BY_SECTION);
   }
}
