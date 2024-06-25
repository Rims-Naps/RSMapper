package org.rsmapper.engine.service.login;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import org.rsmapper.engine.ConcurrentThreadFactory;

public class LoginService implements Runnable {
   private static final ExecutorService serviceThread = Executors.newSingleThreadExecutor(new ConcurrentThreadFactory("LoginService"));
   private static LoginService loginService;
   private BlockingQueue<LoginServiceTask> loginQueue;
   private final Map<String, LoginServiceTask> requests = new HashMap();
   private boolean serviceRunning;

   private LoginService() {
      this.serviceRunning = Boolean.FALSE;
   }

   public static LoginService getSingleton() {
      if (loginService == null) {
         loginService = new LoginService();
      }

      return loginService;
   }

   public void init() {
      this.loginQueue = new LinkedBlockingQueue();
      this.serviceRunning = Boolean.TRUE;
      getServiceThread().submit(this);
   }

   public void submit(LoginServiceTask task) {
      this.getLoginQueue().offer(task);
   }

   public void run() {
      System.out.println("Login service is now running!");

      while(this.serviceRunning) {
         try {
            LoginServiceTask task = (LoginServiceTask)this.getLoginQueue().take();
            task.execute();
         } catch (Exception var2) {
            var2.printStackTrace();
         }
      }

      System.err.println("The login service has shutdown. All login attempts will be ignored.");
   }

   private static ExecutorService getServiceThread() {
      return serviceThread;
   }

   private BlockingQueue<LoginServiceTask> getLoginQueue() {
      return this.loginQueue;
   }

   public Map<String, LoginServiceTask> getRequests() {
      return this.requests;
   }
}
