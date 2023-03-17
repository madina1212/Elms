import classes.Admin;
import service.impl.Elemsimpl;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        Admin admin = new Admin("halikova656@gmail.com", "Madina");
        ArrayList<Admin> admins = new ArrayList<>();
        admins.add(admin);
        if (hours >= 1 && hours <= 11) {
            System.out.println("Кутман тан! " + hours + ":" + minutes);
        } else if (hours >= 12 && hours <= 16) {
            System.out.println("Кутман күн! азыр тушку " + hours + ":" + minutes);
        } else if (hours >= 17 && hours <= 22) {
            System.out.println("Кутман кеч! азыр кечки " + hours + ":" + minutes);
        } else {
            System.out.println("Түнүң бейпил болсун! " + hours);
        }
        Elemsimpl elemsimpl = new Elemsimpl();
        System.out.println("Катталган болсонуз < 0 > басыныз");
        int san = new Scanner(System.in).nextInt();
        while(true){
        switch (san) {
            case 0 -> {
                try {
                    elemsimpl.getAdmin(admins);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    continue;

                }
                while (true) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println(" *** Бир команда танданыз! ***");
                    System.out.println("""
                                    1  -> Add new group
                                    2  -> Get group by name
                                    3  -> Update group name
                                    4  -> Get all groups
                                    5  -> Add new student to group
                                    6  -> Update student
                                    7  -> Find student by first name
                                    8  -> Get all students by group name
                                    9  -> Get all student's lesson
                                    10 -> Delete student from group
                                    11 -> Add new lesson to group
                                    12 -> Get lesson by name
                                    13 -> Get all lesson by group name
                                    14 -> Delete lesson from group
                                    15 -> Delete group
                            """);

                    int num = scanner.nextInt();
                    switch (num) {
                        case 1 -> elemsimpl.Addnewgroup();
                        case 2 -> elemsimpl.GetGroupByName();
                        case 3 -> elemsimpl.UpdateGroupName();
                        case 4 -> elemsimpl.getAllGroups();
                        case 5 -> elemsimpl.addNewStudentToGroup();
                        case 6 -> elemsimpl.UpdateStudent();
                        case 7 -> elemsimpl.FindStudentByFirstName();
                        case 8 -> elemsimpl.GetAllStudentsByGroupName();
                        case 9 -> elemsimpl.GetAllStudentLesson();
                        case 10 -> elemsimpl.deleteStudent();
                        case 11 -> elemsimpl.AddNewLessonToGroup();
                        case 12 -> elemsimpl.GetLessonByName();
                        case 13 -> elemsimpl.GetAllLessonByGroupName();
                        case 14 -> elemsimpl.deleteLessons();
                        case 15 -> elemsimpl.deleteGroup();
                    }
                }
            }
        }
        }
    }
}

