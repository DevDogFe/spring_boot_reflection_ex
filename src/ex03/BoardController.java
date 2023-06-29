package ex03;
@Controller
public class BoardController {
    @RequestMapping(uri = "/put")
    public void put(){
        System.out.println("put 메서드 실행");
    }
}
