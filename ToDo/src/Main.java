import com.project.model.Task;
import com.project.model.TaskDAO;

import java.util.*;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            TaskDAO dao = new TaskDAO();

            while (true) {
                System.out.println("\n📌 Welcome to your To-Do List App");
                System.out.println("1 -> Add new task");
                System.out.println("2 -> View your list (by week)");
                System.out.println("3 -> View finished tasks");
                System.out.println("4 -> Mark task as finished");
                System.out.println("5 -> Exit");
                System.out.print("Choose: ");
                int choice = sc.nextInt();
                sc.nextLine();

                if (choice == 1) {
                    System.out.print("Enter task title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter week number: ");
                    int week = sc.nextInt();
                    dao.addTask(new Task(title, week));
                }
                else if (choice == 2) {
                    System.out.print("Enter week number: ");
                    int week = sc.nextInt();
                    List<Task> tasks = dao.getTasksByWeek(week);
                    for (Task t : tasks) {
                        System.out.println(t.getId() + " - " + t.getTitle() + " (Finished: " + t.isFinished() + ")");
                    }
                }
                else if (choice == 3) {
                    List<Task> tasks = dao.getFinishedTasks();
                    for (Task t : tasks) {
                        System.out.println(t.getId() + " - " + t.getTitle());
                    }
                }
                else if (choice == 4) {
                    System.out.print("Enter task ID to finish: ");
                    int id = sc.nextInt();
                    dao.finishTask(id);
                }
                else if (choice == 5) {
                    System.out.println("👋 Bye!");
                    break;
                }
                else {
                    System.out.println("❌ Invalid choice, try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }
