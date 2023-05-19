package Interfaces;
import java.lang.*;
import Classes.*;

public interface ILoginOperation {
    void matchAdmin(String userName, String userPass);

    void matchUser(String userName, String userPass);
}
