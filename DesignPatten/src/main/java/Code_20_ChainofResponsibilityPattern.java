/**责任链模式
 * @author Bang
 * @date 2020/1/8  11:10
 */
public class Code_20_ChainofResponsibilityPattern {
    public static void main(String[] args) {
        CommonNanager commonNanager = new CommonNanager("经理");
        Major major = new Major("总监");
        GeneralManager generalManager = new GeneralManager("总经理");
        //设置上级 完全可以根据实际需求来更改设置
        commonNanager.setSuperior(major);
        major.setSuperior(generalManager);

        //客户端请求都是由经理发起
        // //但是实际决策者由具体人员负责 客户端不知道
        Request request = new Request();
        request.setRequestType("请假");
        request.setRequestContent("邦邦请假");
        request.setNumber(1);
        commonNanager.RequestApplications(request);

        Request request1 = new Request();
        request1.setRequestType("请假");
        request1.setRequestContent("邦邦请假");
        request1.setNumber(4);
        commonNanager.RequestApplications(request1);

        Request request2 = new Request();
        request2.setRequestType("加薪");
        request2.setRequestContent("邦邦加薪");
        request2.setNumber(1000);
        commonNanager.RequestApplications(request2);

        Request request3 = new Request();
        request3.setRequestType("加薪");
        request3.setRequestContent("邦邦加薪");
        request3.setNumber(3000);
        commonNanager.RequestApplications(request3);
    }
}

//申请
class Request{
    //申请类别
    private String requestType;

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }
    //申请内容
    private String requestContent;

    public String getRequestContent() {
        return requestContent;
    }

    public void setRequestContent(String requestContent) {
        this.requestContent = requestContent;
    }
    //数量
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

//管理者
abstract class Manager{
    protected String name;
    //管理者得上级
    private Manager superior;
    public Manager(String name){
        super();
        this.name = name;
    }
    //设置管理者得上级

    public Manager getSuperior() {
        return superior;
    }

    public void setSuperior(Manager superior) {
        this.superior = superior;
    }

    //申请请求
    public abstract void RequestApplications(Request request);
}
//具体管理者
//经理
class CommonNanager extends Manager{
    public CommonNanager(String name){
        super(name);
    }

    @Override
    public void RequestApplications(Request request) {
        if ("请假".equals(request.getRequestType()) && request.getNumber() <=2){
            System.out.println(name + " " + request.getRequestContent() +
                    " " + request.getNumber() + " 被批准");
        }else{
            if (getSuperior() != null){
                getSuperior().RequestApplications(request);
            }
        }
    }
}

//总监>经理
class Major extends Manager{
    public Major(String name){
        super(name);
    }

    @Override
    public void RequestApplications(Request request) {
        if ("请假".equals(request.getRequestType()) && request.getNumber() <=5){
            System.out.println(name + " " + request.getRequestContent() +
                    " " + request.getNumber() + " 被批准");
        }else{
            if (getSuperior() != null){
                //转到上级
                getSuperior().RequestApplications(request);
            }
        }
    }
}

//总经理》总监》经理
class GeneralManager extends Manager{
    public GeneralManager(String name){
        super(name);
    }

    @Override
    public void RequestApplications(Request request) {
        if ("请假".equals(request.getRequestType())){
            System.out.println(name + " " + request.getRequestContent() +
                    " " + request.getNumber() + " 被批准");
        }else if (request.getRequestType() == "加薪" && request.getNumber() <= 1000){
            System.out.println(name + " " + request.getRequestContent() +
                    " " + request.getNumber() + " 被批准");
        }else if (request.getRequestType() == "加薪" && request.getNumber() > 1000){
            System.out.println(name + " " + request.getRequestContent() +
                    " " + request.getNumber() + " 再说吧");
        }
    }
}