package com.spring.config;

import java.util.List;
import java.util.Properties;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.server.endpoint.interceptor.PayloadLoggingInterceptor;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;
import org.springframework.ws.soap.security.wss4j2.callback.SimplePasswordValidationCallbackHandler;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;


@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
	    MessageDispatcherServlet servlet = new MessageDispatcherServlet();
	    servlet.setApplicationContext(applicationContext);
	    servlet.setTransformWsdlLocations(true);
	    return new ServletRegistrationBean(servlet, "/ws/*");
	}
	
	@Bean
	PayloadLoggingInterceptor payloadLoggingInterceptor() {
		return new PayloadLoggingInterceptor();
	}

	@Bean
    public SimplePasswordValidationCallbackHandler securityCallbackHandler(){
        SimplePasswordValidationCallbackHandler callbackHandler = new SimplePasswordValidationCallbackHandler();
        Properties users = new Properties();
        users.setProperty("admin", "secret");
        callbackHandler.setUsers(users);
        return callbackHandler;
    }	
	
	@Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {
        interceptors.add(securityInterceptor());
    }
	
	@Bean
    public Wss4jSecurityInterceptor securityInterceptor(){
        Wss4jSecurityInterceptor securityInterceptor = new Wss4jSecurityInterceptor();
        securityInterceptor.setValidationActions("Timestamp UsernameToken");
        securityInterceptor.setValidationCallbackHandler(securityCallbackHandler());
        return securityInterceptor;
    }
	
	@Bean
	public DefaultWsdl11Definition countries(XsdSchema countriesSchema) {
	    DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
	    wsdl11Definition.setPortTypeName("CountriesPort");
	    wsdl11Definition.setLocationUri("/ws");
	    wsdl11Definition.setTargetNamespace("http://tirmizee.com/ws/countries"); 
	    wsdl11Definition.setSchema(countriesSchema);
	    return wsdl11Definition;
	}
	 
	@Bean
	public DefaultWsdl11Definition users(XsdSchema userSchema) {
	    DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
	    wsdl11Definition.setPortTypeName("UserPort");
	    wsdl11Definition.setLocationUri("/ws");
	    wsdl11Definition.setTargetNamespace("http://tirmizee.com/ws/user"); 
	    wsdl11Definition.setSchema(userSchema);
	    return wsdl11Definition;
	}
	
	@Bean
	public DefaultWsdl11Definition customer(XsdSchema customerSchema) {
	  DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
	  wsdl11Definition.setPortTypeName("CustomerServicePort");
	  wsdl11Definition.setLocationUri("/ws");
	  wsdl11Definition.setTargetNamespace("http://spring.tutorialflix.com/service/v1");
	  wsdl11Definition.setSchema(customerSchema());
	  return wsdl11Definition;
	 }
	
	@Bean
	public XsdSchema countriesSchema() {
	    return new SimpleXsdSchema(new ClassPathResource("xsd/countries.xsd"));
	}
	
	@Bean
	public XsdSchema userSchema() {
	    return new SimpleXsdSchema(new ClassPathResource("xsd/user.xsd"));
	}
	
	@Bean
	public XsdSchema customerSchema() {
		return new SimpleXsdSchema(new ClassPathResource("xsd/customer-service.xsd"));
	}
	
}
