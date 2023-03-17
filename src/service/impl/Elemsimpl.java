package service.impl;

import classes.Admin;
import classes.Group;
import classes.Lesson;
import classes.Persen;
import enums.Gender;
import service.Elems;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.prefs.BackingStoreException;
public class Elemsimpl implements Elems {
    List<Admin> admins = new ArrayList<>();
    List<Group> gruups = new ArrayList<>();
    List<Persen> persens = new ArrayList<>();
    List<Lesson> lessons = new ArrayList<>();
    @Override
    public void getAdmin(ArrayList<Admin> admins) {
        try {
            System.out.println("Электрондук почтанызды жазыныз");
            String name = new Scanner(System.in).nextLine();
            System.out.println("Пароль жазыныз");
            String Password = new Scanner(System.in).nextLine();
            for (Admin admin : admins) {
                if (!admin.getGmail().equals(name)) {
                    throw new Exception("Your email address is not valid");
                }
                if (!admin.getPassword().equals(Password)) {
                    throw new Exception("Your password is incorrect!");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public Group Addnewgroup() {
        Group group = new Group(persens.size(),lessons .size(), gruups.size() + 1);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Жаны группага ат жазыныз:");
        String name = scanner.nextLine();
        group.setName(name);
        System.out.println("Группанын суроттомосун жазыныз:");
        String description = scanner.nextLine();
        group.setDescription(description);
        gruups.add(group);
        System.out.println(gruups);
        return group;
    }
    @Override
    public void GetGroupByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Группанын атын жазыныз:");
        String name = scanner.nextLine();
        boolean isFalse = false;
        for (Group g : gruups) {
            if (g.getName().equalsIgnoreCase(name)) {
                System.out.println(g);
                isFalse = false;
                break;
            } else {
                isFalse = true;
            }
        }
        if (isFalse) {
            System.out.println("Мындай группа табылган жок!!!");
        }
    }

    @Override
    public void UpdateGroupName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Группанын атын жазыныз:");
        String name = scanner.nextLine();
        Group newGroup = new Group();
        for (Group g : gruups) {
            if (g.getName().equalsIgnoreCase(name)) {
                System.out.println("Жаны ат жазыныз:");
                String name1 = scanner.nextLine();
                g.setName(name1);
                System.out.println(g);
                newGroup = g;
                break;
            }
        }
        if (newGroup.getName() == null) {
            System.out.println("404");
        }
    }
    @Override
    public void getAllGroups() {
        System.out.println(gruups);
    }
    @Override
    public void addNewStudentToGroup() {
        boolean isTure = true;
        Persen persen = new Persen(persens.size() + 1);
        System.out.println("Кайсы группага студент кошосуз, ошол группанын атын жазыныз:");
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        try {
            String name = scanner.nextLine();
            for (Group g : gruups) {
                if (g.getName().equalsIgnoreCase(name)) {
                    g.setStudents(g.getStudents() + 1);
                    System.out.println("Студенттин атын жазыныз:");
                    String name1 = scanner1.nextLine();
                    persen.setName(name1);
                    System.out.println("Фамилиясын жазыныз:");
                    String name2 = scanner.nextLine();
                    persen.getName(name2);
                    int b = 0;
                    while (true) {
                        System.out.println("Электрондук почтанызды жазыныз:");
                        Scanner scanner21 = new Scanner(System.in);
                        try {
                            String name3 = scanner21.nextLine();
                            persen.setGmail(name3);
                            if (name3.contains("@")) {
                            } else if (!name3.equals("@")) {
                                try {
                                    throw new BackingStoreException("Электронный почтанызда @ жок!!!");
                                } catch (BackingStoreException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            System.out.println("Пароль жазыныз:");
                            Scanner scanner23 = new Scanner(System.in);
                            while (true) {
                                String porol = scanner23.nextLine();
                                if (porol.length() >= 7) {
                                    persen.setPasswprd(porol);
                                    b++;
                                    break;
                                } else {
                                    throw new BadRequestException ("Пороль 7 cимболдон тузулуш керек");
                                }
                            }
                        } catch (BadRequestException badRequestException) {
                            System.out.println(badRequestException.getMessage());
                        }
                        if (b == 1) {
                            break;
                        }
                    }
                    while (isTure) {
                        System.out.println("Жынысын жазыныз(male/female):");
                        String pol = scanner1.nextLine();
                        if (pol.equalsIgnoreCase("male")) {
                            persen.setGender(Gender.boy);
                            isTure = false;
                        } else if (pol.equalsIgnoreCase("female")) {
                            persen.setGender(Gender.daughter);
                            isTure = false;
                        } else {
                            System.out.println("Мындай жыныс жок!!!");
                            isTure = true;
                        }
                    }
                    System.out.println("Студент(-кa) ийгиликтуу кошулду!");
                    System.out.println(persen);
                    persens.add(persen);
                    break;

                } else {
                    System.out.println("Мындай группа жок!!!");
                }
            }
        } catch (IllegalAccessError e) {
            System.out.println();
        }
    }

    @Override
    public void UpdateStudent() {
        Persen persen = new Persen(persens.size() + 1);
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Электронный почтанызды жазыныз:");
        String name = scanner.nextLine();
        System.out.println("Пароль жазыныз:");
        String porol = scanner1.nextLine();
        for (Persen s : persens) {
            if (s.getGmail().equals(name)) {
                if (s.getPasswprd().equalsIgnoreCase(porol)) {
                    System.out.println("Жаны ат жазыныз:");
                    String name1 = scanner.nextLine();
                    s.setName(name1);
                    System.out.println("Жаны фамилиясын жазыныз:");
                    String name2 = scanner1.nextLine();
                    s.getSorName(name2);
                    persens.add(s);
                }
            } else {
                System.out.println("Электронный почта же пороль туура эмес!!!");
            }
            break;
        }
        System.out.println(persens);
    }

    @Override
    public void FindStudentByFirstName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Студенттин атын жазыныз:");
        String name = scanner.nextLine();
        for (Persen persen : persens) {
            if (persen.getName().equalsIgnoreCase(name)) {
                System.out.println(persen);
            } else {
                System.out.println("Мындай стедунт табылган жок!!!");
            }
        }
    }

    @Override
    public void GetAllStudentsByGroupName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Группанын атын жазыныз:");
        String name = scanner.nextLine();
        for (Persen s : persens) {
            for (Group g : gruups) {
                if (g.getName().equalsIgnoreCase(name)) {
                    System.out.println(s);
                } else {
                    System.out.println("Мындай группа жок!!!");
                }
            }
        }
    }

    @Override
    public void AddNewLessonToGroup() {
        Lesson lesson = new Lesson(lessons.size() + 1);
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Группанын атын жазыныз:");
        String name = scanner.nextLine();
        for (Group g : gruups) {
            if (g.getName().equalsIgnoreCase(name)) {
                g.setLessons(g.getLessons() + 1);
                System.out.println("Сабактын атын жазыныз:");
                String name1 = scanner1.nextLine();
                lesson.setLessonName(name1);
                System.out.println("Тапшырманын суроттомосун жазыныз:");
                String name2 = scanner.nextLine();
                lesson.setTaskDescription(name2);
            } else {
                System.out.println("Мындай группа жок!!!");
            }
            System.out.println(lesson);
            lessons.add(lesson);
        }
    }

    @Override
    public void deleteStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Кимди очуросуз, ошол адамдын электронный почтасын жазыныз:");
        String email = scanner.nextLine();
        for (Persen s :persens) {
            if (s.getGmail().equals(email)) {
                this.persens.remove(s);
                System.out.println("Электронный почтасы " + s.getGmail() + " болгон студент(-ка) ийгидиктуу очурулду!");
                break;
            } else {
                System.out.println("Мындай электронный почта жок!!!");
            }
        }
    }

    @Override
    public void GetAllStudentLesson() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Студенттин почтасын жазыныз:");
        boolean isFalse = false;
        for (Persen s : persens) {
            String name = scanner.nextLine();
            if (s.getGmail().equals(name)) {
                System.out.println(lessons);
                isFalse = false;
                break;
            } else {
                isFalse = true;
            }
        }
        if (isFalse) {
            System.out.println("Мындай электронный почта жок!!!");
        }
    }

