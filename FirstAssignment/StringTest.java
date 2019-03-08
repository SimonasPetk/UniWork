public class StringTest {
	public static void main(String [] args)  {
		
		String aboutACat = "The cat 891 on the mat";
		int days = Integer.valueOf(aboutACat);
		
		System.out.println(aboutACat.toUpperCase());
		System.out.println(aboutACat.substring(3,7));
		System.out.println(aboutACat.substring(3,7).toUpperCase().trim());
		System.out.println(aboutACat.indexOf("cat"));
		System.out.println(days);
		
	}
}