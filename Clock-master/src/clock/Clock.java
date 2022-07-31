package clock;

//Checking if the imports from priority queue jar are working
import queuemanager.PriorityItem;
import queuemanager.SortedArrayPriorityQueue;


public class Clock {
    
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View(model);
        model.addObserver(view);
        Controller controller = new Controller(model, view);
    }
}
