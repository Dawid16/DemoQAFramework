package Navigation;

/**
 * Created by Dawidek on 2018-03-12.
 */
public class NavigationTabDemo {

    public static class DemoDraggable {
        public static void select() {
            MenuSelector.select("//a[@class='dropdown-toggle']", "//a[@title='Draggable']");
        }
    }

    public static class DemoTabs {
        public static void select() {
            MenuSelector.select("//a[@class='dropdown-toggle']", "//a[@title='Tabs']");
        }
    }

}
