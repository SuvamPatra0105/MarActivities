import java.util.*;
class Student
{
private String name,dept;
private int id,age;
public Student(String name,int id,int age,String dept)
{
this.name=name;
this.id=id;
this.age=age;
this.dept=dept;
}
public String getname() {
return name;
}
public void setname(String name) {
this.name = name;
}
public int getid() {
return id;
}
public void setid(int id) {
this.id=id;
}
public int getage() {
return age;
}
public void setage(int age) {
this.age=age;
}
public String getdept() {
return dept;
}
public void setdept(String dept) {
this.dept=dept;
}
}
public class CRUD {
public static void main(String[] args) {

ArrayList<Student> studentdetails=new ArrayList<Student>();
Scanner sc = new Scanner(System.in);
System.out.println("1: Create Student Details");
System.out.println("2: Display/Read Student Details");
System.out.println("3: Update Student Details");
System.out.println("4: Search for a Student Detalis");
System.out.println("5: Delete Student Details");
System.out.println("6: Exit");
while(true)
{
System.out.println("enter choice:");
int choice= sc.nextInt();sc.nextLine();
switch (choice)
{
case 1:
try {
System.out.println("Enter student name:");
String name=sc.nextLine();
System.out.println("Enter student id:");
int id=sc.nextInt();sc.nextLine();
System.out.println("Enter student age:");
int age=sc.nextInt();sc.nextLine();
System.out.println("Enter student department:");
String dept=sc.nextLine();
studentdetails.add(new Student(name,id,age,dept));
}
catch(InputMismatchException e)
{
System.out.println("Wrong input format");
}
break;
case 2:
try {
if(studentdetails.size()==0)
throw new Exception();
else {
System.out.println("Display Student Details:");
for(Student i:studentdetails)
{
System.out.println("Name: "+i.getname()+" Id: "+i.getid()+" Age: "+i.getage()+" Department: "+i.getdept());
}
}
}
catch(Exception e)
{
System.out.println("No student record found to display");
}
break;
case 3:
try {
if(studentdetails.size()==0)
throw new Exception();
else
{
System.out.println("Enter student name/id to update:");
String check1=sc.nextLine();
System.out.println("Enter which information to update related to :"+check1);
System.out.println("1: Name");
System.out.println("2: Id");
System.out.println("3: Age");
System.out.println("4: Department");
int choice2=sc.nextInt();sc.nextLine();
switch(choice2)
{
case 1:
System.out.println("Enter new name to update:");
String name1=sc.nextLine();
int c=0;
for(Student i:studentdetails)
{
if(check1.equalsIgnoreCase(i.getname()) || check1.equalsIgnoreCase(String.valueOf(i.getid())))
{
int pos=studentdetails.indexOf(i);
studentdetails.set(pos,new Student(name1,i.getid(),i.getage(),i.getdept()));
c++;
}
}
if(c==0)
System.out.println("Student not found. Please recheck!");
else
System.out.println("Name updated successfully");
break;
case 2:
System.out.println("Enter new ID to update:");
int id2=sc.nextInt();sc.nextLine();
int c1=0;
for(Student i:studentdetails)
{
if(check1.equalsIgnoreCase(i.getname()) || check1.equalsIgnoreCase(String.valueOf(i.getid())))
{
int pos=studentdetails.indexOf(i);
studentdetails.set(pos,new Student(i.getname(),id2,i.getage(),i.getdept()));
c1++;
}
}
if(c1==0)
System.out.println("Student not found. Please recheck!");
else
System.out.println("ID updated successfully");
break;
case 3:
System.out.println("Enter new age to update:");
int age1=sc.nextInt();
int c2=0;
for(Student i:studentdetails)
{
if(check1.equalsIgnoreCase(i.getname()) || check1.equalsIgnoreCase(String.valueOf(i.getid())))
{
int pos=studentdetails.indexOf(i);
studentdetails.set(pos,new Student(i.getname(),i.getid(),age1,i.getdept()));
c2++;
}
}
if(c2==0)
System.out.println("Student not found. Please recheck!");
else
System.out.println("Age updated successfully");
break;
case 4:
System.out.println("Enter new department to update:");
String dept1=sc.nextLine();
int c3=0;
for(Student i:studentdetails)
{
if(check1.equalsIgnoreCase(i.getname()) || check1.equalsIgnoreCase(String.valueOf(i.getid())))
{
int pos=studentdetails.indexOf(i);
studentdetails.set(pos,new Student(i.getname(),i.getid(),i.getage(),dept1));
c3++;
}
}
if(c3==0)
System.out.println("Student not found. Please recheck!");
else
System.out.println("Dept updated successfully");
break;
default: System.out.println("Wrong choice! Please re-enter correct choice");
break;
}
}
}
catch(Exception e)
{
System.out.println("No student record found to update");
}
break;
case 4:
try {
if(studentdetails.size()==0)
throw new Exception();
else {
System.out.println("Enter student name/id to search:");
String check=sc.nextLine();
for(Student i:studentdetails)
{
if(check.equalsIgnoreCase(i.getname()) || check.equalsIgnoreCase(Integer.toString(i.getid())))
System.out.println("Name: "+i.getname()+" Id: "+i.getid()+" Age: "+i.getage()+" Department: "+i.getdept());
}
}
}
catch(Exception e)
{
System.out.println("No student record found to search");
}
break;
case 5:
try
{
if (studentdetails.size()==0)
throw new Exception();
else
{
int count=0;
System.out.println("Enter student name/id to delete information:");
String check2=sc.nextLine();
ArrayList<Student> l2=new ArrayList();
for(Student i:studentdetails)
{
if(check2.equalsIgnoreCase(i.getname()) || check2.equalsIgnoreCase(String.valueOf(i.getid())))
{
l2.add(i);
count++;
}
}
studentdetails.removeAll(l2);
if(count==0)
System.out.println("No such student found! Please recheck!");
else
System.out.println("Student information deleted successfully");
}
}
catch(Exception e)
{
System.out.println("No student records found to delete. Please insert values first!");
}
break;
case 6: System.out.println("Program terminated");
System.exit(0);
default: System.out.println("Wrong choice! Please re-enter correct choice");
break;
}
}
}
}
