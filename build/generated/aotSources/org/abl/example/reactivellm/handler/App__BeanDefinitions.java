package org.abl.example.reactivellm.handler;

import org.abl.example.reactivellm.ConversationHandler;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.socket.server.WebSocketService;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;

/**
 * Bean definitions for {@link App}.
 */
@Generated
public class App__BeanDefinitions {
  /**
   * Get the bean definition for 'app'.
   */
  public static BeanDefinition getAppBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(App$$SpringCGLIB$$0.class);
    beanDefinition.setTargetType(App.class);
    ConfigurationClassUtils.initializeConfigurationClass(App.class);
    beanDefinition.setInstanceSupplier(App$$SpringCGLIB$$0::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'handler'.
   */
  private static BeanInstanceSupplier<ConversationHandler> getHandlerInstanceSupplier() {
    return BeanInstanceSupplier.<ConversationHandler>forFactoryMethod(App$$SpringCGLIB$$0.class, "handler")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("app", App.class).handler());
  }

  /**
   * Get the bean definition for 'handler'.
   */
  public static BeanDefinition getHandlerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ConversationHandler.class);
    beanDefinition.setFactoryBeanName("app");
    beanDefinition.setInstanceSupplier(getHandlerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'handlerMapping'.
   */
  private static BeanInstanceSupplier<HandlerMapping> getHandlerMappingInstanceSupplier() {
    return BeanInstanceSupplier.<HandlerMapping>forFactoryMethod(App$$SpringCGLIB$$0.class, "handlerMapping")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("app", App.class).handlerMapping());
  }

  /**
   * Get the bean definition for 'handlerMapping'.
   */
  public static BeanDefinition getHandlerMappingBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(HandlerMapping.class);
    beanDefinition.setFactoryBeanName("app");
    beanDefinition.setInstanceSupplier(getHandlerMappingInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'handlerAdapter'.
   */
  private static BeanInstanceSupplier<WebSocketHandlerAdapter> getHandlerAdapterInstanceSupplier() {
    return BeanInstanceSupplier.<WebSocketHandlerAdapter>forFactoryMethod(App$$SpringCGLIB$$0.class, "handlerAdapter")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("app", App.class).handlerAdapter());
  }

  /**
   * Get the bean definition for 'handlerAdapter'.
   */
  public static BeanDefinition getHandlerAdapterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebSocketHandlerAdapter.class);
    beanDefinition.setFactoryBeanName("app");
    beanDefinition.setInstanceSupplier(getHandlerAdapterInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'webSocketService'.
   */
  private static BeanInstanceSupplier<WebSocketService> getWebSocketServiceInstanceSupplier() {
    return BeanInstanceSupplier.<WebSocketService>forFactoryMethod(App$$SpringCGLIB$$0.class, "webSocketService")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("app", App.class).webSocketService());
  }

  /**
   * Get the bean definition for 'webSocketService'.
   */
  public static BeanDefinition getWebSocketServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebSocketService.class);
    beanDefinition.setFactoryBeanName("app");
    beanDefinition.setInstanceSupplier(getWebSocketServiceInstanceSupplier());
    return beanDefinition;
  }
}
