package simbirsoft.com.models;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class FileProperty {

    private PropertyList custom_properties;

}