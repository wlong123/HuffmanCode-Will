public class HuffmanRunner
{
	public static void main(String [] args)
	{
		HuffmanNode node = new HuffmanNode("a");
		node.setCount(2);
		System.out.println(node);
		HuffmanNode node1 = new HuffmanNode("b");
		System.out.println(node.compareTo(node1));
		System.out.println("----------------");
		HuffmanTree tree = new HuffmanTree("apple");
		System.out.println(tree.map.get('p'));
		System.out.println(tree.createQueue());
	}
}