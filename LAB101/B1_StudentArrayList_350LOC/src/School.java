import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;

public class School {
    ArrayList<Student> Students;
    String[] subjects = { "Java", ".Net", "C/C++" };
    Scanner input = new Scanner(System.in);

    School() {
        Students = new ArrayList<>();
    }
    // main funct to call orther function
    public void menu() {

        String funcString;
        // if input not right, repeat until user call right
        while (true) {
            System.out.println();
            System.out.println("---------------------------------------------------");
            System.out.println("Chao mung den voi chuong trinh quan ly sinh vien");
            System.out.println();
            System.out.println("1. Tao");
            System.out.println("2. Tim kiem va sap xep");
            System.out.println("3. Cap nhat/xoa");
            System.out.println("4.Bao cao");
            System.out.println("5.Thoat");
            System.out.println("Chon chuc nang: ");
            funcString = input.nextLine();

            if (funcString.compareTo("1") == 0) {
                System.out.println("Da chon chuc nang 1");
                addStudent();
            } else if (funcString.compareTo("2") == 0) {
                printListStudentWithName();
            } else if (funcString.compareTo("3") == 0) {
                updateOrremoveStudent();
            } else if (funcString.compareTo("4") == 0) {
                countCourse();
            } else if (funcString.compareTo("5") == 0) {
                System.exit(0);
                break;
            } else {
                System.out.println("Vui long nhap dung chuc nang");
            }
        }
    }
    /**
     * 
     * @param newId id need to check in Arraylist
     * @return if a id exist or not
     */
    public boolean checkId(String newId) {
        if (Students.size() == 0) {
            return false;
        }
        for (Student temp : Students) {
            if (temp.getId().compareTo(newId) == 0) {
                return true;
            }
        }
        return false;
    }
    /**
     * Add Student in to arraylist
     */
    public void addStudent() {
        String newid;
        // check if id exist, ? add: repeat
        while(true) {
            System.out.println("Nhap id: ");
            newid = input.nextLine();
            if(checkId(newid)==false) {
                break;
            } else {
                System.out.println("ID da ton tai");
            }
        }
            
        System.out.println("Nhap ten:");
        String newName = input.nextLine();
        System.out.println("Nhap hoc ki:");
        String newSemester = input.nextLine();
        String subject;
        while (true) {
            System.out.println("Vui long chon mon hoc duoi day:");
            System.out.println("1. Java");
            System.out.println("2. .Net");
            System.out.println("3. C / C++");
            System.out.println("-----------------------------------");
            System.out.println("Mon hoc: ");
            subject = input.nextLine();
            if (subject.compareTo("1") == 0) {
                subject = subjects[0];
                break;
            } else if (subject.compareTo("2") == 0) {
                subject = subjects[1];
                break;
            } else if (subject.compareTo("3") == 0) {
                subject = subjects[2];
                break;
            } else {
                System.out.println("vui long chon dung mon hoc !");
            }
        }

        Students.add(new Student(newid, newName, subject, newSemester));
    }
    /**
     * List all student 
     */
    public void allStudent() {
        if (Students.size() == 0) {
            System.out.println("Khong co hoc sinh");
        } else {
            for (Student temp : Students) {
                System.out.println(temp.toString());
            }
        }
    }
    /**
     * Find student with id
     * @param id in need to find
     * @return Student
     */
    public Student findStudentid(String id) {
        Student result = null;
        for (Student temp : Students) {
            if (temp.getId().compareTo(id) == 0) {
                result = temp;
            }
        }
        return result;
    }
    /**
     * remove student out of arraylist
     * @param id id need to remove
     */
    public void removeStudent(String id) {
        if (Students.size() == 0) {
            return;
        } else {
            Students.remove(findStudentid(id));
        }
    }
    /**
     * Update studen information
     * @param id
     */
    public void updateStudent(String id) {
        System.out.println("----------------------");
        System.out.println("Nhap ten:");
        String newName = input.nextLine();
        System.out.println("Nhap hoc ki:");
        String newSemester = input.nextLine();
        String subject;
        while (true) {
            System.out.println("Vui long chon mon hoc duoi day:");
            System.out.println("1. Java");
            System.out.println("2. .Net");
            System.out.println("3. C / C++");
            System.out.println("-----------------------------------");
            System.out.println("Mon hoc: ");
            subject = input.nextLine();
            if (subject.compareTo("1") == 0) {
                subject = subjects[0];
                break;
            } else if (subject.compareTo("2") == 0) {
                subject = subjects[1];
                break;
            } else if (subject.compareTo("3") == 0) {
                subject = subjects[2];
                break;
            } else {
                System.out.println("vui long chon dung mon hoc !");
            }
        }

        Student studentNeedToUpdate = findStudentid(id);
        studentNeedToUpdate.setCourseName(subject);
        studentNeedToUpdate.setSemester(newSemester);
        studentNeedToUpdate.setStudentName(newName);
    }

