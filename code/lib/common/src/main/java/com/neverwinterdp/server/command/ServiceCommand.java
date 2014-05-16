package com.neverwinterdp.server.command;

import java.io.Serializable;

import com.neverwinterdp.server.Server;
import com.neverwinterdp.server.service.Service;
import com.neverwinterdp.server.service.ServiceDescriptor;

/**
 * @author Tuan Nguyen
 * @email  tuan08@gmail.com
 */
abstract public class ServiceCommand<T> implements Serializable {
  private long    timeout = 5000l ; 
  private boolean logEnable ;
  private ServiceDescriptor targetService ;
  
  public ServiceCommand() {
  }
  
  public ServiceCommand(ServiceDescriptor descriptor) {
    this.targetService = descriptor ;
  }
  
  public long getTimeout() { return timeout ; }
  public ServiceCommand<T> setTimeout(long timeout) {
    this.timeout = timeout ;
    return this ;
  }
  
  public boolean isLogEnable() { return logEnable; }
  public ServiceCommand<T>    setLogEnable(boolean logEnable) {
    this.logEnable = logEnable;
    return this ;
  }

  public ServiceDescriptor getTargetService() { return this.targetService ; }
  public void setTargetService(ServiceDescriptor target) {
    this.targetService = target ;
  }
  
  abstract public T execute(Server server, Service service)  throws Exception ;

  public String getActivityLogName() { return getClass().getSimpleName() ; }
  
  public String getActivityLogMessage() { return null ; }
}
