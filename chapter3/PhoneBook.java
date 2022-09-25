package chapter3;

import java.util.Scanner;

public class PhoneBook {
	private Phone phoneBook[];
	Scanner scan;

	public PhoneBook() {
		scan = new Scanner(System.in);
	}

	public Phone[] getPhoneBook() {
		return this.phoneBook;
	}

	public void setPhoneBook() {
		String name, phoneNumber;
		System.out.printf("인원수>> ");
		int number = scan.nextInt();
		scan.nextLine();
		this.phoneBook = new Phone[number];
		for(int i=0;i<number;i++) {
			System.out.printf("이름과 전화번호(이름과 번호는 빈칸없이 입력) >> ");
			name = scan.next();
			phoneNumber = scan.next();
			scan.nextLine();
			this.phoneBook[i] = new Phone(name, phoneNumber);
		}
		System.out.println("저장되었습니다...");
	}
	
	public void phoneSearch() {
		String name;
		Phone phone;
		Phone phoneBook[] = getPhoneBook();
		while(true) {
			phone = null;
			System.out.printf("검색할 이름 >> ");
			name = scan.nextLine();
			if(name.equals("그만"))
				break;
			for(int i=0;i<phoneBook.length;i++) {
				if(phoneBook[i].getName().equals(name)) {
					phone = phoneBook[i];
					break;
				}
			}
			if(phone != null) {
				System.out.printf("%s의 번호는 %s입니다.\n",phone.getName(),phone.getPhoneNumber());
			}
			else {
				System.out.printf("%s이 없습니다\n",name);
			}
		}
		
	}
}
