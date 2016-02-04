import java.util.HashMap;
import java.util.PriorityQueue;
public class HuffmanRunner
{
	public static void main(String [] args)
	{
		HuffmanTree tree1 = new HuffmanTree("Mississippi river");
		System.out.println(tree1.encode("Mississippi river"));
		System.out.println(tree1.decode("0101001111001111001011010010010110001001000011"));
	}
}