    /**
     * Sub menu to user chose update or remove base on id
     */
    public void updateOrremoveStudent() {
        String funcString;
        String id;
        while(true) {
            System.out.println("Vui long chon chuc nang:");
            System.out.println("Cap nhat thong tin: Nhap u");
            System.out.println("Xoa sinh vien: nhap d");
            System.out.println("Chose (u/d): ");
            funcString = input.nextLine();

            if(funcString.compareTo("u") == 0 || funcString.compareTo("U") == 0) {
                System.out.println("Nhap ID: ");
                id = input.nextLine();
                if (checkId(id) == false) {
                    System.out.println("Khong ton tai sinh vien nay");
                } else {
                    updateStudent(id);
                }
                break;
            } else if(funcString.compareTo("d") == 0 || funcString.compareTo("D") == 0) {
                System.out.println("Nhap ID: ");
                id = input.nextLine();
                if (checkId(id) == false) {
                    System.out.println("Khong ton tai sinh vien nay");
                } else {
                    removeStudent(id);
                }
                break;
            }  else {
                System.out.println("Vui long nhap dung chuc nang!");
            }
        }
        
    }
    // return list student base on their name
    public ArrayList<Student> listStudentsWithName(String subName) {
        ArrayList<Student> results = new ArrayList<>();

        subName = subName.toLowerCase();
        System.out.println("---------------------------");
        for(Student temp : Students) {
            if(temp.getStudentName().toLowerCase().contains(subName)) {
                results.add(temp);
            }
        }
        return results;
    }
    /**
     * Print out all student with same subName
     */
    public void printListStudentWithName() {
        String subName;
        System.out.println("Nhap ten sinh vien:");
        subName = input.nextLine();
        ArrayList<Student> subList = listStudentsWithName(subName);
        if(subList.size() == 0) {
            System.out.println("Khong co sinh vien mang ten " + subName);
        } else {
            sortList(subList);
            for (Student temp: subList) {
                System.out.println(temp.toString());
            }
        }
    }


    // Sorting the ArrayList based on string length
    public void sortList(ArrayList<Student> ar) {
        if(Students.size() == 0) {
            return;
        } else {
            Collections.sort(ar, new Comparator<Student>() {
            @Override
                public int compare(Student person1, Student person2) {
                    return person1.getStudentName().compareTo(person2.getStudentName());
                }
            });
        }
    }



    //Counting course base on name , id , subject
    public void countCourse() {
        if(Students.size()==0) {
            System.out.println("Khong co sinh vien");
        } else {
            String[] keyStrings = new String[Students.size()];
            for(int i = 0 ; i < Students.size() ; i++) {
                keyStrings[i] = Students.get(i).toStringCount();
            }
            Map<String , Integer> stringCountMap = new HashMap<>();

            for(String str:keyStrings) {
                if(stringCountMap.containsKey(str)) {
                    stringCountMap.put(str, stringCountMap.get(str) + 1);
                } else {
                    stringCountMap.put(str,1);
                }
            }

            for (Map.Entry<String, Integer> entry : stringCountMap.entrySet()) {
                System.out.println(entry.getKey() + " | " + entry.getValue());
            }
        }
    }
}