    @Override
    public void GetLessonByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сабактын атын жазыныз:");
        for (Lesson l : lessons) {
            String name = scanner.nextLine();
            if (l.getLessonName().equalsIgnoreCase(name)) {
                System.out.println(lessons);
            } else {
                System.out.println("Мындай сабак жок!!!");
            }
        }
    }

    @Override
    public void GetAllLessonByGroupName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Группанын атын жазыныз:");
        for (Lesson l : lessons) {
            for (Group g : gruups) {
                String name = scanner.nextLine();
                if (g.getName().equalsIgnoreCase(name)) {
                    System.out.println(l);
                } else {
                    System.out.println("Мындай группа жок!!!");
                }
            }
        }
    }

    @Override
    public void deleteLessons() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сабактын атын жазыныз:");
        for (Lesson l : lessons) {
            String name = scanner.nextLine();
            if (l.getLessonName().equalsIgnoreCase(name)) {
                this.lessons.remove(l);
                System.out.println("Сабак ийгиликтуу очурулду!");
                break;
            } else {
                System.out.println("Мындай сабак жок!!!");
            }

        }
    }

    @Override
    public void deleteGroup() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Группанын атын жазыныз:");
        for (Group g : gruups) {
            String name = scanner.nextLine();
            if (g.getName().equalsIgnoreCase(name)) {
              this.gruups.remove(g);
                System.out.println("Группа ийгиликтуу очурулду!");
                break;
            } else {
                System.out.println("Мындай группа жок!!!");
            }
        }
    }

    private class BadRequestException extends Throwable {
        public BadRequestException(String s) {
        }
    }
}

