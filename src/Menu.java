import java.util.ArrayList;
import java.util.List;

public class Menu {
    public static List<Pizzaer> hentMenu() {
        List<Pizzaer> menu = new ArrayList<>();
        menu.add(new Pizzaer(1, "Vesubio", "tomatsauce, ost, skinke, oregano - ", 57));
        menu.add(new Pizzaer(2, "Amerikaner", "tomatsauce, ost, skinke, oregano - ", 53));
        menu.add(new Pizzaer(3, "Cacciotore", "tomatsauce, ost, skinke, oregano - ", 57));
        menu.add(new Pizzaer(4, "Carbona", "tomatsauce, ost, skinke, oregano - ", 63));
        menu.add(new Pizzaer(5, "Dennis", "tomatsauce, ost, skinke, oregano - ", 65));
        menu.add(new Pizzaer(6, "Bertil", "tomatsauce, ost, skinke, oregano - ", 57));
        menu.add(new Pizzaer(7, "Silvia", "tomatsauce, ost, skinke, oregano - ", 61));
        menu.add(new Pizzaer(8, "Victoria", "tomatsauce, ost, skinke, oregano - ", 61));
        menu.add(new Pizzaer(9, "Toronfo", "tomatsauce, ost, skinke, oregano - ", 61));
        menu.add(new Pizzaer(10, "Capricciosa", "tomatsauce, ost, skinke, oregano - ", 61));
        menu.add(new Pizzaer(11, "Hawaii", "tomatsauce, ost, skinke, oregano - ", 61));
        menu.add(new Pizzaer(12, "Le Blissola", "tomatsauce, ost, skinke, oregano - ", 61));
        menu.add(new Pizzaer(13, "Venezia", "tomatsauce, ost, skinke, oregano - ", 61));
        menu.add(new Pizzaer(14, "Mafia", "tomatsauce, ost, skinke, oregano - ", 61));

        return menu;
    }
}