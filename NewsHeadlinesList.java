import java.awt.Graphics;

/**
 * Implements the list of headlines for NewsHeadlines
 */
public class NewsHeadlinesList {
	private ListNode2 heading, topNode;

	/**
	 * Creates a circular list of news headlines. First creates a circular list with one
	 * node, "Today's headlines:", followed by a blank line, and saves a reference to
	 * that node in heading. Appends all the strings from headlines to the list,
	 * in order.
	 */
	public NewsHeadlinesList(String[] headlines) {
		heading = new ListNode2("Today's headlines:");
		heading.setNext(heading);
		heading.setPrevious(heading);
		addBefore(heading, "");
		addAfter(heading, "");

		for (int i = headlines.length - 1; i >= 0; i--) {
			insert(headlines[i]);
		}
		topNode = heading;
	}

	/**
	 * Inserts a node with msg into the headlines list after the blank line that
	 * follows heading.
	 */
	public void insert(String msg) {
		addAfter(heading.getNext(), msg);
	}

	/**
	 * Deletes the node that follows topNode from the headlines list.
	 */
	public void delete() {
		if (!topNode.getNext().equals(heading) && !topNode.getNext().equals(heading.getPrevious())
				&& !topNode.getNext().equals(heading.getNext())) {
			topNode.getNext().getNext().setPrevious(topNode);
			topNode.setNext(topNode.getNext().getNext());
		}
	}

	/**
	 * Scrolls up the headlines list, advancing topNode to the next node.
	 */
	public void scrollUp() {
		topNode = topNode.getNext();
	}

	/**
	 * Adds a new node with msg to the headlines list before a given node. Returns a
	 * reference to the added node.
	 */
	private ListNode2 addBefore(ListNode2 node, String msg) {
		ListNode2 newNode = new ListNode2(msg, node.getPrevious(), node);
		node.getPrevious().setNext(newNode);
		node.setPrevious(newNode);
		return newNode;
	}

	/**
	 * Adds a new node with msg to the headlines list after a given node. Returns a
	 * reference to the added node.
	 */
	private ListNode2 addAfter(ListNode2 node, String msg) {
		return addBefore(node.getNext(), msg);
	}

	/**
	 * Removes a given node from the list.
	 */
	private void remove(ListNode2 node) {
		node.getPrevious().setNext(node.getNext());
		node.getNext().setPrevious(node.getPrevious());
	}

	/**
	 * Draws nLines headlines in g, starting with topNode at x, y and incrementing y
	 * by lineHeight after each headline.
	 */
	public void draw(Graphics g, int x, int y, int lineHeight, int nLines) {
		ListNode2 node = topNode;
		for (int k = 1; k <= nLines; k++) {
			g.drawString((String) node.getValue(), x, y);
			y += lineHeight;
			node = node.getNext();
		}
	}
}