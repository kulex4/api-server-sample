package org.kulex4.data.entity.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.kulex4.data.entity.Group;
import org.kulex4.rest.GroupController;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by nikolai on 20.07.16.
 */
public class GroupResource extends ResourceSupport implements Serializable {

    private final Group group;

    public GroupResource(Group group) {
        this.group = group;
        this.add(new Link(Link.REL_SELF));
        //this.add(linkTo(methodOn(GroupController.class).getAllGroups()).withSelfRel());
    }

    public Group getGroup() {
        return group;
    }
}
