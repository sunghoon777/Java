
public class Lab5_2 {
	//32163219 이성훈
	//HeatIndexCalculator double temperature, double relativeHumidity
	//add 메소드
	public static void add(Manager manager) {
		System.out.println("ADD");
		manager.add(new HeatIndexCalculator(19.8,60));
		manager.add(new HeatIndexCalculator(16.4,30));
		manager.add(new HeatIndexCalculator(17.2,40));
		manager.add(new HeatIndexCalculator(13.3,50));
		manager.add(new HeatIndexCalculator(19.7,20));
		manager.add(new HeatIndexCalculator(19.5,10));
	}
	
	//제거 메소드
	public static void remove(Manager manager) {
		System.out.println("REMOVE");
		manager.remove();
	}
	
	//데이터들 모두 출력
	public static void print(Manager manager) {
		System.out.println("print ALL DATA");
		manager.print();
	}
	
	//HeatIndexcalculate 기준으로 정렬
	public static void sort(Manager manager) {
		System.out.println("SORT by HeatIndexcalculate");
		manager.sort(new HeatComparator());
	}
	
	//replace
	public static void replace(Manager manager) {
		System.out.println("replace data 가장 바닥에 있는 노드 대체 ");
		HeatIndexCalculator data = new HeatIndexCalculator(19.8,60);
		manager.replace(data, new HeatIndexCalculator(24,20));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manager manager= new Manager();
		add(manager);
		print(manager);
		remove(manager);
		print(manager);
		replace(manager);
		print(manager);
		sort(manager);
		print(manager);
	}

}

