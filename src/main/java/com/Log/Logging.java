package com.Log;

public interface Logging {
    // Định nghĩa phương thức cho log
    public void info(String message, String username);
    public void warn(String message, String username);
    public void error(String message);

}
