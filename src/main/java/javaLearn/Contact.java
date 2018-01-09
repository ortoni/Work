package javaLearn;

public class Contact {

	int a[] = {12,13,15};

	public void crCon(int num){
		if(num == 12){
			System.out.println("one");
		}else if(num == 13){
			System.out.println("two");
		}else if(num == 14){
			System.out.println("three");
		}else{
			addContact();
		}
	}

	private void addContact() {
		System.out.println("add contact");
	}

}