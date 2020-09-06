import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.Timer;

public class NewsHeadlines extends JFrame {
	private static String[] headlines = { "Massive Rescue Operation Underway As Crews Battle California's Creek Fire",
			"Police Declare a Riot on 100th Night of Protests in Portland",
    "Raging Campus Outbreaks Send Students Home Across the U.S.", "U.S. Cases Steady; U.K. Infections at 3-Month High: Virus Update",
			"Intense Heat Wave Breaks Numerous Records", "As Trump Parade Boats Sink In Texas, So Are The President's Poll Numbers"};

	public NewsHeadlines() {
		super("Headlines");

		NewsHeadlinesList msgList = new NewsHeadlinesList(headlines);
		NewsHeadlinesScreen display = new NewsHeadlinesScreen(msgList);
		NewsHeadlinesInput inputPanel = new NewsHeadlinesInput(msgList);
		Container c = getContentPane();
		c.add(display, BorderLayout.CENTER);
		c.add(inputPanel, BorderLayout.SOUTH);

		Timer t = new Timer(100, display);
		t.start();
	}

	/************************* MAIN *************************/

	public static void main(String[] args) {
		NewsHeadlines window = new NewsHeadlines();
		window.setSize(500, 300);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}
