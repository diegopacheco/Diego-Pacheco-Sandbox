@RestController
public class WebApp {

    @RequestMapping("/")
    String home() {
        return "Kubernetes + Minikube + Docker + Spring Boot - Current time: " + new java.util.Date();
    }

}
