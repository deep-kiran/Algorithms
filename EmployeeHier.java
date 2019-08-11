import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class Emp implements Comparable<Emp>{
    public String name;
    public int level;
    public Emp root;
    public Emp parent;
    public ArrayList<Emp> children;
    public Emp(String name) {
        this.name= name;
        this.level=0;
        this.parent=null;
        this.children =new ArrayList<>();
    }
    @Override
    public int compareTo(Emp e){
        if(this.level>e.level)return 1;
        return -1;
    }
}

/**
 * We want to maintain the list of employees in a company. We will be concerned with two quantities
 * associated with each employee in the company -- name of the employee (you can assume no
 * two employees in the company have the same name), and the level of the employee.
 * The level denotes where the person stands in the hierarchy. Level 1 denotes the highest post in
 * the company (say the CEO), level 2 comes below level 1 and so on. There is only 1 person at level 1,
 * but there can be several employees at level i > 1. Each level i employee works under a level i-1
 * employee, which is his/her immediate boss. Given an employee A, we can form a sequence of employees A',
 * A'', A''', ... where A works under A', A' works under A'', and so on. We say that each employee
 * in A',A'', A''',... is a boss of A. We would like to
 * implement a suitable tree data-structure so that we can implement the following operations :
 */

public class EmployeeHier {
    Emp root;
    PriorityQueue<Emp> pq =new PriorityQueue<>();

    /**
     *  We want to add a new employee whose name is S. This employee will work under an existing
     *  employee S' (note that this automatically decides the level of S, it
     *  is one more than that of S').
     * @param employer
     * @param employee
     */
    public void insertEmp(Emp employer, Emp employee ) {
        if(!pq.contains(employer)){
            System.out.print("Error employer does not exist");
            return;
        }
        //first employee to be added is CEO
        if(root==null && employer.level==0){
            root.children.add(employer);
        }
        employee.level =employer.level+1;
        employer.children.add(employee);
        employee.parent =employer;
        pq.add(employer);
        pq.add(employee);
        return ;
    }

    /**
     *  We want to remove an employee whose name is S. S' is the name of another employee
     *  in the company who is at the same level as S.
     *  When we remove S, all the persons working under S will now work under S'.
     * @param s
     * @param s1
     */
    public void deleteEmployee(Emp s, Emp s1){
        Emp boss =s.parent;
        if(boss ==null) {
            System.out.print("CEO cannot be deleted");
            return;
        }
        s1.children.addAll(s.children);
        boss.children.remove(s);
        pq.remove(s);
        return;
    }

    /***
     *  S and S' are names of two persons working in the company. This operation prints
     *  the name of the employee A who is a boss of both S and S', and among all such
     *  persons has the largest level. In other words, we want to find the common boss who is lowest
     *  in the hierarchy in the company
     * @param s1
     * @param s2
     * @return
     */
    public Emp lowestCommonBoss(Emp s1, Emp s2){
        Emp boss1 = s1.parent;
        Emp boss2 = s2.parent;
        if(boss1.children.contains(s2))
            return boss1;
        while (!boss1.parent.children.contains(boss2)){
            boss1 =boss1.parent;
            boss2 =boss2.parent;
        }
        return boss1.parent;
    }
    public void printEmployees(){
        for (Emp e :pq){
            System.out.print("Emp name is "+e.name +" level is "+ e.level);
        }
    }
    public static void main(String args[]) {
        EmployeeHier e =new EmployeeHier();

    }
}
