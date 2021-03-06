package config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;

import lombok.Getter;

@Getter
public class DataInterfaceConfig {

  private final String className;
  
  private final Map<String, String> param;
  
  public DataInterfaceConfig(Element dataInterfaceConfig) {
    this.className = dataInterfaceConfig.attributeValue("className");
    this.param = new HashMap<>();
    @SuppressWarnings("unchecked")
    List<Element> params = dataInterfaceConfig.elements("param");
    for (Element element : params) {
      this.param.put(element.attributeValue("key"), element.attributeValue("value"));
    }
  }
}
