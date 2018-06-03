package Array;

public class operator
{
	public static void main(String[] args) {
		int a = 0x0005;
		int b = 0x0007;
		// bitwise and
		// 0101 & 0111=0101
		System.out.println("a&b = " + (a & b));
		// bitwise OR
		// 0101 | 0111=0111
		System.out.println("a|b = " + (a | b));
		// bitwise xor
		// 0101 ^ 0111=0010
		System.out.println("a^b = " + (a ^ b));
		// bitwise Complement
		// ~0101=1010
		System.out.println("~a = " + ~a);
		// can also be combined with assignment operator to provide shorthand assignment
		// a=a&b
		a &= b;
		System.out.println("a= " + a);
		
		System.out.println("s1= " + (4 / 2));
		System.out.println("s2= " + (5 / 2));
	}
}
