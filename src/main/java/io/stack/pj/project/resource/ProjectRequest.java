package io.stack.pj.project.resource;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Prajin Maharjan
 * @since 1.0
 */
@Getter
@Setter
public class ProjectRequest implements Serializable{

    private String name;

    private String description;

    private String url;

}
