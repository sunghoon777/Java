package chapter4;

import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("문제 입력");
		int problem = scan.nextInt();
		scan.nextLine();
		
		//상속 문제(1-2) TV -> ColorTV ->  IPTV 클래스는 상속관계
		if(problem == 1) {
			ColorTV myTV = new ColorTV(32,1024);
			myTV.printProperty();
		}
		else if(problem == 2) {
			IPTV iptv = new IPTV("192.1.1.2",32,2048);
			iptv.printProperty();
		}
		
		//상속 문제(3-4) Converter -> Won2Dollar Converter -> Km2Mile 상속관계
		else if(problem == 3) {
			Won2Dollar toDollor = new Won2Dollar(1200);
			toDollor.run();
		}
		else if(problem == 4) {
			Km2Mile toMile = new Km2Mile(1.6);
			toMile.run();
		}
		
		//상속, 다양한 형태의 생성자 문제(5-8) Point -> ColorPoint Point -> Point3D  Point -> PositivePoint 상속 관계
		else if(problem == 5) {
			ColorPoint cp = new ColorPoint(5,5,"YELLOW");
			cp.setXY(10, 20);
			cp.setColor("RED");
			String str = cp.toString();
			System.out.println(str);
		}
		else if(problem == 6) {
			ColorPoint zeroPoint = new ColorPoint();
			System.out.println(zeroPoint.toString());
			ColorPoint cp = new ColorPoint(10,10);
			cp.setXY(5, 5);
			cp.setColor("RED");
			System.out.println(cp.toString());
		}
		else if(problem == 7) {
			Point3D p  = new Point3D(1,2,3);
			System.out.println(p.toString());
			p.moveUp();
			System.out.println(p.toString());
			p.moveDown();
			p.move(10, 10);	
			System.out.println(p.toString());
			p.move(100, 200, 300);
			System.out.println(p.toString());
		}
		else if(problem == 8) {
			PositivePoint p = new PositivePoint();
			p.move(10, 10);
			System.out.println(p.toString());
			p.move(-5, 5);
			System.out.println(p.toString());
			PositivePoint p2 = new PositivePoint(-10,-10);
			System.out.println(p2.toString());
		}
		//스택 구현
		else if(problem == 9) {
			StackApp stack = new StackApp();
			scan.nextLine();
			while(true) {
				System.out.print("1. 입력   2.  빼기  >>");
				String select = scan.nextLine();
				if(select.equals("1")) {
					System.out.print("문자열 입력 >>");
					String data = scan.nextLine();
					if(data.equals("그만")) {
						int length = stack.length();
						for(int i=0;i<length;i++) {
							System.out.println(stack.pop());
						}
						break;
					}
					boolean success = stack.push(data);
					if(success == false) {
						System.out.println("스택이 꽉차서 푸시 불가");
					}
					
				}
				else if(select.equals("2")) {
					String data = stack.pop();
					if(data.equals("")) {
						System.out.println("스택이 이미 비었습니다.");
					}
				}
				else {
					System.out.println("잘못입력함 다시하세요");
				}
			}
		}
		//HashMap 구현
		else if(problem == 10) {
			Dictionary dic = new Dictionary(10);
			while(true) {
				System.out.print("1. 입력 2.  빼기 3. 길이 4. 데이터 얻기  >>");
				String select = scan.nextLine();
				if(select.equals("1")) {
					System.out.print("키 입력 >>");
					String key = scan.nextLine();
					System.out.print("값 입력 >>");
					String value = scan.nextLine();
					dic.put(key, value);
				}
				else if(select.equals("2")) {
					System.out.print("키 입력 >>");
					String key = scan.nextLine();
					String data = dic.delete(key);
					if(data == null) {
						System.out.println("해당 key는 존재하지 않습니다");
					}
				}
				else if(select.equals("3")) {
					System.out.println("길이는 "+dic.length()+" 입니다.");
				}
				else if(select.equals("4")) {
					System.out.print("키 입력 >>");
					String key = scan.nextLine();
					String data = dic.get(key);
					if(data != null) {
						System.out.println(data);
					}
					else {
						System.out.println("해당 key는 존재하지 않습니다.");
					}
				}
				else {
					System.out.println("다시 입력하세요");
				}
			}
		}
		//add sub mul div
		else if(problem == 11) {
			Cal cal = null;
			System.out.print("두 정수와 연산자를 입력하시오 >> ");
			String a = scan.nextLine();
			String list[] = a.split(" ");
			String operator = list[2];
			if(operator.equals("+")) {
				cal = new Add();
				cal.setValue(Integer.parseInt(list[0]),Integer.parseInt(list[1]));
				System.out.println(	cal.calculate());
			}
			else if(operator.equals("-")) {
				cal = new Sub();
				cal.setValue(Integer.parseInt(list[0]),Integer.parseInt(list[1]));
				System.out.println(	cal.calculate());
			}
			else if(operator.equals("*")) {
				cal = new Mul();
				cal.setValue(Integer.parseInt(list[0]),Integer.parseInt(list[1]));
				System.out.println(	cal.calculate());
			}
			else if(operator.equals("/")) {
				cal = new Div();
				cal.setValue(Integer.parseInt(list[0]),Integer.parseInt(list[1]));
				System.out.println(	cal.calculate());
			}
		}
		//오버라이딩 문제
		else if(problem == 12) {
			System.out.println("그래픽 에디터 beauty을 실행합니다.");
			Shape start = null;
			Shape last = null;
			while(true) {
				System.out.print("삽입(1) 삭제(2) 모두보기(3) 종료(4) >>");
				String select = scan.nextLine();
				if(select.equals("1")) {
					System.out.print("Line(1) Rect(2) Circle(3) >>");
					String select2 = scan.nextLine();
					if(select2.equals("1")) {
						if(start == null) {
							start = new Line();
							last = start;
						}
						else {
							last.setNext(new Line());
							last = start.getNext();
						}
					}
					else if(select2.equals("2")) {
						if(start == null) {
							start = new Rect();
							last = start;
						}
						else {
							last.setNext(new Rect());
							last = start.getNext();
						}
						
					}
					else if(select2.equals("3")) {
						if(start == null) {
							start = new Circle();
							last = start;
						}
						else {
							last.setNext(new Circle());
							last = start.getNext();
						}
					}
					
				}
				else if(select.equals("2")) {
					System.out.print("삭제할 도형의 위치 >>");
					int a = scan.nextInt();
					scan.nextLine();
					Shape shape = start;
					Shape preShape = null;
					int i = 1;
					while(true) {
						if(shape == null) {
							//끝부분일때
							if(i == a) {
								preShape.setNext(null);
								last = preShape;
								break;
							}
							//그 외
							else {
								System.out.println("삭제할수 없습니다.");
								break;
							}
						}
						//a번째 자리 삭제
					    if(i == a) {
					    	if(a == 1) {
					    		start = shape.getNext();
					    	}
					    	else {
					    		preShape.setNext(shape.getNext());
					    	}
							break;
						}
					    preShape = shape;
					    shape = shape.getNext();
						i++;
					}
				}

				else if(select.equals("3")) {
					Shape shape = start;
					while(true) {
						if(shape == null) {
							break;
						}
						shape.draw();
						shape = shape.getNext();
					}
				}

				else if(select.equals("4")) {
					System.out.println("beauty");
					break;
				}
			}
		}
		//인터페이스 문제
		else if(problem ==13) {
			Shapeable shape = new Circle2(10);
			shape.redraw();
			System.out.println("면적은 "+shape.getArea());
		}
	}

}
