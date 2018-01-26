import java.rmi.Naming;

public class HelloClient {
    

    public static void main(String[] args){
        String answer;
        Hello server;
        try{
            server = (Hello)Naming.lookup("rmi://localhost:2000/Hello-Server");
            answer = server.sayHello();
            System.out.println(answer);
        } catch (Excetion e)
        {
            e.printStackTrace();
        }

    }
}