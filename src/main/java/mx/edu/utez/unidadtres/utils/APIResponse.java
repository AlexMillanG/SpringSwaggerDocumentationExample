package mx.edu.utez.unidadtres.utils;


import org.springframework.http.HttpStatus;

public class APIResponse {

    private Object data;
    private String message;
    private boolean error;
    private HttpStatus status;

    public APIResponse() {
    }

    public APIResponse(Object data, String message, boolean error, HttpStatus status) {
        this.data = data;
        this.message = message;
        this.error = error;
        this.status = status;
    }

    public APIResponse(String message,  boolean error,HttpStatus status) {
        this.message = message;
        this.status = status;
        this.error = error;
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
