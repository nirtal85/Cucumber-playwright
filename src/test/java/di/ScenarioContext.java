package di;
/**
 * User: nirtal
 * Date: 27/07/2021
 * Time: 14:46
 * Created with IntelliJ IDEA
 */

import io.cucumber.spring.ScenarioScope;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@ScenarioScope
@Data
public class ScenarioContext {
    private int time;
}
