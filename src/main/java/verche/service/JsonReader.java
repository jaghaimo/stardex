package verche.service;

import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

public abstract class JsonReader {

    protected ObjectMapper objectMapper;

    public JsonReader() {
        objectMapper = JsonMapper.builder().defaultLeniency(true)
                .enable(JsonReadFeature.ALLOW_JAVA_COMMENTS, JsonReadFeature.ALLOW_SINGLE_QUOTES,
                        JsonReadFeature.ALLOW_YAML_COMMENTS, JsonReadFeature.ALLOW_MISSING_VALUES,
                        JsonReadFeature.ALLOW_TRAILING_COMMA, JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES,
                        JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS,
                        JsonReadFeature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER,
                        JsonReadFeature.ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS)
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES).build();
    }
}
