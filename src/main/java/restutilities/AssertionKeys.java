package restutilities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AssertionKeys {
    private String jsonpath;
    private Object expectedValue;
    private Object actualValue;
    private String result;
}
