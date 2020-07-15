package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Execute {
	public static void main(String[] args) {

		List<Person> pList = new ArrayList<>();
		pList.add(new Person("동혁", 22, 70));
		pList.add(new Person("상화", 42, 77));
		pList.add(new Person("경훈", 37, 12));
		pList.add(new Person("원영", 26, 95));
		pList.add(new Person("인혁", 33, 1));
		Collections.sort(pList);
		System.out.println(pList);
// public int compareTo(Person o){
//return point-o.point;} 오름차 반대 빼면 내림차 !  가상의 클래스를 만들어서 더 쉽게 표현해낼 수 있다 !! student o1 - o2
	}
}