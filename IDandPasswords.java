import java.util.HashMap;
public class IDandPasswords {

    HashMap<String,String> logininfo = new HashMap<String,String>();

    IDandPasswords(){

        logininfo.put("Divit","1234");
        logininfo.put("Mallah","PASSWORD");
        logininfo.put("Ram","1177");
    }

    public HashMap getLoginInfo(){
        return logininfo;
    }
}

