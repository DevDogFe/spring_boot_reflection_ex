package ex03;

@Controller // 커스텀 어노테이션 활용
public class UserController {

    @RequestMapping(uri="/login")
    public void login() {
        System.out.println("login() 메서드 호출");
    }

    @RequestMapping(uri="/join")
    public void join() {
        System.out.println("join() 메서드 호출");
    }

    @RequestMapping(uri="/save")
    public void save() {
        System.out.println("save() 메서드 호출");
    }

}
