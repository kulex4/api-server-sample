package org.kulex4.data.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by nikolai on 21.07.16.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found!")
public class ResourceNotFoundException extends RuntimeException {
}
