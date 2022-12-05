import java.util.Scanner;

public class Lab2_5 {
	
	
	
	
	public static void main(String[] args) {
		//사용자가 습도 온도를 입력해 불쾌지수 게산
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("불쾌지수 계산");
			DIscomfortIndexCalculator yourcal = new DIscomfortIndexCalculator();
			System.out.println("섭씨온도?");
			yourcal.setT(scan.nextDouble());
			System.out.println("습도?");
			yourcal.setRH(scan.nextDouble());
			double trash = yourcal.calculate(yourcal.getRH(), yourcal.getT());
			System.out.println("불쾌지수는 "+trash+" 입니다");
			System.out.println("당신의 불쾌지수 단계는 "+DiscomfortIndex.getIndex(trash)+" 입니다");
			System.out.println("더 게산하기 원하시면 q를 누르세요");
			String more = scan.next();
			if(more.equals("q"))
				continue;
			else
				break;
			}
		
	}

}
