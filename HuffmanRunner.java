import java.util.HashMap;
import java.util.PriorityQueue;
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
		HuffmanTree tree = new HuffmanTree("Mississippi");
		//System.out.println(tree.map.get('p'));
		PriorityQueue<HuffmanNode> queue = tree.createQueue();
		System.out.println(queue);
		System.out.println(queue.size());
		HuffmanNode hufftree = tree.createTree();
		System.out.println(hufftree.getRight().getRight());
		System.out.println(tree.encode("M"));
	}
}