package com.capgemini.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such room found !")  // 404
public class RoomNotFoundException extends RuntimeException{

}
