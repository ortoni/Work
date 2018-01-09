package javaLearn;

public class LearnString {

	public static void main(String[] args) {
		String str = "I am learning selenium java";
		String id = "cts1(123ABC45)";
		String[] split = id.split("\\(");
		String[] split2 = split[1].split("\\)");
		//System.out.println(split2.length);
		for (String string : split2) {
			System.out.println(string);
		}
		//System.out.println(split.toString());
		/*for (String string : split) {
			System.out.println(string);
			
		}
		*/
		String[] spl = str.split("\\s", 3);
		for (String string : spl) {
			System.out.println(string);
		}
		String[] idsplit = id.split("\\D");
		for (String idstring : idsplit) {
			System.out.println(idstring);
			
		}
		/*for (int i = 0; i < idsplit.length; i++) {
		System.out.print(idsplit[1]);
		}*/

	}

}
