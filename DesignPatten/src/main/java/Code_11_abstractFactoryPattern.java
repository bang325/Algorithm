/**抽象工厂模式
 * @author Bang
 * @date 2019/12/4  11:52
 */
public class Code_11_abstractFactoryPattern {
    public static void main(String[] args) {
        /*抽象工厂模式
        User user = new User();
        Factory factory = new AccessFactory();
        IUser iUser = factory.createUser();
        iUser.insert(user);
        iUser.getUser(1);

        Department department = new Department();
        IDepartment iDepartment = factory.createDepartment();
        iDepartment.insert(department);
        iDepartment.getDepartment(1);*/
        //简单工厂改进抽象工厂
        User user = new User();
        IUser iUser = DataAccess.createUser();
        iUser.insert(user);
        iUser.getUser(1);

        Department department = new Department();
        IDepartment iDepartment = DataAccess.createDepartment();
        iDepartment.insert(department);
        iDepartment.getDepartment(1);
    }
}
/*抽象工厂模式
class User{
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
interface IUser{
    void insert(User user);
    User getUser(int id);
}
class SqlUser implements IUser{
    @Override
    public void insert(User user) {
        System.out.println("在sql中给user表增加一条数据");
    }

    @Override
    public User getUser(int id) {
        System.out.println("在SQL中根据id获取user表的一条记录");
        return null;
    }
}

class AccessUser implements IUser{
    @Override
    public void insert(User user) {
        System.out.println("在Access中给user表增加一条记录");
    }

    @Override
    public User getUser(int id) {
        System.out.println("在Access中根据id获取user表一条数据");
        return null;
    }
}
class Department{
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

interface Factory{
    IUser createUser();
    IDepartment createDepartment();
}
class SqlFactory implements Factory{
    @Override
    public IUser createUser() {
        return new SqlUser();
    }

    @Override
    public IDepartment createDepartment() {
        return new SqlDepartment();
    }
}
class AccessFactory implements Factory{
    @Override
    public IUser createUser() {
        return new AccessUser();
    }

    @Override
    public IDepartment createDepartment() {
        return new AccessDepartment();
    }
}
interface IDepartment{
    void insert(Department department);
    Department getDepartment(int id);
}
class SqlDepartment implements IDepartment{
    @Override
    public void insert(Department department) {
        System.out.println("在SQL Server中给department表增加一条记录");
    }

    @Override
    public Department getDepartment(int id) {
        System.out.println("在SQL Server中根据id获取department表一条记录");
        return null;
    }
}
class AccessDepartment implements IDepartment{
    @Override
    public void insert(Department department) {
        System.out.println("在Access中给department表增加一条记录");
    }

    @Override
    public Department getDepartment(int id) {
        System.out.println("在access中根据id获取department表一条记录");
        return null;
    }
}*/

//简单工厂改进抽象工厂
class User{
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
interface IUser{
    void insert(User user);
    User getUser(int id);
}
class SqlUser implements IUser{
    @Override
    public void insert(User user) {
        System.out.println("在sql中给user表增加一条数据");
    }

    @Override
    public User getUser(int id) {
        System.out.println("在SQL中根据id获取user表的一条记录");
        return null;
    }
}

class AccessUser implements IUser{
    @Override
    public void insert(User user) {
        System.out.println("在Access中给user表增加一条记录");
    }

    @Override
    public User getUser(int id) {
        System.out.println("在Access中根据id获取user表一条数据");
        return null;
    }
}
class Department{
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
interface IDepartment{
    void insert(Department department);
    Department getDepartment(int id);
}
class SqlDepartment implements IDepartment{
    @Override
    public void insert(Department department) {
        System.out.println("在SQL Server中给department表增加一条记录");
    }

    @Override
    public Department getDepartment(int id) {
        System.out.println("在SQL Server中根据id获取department表一条记录");
        return null;
    }
}
class AccessDepartment implements IDepartment{
    @Override
    public void insert(Department department) {
        System.out.println("在Access中给department表增加一条记录");
    }

    @Override
    public Department getDepartment(int id) {
        System.out.println("在access中根据id获取department表一条记录");
        return null;
    }
}
class DataAccess{
    //private static final String db = "SqlSever";
    private static final String db = "Access";
    public static IUser createUser(){
        IUser iUser = null;
        switch (db){
            case "SqlSever":
                iUser = new SqlUser();
                break;
            case "Access":
                iUser = new AccessUser();
                break;
        }
        return iUser;
    }
    public static IDepartment createDepartment(){
        IDepartment iDepartment = null;
        switch (db){
            case "SqlServer":
                iDepartment = new SqlDepartment();
                break;
            case "Access":
                iDepartment = new AccessDepartment();
                break;
        }
        return iDepartment;
    }
}